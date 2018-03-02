package com.heaven.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AnalyseFormula2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String flag = "";
		File file = null;

		file = new File("D:\\Project\\20171105��˿��\\��˹�ʽ.txt");

		if (!file.exists()) {
			System.out.println("�ļ� *.txt �����ڣ�");
		}
		// ��ʼ����

		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				
				s= cleanBlank(s);
				
				String data[] = null;
				if (s.contains("SJ_") && !s.contains("[") && !s.contains(":")&& !s.contains("->")) {
					flag = s.substring(0, 5);
				}
				
				if(s.contains("��ʾ:")) {
					data = s.split("��ʾ:");
				}
				
				if (data != null) {
					System.out.println(flag+"\t"+data[0]+"\t��ʽ����\t"+data[1]);
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static String cleanBlank(String str) {
		str = str.replace(" ", "");
		return str;
	}
	

}
