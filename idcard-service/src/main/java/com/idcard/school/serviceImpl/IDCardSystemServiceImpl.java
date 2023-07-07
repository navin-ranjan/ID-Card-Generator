package com.idcard.school.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
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
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import com.idcard.school.dao.IDCardSystemDao;
import com.idcard.school.model.IDCardWrapper;
import com.idcard.school.restImpl.IDCardSystemRestImpl;
import com.idcard.school.service.IDCardSystemService;

@Service
public class IDCardSystemServiceImpl implements IDCardSystemService{
	
	private static Logger logger= LogManager.getLogger(IDCardSystemServiceImpl.class);
	
	private IDCardSystemDao idDao;
	
	public static void main(String[] args) {
		IDCardWrapper ob=new IDCardWrapper();
		ob.setName("Navin Ranjan");
		ob.setFatherName("Virendra thakur");
		ob.setAddress("Sitamarhi Bihar 843330");
		ob.setCollegeName("NIT Bhopal");
		ob.setDegree("MCA");
		ob.setDob("15-04-2023");
		ob.setEmail("naviranjan15498@gmail.com");
		ob.setGender("Male");
		ob.setMobile("7979819668");
		ob.setSerialNumber("NBMCA2023001");
		ob.setSession("2019-2022");
		ob.setUniversityName("MANIT");
		
		ob=createIdcardadd(ob);
	}

	@Override
	public IDCardWrapper createIdcard(IDCardWrapper idCardWrapper) {
		logger.info("Insider the createIdcard method with entity value : {} ", idCardWrapper.toString());
		//code
		return null;
	}
	
	public static IDCardWrapper createIdcardadd(IDCardWrapper idCardWrapper) {
		logger.info("Insider the createIdcard method with entity value : {} ", idCardWrapper.toString());
		
		try {
			PDDocument document = PDDocument.load(new File("src/main/java/com/idcard/school/idcard.pdf"));

	        // Get the first page
	        PDPage page = document.getPage(0);

	        // Create a content stream to write on the page
	        PDPageContentStream contentStream = new PDPageContentStream(document, page,AppendMode.APPEND,true);

	        contentStream.setFont(PDType1Font.COURIER_OBLIQUE, 26);
	        // Modify the content of the page
	        contentStream.beginText();
	        contentStream.newLineAtOffset(315,519);
	        contentStream.showText(idCardWrapper.getFatherName());
	        contentStream.endText();
	        
	        contentStream.beginText();
	        contentStream.newLineAtOffset(300,469);
	        contentStream.showText(idCardWrapper.getDob());
	        contentStream.endText();
	        
	        contentStream.beginText();
	        contentStream.newLineAtOffset(220,425);
	        contentStream.showText(idCardWrapper.getGender());
	        contentStream.endText();
	        
	        contentStream.beginText();
	        contentStream.newLineAtOffset(220,385);
	        contentStream.showText(idCardWrapper.getDegree());
	        contentStream.endText();
	        
	        contentStream.beginText();
	        contentStream.newLineAtOffset(230,343);
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
	        
	        
	        contentStream.setFont(PDType1Font.COURIER_BOLD, 36);
	        contentStream.setNonStrokingColor(0.200f, 0.400f,0.600f);
	        contentStream.beginText();
	        contentStream.newLineAtOffset(100, 570);
	        contentStream.showText(idCardWrapper.getName());
	        contentStream.endText();
	        
	        contentStream.setFont(PDType1Font.COURIER_BOLD, 29);
	        contentStream.setNonStrokingColor(0.100f, 0.400f,0.300f);
	        contentStream.beginText();
	        contentStream.newLineAtOffset(200, 640);
	        contentStream.showText(idCardWrapper.getSerialNumber());
	        contentStream.endText();
	        
//	        contentStream.beginText();
//	        
	//
//	        contentStream.endText();
	        
	        

	        System.out.println(contentStream);
	        // Close the content stream
	        contentStream.close();

	        PDFRenderer pd = new PDFRenderer(document);
	        //BufferedImage bufferedImage = pd.renderImageWithDPI(0, 100); // 300 DPI
	        BufferedImage bufferedImage=pd.renderImage(0);

	        // Convert the modified page to a BufferedImage
	        //BufferedImage bufferedImage = page.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
	       

	        System.out.println(bufferedImage);
	        // Save the BufferedImage to a file
	        ImageIO.write(bufferedImage, "png", new File("src/main/java/com/idcard/school/output.png"));

	        // Close the document
	        document.close();

	        System.out.println("Conversion complete.");
			//code
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public byte[] getIdcard(String serialNo, String session, String university, String college, String degree) {
		logger.info("Insider the getIdcard method  serialNo : {}, session : {}, university : {}, college : {}, degree : {}",serialNo,session,university,college,degree);
		
		return null;
	}

	@Override
	public byte[] getListOfIdcard(List<String> listOfSerialno, String session, String university, String college, String degree) {
		logger.info("Insider the getListOfIdcard method  listOfSerialno : {}, session : {}, university : {}, college : {}, degree : {}",listOfSerialno.toString(),session,university,college,degree);
		
		return null;
	}

	@Override
	public Map<String, BufferedImage> getBufferdListOfIdcard(List<String> listOfSerialno, String session, String university, String college, String degree) {
		logger.info("Insider the getBufferdListOfIdcard method  listOfSerialno : {}, session : {}, university : {}, college : {}, degree : {}",listOfSerialno.toString(),session,university,college,degree);
		
		return null;
	}

}
