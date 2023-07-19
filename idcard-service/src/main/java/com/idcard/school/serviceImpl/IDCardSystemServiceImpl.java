package com.idcard.school.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idcard.school.dao.IDCardSystemDao;
import com.idcard.school.model.IDCardWrapper;
import com.idcard.school.service.IDCardSystemService;

@Service
public class IDCardSystemServiceImpl implements IDCardSystemService {

	private static Logger logger = LogManager.getLogger(IDCardSystemServiceImpl.class);
	
	private static final byte [] Empty_Byte=null;
	private static final IDCardWrapper Empty_IDCard_Data=null;

	@Autowired
	private IDCardSystemDao idDao;

	@Override
	public IDCardWrapper createIdcard(IDCardWrapper idCardWrapper) {
		logger.info("Insider the createIdcard method with entity value : {} ", idCardWrapper.toStringSize());

		try {
			PDDocument document = PDDocument.load(new File("src/main/java/com/idcard/school/idcard.pdf"));

			// Get the first page
			PDPage page = document.getPage(0);

			// Create a content stream to write on the page
			PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true);

			PDImageXObject photo = PDImageXObject.createFromByteArray(document, idCardWrapper.getPhoto(), "image");

			BufferedImage imageSign = ImageIO.read(new File("src/main/java/com/idcard/school/universal.png"));

			// Convert the image to a byte array

			ByteArrayOutputStream baosSign = new ByteArrayOutputStream();
			ImageIO.write(imageSign, "png", baosSign);
			byte[] byteArraysign = baosSign.toByteArray();

			PDImageXObject sign = PDImageXObject.createFromByteArray(document, byteArraysign, "image");

			contentStream.setFont(PDType1Font.COURIER_OBLIQUE, 26);
			contentStream.beginText();
			contentStream.newLineAtOffset(315, 519);
			contentStream.showText(idCardWrapper.getFatherName());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(300, 469);
			contentStream.showText(idCardWrapper.getDob());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(220, 425);
			contentStream.showText(idCardWrapper.getGender());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(220, 385);
			contentStream.showText(idCardWrapper.getDegree());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(230, 343);
			contentStream.showText(idCardWrapper.getSession());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(260, 301);
			contentStream.showText(idCardWrapper.getUniversityName());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(210, 260);
			contentStream.showText(idCardWrapper.getEmail());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(263, 215);
			contentStream.showText(idCardWrapper.getMobile());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(235, 171);
			contentStream.showText(idCardWrapper.getAddress());
			contentStream.endText();

			contentStream.drawImage(photo, 850, 400, 130, 150);
			contentStream.drawImage(sign, 800, 400, 125, 40);

			contentStream.setFont(PDType1Font.COURIER_BOLD, 29);
			contentStream.setNonStrokingColor(0.800f, 0.800f, 0.800f);
			contentStream.beginText();
			contentStream.newLineAtOffset(30, 22);
			contentStream.showText(idCardWrapper.getCollegeName());
			contentStream.endText();

			contentStream.setFont(PDType1Font.COURIER_BOLD, 36);
			contentStream.setNonStrokingColor(0.200f, 0.400f, 0.600f);
			contentStream.beginText();
			contentStream.newLineAtOffset(100, 570);
			contentStream.showText(idCardWrapper.getName());
			contentStream.endText();

			contentStream.setFont(PDType1Font.COURIER_BOLD, 29);
			contentStream.setNonStrokingColor(0.200f, 0.200f, 0.300f);
			contentStream.beginText();
			contentStream.newLineAtOffset(200, 640);
			contentStream.showText(idCardWrapper.getSerialNumber());
			contentStream.endText();

			// Close the content stream
			contentStream.close();

			PDFRenderer pd = new PDFRenderer(document);
			// BufferedImage bufferedImage = pd.renderImageWithDPI(0, 100); // 300 DPI
			BufferedImage bufferedImage = pd.renderImage(0);

			System.out.println(bufferedImage);

			ByteArrayOutputStream pdfos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", pdfos);
			byte[] idPdfbyte = pdfos.toByteArray();
			idCardWrapper.setImage(idPdfbyte);

			// Save the BufferedImage to a file
			// ImageIO.write(bufferedImage, "png", new
			// File("src/main/java/com/idcard/school/output.png"));

			// Close the document
			document.close();
			logger.info("final idcard image : {} ", idCardWrapper.getImage().length);
			if (idDao.insertCQL(idCardWrapper)) {
				return idCardWrapper;
			}
		} catch (Exception e) {
			logger.info("error found in createidcard : {}", e.getMessage());
		}

		return Empty_IDCard_Data;
	}

	@Override
	public byte[] getIdcard(String serialNo, String session, String university, String college, String degree) {
		logger.info("Insider the getIdcard method  serialNo : {}, session : {}, university : {}, college : {}, degree : {}",
				serialNo, session, university, college, degree);
			IDCardWrapper idCardWrapper=new IDCardWrapper();
			idCardWrapper.setSerialNumber(serialNo);
			idCardWrapper.setSession(session);
			idCardWrapper.setUniversityName(university);
			idCardWrapper.setCollegeName(college);
			idCardWrapper.setDegree(degree);
			idCardWrapper = idDao.selectOneCQL(idCardWrapper);
			if(idCardWrapper.getImage()!=null){
				return idCardWrapper.getImage();
			}else
				logger.info("Data not found");

		return Empty_Byte;
	}

	@Override
	public Map<String, byte[]> getListOfIdcard(List<String> listOfSerialno, String session, String university, String college,
			String degree) {
		logger.info("Insider the getListOfIdcard method  listOfSerialno : {}, session : {}, university : {}, college : {}, degree : {}",
				listOfSerialno.toString(), session, university, college, degree);
			Map<String,byte []> listofresult=new HashMap<>();
			List<IDCardWrapper> listofIdcard=idDao.selectAllCQL(listOfSerialno, session, university, college, degree);
			if(listofIdcard.size()>0){
				for(IDCardWrapper id:listofIdcard)
					listofresult.put(id.getSerialNumber(), id.getImage());
			}else
				logger.info("Data not found");
		return listofresult;
	}

	@Override
	public Map<String, BufferedImage> getBufferdListOfIdcard(List<String> listOfSerialno, String session,
			String university, String college, String degree) {
		logger.info(
				"Insider the getBufferdListOfIdcard method  listOfSerialno : {}, session : {}, university : {}, college : {}, degree : {}",
				listOfSerialno.toString(), session, university, college, degree);

		return new HashMap<>();
	}

}
