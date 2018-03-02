package com.heaven.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AnalyseFormula2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String flag = "";
		File file = null;

		file = new File("D:\\Project\\20171105审核框架\\审核公式.txt");

		if (!file.exists()) {
			System.out.println("文件 *.txt 不存在！");
		}
		// 开始解析

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
				
				if(s.contains("提示:")) {
					data = s.split("提示:");
				}
				
				if (data != null) {
					System.out.println(flag+"\t"+data[0]+"\t公式含义\t"+data[1]);
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
