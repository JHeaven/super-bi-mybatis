package com.heaven.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.heaven.dao.impl.CellBYDaoImpl;
import com.heaven.model.CellBy;
import com.heaven.utils.Get_Cell_Name;
import com.heaven.utils.Get_Option;

/**
 * 解析所有清册加SJ的表样
 * @author jiangyqc
 *
 */
public class Go_BY {

	public static void main(String[] args) {

		CellBYDaoImpl cellDao = new CellBYDaoImpl();
		File file = null;

		

		file = new File("D:/2018");
		String [] files = file.list(); 
		
		for (int i = 0; i < files.length; i++) {
			file = new File("D:/2018/"+files[i]);
			System.out.println("====================================");
			System.out.println("D:/2018/"+files[i]);
			
			
			
			String text = txt2String(file);


			CellBy cellTop = new CellBy();
			cellTop.setReportAlias(Get_Cell_Name.getAlias(text));
			cellTop.setReportCaption(Get_Cell_Name.getCaption(text));
			cellTop.setReportId(Get_Cell_Name.getID(text));
			cellTop.setReportName(Get_Cell_Name.getName(text));
			cellTop.setReportTaskid(Get_Cell_Name.getTaskId(text));
			cellTop.setReportType(Get_Cell_Name.getType(text));

			
			
			text = text.substring(text.indexOf("</body>"));
			
			if (text.indexOf("<option>") > 0) {
				String text_o = text.substring(text.indexOf("<option>"), text.lastIndexOf("</option>")+9).replace("\\u20","");			
				
				// 提取数据格串
				Get_Option.getOption(text_o,cellTop, cellDao);

			}else {
				System.out.println("no options found!");
			}
			
			
			
		}
		

		
	}

	/**
	 * 读取文本文件的内容
	 * 
	 * @param file
	 *            想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			System.err.println("file not found!");
			System.exit(0);
			// /e.printStackTrace();
		}
		return result.toString();
	}

}
