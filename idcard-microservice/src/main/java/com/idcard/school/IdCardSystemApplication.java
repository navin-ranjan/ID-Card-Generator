package com.idcard.school;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableFeignClients
@EnableWebMvc
@SpringBootApplication
public class IdCardSystemApplication {
	
	public static void main(String[] args) throws IOException{
		SpringApplication.run(IdCardSystemApplication.class, args);
		System.out.println("ID Card System Service Up Sucessfully");
//		   PDDocument document = PDDocument.load(new File("src/main/java/com/idcard/school/idcard.pdf"));
//
//           // Get the first page
//           PDPage page = document.getPage(0);
//
//           // Create a content stream to write on the page
//           PDPageContentStream contentStream = new PDPageContentStream(document, page,AppendMode.APPEND,true);
//
//           contentStream.setFont(PDType1Font.COURIER, 30);
//           // Modify the content of the page
//           contentStream.beginText();
//           contentStream.newLineAtOffset(400, 300);
//           contentStream.showText("Modified text");
//           contentStream.endText();
//           
//           contentStream.beginText();
//           contentStream.newLineAtOffset(300, 350);
//           contentStream.showText("Modified text");
//           contentStream.endText();
//           
//           contentStream.beginText();
//           contentStream.newLineAtOffset(400, 400);
//           contentStream.showText("Modified text");
//           contentStream.endText();
//           contentStream.setFont(PDType1Font.COURIER_BOLD, 30);
//           contentStream.setNonStrokingColor(0.200f, 0.400f,0.600f);
//           contentStream.beginText();
//           contentStream.newLineAtOffset(500, 450);
//           contentStream.showText("NAVIN RANJAN");
//           contentStream.endText();
//           
////           contentStream.beginText();
////           
////
////           contentStream.endText();
//           
//           
//
//           System.out.println(contentStream);
//           // Close the content stream
//           contentStream.close();
//
//           PDFRenderer pd = new PDFRenderer(document);
//           //BufferedImage bufferedImage = pd.renderImageWithDPI(0, 100); // 300 DPI
//           BufferedImage bufferedImage=pd.renderImage(0);
//
//           // Convert the modified page to a BufferedImage
//           //BufferedImage bufferedImage = page.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
//          
//
//           System.out.println(bufferedImage);
//           // Save the BufferedImage to a file
//           ImageIO.write(bufferedImage, "png", new File("src/main/java/com/idcard/school/output.png"));
//
//           // Close the document
//           document.close();
//
//           System.out.println("Conversion complete.");
	}

}
