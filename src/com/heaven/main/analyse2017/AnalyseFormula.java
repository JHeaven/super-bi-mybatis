package com.heaven.main.analyse2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalyseFormula {

	public static Map<Integer,String> discrepancyMap = new HashMap<Integer,String>();
	public static Map<String, Integer> demos1 = new HashMap<String, Integer>();
	public static Map<String, Integer> demos = new HashMap<String, Integer>();
	
	public static List<String> symbols =  new ArrayList<>(); 
	public static List<String> tempList = null; 
	
	public static int iii = 0;
	public static String iiiName = "";
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String finalStr = "{";
		installMap();
		File file = null;
		
		for(int i = 25 ; i < 40 ;i++){
			iii = i;
			if (i == 15) {
				continue;
			}
			
			String flag = "";
			if(i<10) {
				flag = "0"+i;
			}else {
				flag = ""+i;
			}
			
			iiiName = "SJ"+flag;
			file = new File("D:\\Project\\20171105审核框架\\detail\\SJ_"+flag+".txt");
			
			
			if (!file.exists()) {
				System.out.println("文件 SJ_"+flag+".txt 不存在！");
				continue;
			}
			
			finalStr = finalStr + "SJ"+flag+":[";
			
			
			//开始解析
			try {
				BufferedReader br;
				br = new BufferedReader(new FileReader(file));
				String s = null;
				while ((s = br.readLine()) != null) {
					if (s.contains(":=")) {
						s = s.toUpperCase();
						
						//去除空格
						s = cleanBlank(s);
						
						//解析字符(加上末尾标识符)
						s = analyseCode(s+"$");
						
						s = s.substring(0,s.length()-1);
						
						//System.out.println(s);
						//解析SUM
						if (s.contains("SUM(")) {
							s = analyseSum(s);
							//System.out.println(s);
						}else {
							s = changeToTable(s);
						}
						
						
						
						finalStr = finalStr + "'"+s+"',";
						
						
					}
				}
				
				finalStr = finalStr.substring(0, finalStr.length()-1);
				finalStr = finalStr + "],";
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			//break;
			
		}
		
		finalStr = finalStr.substring(0, finalStr.length()-1);
		finalStr = finalStr + "}";
		finalStr = finalStr.replace(":=", "==");
		System.out.println(finalStr);
		
	}
	

	
	private static String analyseCode(String s) {
		
		if (s.equals("F10:=C10+D10-E10$")) {
			//System.out.println("231231231232");
		}
		
		
		//非字母数字标识符匹配
		tempList = new ArrayList<>();
		int endFlag = s.indexOf("$");
		int point = 0;
		while((endFlag-point)>1) {
			int tempPoint = getRecentFlag(point,s);
			
			tempList.add(s.substring(point, tempPoint));
			
			if (tempPoint == s.indexOf("SUM(")) {
				tempPoint = tempPoint + 4;
			}else if(tempPoint == s.indexOf(":=")) {
				tempPoint = tempPoint + 2;
			}else {
				tempPoint++;
			}
			tempPoint = reSetRecentFlag(tempPoint,s);
			point = tempPoint;
		}
		
		
		
		//解析tempList到s中去
		for (String string : tempList) {
			int sampleFrom = s.indexOf(string);
			int sampleEnd = sampleFrom + string.length();
			String tempStr = analyseCodeDetail(s.substring(sampleFrom, sampleEnd));
			s = s.substring(0,sampleFrom) +"["+ tempStr + "]" +s.substring(sampleEnd);
		}
		
		if (s.equals("[6#10]:=[3#10]+[4#10-5#10]$")) {
			System.out.println("!!!!!");
		}
		
		
		//System.out.println(s);
		
		return s;
	}

	
	
	//搜索标志位，>from > val
	private static int getRecentFlag(int from , String s ){
		String tempStr = s.substring(from);
		int val = tempStr.indexOf("$");
		for (String string : symbols) {
			int temp = tempStr.indexOf(string);
			if (temp > 0 ) {
				if (temp < val ) {
					if (string.equals("-")) {
						if (tempStr.charAt(temp+1) == '>') {
							continue;
						}
					}
					val = temp;
					
				}
			}
		}
		
		return val+from;
	}
	
	
	//标志位重装
	private static int reSetRecentFlag(int flag , String s ){
		
		String tempStr = s.substring(flag);
		int temp = 0;
		for (int i = 0; i < symbols.size(); i++) {
			if(temp == tempStr.indexOf(symbols.get(i))) {
				
				if (symbols.get(i).equals("-")) {
					if (tempStr.charAt(temp+1) == '>') {
						continue;
					}
						
					
				}
				temp += symbols.get(i).length();
				
			}
		}
		return flag + temp;
	}
		
		
		

	//11111111
	private static String analyseCodeDetail(String s) {
		//1
		Set<String> ketSet = demos.keySet();
		
		for (Iterator iterator = ketSet.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			s = s.replace(string, demos.get(string).toString()+"#");
		}
		
		
		//2
		Set<String> ketSet1 = demos1.keySet();
		
		for (Iterator iterator = ketSet1.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			s = s.replace(string, demos1.get(string).toString()+"#");
		}
		return s;
	}



	//解析sum表达式-等待完成
	private static String analyseSum(String s) {
		int from = s.indexOf("SUM(");
		if (s.substring(from).indexOf("SUM(")>0) {
			System.out.println("意外出现了多个SUM！！！！！！！！！！！");
			System.exit(0);
		}
		int to = from+s.substring(from).indexOf(")");
		//System.out.println("form:"+from+" to:"+to);
		
		String tempOri = s.substring(from, to+1);
		//System.out.println(tempOri);
		
		String aidSum = tempOri;
		
		if (aidSum.contains(",") && aidSum.contains(":")) {
			//..
			aidSum = aidSum.replace("SUM","").replace("(", "").replace(")","");
			String tempStr1 [] = aidSum.split(",");
			for (int i = 0; i < tempStr1.length; i++) {
				
				
				aidSum = "(";
				if (tempStr1[i].contains(":")) {
					String [] tempPoint0 = tempStr1[i].split(":");
					String [] tempPoint = tempPoint0[0].replace("[","").replace("]", "").split("#");
					int [] fromPoint = new int[2];
					int [] toPoint = new int[2];
					fromPoint[0] = Integer.parseInt(tempPoint[0]);
					fromPoint[1] = Integer.parseInt(tempPoint[1]);
					tempPoint = tempPoint0[1].replace("[","").replace("]", "").split("#");
					toPoint[0] = Integer.parseInt(tempPoint[0]);
					toPoint[1] = Integer.parseInt(tempPoint[1]);
					for (int i1 = fromPoint[0]; i1 <= toPoint[0]; i1++) {
						for(int i2 = fromPoint[1]; i2 <= toPoint[1]; i2++) {
							//==================================================================
							//偏移量修改
							int [] simplePoint = new int[2];
							simplePoint[0] = i1;
							simplePoint[1] = i2;
							simplePoint = alterHeightAndWidth(simplePoint);
							//==================================================================
							aidSum  = aidSum + "["+iiiName+"$tbody_"+simplePoint[1]+"_"+simplePoint[0]+"]+";
						}
					}
					
				}else {
					int [] simplePoint = new int[2];
					String tempPoint [] = tempStr1[i].replace("[","").replace("]", "").split("#");
					simplePoint[0] = Integer.parseInt(tempPoint[0]);
					simplePoint[1] = Integer.parseInt(tempPoint[1]);
					
					//==================================================================
					//偏移量修改
					simplePoint = alterHeightAndWidth(simplePoint);
					//==================================================================
					aidSum  = aidSum + "["+iiiName+"$tbody_"+simplePoint[1]+"_"+simplePoint[0]+"]+";
				}
				aidSum = aidSum.substring(0,aidSum.length()-1);
				
				
			}
			aidSum += ")";
			
			//System.out.println(aidSum);
			
		}else if(aidSum.contains(":")){
			//..
			aidSum = aidSum.replace("SUM","");
			int [] fromPoint = new int[2];
			int [] toPoint = new int[2];
			Pattern p = Pattern.compile("\\[.*?\\]");
			Matcher m = p.matcher(aidSum);
			int i = 0;
			while (m.find()) { 
				String [] tempPoint = m.group().replace("[","").replace("]", "").split("#");
				if (i==0) {
					fromPoint[0] = Integer.parseInt(tempPoint[0]);
					fromPoint[1] = Integer.parseInt(tempPoint[1]);
				}else {
					toPoint[0] = Integer.parseInt(tempPoint[0]);
					toPoint[1] = Integer.parseInt(tempPoint[1]);
				}
				i++;
			}
			
			/*if (fromPoint[0] >= toPoint[0] && fromPoint[1] >= toPoint[1]) {
				
				int [] temp = fromPoint;
				fromPoint = toPoint;
				toPoint = temp;
				
			}*/
			
			if (fromPoint[0] > toPoint[0]) {
				System.out.println("error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
			}
			if (fromPoint[1] > toPoint[1]) {
				System.out.println("error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2");
			}
			aidSum = "(";
			
			
			for (int i1 = fromPoint[0]; i1 <= toPoint[0]; i1++) {
				for(int i2 = fromPoint[1]; i2 <= toPoint[1]; i2++) {
					
					//==================================================================
					//偏移量修改
					int [] simplePoint = new int[2];
					simplePoint[0] = i1;
					simplePoint[1] = i2;
					simplePoint = alterHeightAndWidth(simplePoint);
					//==================================================================
					aidSum  = aidSum + "["+iiiName+"$tbody_"+simplePoint[1]+"_"+simplePoint[0]+"]+";
				}
			}
			aidSum = aidSum.substring(0,aidSum.length()-1);
			
			aidSum += ")";
			//System.out.println(aidSum);
		}else if(aidSum.contains(",")) {
			//.. 
			aidSum = aidSum.replace("SUM","").replace("(", "").replace(")","");
			String tempStr2 [] = aidSum.split(",");
			
			int [] simplePoint = new int[2];
			
			
			aidSum = "(";
			//获取前面的单个+
			for (int i = 0; i < tempStr2.length-1; i++) {
				String tempPoint [] = tempStr2[i].replace("[","").replace("]", "").split("#");
				simplePoint[0] = Integer.parseInt(tempPoint[0]);
				simplePoint[1] = Integer.parseInt(tempPoint[1]);
				
				//==================================================================
				//偏移量修改
				simplePoint = alterHeightAndWidth(simplePoint);
				//==================================================================
				aidSum  = aidSum + "["+iiiName+"$tbody_"+simplePoint[1]+"_"+simplePoint[0]+"]+";
			}
			
			aidSum = aidSum.substring(0,aidSum.length()-1);
			aidSum += ")";
			//System.out.println(aidSum);
		}
		
		s = changeToTable(s.substring(0,from))+aidSum+changeToTable(s.substring(to+1));
		//System.out.println(s);

		return s;
	}

	
	public static String changeToTable(String s) {
		
		
		Map<String ,String > keyMap = new HashMap<>();
		Pattern p = Pattern.compile("\\[.*?\\]");
		Matcher m = p.matcher(s);
		int[] simplePoint = new int[2];
		while(m.find()) {
			
			String tempPoint [] = m.group().replace("[","").replace("]", "").split("#");
			
			
			simplePoint[0] = Integer.parseInt(tempPoint[0]);
			
			
			if (tempPoint[1].equals("10-5")) {
				System.out.println("asdasd");
			}
			
			simplePoint[1] = Integer.parseInt(tempPoint[1]);
			
			//==================================================================
			//偏移量修改
			simplePoint = alterHeightAndWidth(simplePoint);
			//==================================================================
			keyMap.put(m.group(), "["+iiiName+"$tbody_"+simplePoint[1]+"_"+simplePoint[0]+"]");
			
		}
		
		Set<String> keySet = keyMap.keySet();
		for (String string : keySet) {
			s = s.replace(string, keyMap.get(string));
		}
		
		return s;
	}
	


	private static int [] alterHeightAndWidth(int i[]) {
		if (null != discrepancyMap.get(iii) && discrepancyMap.get(iii).contains("#")) {
			//4-3
			//0-2
			String[] dis = discrepancyMap.get(iii).split("#");
			i[1] = i[1] - Integer.parseInt(dis[0]);
			i[0] = i[0] - Integer.parseInt(dis[1]);
		}
		return i;
	}



	private static void installMap() {
		discrepancyMap.put(2,"4#1");//height  -  weith  -
		discrepancyMap.put(7,"3#1");//height  -  weith  -
		
		//序号
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
		
		symbols.add(":=");
		symbols.add("+");
		symbols.add("SUM(");
		symbols.add("-");
		symbols.add(":");
		symbols.add(",");
		symbols.add(")");
		symbols.add("$");
		
	}

	
	

	public static String cleanNumber(String str) {
		str = str.replace("0", "");
		str = str.replace("1", "");
		str = str.replace("2", "");
		str = str.replace("3", "");
		str = str.replace("4", "");
		str = str.replace("5", "");
		str = str.replace("6", "");
		str = str.replace("7", "");
		str = str.replace("8", "");
		str = str.replace("9", "");
		return str;
	}

	public static String cleanChar(String str) {
		str = str.replace("A", "");
		str = str.replace("B", "");
		str = str.replace("C", "");
		str = str.replace("D", "");
		str = str.replace("E", "");
		str = str.replace("F", "");
		str = str.replace("G", "");
		str = str.replace("H", "");
		str = str.replace("I", "");
		str = str.replace("J", "");
		str = str.replace("K", "");
		str = str.replace("L", "");
		str = str.replace("M", "");
		str = str.replace("N", "");
		str = str.replace("O", "");
		str = str.replace("P", "");
		str = str.replace("Q", "");
		str = str.replace("R", "");
		str = str.replace("S", "");
		str = str.replace("T", "");
		str = str.replace("U", "");
		str = str.replace("V", "");
		str = str.replace("W", "");
		str = str.replace("X", "");
		str = str.replace("Y", "");
		str = str.replace("Z", "");
		return str;
	}
	
	
	public static String cleanBlank(String str) {
		str = str.replace(" ", "");
		return str;
	}
	

}
