package com.orienttech.statics.service.report.thread;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.commons.utils.FreemarkerUtils;
import com.orienttech.statics.commons.utils.ImageUtils;
import com.orienttech.statics.commons.utils.Pdf2Image;
import com.orienttech.statics.dao.entity.FinancialReport;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;

public class Pdf2WordUtil {

	public static Map<String, String> cutImages(List<File> files, List<FinancialReport> list) throws IOException{
		Map<String, String> refiles = new HashMap<String, String>();
		//生成png并切割图片
		for (int i = 0; i < files.size(); i++) {
			File f = files.get(i);
			String filename = f.getName();
			FinancialReport fr = list.get(i);
			if(FileUtils.isExists(f)){
				//生成png
				File temp = new File(ServerInfoHelper.getTempImagePath() + File.separator + "temp.png");
				/*if(FileUtils.isExists(temp)){
					FileUtils.deleteDirectory(temp);
				}*/
				/*boolean firstStep = Pdf2Image.setImageByICEPDF(f, temp); 程序备份
				if (firstStep) {
					String key = "image" + fr.getRowId();
					//切割图片
					String sPath = temp.getPath();
					String tPath = ServerInfoHelper.getTempImagePath() + File.separator + key + "_" + filename.substring(0,filename.length()-4) + ".png";
					
					//String targetPath = ImageUtils.cutImage(sPath, tPath, 180, 120, 3120, 1800);
					String targetPath = ImageUtils.cutImage(sPath, tPath, fr.getX1(), fr.getY1(), fr.getX2(), fr.getY2());
					//保存到refiles中
					if (StringUtils.isNotEmpty(targetPath)) {
						refiles.put(key , targetPath);
					}
				}*/
				
				
				String key = "image" + fr.getRowId();
				String sPath = temp.getPath();
				String tPath = ServerInfoHelper.getTempImagePath() + File.separator + key + "_" + filename.substring(0,filename.length()-4) + ".png";
				
				String targetPath = "";//Pdf2Image.setImageANDCutImage(f, temp, sPath, tPath, 180, 120, 3120, 1800);
				//String targetPath = Pdf2Image.setImageANDCutImage(f, temp, sPath, tPath, fr.getX1(), fr.getY1(), fr.getX2(), fr.getY2());
				
				if (StringUtils.isNotEmpty(targetPath)) {
					refiles.put(key , targetPath);
				}
			}
		}
		return refiles;
	}

	public static void createWord(Map<String, String> fileImages, String wordName, String year, String month, String org, String templetName) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		for (Map.Entry<String, String> entry : fileImages.entrySet()) {
			dataMap.put(entry.getKey(), FreemarkerUtils.getImageStr(entry.getValue()));
		}
		if (fileImages != null) {
			dataMap.put("year", year);
			dataMap.put("month", month);
			dataMap.put("org", org);
			
			Calendar cal = Calendar.getInstance();
			dataMap.put("nowyear", String.valueOf(cal.get(Calendar.YEAR)));
			dataMap.put("nowmonth", String.valueOf(cal.get(Calendar.MONTH)+1));
			dataMap.put("nowday", String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
		}
		try {
			FreemarkerUtils.createDoc(templetName + ".xml", wordName, dataMap);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//String prefix = "E:\\cognos\\images\\";
		String prefix = "C:\\Users\\kyf\\uploads\\analytics\\tempImage\\";
		Map<String, String> fileImages = new HashMap<String, String>();
		for (int i = 1; i <= 38; i++) {
			fileImages.put("image" + i, prefix + "image" + i + "_1423130656042" + i + ".png");
		}
		createWord(fileImages, "tageter.doc", "2014", "5", "上海邦信", "allOrg");
		/*String tPath = "E:\\cognos2\\test2\\17.png";
		String targetPath = Pdf2Image.pdf2PNG("E:\\cognos2\\test\\17.pdf", tPath, 180, 120, 3120, 1800);
		System.out.println(targetPath);*/
	}
}
