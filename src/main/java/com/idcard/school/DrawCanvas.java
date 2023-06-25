package com.idcard.school;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JComponent;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;


public class DrawCanvas extends JComponent {
	
	private int width;
	private int height;
	
	public DrawCanvas(int w,int h) {
		this.width=w;
		this.height=h;
	}
	
	protected void paintComponent(Graphics g) {
		System.out.println("insider the draw method");
		Graphics2D g2d = (Graphics2D) g;
		try {
			PDDocument document = PDDocument.load(new File("src/main/java/com/idcard/school/idcard.pdf"));
		    PDFRenderer pdfRenderer = new PDFRenderer(document);
////		    int numPages = document.getNumberOfPages();
	//
//		    // Choose the page you want to convert (e.g., page 0 for the first page)
		    int pageNumber = 0;
//		    // Render the page to an image
		    BufferedImage image = pdfRenderer.renderImage(0);
		    g2d=image.createGraphics();
		    g2d.setColor(Color.blue);
			g2d.fillRect(100, 200, width, height);
			g2d.setColor(Color.BLACK);

			// Set font properties
			Font font = new Font("Arial", Font.BOLD, 16);
			g2d.setFont(font);

			// Write the modified content onto the image
			g2d.drawString("this is content", 10, 20);

			// Dispose the graphics object
			g2d.dispose();
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		

	}

}
