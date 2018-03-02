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


/**
 * 
 * 转换成名称显示
 * 输出sql插入语句
 * @author jiangyqc
 *
 */
public class AnalyseFormula5 {

	public static Map<Integer,String> discrepancyMap = new HashMap<Integer,String>();
	public static Map<String, Integer> demos1 = new HashMap<String, Integer>();
	public static Map<String, Integer> demos = new HashMap<String, Integer>();
	
	public static List<String> symbols =  new ArrayList<>(); 
	public static List<String> tempList = null; 
	
	public static int iii = 0;
	public static String iiiName = "";
	
	
	
	public static Map<Integer,Map> OneMap = new HashMap<Integer,Map>();
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String v_bbmc = "";
		String v_formula = "";
				
				
		installMap();
		File file = null;
		
		for(int i = 1 ; i < 5 ;i++){
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
						
						s = changeToTableNew(s);						
						
						v_bbmc = "SJ"+flag;
						
						v_formula = s.replace(":=", "==");
						
						System.out.println("insert into gy_bbcx_shxx_formulas  (uuid, bbmc, formula, yxbz) values  (SYS_GUID(), '"+v_bbmc+"', '"+v_formula+"', 'Y');");
					}
				}
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			//break;
			System.out.println("commit;");
			
		}
		
		
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



	public static String changeToTableNew(String s) {
		
		
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
			//simplePoint = alterHeightAndWidth(simplePoint);
			
			String [] name = alterName(simplePoint);
			
			//==================================================================
			//
			
			
			if (name == null) {
				keyMap.put(m.group(), "["+iiiName+"$"+simplePoint[1]+"_"+simplePoint[0]+"]");
			}else {
				keyMap.put(m.group(), "["+iiiName+"$"+name[1]+"_"+name[0]+"]");
			}
			
		}
		
		Set<String> keySet = keyMap.keySet();
		for (String string : keySet) {
			s = s.replace(string, keyMap.get(string));
		}
		
		return s;
	}
	
	
	private static String [] alterName(int i[]) {
		String [] name = new String[2];
		
		Map SJSJSJ = OneMap.get(iii);
		
		if (SJSJSJ!=null) {
			name[0] = (String) SJSJSJ.get(i[0]+"H");
			name[1] = (String) SJSJSJ.get(i[1]+"L");
			return name;
		}else{
			return null;
		}
		
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
		
		//map
		Map<String, String> demo01 = new HashMap<String, String>();
		Map<String, String> demo02 = new HashMap<String, String>();
		Map<String, String> demo03 = new HashMap<String, String>();
		Map<String, String> demo04 = new HashMap<String, String>();
		Map<String, String> demo07 = new HashMap<String, String>();
		
		
		OneMap.put(1,demo01);
		OneMap.put(2,demo02);
		OneMap.put(3,demo03);
		OneMap.put(4,demo04);
		OneMap.put(7,demo07);
		
		
		
		
		
		demo02.put("4L","ZJ");
		demo02.put("5L","SSSRHJ");
		demo02.put("6L","ZZSSR");
		demo02.put("7L","GNZZS");
		demo02.put("8L","YBZZS");
		demo02.put("9L","GZZZS");
		demo02.put("10L","QZZGTLZGSGZZZSSR");
		demo02.put("11L","CJRJYZZSTS");
		demo02.put("12L","RJZZSTS");
		demo02.put("13L","SGZHLYZZSTS");
		demo02.put("14L","SDZZSTS");
		demo02.put("15L","ZYZHLYZZSTS");
		demo02.put("16L","CPYZZSTS");
		demo02.put("17L","MDDZZZS");
		demo02.put("18L","MDDZGZZZS");
		demo02.put("19L","2JKHWZZS");
		demo02.put("20L","2XFSSR");
		demo02.put("21L","GNXFS");
		demo02.put("22L","QZCPYXFS");
		demo02.put("23L","JKXFPXFS");
		demo02.put("24L","QZJKCPYXFS");
		demo02.put("25L","3YYS");
		demo02.put("26L","JRBXYYYS");
		demo02.put("27L","QTYYS");
		demo02.put("28L","4QYSDS");
		demo02.put("29L","QZZYGDSR");
		demo02.put("30L","1YBQYSDS");
		demo02.put("31L","NZQY1");
		demo02.put("32L","WZQY1");
		demo02.put("33L","2FZJGYJSDS");
		demo02.put("34L","NZQY2");
		demo02.put("35L","WZQY2");
		demo02.put("36L","3ZJGYJSDS");
		demo02.put("37L","NZQY3");
		demo02.put("38L","WZQY3");
		demo02.put("39L","4FZJGHSQJSDS");
		demo02.put("40L","NZQY4");
		demo02.put("41L","WZQY4");
		demo02.put("42L","5ZJGHSQJSDS");
		demo02.put("43L","NZQY5");
		demo02.put("44L","WZQY5");
		demo02.put("45L","6QYSDSDFPSR");
		demo02.put("46L","NZQY6");
		demo02.put("47L","WZQY6");
		demo02.put("48L","5GRSDS");
		demo02.put("49L","LXSDS");
		demo02.put("50L","QTGRSDS");
		demo02.put("51L","6ZYS");
		demo02.put("52L","7GDZCTZFXDJS");
		demo02.put("53L","8CSWHJSS");
		demo02.put("54L","9FCS");
		demo02.put("55L","10YHS");
		demo02.put("56L","ZQJYYHS");
		demo02.put("57L","QTYHS");
		demo02.put("58L","11CZTDSYS");
		demo02.put("59L","12TDZZS");
		demo02.put("60L","13CCS");
		demo02.put("61L","14CLGZS");
		demo02.put("62L","15YYS");
		demo02.put("63L","16GDZYS");
		demo02.put("64L","17QS");
		demo02.put("65L","18QTSS");
		demo02.put("66L","ECPYXFSTS");
		demo02.put("67L","SCKTSHJ");
		demo02.put("68L","1CKHWTZZS");
		demo02.put("69L","2GZZZSCKTS");
		demo02.put("70L","3MDDJZZS");
		demo02.put("71L","4MDDJGZZZS");
		demo02.put("72L","5CKXFPTXFS");
		demo02.put("73L","SFSSRHJ");
		demo02.put("74L","1JYFFJSR");
		demo02.put("75L","2DFJYFJ");
		demo02.put("76L","3WHSYJSFSR");
		demo02.put("77L","4HSSYKQSYFSR");
		demo02.put("78L","5SWBMFMSR");
		demo02.put("79L","6CJRJYBZJJ");
		demo02.put("80L","7SHBXJJSR");
		demo02.put("81L","QYZGJBYLBXJJSR");
		demo02.put("82L","JGSYDWJBYLBXJJSR");
		demo02.put("83L","SYBXJJSR1");
		demo02.put("84L","JBYLBXJJSR");
		demo02.put("85L","GSBXJJSR");
		demo02.put("86L","SYBXJJSR2");
		demo02.put("87L","QTSHBXJJSR");
		demo02.put("88L","8ZFXJJSR");
		demo02.put("89L","FQDQDZCPCLJJSR");
		demo02.put("90L","QTZFXJJSR");
		demo02.put("91L","9GHJFSR");
		demo02.put("92L","10QTFSSR");


		demo02.put("1H","XH");
		demo02.put("2H","XM");
		demo02.put("3H","HJ");
		demo02.put("4H","BNXQRK");
		demo02.put("5H","20010501HCQRK");
		demo02.put("6H","20010501QCQRK");
		demo02.put("7H","ZY");
		demo02.put("8H","DFXJ1");
		demo02.put("9H","DFSJ1");
		demo02.put("10H","DFSJ2");
		demo02.put("11H","DFXJ2");

		demo07.put("3L","ZJ");
		demo07.put("4L","YSSSRHJ");
		demo07.put("5L","1ZZSSR");
		demo07.put("6L","QZGNZZS");
		demo07.put("7L","2XFSSR");
		demo07.put("8L","QZGNXFS");
		demo07.put("9L","3YYS");
		demo07.put("10L","4QYSDS");
		demo07.put("11L","5GRSDS");
		demo07.put("12L","6ZYS");
		demo07.put("13L","7GDZCTZFXDJS");
		demo07.put("14L","8CSWHJSS");
		demo07.put("15L","9FCS");
		demo07.put("16L","10YHS");
		demo07.put("17L","11CZTDSYS");
		demo07.put("18L","12TDZZS");
		demo07.put("19L","13CCS");
		demo07.put("20L","14CLGZS");
		demo07.put("21L","15YYS");
		demo07.put("22L","16GDZYS");
		demo07.put("23L","17QS");
		demo07.put("24L","18QTSS");
		demo07.put("25L","EQTSRHJ");
		demo07.put("26L","FQDQDZCPCLJJSR");
		demo07.put("1H","XH");
		demo07.put("2H","XM");
		demo07.put("3H","DJSJNCYE");
		demo07.put("4H","DJSJQMYE");
		demo07.put("5H","ZTSJNCYE");
		demo07.put("6H","ZTSJQMYE");
		demo07.put("7H","DJSJNCYE2");
		demo07.put("8H","DJSJQMYE2");
		demo07.put("9H","DCLSSSJNCYE");
		demo07.put("10H","DCLSSSJQMYE");
		demo07.put("11H","SSSJHXNCYE");
		demo07.put("12H","SSSJHXQMYE");


		
		demo01.put("1H","XH");
		demo01.put("2H","ZJZYKM");
		demo01.put("3H","ZJZYNCYE");
		demo01.put("4H","ZJZYQMYE");
		demo01.put("5H","ZJLYKM");
		demo01.put("6H","ZJLYKMNCYE");
		demo01.put("7H","ZJLYKMQMYE");

		demo01.put("3L","HJ");
		demo01.put("4L","1DZSS");
		demo01.put("5L","2DZQTSR");
		demo01.put("6L","3JMSJ");
		demo01.put("7L","4DJSJ");
		demo01.put("8L","5ZTSJ");
		demo01.put("9L","6RKSS");
		demo01.put("10L","7RKQTSR");
		demo01.put("11L","8TTSJ");
		demo01.put("12L","9DCLSSSJ");
		demo01.put("13L","10SSSJHX");
		demo01.put("14L","11BGK");

		demo03.put("3L","ZJ");
		demo03.put("4L","YSSSRHJ");
		demo03.put("5L","1ZZSSR");
		demo03.put("6L","QZGZZZS");
		demo03.put("7L","2XFSSR");
		demo03.put("8L","3YYS");
		demo03.put("9L","4QYSDS");
		demo03.put("10L","5GRSDS");
		demo03.put("11L","6ZYS");
		demo03.put("12L","7GDZCTZFXDJS");
		demo03.put("13L","8CSWHJSS");
		demo03.put("14L","9FCS");
		demo03.put("15L","10YHS");
		demo03.put("16L","11CZTDSYS");
		demo03.put("17L","12TDZZS");
		demo03.put("18L","13CCS");
		demo03.put("19L","14CLGZS");
		demo03.put("20L","15YYS");
		demo03.put("21L","16GDZYS");
		demo03.put("22L","17QS");
		demo03.put("23L","18QTSS");
		demo03.put("24L","EQTSRHJ");
		demo03.put("25L","QZFQDQDZCPCLJJSR");

		
		demo03.put("1H","XH");
		demo03.put("2H","XM");
		demo03.put("3H","NCYE");
		demo03.put("4H","DNFSEHJ");
		demo03.put("5H","DNFSEGYQY");
		demo03.put("6H","DNFSEJTQY");
		demo03.put("7H","DNFSEGFHZQY");
		demo03.put("8H","DNFSELYQY");
		demo03.put("9H","DNFSEQZGYKG");
		demo03.put("10H","DNFSEGFGS");
		demo03.put("11H","DNFSEQZGYKG");
		demo03.put("12H","DNFSESYQY");
		demo03.put("13H","DNFSEGATTZQY");
		demo03.put("14H","DNFSEQZGYKG");
		demo03.put("15H","DNFSEWSTZQY");
		demo03.put("16H","DNFSEQZGYKG");
		demo03.put("17H","DNFSEQTQY");
		demo03.put("18H","QMYE");
		
		
		demo04.put("2L","ZJ");
		demo04.put("3L","YSSSRHJ");
		demo04.put("4L","WDQYJSK");
		demo04.put("5L","JPZHZ");
		demo04.put("6L","GTJKKQYQS");
		demo04.put("7L","WNCQ");
		demo04.put("8L","BNXQ");
		demo04.put("9L","1GNZZS");
		demo04.put("10L","QZGZZZS");
		demo04.put("11L","WDQYJSK");
		demo04.put("12L","JPZHZ");
		demo04.put("13L","GTJKKQYQS");
		demo04.put("14L","WNCQ");
		demo04.put("15L","BNXQ");
		demo04.put("16L","2GNXFS");
		demo04.put("17L","WDQYJSK");
		demo04.put("18L","JPZHZ");
		demo04.put("19L","GTJKKQYQS");
		demo04.put("20L","WNCQ");
		demo04.put("21L","BNXQ");
		demo04.put("22L","3YYS");
		demo04.put("23L","WDQYJSK");
		demo04.put("24L","JPZHZ");
		demo04.put("25L","GTJKKQYQS");
		demo04.put("26L","WNCQ");
		demo04.put("27L","BNXQ");
		demo04.put("28L","4QYSDS");
		demo04.put("29L","WDQYJSK");
		demo04.put("30L","JPZHZ");
		demo04.put("31L","GTJKKQYQS");
		demo04.put("32L","WNCQ");
		demo04.put("33L","BNXQ");
		demo04.put("34L","5GRSDS");
		demo04.put("35L","WDQYJSK");
		demo04.put("36L","JPZHZ");
		demo04.put("37L","GTJKKQYQS");
		demo04.put("38L","WNCQ");
		demo04.put("39L","BNXQ");
		demo04.put("40L","6ZYS");
		demo04.put("41L","WDQYJSK");
		demo04.put("42L","JPZHZ");
		demo04.put("43L","GTJKKQYQS");
		demo04.put("44L","WNCQ");
		demo04.put("45L","BNXQ");
		demo04.put("46L","7CSWHJSS");
		demo04.put("47L","WDQYJSK");
		demo04.put("48L","JPZHZ");
		demo04.put("49L","GTJKKQYQS");
		demo04.put("50L","WNCQ");
		demo04.put("51L","BNXQ");
		demo04.put("52L","8FCS");
		demo04.put("53L","WDQYJSK");
		demo04.put("54L","JPZHZ");
		demo04.put("55L","GTJKKQYQS");
		demo04.put("56L","WNCQ");
		demo04.put("57L","BNXQ");
		demo04.put("58L","9YHS");
		demo04.put("59L","WDQYJSK");
		demo04.put("60L","JPZHZ");
		demo04.put("61L","GTJKKQYQS");
		demo04.put("62L","WNCQ");
		demo04.put("63L","BNXQ");
		demo04.put("64L","10CZTDSYS");
		demo04.put("65L","WDQYJSK");
		demo04.put("66L","JPZHZ");
		demo04.put("67L","GTJKKQYQS");
		demo04.put("68L","WNCQ");
		demo04.put("69L","BNXQ");
		demo04.put("70L","11TDZZS");
		demo04.put("71L","WDQYJSK");
		demo04.put("72L","JPZHZ");
		demo04.put("73L","GTJKKQYQS");
		demo04.put("74L","WNCQ");
		demo04.put("75L","BNXQ");
		demo04.put("76L","12CCS");
		demo04.put("77L","WDQYJSK");
		demo04.put("78L","JPZHZ");
		demo04.put("79L","GTJKKQYQS");
		demo04.put("80L","WNCQ");
		demo04.put("81L","BNXQ");
		demo04.put("82L","13YYS");
		demo04.put("83L","WDQYJSK");
		demo04.put("84L","JPZHZ");
		demo04.put("85L","GTJKKQYQS");
		demo04.put("86L","WNCQ");
		demo04.put("87L","BNXQ");
		demo04.put("88L","14GDZYS");
		demo04.put("89L","WDQYJSK");
		demo04.put("90L","JPZHZ");
		demo04.put("91L","GTJKKQYQS");
		demo04.put("92L","WNCQ");
		demo04.put("93L","BNXQ");
		demo04.put("94L","15QS");
		demo04.put("95L","WDQYJSK");
		demo04.put("96L","JPZHZ");
		demo04.put("97L","GTJKKQYQS");
		demo04.put("98L","WNCQ");
		demo04.put("99L","BNXQ");
		demo04.put("100L","16QTSS");
		demo04.put("101L","WDQYJSK");
		demo04.put("102L","JPZHZ");
		demo04.put("103L","GTJKKQYQS");
		demo04.put("104L","WNCQ");
		demo04.put("105L","BNXQ");
		demo04.put("106L","EQTSRHJ");
		demo04.put("107L","QZFQDQDZCPCLJJSR");


		
		
		demo04.put("1H","XH");
		demo04.put("2H","XM");
		demo04.put("3H","QCYE");
		demo04.put("4H","BQZJE");
		demo04.put("5H","BQJSE");
		demo04.put("6H","QMYE");


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
