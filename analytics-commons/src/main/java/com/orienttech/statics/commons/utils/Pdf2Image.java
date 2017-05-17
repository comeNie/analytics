package com.orienttech.statics.commons.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;

public class Pdf2Image {
	private static Logger logger = LoggerFactory.getLogger(Pdf2Image.class);
	
	public static final String FILETYPE_JPG = "png";
	public static final String SUFF_IMAGE = "." + FILETYPE_JPG;
	
	public static Boolean setImage(File originalFile, File targetFile) {
		int pagen = 1;
		boolean isSuccess = true;
		String msg = "";
		PDFFile pdffile = null;
		RandomAccessFile raf = null;
		FileChannel channel = null;
		try {
			raf = new RandomAccessFile(originalFile, "r");
			channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			pdffile = new PDFFile(buf);
			if (pagen < pdffile.getNumPages()) {
				msg = "文档的页数为零" ;
			}
			if ("".equals(msg)) {
				PDFPage page = pdffile.getPage(pagen);
				int width = (int) page.getBBox().getWidth() * 6;
				int height = (int) page.getBBox().getHeight() * 6;
				BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2 = img.createGraphics();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				PDFRenderer renderer = new PDFRenderer(page, g2, new Rectangle(0, 0, width, height), null, Color.WHITE);
				page.waitForFinish();
				renderer.run();
				g2.dispose();
				ImageIO.write(img, "png", targetFile);//写入相应路径
			}
		} catch (FileNotFoundException e) {
			msg = "找不到相应pdf文档";
			isSuccess = false;
			e.printStackTrace();
		} catch (IOException e) {
			msg = "读取pdf图片异常";
			isSuccess = false;
			e.printStackTrace();
		} catch (InterruptedException e) {
			msg = "参数设置异常";
			isSuccess = false;
			e.printStackTrace();
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
				if (raf != null) {
					raf.close();
				}
				System.out.println(originalFile.delete());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("pdf to image is " + isSuccess + " msg is " + msg);
		return isSuccess;
	}
	
	
	public static Boolean setImageByICEPDF(File originalFile, File targetFile) {
		String msg = "成功";
		boolean isSuccess = true;
		Document document = new Document();
		try {
			document.setFile(originalFile.getPath());
			BufferedImage rendImage = (BufferedImage) document.getPageImage(0,
					GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX, 0f, 6);
			ImageIO.write(rendImage, "png", targetFile);
			rendImage.flush();
		} catch (PDFException e) {
			msg = "读取pdf图片异常:PDFException";
			e.printStackTrace();
		} catch (PDFSecurityException e) {
			msg = "读取pdf图片异常:PDFSecurityException";
			e.printStackTrace();
		} catch (IOException e) {
			msg = "读取pdf图片异常:IOException";
			e.printStackTrace();
		} finally {
			try {
				document.dispose();
				logger.info("delte create pdf  " + originalFile.delete());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("pdf to image is " + isSuccess + " .  msg is " + msg);
		return isSuccess;
	}
	public static String pdf2PNG(String pdfPath, String targetPath, int x, int y, int width, int height) {
		String returnPath = "";
		String msg = "成功";
		boolean isSuccess = false;
		Document document = new Document();
		try {
			document.setFile(pdfPath);
			BufferedImage rendImage = (BufferedImage) document.getPageImage(0, GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX, 0f, 6);
			rendImage = rendImage.getSubimage(x, y, width, height);
			ImageIO.write(rendImage, "png", new File(targetPath));
			rendImage.flush();
			isSuccess = true;
		} catch (PDFException e) {
			msg = "读取pdf图片异常:PDFException";
			e.printStackTrace();
		} catch (PDFSecurityException e) {
			msg = "读取pdf图片异常:PDFSecurityException";
			e.printStackTrace();
		} catch (IOException e) {
			msg = "读取pdf图片异常:IOException";
			e.printStackTrace();
		} finally {
			try {
				document.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("pdf to image is " + isSuccess + " .  msg is " + msg);
		return returnPath;
	}
	
	public static void main(String[] args) {
		/*File file = new File("C:\\Users\\kyf\\uploads\\tempReport\\temp20150105615402014051.pdf");
		System.out.println(file.delete());*/
		
		/*setImageByICEPDF(new File("E:\\cognos\\pdf\\2.pdf"), new File("E:\\cognos\\pdf2img\\temp.png"));*/
	}

}
