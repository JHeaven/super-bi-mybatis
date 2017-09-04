package com.heaven.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.heaven.dao.impl.CellQCDaoImpl;
import com.heaven.model.CellQc;
import com.heaven.utils.Get_CellQC_R_C;
import com.heaven.utils.Get_Cell_Name;
/**
 * �����������
 * @author jiangyqc
 *
 */
public class Go_QC {

	public static void main(String[] args) {

		CellQCDaoImpl cellDao = new CellQCDaoImpl();
		File file = null;
		/*
		 * file = new File("D:/2017���ͳ����/QC/QC_101�����Ŀ��ˮ���.npf");
		 */
		
		file = new File("D:/2017���ͳ����/QC");
		String [] files = file.list();
		for (int i = 0; i < files.length; i++) {
			if (files[i].endsWith(".npf")) {
				
				file = new File("D:/2017���ͳ����/QC/"+files[i]);
				
				String text = txt2String(file);

				String text_r_c = text.substring(text.indexOf("<cl r=0 c=0"), text.lastIndexOf("</cl>") + 5).replace("\\u20","");

				CellQc cellTop = new CellQc();
				cellTop.setReportAlias(Get_Cell_Name.getAlias(text));
				cellTop.setReportCaption(Get_Cell_Name.getCaption(text));
				cellTop.setReportId(Get_Cell_Name.getID(text));
				cellTop.setReportName(Get_Cell_Name.getName(text));
				cellTop.setReportTaskid(Get_Cell_Name.getTaskId(text));
				cellTop.setReportType(Get_Cell_Name.getType(text));
				System.out.println("========================================================");
				System.out.println("=================="+files[i]);
				System.out.println("=================="+cellTop.getReportName());
				// ��ȡ���ݸ�
				Get_CellQC_R_C.getRC(text_r_c, cellDao, cellTop);
				
			}
		}
		
		

	}

	/**
	 * ��ȡ�ı��ļ�������
	 * 
	 * @param file
	 *            ��Ҫ��ȡ���ļ�����
	 * @return �����ļ�����
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
