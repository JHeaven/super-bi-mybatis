package com.heaven.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnalyseFormula3 {
	public static Map<String, Integer> demos1 = new HashMap<String, Integer>();
	public static Map<String, Integer> demos = new HashMap<String, Integer>();
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
				demos1.put("A", 1);
				demos1.put("B", 2);
				demos1.put("C", 3);
				demos1.put("D", 4);
				demos1.put("E", 5);
				demos1.put("F", 6);
				demos1.put("G", 7);
				demos1.put("H", 8);
				demos1.put("I", 9);
				demos1.put("J", 10);
				demos1.put("K", 11);
				demos1.put("L", 12);
				demos1.put("M", 13);
				demos1.put("N", 14);
				demos1.put("O", 15);
				demos1.put("P", 16);
				demos1.put("Q", 17);
				demos1.put("R", 18);
				demos1.put("S", 19);
				demos1.put("T", 20);
				demos1.put("U", 21);
				demos1.put("V", 22);
				demos1.put("W", 23);
				demos1.put("X", 24);
				demos1.put("Y", 25);
				demos1.put("Z", 26);

				demos.put("AA", 27);
				demos.put("AB", 28);
				demos.put("AC", 29);
				demos.put("AD", 30);
				demos.put("AE", 31);
				demos.put("AF", 32);
				demos.put("AG", 33);
				demos.put("AH", 34);
				demos.put("AI", 35);
				demos.put("AJ", 36);
				demos.put("AK", 37);
				demos.put("AL", 38);
				demos.put("AM", 39);
				demos.put("AN", 40);
				demos.put("AO", 41);
				demos.put("AP", 42);
				demos.put("AQ", 43);
				demos.put("AR", 44);
				demos.put("AS", 45);
				demos.put("AT", 46);
				demos.put("AU", 47);
				demos.put("AV", 48);
				demos.put("AW", 49);
				demos.put("AX", 50);
				demos.put("AY", 51);
				demos.put("AZ", 52);

				demos.put("BA", 53);
				demos.put("BB", 54);
				demos.put("BC", 55);
				demos.put("BD", 56);
				demos.put("BE", 57);
		File file = null;

		file = new File("D:\\Project\\20171105审核框架\\审核demo.txt");

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
				
				s = parse1(s);
				s = parse2(s);
				
				
				
				System.out.println(s);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private static String parse2(String s) {
		
		s=s.replace("@-1", "上期的");
		s=s.replace("&", "并且");
		s=s.replace("|", "或者");
		s=s.replace(">=", "大于等于");
		s=s.replace("<=", "小于等于");
		s=s.replace("<>", "不等于");
		s=s.replace("null", "空");
		s=s.replace("id()", "当前税务机关");
		s=s.replace("t(2)", "当前月份");
		s=s.replace("t(1)", "当前年份");
		s=s.replace("->", "中的");
		s=s.replace("=", "等于");
		return s;
	}


	/*
	 * 1[]
	 */
	private static String parse1(String s) {
		int flagFrom = s.indexOf('[');
		int flagTo = s.indexOf(']');
		while (flagFrom >= 0) {
			flagTo = s.indexOf(']');
			if (s.substring(flagFrom).indexOf(',')+flagFrom >flagFrom && s.substring(flagFrom).indexOf(',')+flagFrom<flagTo) {
				break;
			}
			
			String tempStr = s.substring(flagFrom, flagTo+1);
			tempStr = tempStr.replace("[", "").replace("]", "");
			String [] point = tempStr.split(":");
			String aidO =  point[0]+"到"+point[1]
					+"的单元格";
			s = s.substring(0,flagFrom)+aidO + s.substring(flagTo+1);
			flagFrom = s.indexOf('[');
		}

		return s;
	}

	public static String cleanBlank(String str) {
		str = str.replace(" ", "");
		return str;
	}
	

}
