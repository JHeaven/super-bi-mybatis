package com.heaven.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oracle.net.aso.s;

/**
 * 审核公式转换成数字 再转换成字母
 * 
 * @author jiangyqc
 *
 */
public class AnalyseFormula7 {

	public static Map<String, Integer> demos1 = new HashMap<String, Integer>();
	public static Map<String, Integer> demos = new HashMap<String, Integer>();
	public static Map<String, String> demoX = new HashMap<String, String>();
	public static Map<String, String> demoxx = new HashMap<String, String>();

	public static List<String> symbols = new ArrayList<>();
	public static List<String> tempList = null;

	public static int iii = 0;
	public static String iiiName = "";

	public static Map<Integer, Map> OneMap = new HashMap<Integer, Map>();

	public static int count = 0;
	
	public static String iiiNameFormer = "";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		installMap();
		File file = null;
		
		//文件写入
		File file2 = new File("D:\\Project\\20171105审核框架\\1111-01-39-sqlOut.txt");
		
		FileWriter fw = null;
		BufferedWriter writer = null;
		
		fw = new FileWriter(file2);
		writer = new BufferedWriter(fw);
		
		//json
		File file3 = new File("D:\\Project\\20171105审核框架\\1111-01-39-jsonOut.txt");
		FileWriter fw3 = null;
		BufferedWriter writer3 = null;
		
		fw3 = new FileWriter(file3);
		writer3 = new BufferedWriter(fw3);
		
		writer3.write("var formulasS = {");
				
				
		for (int i = 1; i < 2; i++) {
			iii = i;
			if (i == 15) {
				continue;
			}

			String flag = "";
			if (i < 10) {
				flag = "0" + i;
			} else {
				flag = "" + i;
			}

			iiiName = "SJ" + flag;
			file = new File("D:\\Project\\20171105审核框架\\1111-01-39.txt");

			if (!file.exists()) {
				System.out.println("文件 不存在！");
				continue;
			}

			// 开始解析
			try {
				BufferedReader br;
				br = new BufferedReader(new FileReader(file));
				String s = null;
				while ((s = br.readLine()) != null) {
					
					iiiName = getiiiName(s);
					
					
					s = s.toUpperCase();

					// 去除空格
					s = cleanBlank(s);
					
					/* 只输出后台公式
					if (!s.contains("_NC_") && !s.contains("_SQ_") && !s.contains("_SNM_")) {
						continue;
					}
					*/
					// s = changeToTable(s);

					s = chantetables(s);
					
					s = filterK(s);

					//System.out.println(s.split("提示:")[0]);
					
					String v_flag = "Q";

					if (s.contains("_NC_") || s.contains("_SQ_") || s.contains("_SNM_")) {
						v_flag = "H";
					}
					
					if (s.contains("提示:")) {
						String temp = s.split("提示:")[0].replace("'", "''");
						//System.out.println("insert into gy_bbcx_shxx_formulas  (uuid, bbmc, formula, yxbz, flag, nfsq, gslx, shlx, tips, sfzdy) values  (sys_guid(),'"+iiiName+"', '"+temp+"', 'Y', '"+v_flag+"', '2017', 'S', 'H', '"+s.split("提示:")[1]+"', 'N');");
						count++;
						writer.write("insert into gy_bbcx_shxx_formulas  (uuid, bbmc, formula, yxbz, flag, nfsq, gslx, shlx, tips, sfzdy) values  (sys_guid(),'"+iiiName+"', '"+temp+"', 'Y', '"+v_flag+"', '2017', 'S', 'H', '"+s.split("提示:")[1]+"', 'N');");
						writer.newLine();//换行
						if (count%5000 == 0) {
							writer.write("commit;");
							writer.newLine();//换行
							writer.write("prompt "+count+" records loaded");
							writer.newLine();//换行
						}
						if (count%100 == 0) {
							System.out.println("loaded-"+count);
						}
						
						
						
						//json生成
						if (iiiName.equals(iiiNameFormer)) {
							writer3.write(",["+"\""+temp.replace("''", "'").replace("\"", "'")+"\",\""+s.split("提示:")[1].replace("\"", " ")+"\",\""+v_flag+"\"]");
						}else {
							iiiNameFormer = iiiName;
							if (!"".equals(iiiNameFormer)) {
								
								writer3.write("],");
							}
							writer3.write(iiiName+":[");
							writer3.write("["+"\""+temp.replace("''", "'").replace("\"", "'")+"\",\""+s.split("提示:")[1].replace("\"", " ")+"\",\""+v_flag+"\"]");
							
						}
						
						
						
					}

				}
				
				writer.close();
				fw.close();
				
				writer3.write("]}");
				writer3.close();
				fw3.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		}
		
		System.out.println("END");

	}


	// 规避风险 A1 替换 A11
	private static String chantetables(String s) {

		for (Iterator iterator = demos.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			for (int i = 650; i > 0; i--) {
				s = s.replace(string + i, "{" + i + "#" + demos.get(string) + "}");
			}
		}

		for (Iterator iterator = demos1.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			for (int i = 650; i > 0; i--) {
				s = s.replace(string + i, "{" + i + "#" + demos1.get(string) + "}");
			}
		}

		

		for (Iterator iterator = demoxx.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			s = s.replace(string, demoxx.get(string));
		}
		
		
		s = changeToTableNew(s);

		return s;
	}

	// 正则提取表格号
	public static String changeToTable(String s) {

		Map<String, String> keyMap = new HashMap<>();
		Pattern p = Pattern.compile("[A-Z]{1,2}[0-9]{1,2}");
		Matcher m = p.matcher(s);
		while (m.find()) {

			System.out.println(m.group());

		}

		System.out.println("=====================================");
		return s;
	}
	
	
	// 正则去除SQ NC SNM 括号
		public static String filterK(String s) {

			if (s.contains("_SQ_(")) {
				Map<String, String> keyMap = new HashMap<>();
				Pattern p = Pattern.compile("_SQ_\\(.*?\\)");
				Matcher m = p.matcher(s);
				while (m.find()) {
					System.out.println(m.group());
					s = s.replace(m.group(), m.group().replace("(", "").replace(")",""));
				}
			}
			
			
			if (s.contains("_NC_(")) {
				Map<String, String> keyMap = new HashMap<>();
				Pattern p = Pattern.compile("_NC_\\(.*?\\)");
				Matcher m = p.matcher(s);
				while (m.find()) {
					System.out.println(m.group());
					s = s.replace(m.group(), m.group().replace("(", "").replace(")",""));
				}
			}
			
			
			if (s.contains("_SNM_(")) {
				Map<String, String> keyMap = new HashMap<>();
				Pattern p = Pattern.compile("_SNM_\\(.*?\\)");
				Matcher m = p.matcher(s);
				while (m.find()) {
					System.out.println(m.group());
					s = s.replace(m.group(), m.group().replace("(", "").replace(")",""));
				}
			}
			

			return s;
		}

	public static String changeToTableNew(String s) {
		int iiiTemp = iii;
		String iiiNameTemp = iiiName;
		Map<String, String> keyMap = new HashMap<>();
		Pattern p = Pattern.compile("\\{.*?\\}");
		Matcher m = p.matcher(s);
		int[] simplePoint = new int[2];
		while (m.find()) {
			
			if (m.group().contains("$")) {
				//检测到跨表
				String tempStr  [] = m.group().replace("{", "").replace("}", "").split("\\$");
				String bbmcTemp = tempStr[0];
				String tempPoint[] = tempStr[1].split("#");
				
				//标志位重定向
				iii = Integer.parseInt(bbmcTemp.split("_")[1]);
				iiiName = bbmcTemp.replace("_", "");
				
				simplePoint[0] = Integer.parseInt(tempPoint[0]);

				if (tempPoint[1].equals("10-5")) {
					System.out.println("asdasd");
				}

				simplePoint[1] = Integer.parseInt(tempPoint[1]);

				// ==================================================================
				// 偏移量修改
				// simplePoint = alterHeightAndWidth(simplePoint);

				String[] name = alterName(simplePoint);

				// ==================================================================
				//

				if (name == null) {
					keyMap.put(m.group(), "{"+iiiName+"$"+simplePoint[1] + "_" + simplePoint[0] + "}");
				} else {
					keyMap.put(m.group(), "{"+iiiName+"$"+ (name[1] == null ? simplePoint[1] : name[1]) + "#"
							+ (name[0] == null ? simplePoint[0] : name[0]) + "}");
				}
				
				
				//标志位回退
				iii = iiiTemp;
				iiiName = iiiNameTemp;
				
			}else {
				String tempPoint[] = m.group().replace("{", "").replace("}", "").split("#");

				simplePoint[0] = Integer.parseInt(tempPoint[0]);

				if (tempPoint[1].equals("10-5")) {
					System.out.println("asdasd");
				}

				simplePoint[1] = Integer.parseInt(tempPoint[1]);

				// ==================================================================
				// 偏移量修改
				// simplePoint = alterHeightAndWidth(simplePoint);

				String[] name = alterName(simplePoint);

				// ==================================================================
				//

				if (name == null) {
					keyMap.put(m.group(), "{"+iiiName+"$"+simplePoint[1] + "_" + simplePoint[0] + "}");
				} else {
					keyMap.put(m.group(), "{"+iiiName+"$"+ (name[1] == null ? simplePoint[1] : name[1]) + "#"
							+ (name[0] == null ? simplePoint[0] : name[0]) + "}");
				}
			}
			
			

		}

		Set<String> keySet = keyMap.keySet();
		for (String string : keySet) {
			s = s.replace(string, keyMap.get(string));
		}

		return s;
	}

	private static String[] alterName(int i[]) {
		String[] name = new String[2];

		Map SJSJSJ = OneMap.get(iii);

		if (SJSJSJ != null) {
			name[0] = (String) SJSJSJ.get(i[1] + "H");
			name[1] = (String) SJSJSJ.get(i[0] + "L");
			return name;
		} else {
			return null;
		}

	}

	private static void installMap() {
		// 序号
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

		demoxx.put("SJ_01->{", "{SJ_01$");
		demoxx.put("SJ_02->{", "{SJ_02$");
		demoxx.put("SJ_03->{", "{SJ_03$");
		demoxx.put("SJ_04->{", "{SJ_04$");
		demoxx.put("SJ_05->{", "{SJ_05$");
		demoxx.put("SJ_06->{", "{SJ_06$");
		demoxx.put("SJ_07->{", "{SJ_07$");
		demoxx.put("SJ_08->{", "{SJ_08$");
		demoxx.put("SJ_09->{", "{SJ_09$");
		demoxx.put("SJ_10->{", "{SJ_10$");
		demoxx.put("SJ_11->{", "{SJ_11$");
		demoxx.put("SJ_12->{", "{SJ_12$");
		demoxx.put("SJ_13->{", "{SJ_13$");
		demoxx.put("SJ_14->{", "{SJ_14$");
		demoxx.put("SJ_15->{", "{SJ_15$");
		demoxx.put("SJ_16->{", "{SJ_16$");
		demoxx.put("SJ_17->{", "{SJ_17$");
		demoxx.put("SJ_18->{", "{SJ_18$");
		demoxx.put("SJ_19->{", "{SJ_19$");
		demoxx.put("SJ_20->{", "{SJ_20$");
		demoxx.put("SJ_21->{", "{SJ_21$");
		demoxx.put("SJ_22->{", "{SJ_22$");
		demoxx.put("SJ_23->{", "{SJ_23$");
		demoxx.put("SJ_24->{", "{SJ_24$");
		demoxx.put("SJ_25->{", "{SJ_25$");
		demoxx.put("SJ_26->{", "{SJ_26$");
		demoxx.put("SJ_27->{", "{SJ_27$");
		demoxx.put("SJ_28->{", "{SJ_28$");
		demoxx.put("SJ_29->{", "{SJ_29$");
		demoxx.put("SJ_30->{", "{SJ_30$");
		demoxx.put("SJ_31->{", "{SJ_31$");
		demoxx.put("SJ_32->{", "{SJ_32$");
		demoxx.put("SJ_33->{", "{SJ_33$");
		demoxx.put("SJ_34->{", "{SJ_34$");
		demoxx.put("SJ_35->{", "{SJ_35$");
		demoxx.put("SJ_36->{", "{SJ_36$");
		demoxx.put("SJ_37->{", "{SJ_37$");
		demoxx.put("SJ_38->{", "{SJ_38$");
		demoxx.put("SJ_39->{", "{SJ_39$");
		demoxx.put("SJ_40->{", "{SJ_40$");
		demoxx.put("SJ_41->{", "{SJ_41$");
		demoxx.put("SJ_42->{", "{SJ_42$");
		demoxx.put("SJ_43->{", "{SJ_43$");
		demoxx.put("SJ_44->{", "{SJ_44$");
		demoxx.put("SJ_45->{", "{SJ_45$");
		demoxx.put("SJ_46->{", "{SJ_46$");
		demoxx.put("SJ_47->{", "{SJ_47$");
		demoxx.put("SJ_48->{", "{SJ_48$");
		demoxx.put("SJ_49->{", "{SJ_49$");
		demoxx.put("SJ_50->{", "{SJ_50$");
		demoxx.put("SJ_51->{", "{SJ_51$");
		demoxx.put("SJ_52->{", "{SJ_52$");
		demoxx.put("SJ_53->{", "{SJ_53$");
		demoxx.put("SJ_54->{", "{SJ_54$");
		demoxx.put("SJ_55->{", "{SJ_55$");
		demoxx.put("SJ_56->{", "{SJ_56$");
		demoxx.put("SJ_57->{", "{SJ_57$");
		demoxx.put("SJ_58->{", "{SJ_58$");
		demoxx.put("SJ_59->{", "{SJ_59$");
		demoxx.put("SJ_60->{", "{SJ_60$");
		demoxx.put("SJ_61->{", "{SJ_61$");
		demoxx.put("SJ_62->{", "{SJ_62$");
		demoxx.put("SJ_63->{", "{SJ_63$");
		demoxx.put("SJ_64->{", "{SJ_64$");
		demoxx.put("SJ_65->{", "{SJ_65$");
		demoxx.put("SJ_66->{", "{SJ_66$");
		demoxx.put("SJ_67->{", "{SJ_67$");
		demoxx.put("SJ_68->{", "{SJ_68$");
		demoxx.put("SJ_69->{", "{SJ_69$");
		demoxx.put("SJ_70->{", "{SJ_70$");
		demoxx.put("SJ_71->{", "{SJ_71$");
		demoxx.put("SJ_72->{", "{SJ_72$");
		demoxx.put("SJ_73->{", "{SJ_73$");
		demoxx.put("SJ_74->{", "{SJ_74$");
		demoxx.put("SJ_75->{", "{SJ_75$");
		demoxx.put("SJ_76->{", "{SJ_76$");
		demoxx.put("SJ_77->{", "{SJ_77$");
		demoxx.put("SJ_78->{", "{SJ_78$");
		demoxx.put("SJ_79->{", "{SJ_79$");
		demoxx.put("SJ_80->{", "{SJ_80$");
		demoxx.put("SJ_81->{", "{SJ_81$");
		demoxx.put("SJ_82->{", "{SJ_82$");
		
		demoxx.put("SJ_01->_NC_({", "_NC_({SJ_01$");
		demoxx.put("SJ_02->_NC_({", "_NC_({SJ_02$");
		demoxx.put("SJ_03->_NC_({", "_NC_({SJ_03$");
		demoxx.put("SJ_04->_NC_({", "_NC_({SJ_04$");
		demoxx.put("SJ_05->_NC_({", "_NC_({SJ_05$");
		demoxx.put("SJ_06->_NC_({", "_NC_({SJ_06$");
		demoxx.put("SJ_07->_NC_({", "_NC_({SJ_07$");
		demoxx.put("SJ_08->_NC_({", "_NC_({SJ_08$");
		demoxx.put("SJ_09->_NC_({", "_NC_({SJ_09$");
		demoxx.put("SJ_10->_NC_({", "_NC_({SJ_10$");
		demoxx.put("SJ_11->_NC_({", "_NC_({SJ_11$");
		demoxx.put("SJ_12->_NC_({", "_NC_({SJ_12$");
		demoxx.put("SJ_13->_NC_({", "_NC_({SJ_13$");
		demoxx.put("SJ_14->_NC_({", "_NC_({SJ_14$");
		demoxx.put("SJ_15->_NC_({", "_NC_({SJ_15$");
		demoxx.put("SJ_16->_NC_({", "_NC_({SJ_16$");
		demoxx.put("SJ_17->_NC_({", "_NC_({SJ_17$");
		demoxx.put("SJ_18->_NC_({", "_NC_({SJ_18$");
		demoxx.put("SJ_19->_NC_({", "_NC_({SJ_19$");
		demoxx.put("SJ_20->_NC_({", "_NC_({SJ_20$");
		demoxx.put("SJ_21->_NC_({", "_NC_({SJ_21$");
		demoxx.put("SJ_22->_NC_({", "_NC_({SJ_22$");
		demoxx.put("SJ_23->_NC_({", "_NC_({SJ_23$");
		demoxx.put("SJ_24->_NC_({", "_NC_({SJ_24$");
		demoxx.put("SJ_25->_NC_({", "_NC_({SJ_25$");
		demoxx.put("SJ_26->_NC_({", "_NC_({SJ_26$");
		demoxx.put("SJ_27->_NC_({", "_NC_({SJ_27$");
		demoxx.put("SJ_28->_NC_({", "_NC_({SJ_28$");
		demoxx.put("SJ_29->_NC_({", "_NC_({SJ_29$");
		demoxx.put("SJ_30->_NC_({", "_NC_({SJ_30$");
		demoxx.put("SJ_31->_NC_({", "_NC_({SJ_31$");
		demoxx.put("SJ_32->_NC_({", "_NC_({SJ_32$");
		demoxx.put("SJ_33->_NC_({", "_NC_({SJ_33$");
		demoxx.put("SJ_34->_NC_({", "_NC_({SJ_34$");
		demoxx.put("SJ_35->_NC_({", "_NC_({SJ_35$");
		demoxx.put("SJ_36->_NC_({", "_NC_({SJ_36$");
		demoxx.put("SJ_37->_NC_({", "_NC_({SJ_37$");
		demoxx.put("SJ_38->_NC_({", "_NC_({SJ_38$");
		demoxx.put("SJ_39->_NC_({", "_NC_({SJ_39$");
		demoxx.put("SJ_40->_NC_({", "_NC_({SJ_40$");
		demoxx.put("SJ_41->_NC_({", "_NC_({SJ_41$");
		demoxx.put("SJ_42->_NC_({", "_NC_({SJ_42$");
		demoxx.put("SJ_43->_NC_({", "_NC_({SJ_43$");
		demoxx.put("SJ_44->_NC_({", "_NC_({SJ_44$");
		demoxx.put("SJ_45->_NC_({", "_NC_({SJ_45$");
		demoxx.put("SJ_46->_NC_({", "_NC_({SJ_46$");
		demoxx.put("SJ_47->_NC_({", "_NC_({SJ_47$");
		demoxx.put("SJ_48->_NC_({", "_NC_({SJ_48$");
		demoxx.put("SJ_49->_NC_({", "_NC_({SJ_49$");
		demoxx.put("SJ_50->_NC_({", "_NC_({SJ_50$");
		demoxx.put("SJ_51->_NC_({", "_NC_({SJ_51$");
		demoxx.put("SJ_52->_NC_({", "_NC_({SJ_52$");
		demoxx.put("SJ_53->_NC_({", "_NC_({SJ_53$");
		demoxx.put("SJ_54->_NC_({", "_NC_({SJ_54$");
		demoxx.put("SJ_55->_NC_({", "_NC_({SJ_55$");
		demoxx.put("SJ_56->_NC_({", "_NC_({SJ_56$");
		demoxx.put("SJ_57->_NC_({", "_NC_({SJ_57$");
		demoxx.put("SJ_58->_NC_({", "_NC_({SJ_58$");
		demoxx.put("SJ_59->_NC_({", "_NC_({SJ_59$");
		demoxx.put("SJ_60->_NC_({", "_NC_({SJ_60$");
		demoxx.put("SJ_61->_NC_({", "_NC_({SJ_61$");
		demoxx.put("SJ_62->_NC_({", "_NC_({SJ_62$");
		demoxx.put("SJ_63->_NC_({", "_NC_({SJ_63$");
		demoxx.put("SJ_64->_NC_({", "_NC_({SJ_64$");
		demoxx.put("SJ_65->_NC_({", "_NC_({SJ_65$");
		demoxx.put("SJ_66->_NC_({", "_NC_({SJ_66$");
		demoxx.put("SJ_67->_NC_({", "_NC_({SJ_67$");
		demoxx.put("SJ_68->_NC_({", "_NC_({SJ_68$");
		demoxx.put("SJ_69->_NC_({", "_NC_({SJ_69$");
		demoxx.put("SJ_70->_NC_({", "_NC_({SJ_70$");
		demoxx.put("SJ_71->_NC_({", "_NC_({SJ_71$");
		demoxx.put("SJ_72->_NC_({", "_NC_({SJ_72$");
		demoxx.put("SJ_73->_NC_({", "_NC_({SJ_73$");
		demoxx.put("SJ_74->_NC_({", "_NC_({SJ_74$");
		demoxx.put("SJ_75->_NC_({", "_NC_({SJ_75$");
		demoxx.put("SJ_76->_NC_({", "_NC_({SJ_76$");
		demoxx.put("SJ_77->_NC_({", "_NC_({SJ_77$");
		demoxx.put("SJ_78->_NC_({", "_NC_({SJ_78$");
		demoxx.put("SJ_79->_NC_({", "_NC_({SJ_79$");
		demoxx.put("SJ_80->_NC_({", "_NC_({SJ_80$");
		demoxx.put("SJ_81->_NC_({", "_NC_({SJ_81$");
		demoxx.put("SJ_82->_NC_({", "_NC_({SJ_82$");
		demoxx.put("SJ_83->_NC_({", "_NC_({SJ_83$");
		demoxx.put("SJ_84->_NC_({", "_NC_({SJ_84$");
		demoxx.put("SJ_85->_NC_({", "_NC_({SJ_85$");
		demoxx.put("SJ_86->_NC_({", "_NC_({SJ_86$");
		demoxx.put("SJ_87->_NC_({", "_NC_({SJ_87$");
		demoxx.put("SJ_88->_NC_({", "_NC_({SJ_88$");
		demoxx.put("SJ_89->_NC_({", "_NC_({SJ_89$");
		demoxx.put("SJ_90->_NC_({", "_NC_({SJ_90$");
		demoxx.put("SJ_91->_NC_({", "_NC_({SJ_91$");
		demoxx.put("SJ_92->_NC_({", "_NC_({SJ_92$");
		demoxx.put("SJ_93->_NC_({", "_NC_({SJ_93$");
		demoxx.put("SJ_94->_NC_({", "_NC_({SJ_94$");
		demoxx.put("SJ_95->_NC_({", "_NC_({SJ_95$");
		demoxx.put("SJ_96->_NC_({", "_NC_({SJ_96$");
		demoxx.put("SJ_97->_NC_({", "_NC_({SJ_97$");
		demoxx.put("SJ_98->_NC_({", "_NC_({SJ_98$");
		demoxx.put("SJ_99->_NC_({", "_NC_({SJ_99$");
		demoxx.put("SJ_100->_NC_({", "_NC_({SJ_100$");

		
		
		demoxx.put("SJ_01->_SQ_({", "_SQ_({SJ_01$");
		demoxx.put("SJ_02->_SQ_({", "_SQ_({SJ_02$");
		demoxx.put("SJ_03->_SQ_({", "_SQ_({SJ_03$");
		demoxx.put("SJ_04->_SQ_({", "_SQ_({SJ_04$");
		demoxx.put("SJ_05->_SQ_({", "_SQ_({SJ_05$");
		demoxx.put("SJ_06->_SQ_({", "_SQ_({SJ_06$");
		demoxx.put("SJ_07->_SQ_({", "_SQ_({SJ_07$");
		demoxx.put("SJ_08->_SQ_({", "_SQ_({SJ_08$");
		demoxx.put("SJ_09->_SQ_({", "_SQ_({SJ_09$");
		demoxx.put("SJ_10->_SQ_({", "_SQ_({SJ_10$");
		demoxx.put("SJ_11->_SQ_({", "_SQ_({SJ_11$");
		demoxx.put("SJ_12->_SQ_({", "_SQ_({SJ_12$");
		demoxx.put("SJ_13->_SQ_({", "_SQ_({SJ_13$");
		demoxx.put("SJ_14->_SQ_({", "_SQ_({SJ_14$");
		demoxx.put("SJ_15->_SQ_({", "_SQ_({SJ_15$");
		demoxx.put("SJ_16->_SQ_({", "_SQ_({SJ_16$");
		demoxx.put("SJ_17->_SQ_({", "_SQ_({SJ_17$");
		demoxx.put("SJ_18->_SQ_({", "_SQ_({SJ_18$");
		demoxx.put("SJ_19->_SQ_({", "_SQ_({SJ_19$");
		demoxx.put("SJ_20->_SQ_({", "_SQ_({SJ_20$");
		demoxx.put("SJ_21->_SQ_({", "_SQ_({SJ_21$");
		demoxx.put("SJ_22->_SQ_({", "_SQ_({SJ_22$");
		demoxx.put("SJ_23->_SQ_({", "_SQ_({SJ_23$");
		demoxx.put("SJ_24->_SQ_({", "_SQ_({SJ_24$");
		demoxx.put("SJ_25->_SQ_({", "_SQ_({SJ_25$");
		demoxx.put("SJ_26->_SQ_({", "_SQ_({SJ_26$");
		demoxx.put("SJ_27->_SQ_({", "_SQ_({SJ_27$");
		demoxx.put("SJ_28->_SQ_({", "_SQ_({SJ_28$");
		demoxx.put("SJ_29->_SQ_({", "_SQ_({SJ_29$");
		demoxx.put("SJ_30->_SQ_({", "_SQ_({SJ_30$");
		demoxx.put("SJ_31->_SQ_({", "_SQ_({SJ_31$");
		demoxx.put("SJ_32->_SQ_({", "_SQ_({SJ_32$");
		demoxx.put("SJ_33->_SQ_({", "_SQ_({SJ_33$");
		demoxx.put("SJ_34->_SQ_({", "_SQ_({SJ_34$");
		demoxx.put("SJ_35->_SQ_({", "_SQ_({SJ_35$");
		demoxx.put("SJ_36->_SQ_({", "_SQ_({SJ_36$");
		demoxx.put("SJ_37->_SQ_({", "_SQ_({SJ_37$");
		demoxx.put("SJ_38->_SQ_({", "_SQ_({SJ_38$");
		demoxx.put("SJ_39->_SQ_({", "_SQ_({SJ_39$");
		demoxx.put("SJ_40->_SQ_({", "_SQ_({SJ_40$");
		demoxx.put("SJ_41->_SQ_({", "_SQ_({SJ_41$");
		demoxx.put("SJ_42->_SQ_({", "_SQ_({SJ_42$");
		demoxx.put("SJ_43->_SQ_({", "_SQ_({SJ_43$");
		demoxx.put("SJ_44->_SQ_({", "_SQ_({SJ_44$");
		demoxx.put("SJ_45->_SQ_({", "_SQ_({SJ_45$");
		demoxx.put("SJ_46->_SQ_({", "_SQ_({SJ_46$");
		demoxx.put("SJ_47->_SQ_({", "_SQ_({SJ_47$");
		demoxx.put("SJ_48->_SQ_({", "_SQ_({SJ_48$");
		demoxx.put("SJ_49->_SQ_({", "_SQ_({SJ_49$");
		demoxx.put("SJ_50->_SQ_({", "_SQ_({SJ_50$");
		demoxx.put("SJ_51->_SQ_({", "_SQ_({SJ_51$");
		demoxx.put("SJ_52->_SQ_({", "_SQ_({SJ_52$");
		demoxx.put("SJ_53->_SQ_({", "_SQ_({SJ_53$");
		demoxx.put("SJ_54->_SQ_({", "_SQ_({SJ_54$");
		demoxx.put("SJ_55->_SQ_({", "_SQ_({SJ_55$");
		demoxx.put("SJ_56->_SQ_({", "_SQ_({SJ_56$");
		demoxx.put("SJ_57->_SQ_({", "_SQ_({SJ_57$");
		demoxx.put("SJ_58->_SQ_({", "_SQ_({SJ_58$");
		demoxx.put("SJ_59->_SQ_({", "_SQ_({SJ_59$");
		demoxx.put("SJ_60->_SQ_({", "_SQ_({SJ_60$");
		demoxx.put("SJ_61->_SQ_({", "_SQ_({SJ_61$");
		demoxx.put("SJ_62->_SQ_({", "_SQ_({SJ_62$");
		demoxx.put("SJ_63->_SQ_({", "_SQ_({SJ_63$");
		demoxx.put("SJ_64->_SQ_({", "_SQ_({SJ_64$");
		demoxx.put("SJ_65->_SQ_({", "_SQ_({SJ_65$");
		demoxx.put("SJ_66->_SQ_({", "_SQ_({SJ_66$");
		demoxx.put("SJ_67->_SQ_({", "_SQ_({SJ_67$");
		demoxx.put("SJ_68->_SQ_({", "_SQ_({SJ_68$");
		demoxx.put("SJ_69->_SQ_({", "_SQ_({SJ_69$");
		demoxx.put("SJ_70->_SQ_({", "_SQ_({SJ_70$");
		demoxx.put("SJ_71->_SQ_({", "_SQ_({SJ_71$");
		demoxx.put("SJ_72->_SQ_({", "_SQ_({SJ_72$");
		demoxx.put("SJ_73->_SQ_({", "_SQ_({SJ_73$");
		demoxx.put("SJ_74->_SQ_({", "_SQ_({SJ_74$");
		demoxx.put("SJ_75->_SQ_({", "_SQ_({SJ_75$");
		demoxx.put("SJ_76->_SQ_({", "_SQ_({SJ_76$");
		demoxx.put("SJ_77->_SQ_({", "_SQ_({SJ_77$");
		demoxx.put("SJ_78->_SQ_({", "_SQ_({SJ_78$");
		demoxx.put("SJ_79->_SQ_({", "_SQ_({SJ_79$");
		demoxx.put("SJ_80->_SQ_({", "_SQ_({SJ_80$");
		demoxx.put("SJ_81->_SQ_({", "_SQ_({SJ_81$");
		demoxx.put("SJ_82->_SQ_({", "_SQ_({SJ_82$");
		demoxx.put("SJ_83->_SQ_({", "_SQ_({SJ_83$");
		demoxx.put("SJ_84->_SQ_({", "_SQ_({SJ_84$");
		demoxx.put("SJ_85->_SQ_({", "_SQ_({SJ_85$");
		demoxx.put("SJ_86->_SQ_({", "_SQ_({SJ_86$");
		demoxx.put("SJ_87->_SQ_({", "_SQ_({SJ_87$");
		demoxx.put("SJ_88->_SQ_({", "_SQ_({SJ_88$");
		demoxx.put("SJ_89->_SQ_({", "_SQ_({SJ_89$");
		demoxx.put("SJ_90->_SQ_({", "_SQ_({SJ_90$");
		demoxx.put("SJ_91->_SQ_({", "_SQ_({SJ_91$");
		demoxx.put("SJ_92->_SQ_({", "_SQ_({SJ_92$");
		demoxx.put("SJ_93->_SQ_({", "_SQ_({SJ_93$");
		demoxx.put("SJ_94->_SQ_({", "_SQ_({SJ_94$");
		demoxx.put("SJ_95->_SQ_({", "_SQ_({SJ_95$");
		demoxx.put("SJ_96->_SQ_({", "_SQ_({SJ_96$");
		demoxx.put("SJ_97->_SQ_({", "_SQ_({SJ_97$");
		demoxx.put("SJ_98->_SQ_({", "_SQ_({SJ_98$");
		demoxx.put("SJ_99->_SQ_({", "_SQ_({SJ_99$");
		demoxx.put("SJ_100->_SQ_({", "_SQ_({SJ_100$");
		



		demoxx.put(":SJ_01:{", "{SJ_01$");
		demoxx.put(":SJ_02:{", "{SJ_02$");
		demoxx.put(":SJ_03:{", "{SJ_03$");
		demoxx.put(":SJ_04:{", "{SJ_04$");
		demoxx.put(":SJ_05:{", "{SJ_05$");
		demoxx.put(":SJ_06:{", "{SJ_06$");
		demoxx.put(":SJ_07:{", "{SJ_07$");
		demoxx.put(":SJ_08:{", "{SJ_08$");
		demoxx.put(":SJ_09:{", "{SJ_09$");
		demoxx.put(":SJ_10:{", "{SJ_10$");
		demoxx.put(":SJ_11:{", "{SJ_11$");
		demoxx.put(":SJ_12:{", "{SJ_12$");
		demoxx.put(":SJ_13:{", "{SJ_13$");
		demoxx.put(":SJ_14:{", "{SJ_14$");
		demoxx.put(":SJ_15:{", "{SJ_15$");
		demoxx.put(":SJ_16:{", "{SJ_16$");
		demoxx.put(":SJ_17:{", "{SJ_17$");
		demoxx.put(":SJ_18:{", "{SJ_18$");
		demoxx.put(":SJ_19:{", "{SJ_19$");
		demoxx.put(":SJ_20:{", "{SJ_20$");
		demoxx.put(":SJ_21:{", "{SJ_21$");
		demoxx.put(":SJ_22:{", "{SJ_22$");
		demoxx.put(":SJ_23:{", "{SJ_23$");
		demoxx.put(":SJ_24:{", "{SJ_24$");
		demoxx.put(":SJ_25:{", "{SJ_25$");
		demoxx.put(":SJ_26:{", "{SJ_26$");
		demoxx.put(":SJ_27:{", "{SJ_27$");
		demoxx.put(":SJ_28:{", "{SJ_28$");
		demoxx.put(":SJ_29:{", "{SJ_29$");
		demoxx.put(":SJ_30:{", "{SJ_30$");
		demoxx.put(":SJ_31:{", "{SJ_31$");
		demoxx.put(":SJ_32:{", "{SJ_32$");
		demoxx.put(":SJ_33:{", "{SJ_33$");
		demoxx.put(":SJ_34:{", "{SJ_34$");
		demoxx.put(":SJ_35:{", "{SJ_35$");
		demoxx.put(":SJ_36:{", "{SJ_36$");
		demoxx.put(":SJ_37:{", "{SJ_37$");
		demoxx.put(":SJ_38:{", "{SJ_38$");
		demoxx.put(":SJ_39:{", "{SJ_39$");
		demoxx.put(":SJ_40:{", "{SJ_40$");
		demoxx.put(":SJ_41:{", "{SJ_41$");
		demoxx.put(":SJ_42:{", "{SJ_42$");
		demoxx.put(":SJ_43:{", "{SJ_43$");
		demoxx.put(":SJ_44:{", "{SJ_44$");
		demoxx.put(":SJ_45:{", "{SJ_45$");
		demoxx.put(":SJ_46:{", "{SJ_46$");
		demoxx.put(":SJ_47:{", "{SJ_47$");
		demoxx.put(":SJ_48:{", "{SJ_48$");
		demoxx.put(":SJ_49:{", "{SJ_49$");
		demoxx.put(":SJ_50:{", "{SJ_50$");
		demoxx.put(":SJ_51:{", "{SJ_51$");
		demoxx.put(":SJ_52:{", "{SJ_52$");
		demoxx.put(":SJ_53:{", "{SJ_53$");
		demoxx.put(":SJ_54:{", "{SJ_54$");
		demoxx.put(":SJ_55:{", "{SJ_55$");
		demoxx.put(":SJ_56:{", "{SJ_56$");
		demoxx.put(":SJ_57:{", "{SJ_57$");
		demoxx.put(":SJ_58:{", "{SJ_58$");
		demoxx.put(":SJ_59:{", "{SJ_59$");
		demoxx.put(":SJ_60:{", "{SJ_60$");
		demoxx.put(":SJ_61:{", "{SJ_61$");
		demoxx.put(":SJ_62:{", "{SJ_62$");
		demoxx.put(":SJ_63:{", "{SJ_63$");
		demoxx.put(":SJ_64:{", "{SJ_64$");
		demoxx.put(":SJ_65:{", "{SJ_65$");
		demoxx.put(":SJ_66:{", "{SJ_66$");
		demoxx.put(":SJ_67:{", "{SJ_67$");
		demoxx.put(":SJ_68:{", "{SJ_68$");
		demoxx.put(":SJ_69:{", "{SJ_69$");
		demoxx.put(":SJ_70:{", "{SJ_70$");
		demoxx.put(":SJ_71:{", "{SJ_71$");
		demoxx.put(":SJ_72:{", "{SJ_72$");
		demoxx.put(":SJ_73:{", "{SJ_73$");
		demoxx.put(":SJ_74:{", "{SJ_74$");
		demoxx.put(":SJ_75:{", "{SJ_75$");
		demoxx.put(":SJ_76:{", "{SJ_76$");
		demoxx.put(":SJ_77:{", "{SJ_77$");
		demoxx.put(":SJ_78:{", "{SJ_78$");
		demoxx.put(":SJ_79:{", "{SJ_79$");
		demoxx.put(":SJ_80:{", "{SJ_80$");
		demoxx.put(":SJ_81:{", "{SJ_81$");
		demoxx.put(":SJ_82:{", "{SJ_82$");
		demoxx.put(":SJ_83:{", "{SJ_83$");
		demoxx.put(":SJ_84:{", "{SJ_84$");
		demoxx.put(":SJ_85:{", "{SJ_85$");
		demoxx.put(":SJ_86:{", "{SJ_86$");
		demoxx.put(":SJ_87:{", "{SJ_87$");
		demoxx.put(":SJ_88:{", "{SJ_88$");
		demoxx.put(":SJ_89:{", "{SJ_89$");
		demoxx.put(":SJ_90:{", "{SJ_90$");
		demoxx.put(":SJ_91:{", "{SJ_91$");
		demoxx.put(":SJ_92:{", "{SJ_92$");
		demoxx.put(":SJ_93:{", "{SJ_93$");
		demoxx.put(":SJ_94:{", "{SJ_94$");
		demoxx.put(":SJ_95:{", "{SJ_95$");
		demoxx.put(":SJ_96:{", "{SJ_96$");
		demoxx.put(":SJ_97:{", "{SJ_97$");
		demoxx.put(":SJ_98:{", "{SJ_98$");
		demoxx.put(":SJ_99:{", "{SJ_99$");
		demoxx.put(":SJ_100:{", "{SJ_100$");

		
		demoxx.put("}=", "}==");
		demoxx.put(")=", ")==");


		// map
		Map<String, String> demo01 = new HashMap<String, String>();
		Map<String, String> demo02 = new HashMap<String, String>();
		Map<String, String> demo03 = new HashMap<String, String>();
		Map<String, String> demo04 = new HashMap<String, String>();
		Map<String, String> demo05 = new HashMap<String, String>();
		Map<String, String> demo06 = new HashMap<String, String>();
		Map<String, String> demo07 = new HashMap<String, String>();
		Map<String, String> demo08 = new HashMap<String, String>();
		Map<String, String> demo09 = new HashMap<String, String>();
		Map<String, String> demo10 = new HashMap<String, String>();
		Map<String, String> demo11 = new HashMap<String, String>();
		Map<String, String> demo12 = new HashMap<String, String>();
		Map<String, String> demo13 = new HashMap<String, String>();
		Map<String, String> demo14 = new HashMap<String, String>();
		Map<String, String> demo15 = new HashMap<String, String>();
		Map<String, String> demo16 = new HashMap<String, String>();
		Map<String, String> demo17 = new HashMap<String, String>();
		Map<String, String> demo18 = new HashMap<String, String>();
		Map<String, String> demo19 = new HashMap<String, String>();
		Map<String, String> demo20 = new HashMap<String, String>();
		Map<String, String> demo21 = new HashMap<String, String>();
		Map<String, String> demo22 = new HashMap<String, String>();
		Map<String, String> demo23 = new HashMap<String, String>();
		Map<String, String> demo24 = new HashMap<String, String>();
		Map<String, String> demo25 = new HashMap<String, String>();
		Map<String, String> demo26 = new HashMap<String, String>();
		Map<String, String> demo27 = new HashMap<String, String>();
		Map<String, String> demo28 = new HashMap<String, String>();
		Map<String, String> demo29 = new HashMap<String, String>();
		Map<String, String> demo30 = new HashMap<String, String>();
		Map<String, String> demo31 = new HashMap<String, String>();
		Map<String, String> demo32 = new HashMap<String, String>();
		Map<String, String> demo33 = new HashMap<String, String>();
		Map<String, String> demo34 = new HashMap<String, String>();
		Map<String, String> demo35 = new HashMap<String, String>();
		Map<String, String> demo36 = new HashMap<String, String>();
		Map<String, String> demo37 = new HashMap<String, String>();
		Map<String, String> demo38 = new HashMap<String, String>();
		Map<String, String> demo39 = new HashMap<String, String>();
		Map<String, String> demo40 = new HashMap<String, String>();
		Map<String, String> demo41 = new HashMap<String, String>();
		Map<String, String> demo42 = new HashMap<String, String>();
		Map<String, String> demo43 = new HashMap<String, String>();
		Map<String, String> demo44 = new HashMap<String, String>();
		Map<String, String> demo45 = new HashMap<String, String>();
		Map<String, String> demo46 = new HashMap<String, String>();
		Map<String, String> demo47 = new HashMap<String, String>();
		Map<String, String> demo48 = new HashMap<String, String>();
		Map<String, String> demo49 = new HashMap<String, String>();
		Map<String, String> demo50 = new HashMap<String, String>();
		Map<String, String> demo51 = new HashMap<String, String>();
		Map<String, String> demo52 = new HashMap<String, String>();
		Map<String, String> demo53 = new HashMap<String, String>();
		Map<String, String> demo54 = new HashMap<String, String>();
		Map<String, String> demo55 = new HashMap<String, String>();
		Map<String, String> demo56 = new HashMap<String, String>();
		Map<String, String> demo57 = new HashMap<String, String>();
		Map<String, String> demo58 = new HashMap<String, String>();
		Map<String, String> demo59 = new HashMap<String, String>();
		Map<String, String> demo60 = new HashMap<String, String>();
		Map<String, String> demo61 = new HashMap<String, String>();
		Map<String, String> demo62 = new HashMap<String, String>();
		Map<String, String> demo63 = new HashMap<String, String>();
		Map<String, String> demo64 = new HashMap<String, String>();
		Map<String, String> demo65 = new HashMap<String, String>();
		Map<String, String> demo66 = new HashMap<String, String>();
		Map<String, String> demo67 = new HashMap<String, String>();
		Map<String, String> demo68 = new HashMap<String, String>();
		Map<String, String> demo69 = new HashMap<String, String>();
		Map<String, String> demo70 = new HashMap<String, String>();
		Map<String, String> demo71 = new HashMap<String, String>();
		Map<String, String> demo72 = new HashMap<String, String>();
		Map<String, String> demo73 = new HashMap<String, String>();
		Map<String, String> demo74 = new HashMap<String, String>();
		Map<String, String> demo75 = new HashMap<String, String>();
		Map<String, String> demo76 = new HashMap<String, String>();
		Map<String, String> demo77 = new HashMap<String, String>();
		Map<String, String> demo78 = new HashMap<String, String>();
		Map<String, String> demo79 = new HashMap<String, String>();

		OneMap.put(1, demo01);
		OneMap.put(2, demo02);
		OneMap.put(3, demo03);
		OneMap.put(4, demo04);
		OneMap.put(5, demo05);
		OneMap.put(6, demo06);
		OneMap.put(7, demo07);
		OneMap.put(8, demo08);
		OneMap.put(9, demo09);
		OneMap.put(10, demo10);
		OneMap.put(11, demo11);
		OneMap.put(12, demo12);
		OneMap.put(13, demo13);
		OneMap.put(14, demo14);
		// OneMap.put(15,demo15);
		OneMap.put(16, demo16);
		OneMap.put(17, demo17);
		OneMap.put(18, demo18);
		// OneMap.put(19,demo19);
		OneMap.put(20, demo20);
		OneMap.put(21, demo21);
		OneMap.put(22, demo22);
		OneMap.put(23, demo23);
		OneMap.put(24, demo24);
		OneMap.put(25, demo25);
		OneMap.put(26, demo26);
		OneMap.put(27, demo27);
		OneMap.put(28, demo28);
		OneMap.put(29, demo29);
		// OneMap.put(30,demo30);
		// OneMap.put(31,demo31);
		// OneMap.put(32,demo32);
		OneMap.put(33, demo33);
		OneMap.put(34, demo34);
		OneMap.put(35, demo35);
		OneMap.put(36, demo36);
		OneMap.put(37, demo37);
		OneMap.put(38, demo38);
		OneMap.put(39, demo39);
		// OneMap.put(40,demo40);
		// OneMap.put(41,demo41);
		// OneMap.put(42,demo42);
		// OneMap.put(43,demo43);
		// OneMap.put(44,demo44);
		// OneMap.put(45,demo45);
		// OneMap.put(46,demo46);
		// OneMap.put(47,demo47);
		// OneMap.put(48,demo48);
		// OneMap.put(49,demo49);
		// OneMap.put(50,demo50);
		// OneMap.put(51,demo51);
		// OneMap.put(52,demo52);
		// OneMap.put(53,demo53);
		// OneMap.put(54,demo54);
		// OneMap.put(55,demo55);
		// OneMap.put(56,demo56);
		// OneMap.put(57,demo57);
		// OneMap.put(58,demo58);
		// OneMap.put(59,demo59);
		// OneMap.put(60,demo60);
		// OneMap.put(61,demo61);
		// OneMap.put(62,demo62);
		// OneMap.put(63,demo63);
		// OneMap.put(64,demo64);
		// OneMap.put(65,demo65);
		// OneMap.put(66,demo66);
		// OneMap.put(67,demo67);
		// OneMap.put(68,demo68);
		// OneMap.put(69,demo69);
		// OneMap.put(70,demo70);
		// OneMap.put(71,demo71);
		// OneMap.put(72,demo72);
		// OneMap.put(73,demo73);
		// OneMap.put(74,demo74);
		// OneMap.put(75,demo75);
		// OneMap.put(76,demo76);
		// OneMap.put(77,demo77);
		// OneMap.put(78,demo78);
		// OneMap.put(79,demo79);

		demo02.put("4L", "ZJ");
		demo02.put("5L", "SSSRHJ");
		demo02.put("6L", "ZZSSR");
		demo02.put("7L", "GNZZS");
		demo02.put("8L", "YBZZS");
		demo02.put("9L", "GZZZS");
		demo02.put("10L", "QZZGTLZGSGZZZSSR");
		demo02.put("11L", "CJRJYZZSTS");
		demo02.put("12L", "RJZZSTS");
		demo02.put("13L", "SGZHLYZZSTS");
		demo02.put("14L", "SDZZSTS");
		demo02.put("15L", "ZYZHLYZZSTS");
		demo02.put("16L", "CPYZZSTS");
		demo02.put("17L", "MDDZZZS");
		demo02.put("18L", "MDDZGZZZS");
		demo02.put("19L", "2JKHWZZS");
		demo02.put("20L", "2XFSSR");
		demo02.put("21L", "GNXFS");
		demo02.put("22L", "QZCPYXFS");
		demo02.put("23L", "JKXFPXFS");
		demo02.put("24L", "QZJKCPYXFS");
		demo02.put("25L", "3YYS");
		demo02.put("26L", "JRBXYYYS");
		demo02.put("27L", "QTYYS");
		demo02.put("28L", "4QYSDS");
		demo02.put("29L", "QZZYGDSR");
		demo02.put("30L", "1YBQYSDS");
		demo02.put("31L", "NZQY1");
		demo02.put("32L", "WZQY1");
		demo02.put("33L", "2FZJGYJSDS");
		demo02.put("34L", "NZQY2");
		demo02.put("35L", "WZQY2");
		demo02.put("36L", "3ZJGYJSDS");
		demo02.put("37L", "NZQY3");
		demo02.put("38L", "WZQY3");
		demo02.put("39L", "4FZJGHSQJSDS");
		demo02.put("40L", "NZQY4");
		demo02.put("41L", "WZQY4");
		demo02.put("42L", "5ZJGHSQJSDS");
		demo02.put("43L", "NZQY5");
		demo02.put("44L", "WZQY5");
		demo02.put("45L", "6QYSDSDFPSR");
		demo02.put("46L", "NZQY6");
		demo02.put("47L", "WZQY6");
		demo02.put("48L", "5GRSDS");
		demo02.put("49L", "LXSDS");
		demo02.put("50L", "QTGRSDS");
		demo02.put("51L", "6ZYS");
		demo02.put("52L", "7GDZCTZFXDJS");
		demo02.put("53L", "8CSWHJSS");
		demo02.put("54L", "9FCS");
		demo02.put("55L", "10YHS");
		demo02.put("56L", "ZQJYYHS");
		demo02.put("57L", "QTYHS");
		demo02.put("58L", "11CZTDSYS");
		demo02.put("59L", "12TDZZS");
		demo02.put("60L", "13CCS");
		demo02.put("61L", "14CLGZS");
		demo02.put("62L", "15YYS");
		demo02.put("63L", "16GDZYS");
		demo02.put("64L", "17QS");
		demo02.put("65L", "18QTSS");
		demo02.put("66L", "ECPYXFSTS");
		demo02.put("67L", "SCKTSHJ");
		demo02.put("68L", "1CKHWTZZS");
		demo02.put("69L", "2GZZZSCKTS");
		demo02.put("70L", "3MDDJZZS");
		demo02.put("71L", "4MDDJGZZZS");
		demo02.put("72L", "5CKXFPTXFS");
		demo02.put("73L", "SFSSRHJ");
		demo02.put("74L", "1JYFFJSR");
		demo02.put("75L", "2DFJYFJ");
		demo02.put("76L", "3WHSYJSFSR");
		demo02.put("77L", "4HSSYKQSYFSR");
		demo02.put("78L", "5SWBMFMSR");
		demo02.put("79L", "6CJRJYBZJJ");
		demo02.put("80L", "7SHBXJJSR");
		demo02.put("81L", "QYZGJBYLBXJJSR");
		demo02.put("82L", "JGSYDWJBYLBXJJSR");
		demo02.put("83L", "SYBXJJSR1");
		demo02.put("84L", "JBYLBXJJSR");
		demo02.put("85L", "GSBXJJSR");
		demo02.put("86L", "SYBXJJSR2");
		demo02.put("87L", "QTSHBXJJSR");
		demo02.put("88L", "8ZFXJJSR");
		demo02.put("89L", "FQDQDZCPCLJJSR");
		demo02.put("90L", "QTZFXJJSR");
		demo02.put("91L", "9GHJFSR");
		demo02.put("92L", "10QTFSSR");

		demo02.put("1H", "XH");
		demo02.put("2H", "XM");
		demo02.put("3H", "HJ");
		demo02.put("4H", "BNXQRK");
		demo02.put("5H", "20010501HCQRK");
		demo02.put("6H", "20010501QCQRK");
		demo02.put("7H", "ZY");
		demo02.put("8H", "DFXJ1");
		demo02.put("9H", "DFSJ1");
		demo02.put("10H", "DFSJ2");
		demo02.put("11H", "DFXJ2");

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


		demo01.put("1H", "XH");
		demo01.put("2H", "ZJZYKM");
		demo01.put("3H", "ZJZYNCYE");
		demo01.put("4H", "ZJZYQMYE");
		demo01.put("5H", "ZJLYKM");
		demo01.put("6H", "ZJLYKMNCYE");
		demo01.put("7H", "ZJLYKMQMYE");

		demo01.put("3L", "HJ");
		demo01.put("4L", "1DZSS");
		demo01.put("5L", "2DZQTSR");
		demo01.put("6L", "3JMSJ");
		demo01.put("7L", "4DJSJ");
		demo01.put("8L", "5ZTSJ");
		demo01.put("9L", "6RKSS");
		demo01.put("10L", "7RKQTSR");
		demo01.put("11L", "8TTSJ");
		demo01.put("12L", "9DCLSSSJ");
		demo01.put("13L", "10SSSJHX");
		demo01.put("14L", "11BGK");

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
		demo03.put("9H","DNFSEQZGYKG1");
		demo03.put("10H","DNFSEGFGS");
		demo03.put("11H","DNFSEQZGYKG2");
		demo03.put("12H","DNFSESYQY");
		demo03.put("13H","DNFSEGATTZQY");
		demo03.put("14H","DNFSEQZGYKG3");
		demo03.put("15H","DNFSEWSTZQY");
		demo03.put("16H","DNFSEQZGYKG4");
		demo03.put("17H","DNFSEQTQY");
		demo03.put("18H","QMYE");
		
		
		demo04.put("2L","ZJ1");
		demo04.put("3L","YSSSRHJ2");
		demo04.put("4L","WDQYJSK3");
		demo04.put("5L","JPZHZ4");
		demo04.put("6L","GTJKKQYQS5");
		demo04.put("7L","WNCQ6");
		demo04.put("8L","BNXQ7");
		demo04.put("9L","1GNZZS8");
		demo04.put("10L","QZGZZZS9");
		demo04.put("11L","WDQYJSK10");
		demo04.put("12L","JPZHZ11");
		demo04.put("13L","GTJKKQYQS12");
		demo04.put("14L","WNCQ13");
		demo04.put("15L","BNXQ14");
		demo04.put("16L","2GNXFS15");
		demo04.put("17L","WDQYJSK16");
		demo04.put("18L","JPZHZ17");
		demo04.put("19L","GTJKKQYQS18");
		demo04.put("20L","WNCQ19");
		demo04.put("21L","BNXQ20");
		demo04.put("22L","3YYS21");
		demo04.put("23L","WDQYJSK22");
		demo04.put("24L","JPZHZ23");
		demo04.put("25L","GTJKKQYQS24");
		demo04.put("26L","WNCQ25");
		demo04.put("27L","BNXQ26");
		demo04.put("28L","4QYSDS27");
		demo04.put("29L","WDQYJSK28");
		demo04.put("30L","JPZHZ29");
		demo04.put("31L","GTJKKQYQS30");
		demo04.put("32L","WNCQ31");
		demo04.put("33L","BNXQ32");
		demo04.put("34L","5GRSDS33");
		demo04.put("35L","WDQYJSK34");
		demo04.put("36L","JPZHZ35");
		demo04.put("37L","GTJKKQYQS36");
		demo04.put("38L","WNCQ37");
		demo04.put("39L","BNXQ38");
		demo04.put("40L","6ZYS39");
		demo04.put("41L","WDQYJSK40");
		demo04.put("42L","JPZHZ41");
		demo04.put("43L","GTJKKQYQS42");
		demo04.put("44L","WNCQ43");
		demo04.put("45L","BNXQ44");
		demo04.put("46L","7CSWHJSS45");
		demo04.put("47L","WDQYJSK46");
		demo04.put("48L","JPZHZ47");
		demo04.put("49L","GTJKKQYQS48");
		demo04.put("50L","WNCQ49");
		demo04.put("51L","BNXQ50");
		demo04.put("52L","8FCS51");
		demo04.put("53L","WDQYJSK52");
		demo04.put("54L","JPZHZ53");
		demo04.put("55L","GTJKKQYQS54");
		demo04.put("56L","WNCQ55");
		demo04.put("57L","BNXQ56");
		demo04.put("58L","9YHS57");
		demo04.put("59L","WDQYJSK58");
		demo04.put("60L","JPZHZ59");
		demo04.put("61L","GTJKKQYQS60");
		demo04.put("62L","WNCQ61");
		demo04.put("63L","BNXQ62");
		demo04.put("64L","10CZTDSYS63");
		demo04.put("65L","WDQYJSK64");
		demo04.put("66L","JPZHZ65");
		demo04.put("67L","GTJKKQYQS66");
		demo04.put("68L","WNCQ67");
		demo04.put("69L","BNXQ68");
		demo04.put("70L","11TDZZS69");
		demo04.put("71L","WDQYJSK70");
		demo04.put("72L","JPZHZ71");
		demo04.put("73L","GTJKKQYQS72");
		demo04.put("74L","WNCQ73");
		demo04.put("75L","BNXQ74");
		demo04.put("76L","12CCS75");
		demo04.put("77L","WDQYJSK76");
		demo04.put("78L","JPZHZ77");
		demo04.put("79L","GTJKKQYQS78");
		demo04.put("80L","WNCQ79");
		demo04.put("81L","BNXQ80");
		demo04.put("82L","13YYS81");
		demo04.put("83L","WDQYJSK82");
		demo04.put("84L","JPZHZ83");
		demo04.put("85L","GTJKKQYQS84");
		demo04.put("86L","WNCQ85");
		demo04.put("87L","BNXQ86");
		demo04.put("88L","14GDZYS87");
		demo04.put("89L","WDQYJSK88");
		demo04.put("90L","JPZHZ89");
		demo04.put("91L","GTJKKQYQS90");
		demo04.put("92L","WNCQ91");
		demo04.put("93L","BNXQ92");
		demo04.put("94L","15QS93");
		demo04.put("95L","WDQYJSK94");
		demo04.put("96L","JPZHZ95");
		demo04.put("97L","GTJKKQYQS96");
		demo04.put("98L","WNCQ97");
		demo04.put("99L","BNXQ98");
		demo04.put("100L","16QTSS99");
		demo04.put("101L","WDQYJSK100");
		demo04.put("102L","JPZHZ101");
		demo04.put("103L","GTJKKQYQS102");
		demo04.put("104L","WNCQ103");
		demo04.put("105L","BNXQ104");
		demo04.put("106L","EQTSRHJ105");
		demo04.put("107L","QZFQDQDZCPCLJJSR106");
		demo04.put("1H","XH");
		demo04.put("2H","XM");
		demo04.put("3H","QCYE");
		demo04.put("4H","BQZJE");
		demo04.put("5H","BQJSE");
		demo04.put("6H","QMYE");

		demo05.put("2L", "ZJ");
		demo05.put("3L", "YSSSRHJ");
		demo05.put("4L", "1ZZS");
		demo05.put("5L", "QZGZZZS");
		demo05.put("6L", "JXLD");
		demo05.put("7L", "2XFS");
		demo05.put("8L", "QZCPYXFS");
		demo05.put("9L", "3YYS");
		demo05.put("10L", "4QYSDS");
		demo05.put("11L", "5GRSDS");
		demo05.put("12L", "6ZYS");
		demo05.put("13L", "7GDZCTZFXDJS");
		demo05.put("14L", "8CSWHJSS");
		demo05.put("15L", "9FCS");
		demo05.put("16L", "10YHS");
		demo05.put("17L", "11CZTDSYS");
		demo05.put("18L", "12TDZZS");
		demo05.put("19L", "13CCS");
		demo05.put("20L", "14CLGZS");
		demo05.put("21L", "15YYS");
		demo05.put("22L", "16GDZYS");
		demo05.put("23L", "17QS");
		demo05.put("24L", "18QTSS");
		demo05.put("25L", "EQTSRHJ");
		demo05.put("26L", "QZFQDQDZCPCLJJSR");
		demo05.put("27L", "FLZLZZSJXLDSE");
		demo05.put("1H", "XH");
		demo05.put("2H", "XM");
		demo05.put("3H", "HJ");
		demo05.put("4H", "CKTS");
		demo05.put("5H", "XZHT");
		demo05.put("6H", "JMTS");
		demo05.put("7H", "HSQJJSTS");
		demo05.put("8H", "WSTS");
		demo05.put("9H", "QTTS");

		demo06.put("3L", "ZJ");
		demo06.put("4L", "QZZQJM");
		demo06.put("5L", "TKJM");
		demo06.put("6L", "DDQS");
		demo06.put("7L", "YGSMS");
		demo06.put("8L", "1ZF");
		demo06.put("9L", "2JZJZJ");
		demo06.put("10L", "3JZZY");
		demo06.put("11L", "4ZJYFC");
		demo06.put("12L", "5SHBZ");
		demo06.put("13L", "6TGJMSR");
		demo06.put("14L", "7QT");
		demo06.put("15L", "EGLGXJS");
		demo06.put("16L", "1JSZR");
		demo06.put("17L", "2KJFZ");
		demo06.put("18L", "3ZZCX");
		demo06.put("19L", "4KYJGZZ");
		demo06.put("20L", "5TZCY");
		demo06.put("21L", "6WBFW");
		demo06.put("22L", "7GXJS");
		demo06.put("23L", "8QT");
		demo06.put("24L", "SCJXWQYFZ");
		demo06.put("25L", "1JRSC");
		demo06.put("26L", "2WDQZD");
		demo06.put("27L", "3MZZZSHYYSZC");
		demo06.put("28L", "4QT1");
		demo06.put("29L", "SZZSJ");
		demo06.put("30L", "1QYFZ");
		demo06.put("31L", "2QYZZGZ");
		demo06.put("32L", "3QT");
		demo06.put("33L", "WJNHB");
		demo06.put("34L", "1HJBH");
		demo06.put("35L", "2DLJS");
		demo06.put("36L", "3ZYZHLY");
		demo06.put("37L", "4QT2");
		demo06.put("38L", "LCJQYFZ");
		demo06.put("39L", "1XBKF");
		demo06.put("40L", "2DBFZ");
		demo06.put("41L", "3LAJL");
		demo06.put("42L", "4QT3");
		demo06.put("43L", "QZCWHJYTY");
		demo06.put("44L", "1JY");
		demo06.put("45L", "2TY");
		demo06.put("46L", "3WH");
		demo06.put("47L", "BZCJRZBSC");
		demo06.put("48L", "1ZBSC");
		demo06.put("49L", "2JRSC");
		demo06.put("50L", "JZCSN");
		demo06.put("51L", "1NCJS");
		demo06.put("52L", "2FLSL");
		demo06.put("53L", "3CYSJ");
		demo06.put("54L", "4JRSC");
		demo06.put("55L", "5QT1");
		demo06.put("56L", "SZCQTGXSY");
		demo06.put("57L", "1FJZZ");
		demo06.put("58L", "2JCSSJS");
		demo06.put("59L", "3CPY");
		demo06.put("60L", "4GFJS");
		demo06.put("61L", "5GJF");
		demo06.put("62L", "6YLWS");
		demo06.put("63L", "7JTYS");
		demo06.put("64L", "8WCYZ");
		demo06.put("65L", "9GY");
		demo06.put("66L", "10SPCB");
		demo06.put("67L", "11WJRY");
		demo06.put("68L", "12ZXCZXZJ");
		demo06.put("69L", "13QT");
		demo06.put("70L", "SYXSSSXDDY");
		demo06.put("71L", "1GX");
		demo06.put("72L", "2LX");
		demo06.put("73L", "3TXQSYF");
		demo06.put("74L", "4CCSY");
		demo06.put("75L", "5QT2");
		demo06.put("1H", "XH");
		demo06.put("2H", "XM");
		demo06.put("3H", "HJ");
		demo06.put("4H", "SSSRXJ");
		demo06.put("5H", "SSSRZZS");
		demo06.put("6H", "SSSRQZ：GZZZS");
		demo06.put("7H", "SSSRXFS");
		demo06.put("8H", "SSSRYYS");
		demo06.put("9H", "SSSRQYSDS");
		demo06.put("10H", "SSSRGRSDS");
		demo06.put("11H", "SSSRZYS");
		demo06.put("12H", "SSSRCSWHJSS");
		demo06.put("13H", "SSSRFCS");
		demo06.put("14H", "SSSRYHS");
		demo06.put("15H", "SSSRCZTDSYS");
		demo06.put("16H", "SSSRTDZZS");
		demo06.put("17H", "SSSRCCS");
		demo06.put("18H", "SSSRCLGZS");
		demo06.put("19H", "SSSRGDZYS");
		demo06.put("20H", "SSSRQS");
		demo06.put("21H", "SSSRQTSS");
		demo06.put("22H", "QTSRHJ");
		demo06.put("23H", "QYSDSYJYJJM");

		demo08.put("5L", "ZJ");
		demo08.put("6L", "YSSSRHJ");
		demo08.put("7L", "1ZZS");
		demo08.put("8L", "QZGZZZS");
		demo08.put("9L", "2XFS");
		demo08.put("10L", "3YYS");
		demo08.put("11L", "4QYSDS");
		demo08.put("12L", "5GRSDS");
		demo08.put("13L", "6ZYS");
		demo08.put("14L", "7GDZCTZFXDJS");
		demo08.put("15L", "8CSWHJSS");
		demo08.put("16L", "9FCS");
		demo08.put("17L", "10YHS");
		demo08.put("18L", "11CZTDSYS");
		demo08.put("19L", "12TDZZS");
		demo08.put("20L", "13CCS");
		demo08.put("21L", "14CLGZS");
		demo08.put("22L", "15YYS");
		demo08.put("23L", "16GDZYS");
		demo08.put("24L", "17QS");
		demo08.put("25L", "18QTSS");
		demo08.put("26L", "EQTSRHJ");
		demo08.put("27L", "QZ1JYFFJSR");
		demo08.put("28L", "2WHSYJSFSR");
		demo08.put("29L", "3FQDQDZCPCLJJSR");
		demo08.put("30L", "4QTFMSR");
		demo08.put("1H", "XH");
		demo08.put("2H", "XM");
		demo08.put("3H", "HJ1");
		demo08.put("4H", "YZCBSJSWJCBMCBSK");
		demo08.put("5H", "YZCBSJSWJCBMCBZNJ");
		demo08.put("6H", "YZCBSJSWJCBMCBFK");
		demo08.put("7H", "YZCBSJSWJCBMCBQZZCBS");
		demo08.put("8H", "YZCBSJSWQTBMCBSK");
		demo08.put("9H", "YZCBSJSWQTBMCBZNJ");
		demo08.put("10H", "YZCBSJSWQTBMCBFK");
		demo08.put("11H", "QZ1TBNSDZ");
		demo08.put("12H", "YZCBSJSWQTBMCB2NSPG");
		demo08.put("13H", "YZCBSJWBMCBSK");
		demo08.put("14H", "YZCBSJWBMCBZNJ");
		demo08.put("15H", "YZCBSJWBMCBFK");
		demo08.put("16H", "HJ2");
		demo08.put("17H", "RKCBSJSWJCBMCBXJ");
		demo08.put("18H", "RKCBSJSWJCBMCBZY");
		demo08.put("19H", "RKCBSJSWJCBMCBXJDF");
		demo08.put("20H", "RKCBSJSWJCBMCBSK");
		demo08.put("21H", "RKCBSJSWJCBMCBZNJ");
		demo08.put("22H", "RKCBSJSWJCBMCBFK");
		demo08.put("23H", "RKCBSJSWJCBMCBQZZCBS");
		demo08.put("24H", "RKCBSJSWQTBMCBSK");
		demo08.put("25H", "RKCBSJSWQTBMCBZNJ");
		demo08.put("26H", "RKCBSJSWQTBMCBFK");
		demo08.put("27H", "RKCBSJSWQTBMCBQZ1TBNSDZ");
		demo08.put("28H", "RKCBSJSWQTBMCB2NSPG");
		demo08.put("29H", "RKCBSJWBMCBSK");
		demo08.put("30H", "RKCBSJWBMCBZNJ");
		demo08.put("31H", "RKCBSJWBMCBFK");
		demo08.put("32H", "RKSKZNJFKSR");

		demo09.put("2L", "SSSRHJ");
		demo09.put("3L", "1ZZS");
		demo09.put("4L", "QZGZZZS");
		demo09.put("5L", "2XFS");
		demo09.put("6L", "3YYS");
		demo09.put("7L", "4QYSDS");
		demo09.put("8L", "5GRSDS");
		demo09.put("9L", "6ZYS");
		demo09.put("10L", "7GDTZFXDJS");
		demo09.put("11L", "8CSWHJSS");
		demo09.put("12L", "9FCS");
		demo09.put("13L", "10YHS");
		demo09.put("14L", "11CZTDSYS");
		demo09.put("15L", "12TDZZS");
		demo09.put("16L", "13CCS");
		demo09.put("17L", "14CLGZS");
		demo09.put("18L", "15YYS");
		demo09.put("19L", "16GDZYS");
		demo09.put("20L", "17QS");
		demo09.put("21L", "18QTSS");
		demo09.put("1H", "XH");
		demo09.put("2H", "XM");
		demo09.put("3H", "HJ");
		demo09.put("4H", "RKZNJ");
		demo09.put("5H", "HXZNJ");
		demo09.put("6H", "YJWJZNJ");

		demo10.put("2L", "ZJ");
		demo10.put("3L", "YSSSRHJ");
		demo10.put("4L", "1ZZS");
		demo10.put("5L", "QZGZZZS");
		demo10.put("6L", "2XFS");
		demo10.put("7L", "3YYS");
		demo10.put("8L", "4QYSDS");
		demo10.put("9L", "5GRSDS");
		demo10.put("10L", "6ZYS");
		demo10.put("11L", "7GDZCTZFXDJS");
		demo10.put("12L", "8CSWHJSS");
		demo10.put("13L", "9FCS");
		demo10.put("14L", "10YHS");
		demo10.put("15L", "QZZQJYYHS");
		demo10.put("16L", "11CZTDSYS");
		demo10.put("17L", "12TDZZS");
		demo10.put("18L", "13CCS");
		demo10.put("19L", "14CLGZS");
		demo10.put("20L", "15YYS");
		demo10.put("21L", "16GDZYS");
		demo10.put("22L", "17QS");
		demo10.put("23L", "18QTSS");
		demo10.put("24L", "EQTSRHJ");
		demo10.put("25L", "QZJYFFJSR");
		demo10.put("26L", "FQDQDZCPCLJJSR");
		demo10.put("1H", "XH");
		demo10.put("2H", "XM");
		demo10.put("3H", "HJ");
		demo10.put("4H", "DKDS");
		demo10.put("5H", "WTDZ");

		demo11.put("3L", "HJ");
		demo11.put("4L", "NSBZJ");
		demo11.put("5L", "FPBZJ");
		demo11.put("6L", "NSDBJ");
		demo11.put("7L", "SSBQK");
		demo11.put("8L", "PMBMK");
		demo11.put("9L", "QT");
		demo11.put("1H", "XH");
		demo11.put("2H", "XM");
		demo11.put("3H", "NCYE");
		demo11.put("4H", "SRBY");
		demo11.put("5H", "SRBNLJ");
		demo11.put("6H", "ZCBY");
		demo11.put("7H", "ZCBNLJ");
		demo11.put("8H", "QMYE");

		demo12.put("2L", "ZJ");
		demo12.put("3L", "YSSSRHJ");
		demo12.put("4L", "1ZZS");
		demo12.put("5L", "2XFS");
		demo12.put("6L", "3YYS");
		demo12.put("7L", "4QYSDS");
		demo12.put("8L", "5GRSDS");
		demo12.put("9L", "6ZYS");
		demo12.put("10L", "7GDZCTZFXDJS");
		demo12.put("11L", "8CSWHJSS");
		demo12.put("12L", "9FCS");
		demo12.put("13L", "10YHS");
		demo12.put("14L", "11CZTDSYS");
		demo12.put("15L", "12TDZZS");
		demo12.put("16L", "13CCS");
		demo12.put("17L", "14CLGZS");
		demo12.put("18L", "15YYS");
		demo12.put("19L", "16GDZYS");
		demo12.put("20L", "17QS");
		demo12.put("21L", "18QTSS");
		demo12.put("22L", "EQTSRHJ");
		demo12.put("1H", "XH");
		demo12.put("2H", "XM");
		demo12.put("3H", "HJ");
		demo12.put("4H", "GTQYDZSJ");
		demo12.put("5H", "KKQYDZSJ");
		demo12.put("6H", "ZFZCXDZSJ");
		demo12.put("7H", "QT");

		demo13.put("3L", "HJ");
		demo13.put("4L", "YJTYSFW");
		demo13.put("5L", "1LLYSFW");
		demo13.put("6L", "2SLYSFW");
		demo13.put("7L", "3HKYSFW");
		demo13.put("8L", "4GDYSFW");
		demo13.put("9L", "EYZFW");
		demo13.put("10L", "1YZPBFW");
		demo13.put("11L", "2YZTSFW");
		demo13.put("12L", "3QTYZFW");
		demo13.put("13L", "SDXFW");
		demo13.put("14L", "1JCDXFW");
		demo13.put("15L", "2ZZDXFW");
		demo13.put("16L", "SJZFW");
		demo13.put("17L", "1GCFW");
		demo13.put("18L", "2AZFW");
		demo13.put("19L", "3XSFW");
		demo13.put("20L", "4ZSFW");
		demo13.put("21L", "5QTJZFW");
		demo13.put("22L", "WJRFW");
		demo13.put("23L", "1DKFW");
		demo13.put("24L", "2ZJSFJRFW");
		demo13.put("25L", "3BXFW");
		demo13.put("26L", "4JRSPZR");
		demo13.put("27L", "LXDFW");
		demo13.put("28L", "1YFHJSFW");
		demo13.put("29L", "2XXJSFW");
		demo13.put("30L", "3WHCYFW");
		demo13.put("31L", "4WLFZFW");
		demo13.put("32L", "5ZLFW");
		demo13.put("33L", "6JZZXFW");
		demo13.put("34L", "7GBYSFW");
		demo13.put("35L", "8SWFZFW");
		demo13.put("36L", "9QTXDFW");
		demo13.put("37L", "QSHFW");
		demo13.put("38L", "1WHTYFW");
		demo13.put("39L", "2JYYLFW");
		demo13.put("40L", "3LYYLFW");
		demo13.put("41L", "4CYZSFW");
		demo13.put("42L", "5JMRCFW");
		demo13.put("43L", "6QTSHFW");
		demo13.put("44L", "BXSWXZC");
		demo13.put("45L", "1ZLHFZLJS");
		demo13.put("46L", "2SBHZZQ");
		demo13.put("47L", "3TDSYQ");
		demo13.put("48L", "4QTZRZYSYQ");
		demo13.put("49L", "5QTQYXWXZC");
		demo13.put("50L", "JXSBDC");
		demo13.put("51L", "1JZW");
		demo13.put("52L", "QZESFJY1");
		demo13.put("53L", "2GZW");
		demo13.put("54L", "QZESFJY2");
		demo13.put("1H", "XH");
		demo13.put("2H", "XM");
		demo13.put("3H", "RKSJ");
		demo13.put("4H", "YZSJNCYE");
		demo13.put("5H", "YZSJQMYE");
		demo13.put("6H", "DZSJNCYE");
		demo13.put("7H", "DZSJQMYE");
		demo13.put("8H", "TTSJ");
		demo13.put("9H", "JMSJ");
		demo13.put("10H", "DJSJ1");
		demo13.put("11H", "ZTSJ");
		demo13.put("12H", "DJSJ2");
		demo13.put("13H", "DCLSSSJ");
		demo13.put("14H", "SSSJHX");

		demo14.put("3L", "HJ");
		demo14.put("4L", "QZBNXQ");
		demo14.put("5L", "WNCQ");
		demo14.put("6L", "GTJKKQYQS");
		demo14.put("7L", "1GNZZS");
		demo14.put("8L", "QZGZZZS");
		demo14.put("9L", "2GNXFS");
		demo14.put("10L", "3YYS");
		demo14.put("11L", "4QYSDS");
		demo14.put("12L", "5GRSDS");
		demo14.put("13L", "6ZYS");
		demo14.put("14L", "7GDZCTZFXDJS");
		demo14.put("15L", "8CSWHJSS");
		demo14.put("16L", "9FCS");
		demo14.put("17L", "10YHS");
		demo14.put("18L", "11CZTDSYS");
		demo14.put("19L", "12TDZZS");
		demo14.put("20L", "13CCS");
		demo14.put("21L", "14CLGZS");
		demo14.put("22L", "15YYS");
		demo14.put("23L", "16GDZYS");
		demo14.put("24L", "17QS");
		demo14.put("25L", "18QTSS");
		demo14.put("1H", "XH");
		demo14.put("2H", "XM");
		demo14.put("3H", "QMYEHJ");
		demo14.put("4H", "DFXQJRK");
		demo14.put("5H", "DFXQJDJ");
		demo14.put("6H", "DFXQJ");
		demo14.put("7H", "DFXQJQMYE");
		demo14.put("8H", "ZFXQJRK");
		demo14.put("9H", "ZFXQJDJ");
		demo14.put("10H", "ZFXQJHX");
		demo14.put("11H", "ZFXQJQMYE");
		demo14.put("12H", "GFXQJRK");
		demo14.put("13H", "GFXQJDJ");
		demo14.put("14H", "GFXQJHX");
		demo14.put("15H", "GFXQJQMYE");
		demo14.put("16H", "GWQJRK");
		demo14.put("17H", "GWQJDJ");
		demo14.put("18H", "GWQJHX");
		demo14.put("19H", "GWQJQMYE");

		demo16.put("2L", "HJ");
		demo16.put("3L", "YNZQY");
		demo16.put("4L", "YGYQY");
		demo16.put("5L", "EJTQY");
		demo16.put("6L", "SGFHZQY");
		demo16.put("7L", "SLYQY");
		demo16.put("8L", "QZGYKG1");
		demo16.put("9L", "1GYLYQY");
		demo16.put("10L", "2JTLYQY");
		demo16.put("11L", "3GYYJTLYQY");
		demo16.put("12L", "4QTLYQY");
		demo16.put("13L", "WYXZRGS");
		demo16.put("14L", "QZGYKG2");
		demo16.put("15L", "1GYDZQY");
		demo16.put("16L", "2QTYXZRGS");
		demo16.put("17L", "LGFYXGS");
		demo16.put("18L", "QZ:GYKG");
		demo16.put("19L", "QSYQY");
		demo16.put("20L", "1SYDZQY");
		demo16.put("21L", "2SYHHQY");
		demo16.put("22L", "3SYYXZRGS");
		demo16.put("23L", "4SYGFYXGS");
		demo16.put("24L", "BQTQY");
		demo16.put("25L", "EGATSTZQY");
		demo16.put("26L", "QZGYKG3");
		demo16.put("27L", "1HZJYQYGHATZ");
		demo16.put("28L", "2HZJYQYGHATZ");
		demo16.put("29L", "3GATSDZJYQY");
		demo16.put("30L", "4GATSTZGFYXGS");
		demo16.put("31L", "5QTGATSTZQY");
		demo16.put("32L", "SWSTZQY");
		demo16.put("33L", "QZGYKG4");
		demo16.put("34L", "1ZWHZJYQY");
		demo16.put("35L", "2ZWHZJYQY");
		demo16.put("36L", "3WZQY");
		demo16.put("37L", "4WSTZGFYXGS");
		demo16.put("38L", "5QTWSTZQY");
		demo16.put("39L", "SGTJY");
		demo16.put("40L", "1GTH");
		demo16.put("41L", "2GRHH");
		demo16.put("1H", "XH");
		demo16.put("2H", "XM");
		demo16.put("3H", "SSSRHJ");
		demo16.put("4H", "GNZZS");
		demo16.put("5H", "QZ：YBNSR");
		demo16.put("6H", "GNXFS");
		demo16.put("7H", "YYS");
		demo16.put("8H", "QYSDS");
		demo16.put("9H", "GRSDS");
		demo16.put("10H", "ZYS");
		demo16.put("11H", "CSWHJSS");
		demo16.put("12H", "FCS");
		demo16.put("13H", "YHS");
		demo16.put("14H", "CZTDSYS");
		demo16.put("15H", "TDZZS");
		demo16.put("16H", "CCS");
		demo16.put("17H", "CLGZS");
		demo16.put("18H", "GDZYS");
		demo16.put("19H", "QS");
		demo16.put("20H", "QTSS");

		demo17.put("3L", "YZZSSRHJ");
		demo17.put("4L", "YGNZZS");
		demo17.put("5L", "1CKY");
		demo17.put("6L", "1MTKCHXXY");
		demo17.put("7L", "2SYHTRQKCY");
		demo17.put("8L", "QZYY");
		demo17.put("9L", "3HSJSKCXY");
		demo17.put("10L", "4YSJSKCXY");
		demo17.put("11L", "5FJSKCXY");
		demo17.put("12L", "6QTCKY");
		demo17.put("13L", "2ZZY");
		demo17.put("14L", "1NFSPJGY");
		demo17.put("15L", "2SPZZY");
		demo17.put("16L", "3JYLHJZCZZY");
		demo17.put("17L", "JDZZ");
		demo17.put("18L", "QZJJ");
		demo17.put("19L", "YLZZ");
		demo17.put("20L", "JZCZZ");
		demo17.put("21L", "4YCZPY");
		demo17.put("22L", "YYFK");
		demo17.put("23L", "JYZZ");
		demo17.put("24L", "QTYCZPZZ");
		demo17.put("25L", "5FZY");
		demo17.put("26L", "6FZFZFSY");
		demo17.put("27L", "QZJZFZZZ");
		demo17.put("28L", "7PGMPYMJQZPHZXY");
		demo17.put("29L", "QZPGMP");
		demo17.put("30L", "8MCJGJMZTZCZPY");
		demo17.put("31L", "9JJZZY");
		demo17.put("32L", "10ZZJZZPY");
		demo17.put("33L", "ZJZZ");
		demo17.put("34L", "ZZ");
		demo17.put("35L", "QZJZZJZBZZ");
		demo17.put("36L", "ZZPZZ");
		demo17.put("37L", "11YSHJLMJFZY");
		demo17.put("38L", "12WJGMTYHYLYPZZY");
		demo17.put("39L", "13SYJGLJHHRLJGY");
		demo17.put("40L", "YYJGJSYZPZZ");
		demo17.put("41L", "QZCPY");
		demo17.put("42L", "RZYYZZ");
		demo17.put("43L", "LJ");
		demo17.put("44L", "HRLJG");
		demo17.put("45L", "14HXYLJHXZPY");
		demo17.put("46L", "FLZZ");
		demo17.put("47L", "NYZZ");
		demo17.put("48L", "ZYHXCPZZ");
		demo17.put("49L", "RYHXCPZZ");
		demo17.put("50L", "QZHZPZZ");
		demo17.put("51L", "QT1");
		demo17.put("52L", "15YYZZY");
		demo17.put("53L", "16HXXWZZY");
		demo17.put("54L", "17XJHSLZPY");
		demo17.put("55L", "QZLTZZ");
		demo17.put("56L", "18FJSKWZPY");
		demo17.put("57L", "SNSHHSGZZ");
		demo17.put("58L", "QZSNZZ");
		demo17.put("59L", "SNJSGZPZZ");
		demo17.put("60L", "BLJBLZPZZ");
		demo17.put("61L", "QT2");
		demo17.put("62L", "19HSJSYLJYYJGY");
		demo17.put("63L", "QZGYYJG");
		demo17.put("64L", "20YSJSYLJYYJGY");
		demo17.put("65L", "21JSZPY");
		demo17.put("66L", "22TYSBZZY");
		demo17.put("67L", "23ZYSBZZY");
		demo17.put("68L", "24QCZZY");
		demo17.put("69L", "QZQCZCZZ");
		demo17.put("70L", "DCZZ");
		demo17.put("71L", "25TLCBHKHTHQTYSSBZZY");
		demo17.put("72L", "QZTLYSSBZZ");
		demo17.put("73L", "CBJXGZZZZ");
		demo17.put("74L", "HKHTJSBZZ");
		demo17.put("75L", "MTCZZ");
		demo17.put("76L", "26DQJXHQCZZY");
		demo17.put("77L", "DJZZ");
		demo17.put("78L", "DXDLGLJDGQCZZ");
		demo17.put("79L", "JYDLQJZZ");
		demo17.put("80L", "QT3");
		demo17.put("81L", "27JSJTXHQTDZSBZZY");
		demo17.put("82L", "JSJZZ");
		demo17.put("83L", "TXSBZZ");
		demo17.put("84L", "GBDSSBZZ");
		demo17.put("85L", "STSBZZ");
		demo17.put("86L", "QT4");
		demo17.put("87L", "28YBYQZZY");
		demo17.put("88L", "29QTZZY");
		demo17.put("89L", "3DLRLRQJSDSCHGYY");
		demo17.put("90L", "1DLRLSCHGYY");
		demo17.put("91L", "DLSC");
		demo17.put("92L", "QZHLFD");
		demo17.put("93L", "SLFD");
		demo17.put("94L", "HLFD");
		demo17.put("95L", "FLFD");
		demo17.put("96L", "TYNFD");
		demo17.put("97L", "DLGY");
		demo17.put("98L", "RLSCHGY");
		demo17.put("99L", "2RQSCHGYY");
		demo17.put("100L", "3SDSCHGYY");
		demo17.put("101L", "4PFHLSY");
		demo17.put("102L", "1PFY");
		demo17.put("103L", "SPYLJYCZPPF");
		demo17.put("104L", "QZYCZPPF");
		demo17.put("105L", "FZFZJJTYPPF");
		demo17.put("106L", "KCPJCJHGCPPF");
		demo17.put("107L", "QZMTJZPPF");
		demo17.put("108L", "SYJZPPF");
		demo17.put("109L", "JCPF");
		demo17.put("110L", "JXSBWJJDJDZCPPF");
		demo17.put("111L", "QZQCPF");
		demo17.put("112L", "MTCJLPJPF");
		demo17.put("113L", "DQSBPF");
		demo17.put("114L", "JSJRJJFZSBPF");
		demo17.put("115L", "QT5");
		demo17.put("116L", "2LSY");
		demo17.put("117L", "5JTYSCCHYZY");
		demo17.put("118L", "1JTYSY");
		demo17.put("119L", "TLYSY");
		demo17.put("120L", "DLYSY");
		demo17.put("121L", "SSYSY");
		demo17.put("122L", "HKYSY");
		demo17.put("123L", "GDYSY");
		demo17.put("124L", "ZXBYHYSDLY");
		demo17.put("125L", "2CCY");
		demo17.put("126L", "3YZY");
		demo17.put("127L", "6ZSHCYY");
		demo17.put("128L", "1ZSY");
		demo17.put("129L", "2CYY");
		demo17.put("130L", "7XXCSRJHXXJSFWY");
		demo17.put("131L", "1DXGBDSHWXCSFWY");
		demo17.put("132L", "QZDX");
		demo17.put("133L", "2HLWHXGFW");
		demo17.put("134L", "3RJHXXJSFWY");
		demo17.put("135L", "8JRY");
		demo17.put("136L", "1HBJRFW");
		demo17.put("137L", "QZYX");
		demo17.put("138L", "JRZL");
		demo17.put("139L", "2ZBSCFW");
		demo17.put("140L", "3BXY");
		demo17.put("141L", "4QTJRY");
		demo17.put("142L", "9FDCY");
		demo17.put("143L", "1FDCKFJYY");
		demo17.put("144L", "2WYGL");
		demo17.put("145L", "3FDCZJFW");
		demo17.put("146L", "4ZYFDCJYHD");
		demo17.put("147L", "5QTFDCY");
		demo17.put("148L", "10ZLHSWFWY");
		demo17.put("149L", "1ZLY");
		demo17.put("150L", "2SWFWY");
		demo17.put("151L", "QZZXYDC");
		demo17.put("152L", "GGY");
		demo17.put("153L", "ZSCQFW");
		demo17.put("154L", "HYJZLFW");
		demo17.put("155L", "11KXYJHJSFWY");
		demo17.put("156L", "1YJHSYFZ");
		demo17.put("157L", "2ZYJSFWY");
		demo17.put("158L", "QZZYHSJFW");
		demo17.put("159L", "3KJTGHYYFWY");
		demo17.put("160L", "12JMFWXLHQTFWY");
		demo17.put("161L", "QZJMFWY");
		demo17.put("162L", "JDCDZCPHRYCPXLY");
		demo17.put("163L", "13JY");
		demo17.put("164L", "14WSHSHGZ");
		demo17.put("165L", "QZWS");
		demo17.put("166L", "15WHTYHYLY");
		demo17.put("167L", "QZXWHCBY");
		demo17.put("168L", "GBDSDYHYSLYZZY");
		demo17.put("169L", "TY");
		demo17.put("170L", "YLY");
		demo17.put("171L", "16GGGLSHBZHSHZZ");
		demo17.put("172L", "17JZY");
		demo17.put("173L", "1FWJZY");
		demo17.put("174L", "2TMGCJZY");
		demo17.put("175L", "3JZAZY");
		demo17.put("176L", "4JZZSHQTJZY");
		demo17.put("177L", "18SLHJHGGSSGLY");
		demo17.put("178L", "QZGGSSGLY");
		demo17.put("179L", "19QTXY");
		demo17.put("180L", "EJKHWZZS");
		demo17.put("181L", "ECKTZZSHJ");
		demo17.put("1H", "XH");
		demo17.put("2H", "XM");
		demo17.put("3H", "HJ");
		demo17.put("4H", "QZMDDK");
		demo17.put("5H", "NZQYXJ");
		demo17.put("6H", "NZQYGYQY");
		demo17.put("7H", "NZQYJTQY");
		demo17.put("8H", "NZQYGFHZQY");
		demo17.put("9H", "NZQYLYQY");
		demo17.put("10H", "NZQYQZGYKG1");
		demo17.put("11H", "NZQYGFGS");
		demo17.put("12H", "NZQYQZGYKG2");
		demo17.put("13H", "NZQYSYQY");
		demo17.put("14H", "NZQYQTQY");
		demo17.put("15H", "GATTZQY");
		demo17.put("16H", "QZGYKG1");
		demo17.put("17H", "WSTZQY");
		demo17.put("18H", "QZGYKG2");
		demo17.put("19H", "GTJY");
		demo17.put("20H", "FLZLGDZCJXSE");
		demo17.put("21H", "SJDKZZS");
		demo17.put("22H", "DDKGDZCJXSE");

		demo18.put("3L", "YXFSSR");
		demo18.put("4L", "YGNXFS");
		demo18.put("5L", "1JJJJ");
		demo18.put("6L", "1BJ");
		demo18.put("7L", "2HJ");
		demo18.put("8L", "3PJ");
		demo18.put("9L", "4QTJ");
		demo18.put("10L", "5JJ");
		demo18.put("11L", "2Y");
		demo18.put("12L", "1GYJY");
		demo18.put("13L", "QZA56SLZS");
		demo18.put("14L", "A36SLZS");
		demo18.put("15L", "2XQY");
		demo18.put("16L", "3YS");
		demo18.put("17L", "4SYPFJY");
		demo18.put("18L", "3CPY");
		demo18.put("19L", "1QY");
		demo18.put("20L", "2CY");
		demo18.put("21L", "3SNY");
		demo18.put("22L", "4RJY");
		demo18.put("23L", "5RHY");
		demo18.put("24L", "6RLY");
		demo18.put("25L", "7HKMY");
		demo18.put("26L", "4XQC");
		demo18.put("27L", "1CYC");
		demo18.put("28L", "A1SLZS");
		demo18.put("29L", "A3SLZS");
		demo18.put("30L", "A5SLZS");
		demo18.put("31L", "A9SLZS");
		demo18.put("32L", "A12SLZS");
		demo18.put("33L", "A25SLZS");
		demo18.put("34L", "A40SLZS");
		demo18.put("35L", "2ZQXSYKC");
		demo18.put("36L", "3CHHXQC");
		demo18.put("37L", "5MTC");
		demo18.put("38L", "6GEFQJQJ");
		demo18.put("39L", "7QCLT");
		demo18.put("40L", "8GDHZP");
		demo18.put("41L", "9GZSS");
		demo18.put("42L", "10BPYH");
		demo18.put("43L", "11GDSB");
		demo18.put("44L", "12YT");
		demo18.put("45L", "13MZYCXKZ");
		demo18.put("46L", "14SMDB");
		demo18.put("47L", "15DC");
		demo18.put("48L", "16TL");
		demo18.put("49L", "17QT");
		demo18.put("50L", "18SKZNJFKSR");
		demo18.put("51L", "EJKXFPXFS");
		demo18.put("52L", "ECKXFPTXFS");
		demo18.put("1H", "XH");
		demo18.put("2H", "XM");
		demo18.put("3H", "HJ");
		demo18.put("4H", "NZQYXJ");
		demo18.put("5H", "NZQYGYQY");
		demo18.put("6H", "NZQYJTQY");
		demo18.put("7H", "NZQYGFHZQY");
		demo18.put("8H", "NZQYLYQY");
		demo18.put("9H", "NZQYQZGYKG1");
		demo18.put("10H", "NZQYGFGS");
		demo18.put("11H", "NZQYQZGYKG2");
		demo18.put("12H", "NZQYSYQY");
		demo18.put("13H", "NZQYQTQY");
		demo18.put("14H", "GATTZQY");
		demo18.put("15H", "QZGYKG1");
		demo18.put("16H", "WSTZQY");
		demo18.put("17H", "QZGYKG2");
		demo18.put("18H", "GTJY");

		demo20.put("2L", "ZJ");
		demo20.put("3L", "YCKY");
		demo20.put("4L", "1MTKCHXXY");
		demo20.put("5L", "2SYHTRQKCY");
		demo20.put("6L", "QZYY");
		demo20.put("7L", "3HSJSKCXY");
		demo20.put("8L", "4YSJSKCXY");
		demo20.put("9L", "5FJSKCXY");
		demo20.put("10L", "6QTCKY");
		demo20.put("11L", "EZZY");
		demo20.put("12L", "1NFSPJGY");
		demo20.put("13L", "2SPZZY");
		demo20.put("14L", "3JYLHJZCZZY");
		demo20.put("15L", "JDZZ");
		demo20.put("16L", "QZJJ");
		demo20.put("17L", "YLZZ");
		demo20.put("18L", "JZCZZ");
		demo20.put("19L", "4YCZPY");
		demo20.put("20L", "YYFK");
		demo20.put("21L", "JYZZ");
		demo20.put("22L", "QTYCZPJG");
		demo20.put("23L", "5FZY");
		demo20.put("24L", "6FZFZFSY");
		demo20.put("25L", "QZFZFZ");
		demo20.put("26L", "7PGMPYMJQZPHZXY");
		demo20.put("27L", "QZPGMP");
		demo20.put("28L", "8MCJGHMZTZCZPY");
		demo20.put("29L", "9JJZZY");
		demo20.put("30L", "10ZZHZZPY");
		demo20.put("31L", "ZJZZ");
		demo20.put("32L", "ZZ");
		demo20.put("33L", "QZJZZJZBZZ");
		demo20.put("34L", "ZZPZZ");
		demo20.put("35L", "11YSHJLMJFZY");
		demo20.put("36L", "12WJGMTYHYLYPZZY");
		demo20.put("37L", "13SYJGLJHHRLJGY");
		demo20.put("38L", "QZCPY");
		demo20.put("39L", "14HXYLHHXZPZZY");
		demo20.put("40L", "FLZZ");
		demo20.put("41L", "NYZZ");
		demo20.put("42L", "ZYHXCPZZ");
		demo20.put("43L", "RYHXCPZZ");
		demo20.put("44L", "QZHZPZZ");
		demo20.put("45L", "QT1");
		demo20.put("46L", "15YYZZY");
		demo20.put("47L", "16HXXWZZY");
		demo20.put("48L", "17XJHSLZPY");
		demo20.put("49L", "QZLTZZ");
		demo20.put("50L", "18FJSKWZPY");
		demo20.put("51L", "SNSHHSGZZ");
		demo20.put("52L", "QZSNZZ");
		demo20.put("53L", "SNJSGZPZZ");
		demo20.put("54L", "BLJBLZPZZ");
		demo20.put("55L", "QT2");
		demo20.put("56L", "19HSJSYLHYYJGY");
		demo20.put("57L", "QZGYYJG");
		demo20.put("58L", "20YSJSYLHYYJGY");
		demo20.put("59L", "21JSZPY");
		demo20.put("60L", "22TYSBZZY");
		demo20.put("61L", "23ZYSBZZY");
		demo20.put("62L", "24QCZZY");
		demo20.put("63L", "25TLCBHKHTHQTYSSBZZY");
		demo20.put("64L", "QZTLYSSBZZ");
		demo20.put("65L", "CBJXGZZZZ");
		demo20.put("66L", "HKHTJSBZZ");
		demo20.put("67L", "MTCZZ");
		demo20.put("68L", "26DQJXHQCZZY");
		demo20.put("69L", "DJZZ");
		demo20.put("70L", "DXDLGLJDGQCZZ");
		demo20.put("71L", "JYDLQJZZ");
		demo20.put("72L", "QT3");
		demo20.put("73L", "27JSJTXHQTDZSBZZY");
		demo20.put("74L", "JSJZZ");
		demo20.put("75L", "TXSBZZ");
		demo20.put("76L", "GBDSSBZZ");
		demo20.put("77L", "STSBZZ");
		demo20.put("78L", "QT");
		demo20.put("79L", "28YBYQZZY");
		demo20.put("80L", "29QTZZY");
		demo20.put("81L", "SDLRLRQJSDSCHGYY");
		demo20.put("82L", "1DLRLSCHGYY");
		demo20.put("83L", "DLSC");
		demo20.put("84L", "QZHLFD");
		demo20.put("85L", "SLFD");
		demo20.put("86L", "HLFD");
		demo20.put("87L", "FLFD");
		demo20.put("88L", "TYNFD");
		demo20.put("89L", "DLGY");
		demo20.put("90L", "RLSCHGYY");
		demo20.put("91L", "2RQSCHGYY");
		demo20.put("92L", "3SDSCHGYY");
		demo20.put("93L", "SJZY");
		demo20.put("94L", "1FWJZY");
		demo20.put("95L", "2TMGCJZY");
		demo20.put("96L", "3JZAZY");
		demo20.put("97L", "4JZZSHQTJZY");
		demo20.put("98L", "WPFHLSY");
		demo20.put("99L", "1PFY");
		demo20.put("100L", "QZYCZPPF");
		demo20.put("101L", "MTJZPPF");
		demo20.put("102L", "SYJQZPPF");
		demo20.put("103L", "QCJLPJPF");
		demo20.put("104L", "2LSY");
		demo20.put("105L", "LJTYSCCHYZY");
		demo20.put("106L", "1JTYSY");
		demo20.put("107L", "2CCY");
		demo20.put("108L", "3YZY");
		demo20.put("109L", "QZSHCYY");
		demo20.put("110L", "1ZSY");
		demo20.put("111L", "2CYY");
		demo20.put("112L", "BXXCSRJHXXJSFWY");
		demo20.put("113L", "1DXGBDSHWXCSFWY");
		demo20.put("114L", "QZDX");
		demo20.put("115L", "2HLWHXGFW");
		demo20.put("116L", "3RJHXXJSFWY");
		demo20.put("117L", "JJRY");
		demo20.put("118L", "1HBJRFW");
		demo20.put("119L", "QZYX");
		demo20.put("120L", "JRZL");
		demo20.put("121L", "2ZBSCFW");
		demo20.put("122L", "3BXY");
		demo20.put("123L", "4QTJRY");
		demo20.put("124L", "SFDCY");
		demo20.put("125L", "SYZLHSWFWY");
		demo20.put("126L", "1ZLY");
		demo20.put("127L", "2SWFWY");
		demo20.put("128L", "SEKXYJHJSFWY");
		demo20.put("129L", "SSJMFWXLHQTFWY");
		demo20.put("130L", "QZJMFWY");
		demo20.put("131L", "JDCDZCPHRYCPXLY");
		demo20.put("132L", "SSJY");
		demo20.put("133L", "SWWSHSHGZ");
		demo20.put("134L", "QZWS");
		demo20.put("135L", "SLWHTYHYLY");
		demo20.put("136L", "QZXWHCBY");
		demo20.put("137L", "GBDSDYHYSLYZZY");
		demo20.put("138L", "TY");
		demo20.put("139L", "YLY");
		demo20.put("140L", "SQGGGLSHBZHSHZZ");
		demo20.put("141L", "SBQTXY");
		demo20.put("1H", "XH");
		demo20.put("2H", "XM");
		demo20.put("3H", "HJ");
		demo20.put("4H", "YJ");
		demo20.put("5H", "HSQJ");
		demo20.put("6H", "JNYQNDQS");

		demo21.put("2L", "ZJ");
		demo21.put("3L", "1GZXJSD");
		demo21.put("4L", "A3SLZS");
		demo21.put("5L", "A10SLZS1");
		demo21.put("6L", "A20SLZS1");
		demo21.put("7L", "A25SLZS");
		demo21.put("8L", "A30SLZS1");
		demo21.put("9L", "A35SLZS1");
		demo21.put("10L", "A45SLZS");
		demo21.put("11L", "2GTGSHSCJYSD");
		demo21.put("12L", "A5SLZS1");
		demo21.put("13L", "A10SLZS2");
		demo21.put("14L", "A20SLZS2");
		demo21.put("15L", "A30SLZS2");
		demo21.put("16L", "A35SLZS2");
		demo21.put("17L", "HDZS1");
		demo21.put("18L", "3QSYDWCBCZJYSD");
		demo21.put("19L", "A5SLZS");
		demo21.put("20L", "A10SLZS");
		demo21.put("21L", "A20SLZS3");
		demo21.put("22L", "A30SLZS3");
		demo21.put("23L", "A35SLZS");
		demo21.put("24L", "HDZS");
		demo21.put("25L", "4LWBCSD");
		demo21.put("26L", "A20SLZS");
		demo21.put("27L", "A30SLZS");
		demo21.put("28L", "A40SLZS");
		demo21.put("29L", "5GCSD");
		demo21.put("30L", "6TXQSYFSD");
		demo21.put("31L", "7LXGXHLSD");
		demo21.put("32L", "QZCXCKLXSD");
		demo21.put("33L", "8CCZLSD");
		demo21.put("34L", "9CCZRSD");
		demo21.put("35L", "QZXSGZRSD");
		demo21.put("36L", "FWZRSD");
		demo21.put("37L", "10ORSD");
		demo21.put("38L", "11QTSD");
		demo21.put("39L", "12SKZNJFKSR");
		demo21.put("1H", "XH");
		demo21.put("2H", "XM");
		demo21.put("3H", "HJ");
		demo21.put("4H", "DL");
		demo21.put("5H", "GAT");
		demo21.put("6H", "WG");

		demo22.put("3L", "ZJ");
		demo22.put("4L", "YNYK");
		demo22.put("5L", "1MT");
		demo22.put("6L", "2YY");
		demo22.put("7L", "3TRQ");
		demo22.put("8L", "4MCCQ");
		demo22.put("9L", "5DR");
		demo22.put("10L", "6QTNYK");
		demo22.put("11L", "EJSK");
		demo22.put("12L", "1TK");
		demo22.put("13L", "2JK");
		demo22.put("14L", "3TK");
		demo22.put("15L", "4LTK");
		demo22.put("16L", "5QXK");
		demo22.put("17L", "6NK");
		demo22.put("18L", "7XK");
		demo22.put("19L", "8ZZXTK");
		demo22.put("20L", "9QXTK");
		demo22.put("21L", "10WK");
		demo22.put("22L", "11ZK");
		demo22.put("23L", "12MK");
		demo22.put("24L", "13YK");
		demo22.put("25L", "14QTJSK");
		demo22.put("26L", "SFJSK");
		demo22.put("27L", "1SM");
		demo22.put("28L", "2GZT");
		demo22.put("29L", "3GLT");
		demo22.put("30L", "4YS");
		demo22.put("31L", "5SHS");
		demo22.put("32L", "6LTK");
		demo22.put("33L", "7LK");
		demo22.put("34L", "8LHJ");
		demo22.put("35L", "9LSJ");
		demo22.put("36L", "10ZT");
		demo22.put("37L", "11SS");
		demo22.put("38L", "12JKY");
		demo22.put("39L", "13HY");
		demo22.put("40L", "14HY");
		demo22.put("41L", "15DXLSSZDY");
		demo22.put("42L", "16KQS");
		demo22.put("43L", "17DLY");
		demo22.put("44L", "18HGY");
		demo22.put("45L", "19NHZT");
		demo22.put("46L", "20MX");
		demo22.put("47L", "21QTFJSK");
		demo22.put("48L", "SSZY");
		demo22.put("49L", "1DBS");
		demo22.put("50L", "2DXS");
		demo22.put("51L", "WQT");
		demo22.put("52L", "LSKZNJFKSR");
		demo22.put("1H", "XH");
		demo22.put("2H", "XM");
		demo22.put("3H", "HJ");
		demo22.put("4H", "NZQYXJ");
		demo22.put("5H", "NZQYGYQY");
		demo22.put("6H", "NZQYJTQY");
		demo22.put("7H", "NZQYGFHZQY");
		demo22.put("8H", "NZQYLYQY");
		demo22.put("9H", "NZQYQZGYKG1");
		demo22.put("10H", "NZQYGFGS");
		demo22.put("11H", "NZQYQZGYKG2");
		demo22.put("12H", "NZQYSYQY");
		demo22.put("13H", "NZQYQTQY");
		demo22.put("14H", "GATTZQY");
		demo22.put("15H", "QZGYKG1");
		demo22.put("16H", "WSTZQY");
		demo22.put("17H", "QZGYKG2");
		demo22.put("18H", "GTJY");

		demo23.put("2L", "YSWSSSR1");
		demo23.put("3L", "YZWHZJYQY2");
		demo23.put("4L", "1CKY3");
		demo23.put("5L", "2ZZY4");
		demo23.put("6L", "3DLRLRQJSDSCHGYY5");
		demo23.put("7L", "4JZY6");
		demo23.put("8L", "5PFHLSY7");
		demo23.put("9L", "6JTYSCCHYZY8");
		demo23.put("10L", "7ZSHCYY9");
		demo23.put("11L", "8XXCSRJHXXJSFWY10");
		demo23.put("12L", "9JRY11");
		demo23.put("13L", "10FDCY12");
		demo23.put("14L", "11ZLHSWFWY13");
		demo23.put("15L", "12KXYJHJSFWY14");
		demo23.put("16L", "13WHTYHYLY15");
		demo23.put("17L", "14QTXY16");
		demo23.put("18L", "EZWHZJYQY17");
		demo23.put("19L", "1CKY18");
		demo23.put("20L", "2ZZY19");
		demo23.put("21L", "3DLRLRQJSDSCHGYY20");
		demo23.put("22L", "4JZY21");
		demo23.put("23L", "5PFHLSY22");
		demo23.put("24L", "6JTYSCCHYZY23");
		demo23.put("25L", "7ZSHCYY24");
		demo23.put("26L", "8XXCSRJHXXJSFWY25");
		demo23.put("27L", "9JRY26");
		demo23.put("28L", "10FDCY27");
		demo23.put("29L", "11ZLHSWFWY28");
		demo23.put("30L", "12KXYJHJSFWY29");
		demo23.put("31L", "13WHTYHYLY30");
		demo23.put("32L", "14QTXY31");
		demo23.put("33L", "SWZQY32");
		demo23.put("34L", "1CKY33");
		demo23.put("35L", "2ZZY34");
		demo23.put("36L", "3DLRLRQJSDSCHGYY35");
		demo23.put("37L", "4JZY36");
		demo23.put("38L", "5PFHLSY37");
		demo23.put("39L", "6JTYSCCHYZY38");
		demo23.put("40L", "7ZSHCYY39");
		demo23.put("41L", "8XXCSRJHXXJSFWY40");
		demo23.put("42L", "9JRY41");
		demo23.put("43L", "10FDCY42");
		demo23.put("44L", "11ZLHSWFWY43");
		demo23.put("45L", "12KXYJHJSFWY44");
		demo23.put("46L", "13WHTYHYLY45");
		demo23.put("47L", "14QTXY46");
		demo23.put("48L", "SFJMQY47");
		demo23.put("49L", "1WGQYCZDBJG48");
		demo23.put("50L", "2TGLWCBGCZY49");
		demo23.put("51L", "3JRHBX50");
		demo23.put("52L", "4GJYSSR51");
		demo23.put("53L", "5ZFDWKJ52");
		demo23.put("54L", "6QT53");
		demo23.put("55L", "WWJGR54");
		demo23.put("56L", "LJKHWSS55");
		demo23.put("57L", "ECKHWTS56");
		demo23.put("1H", "XH");
		demo23.put("2H", "XM");
		demo23.put("3H", "HJ");
		demo23.put("4H", "ZZS");
		demo23.put("5H", "XFS");
		demo23.put("6H", "YYS");
		demo23.put("7H", "QYSDS");
		demo23.put("8H", "GRSDS");
		demo23.put("9H", "CSWHJSS");
		demo23.put("10H", "FCS");
		demo23.put("11H", "CZTDSYS");
		demo23.put("12H", "CCS");
		demo23.put("13H", "QTGS");

		demo24.put("2L", "ZJ");
		demo24.put("3L", "BNXQ");
		demo24.put("4L", "WNCQ");
		demo24.put("5L", "1GNZZS");
		demo24.put("6L", "1YCZPY");
		demo24.put("7L", "QZJY");
		demo24.put("8L", "2JZZY");
		demo24.put("9L", "3FZY");
		demo24.put("10L", "4YYJGJSYZPZZY");
		demo24.put("11L", "QZCPY");
		demo24.put("12L", "5HXYLHHXZPZZY");
		demo24.put("13L", "6FJSKWZPY");
		demo24.put("14L", "7HSJSYLJYYJGY");
		demo24.put("15L", "QZGPGC");
		demo24.put("16L", "8QCZZY");
		demo24.put("17L", "9MTCZZY");
		demo24.put("18L", "10MTKCHXXY");
		demo24.put("19L", "11YYHTRQKC");
		demo24.put("20L", "QZYY");
		demo24.put("21L", "12DLSCHGYY");
		demo24.put("22L", "13JZY");
		demo24.put("23L", "14JTYSY");
		demo24.put("24L", "QZTLYSFW");
		demo24.put("25L", "LLYSFW");
		demo24.put("26L", "SLYSFW");
		demo24.put("27L", "HKYSFW");
		demo24.put("28L", "GDYSFW");
		demo24.put("29L", "15YZY");
		demo24.put("30L", "16DXY");
		demo24.put("31L", "17JRY");
		demo24.put("32L", "QZHBJRFW");
		demo24.put("33L", "ZBSCFW");
		demo24.put("34L", "BXY");
		demo24.put("35L", "18FDCY");
		demo24.put("36L", "QZFDCKFJYY");
		demo24.put("37L", "19KXYJHJSFWY");
		demo24.put("38L", "2GNXFS");
		demo24.put("39L", "QZ1JJJJ");
		demo24.put("40L", "J");
		demo24.put("41L", "JJ");
		demo24.put("42L", "2Y");
		demo24.put("43L", "JY");
		demo24.put("44L", "XQY");
		demo24.put("45L", "YS");
		demo24.put("46L", "3CPY");
		demo24.put("47L", "4XQC");
		demo24.put("48L", "5MTC");
		demo24.put("49L", "3YYS");
		demo24.put("50L", "4QYSDS");
		demo24.put("51L", "5CSWHJSS");
		demo24.put("52L", "6QTGS");
		demo24.put("1H", "XH");
		demo24.put("2H", "XM");
		demo24.put("3H", "HJ");
		demo24.put("4H", "GYQY");
		demo24.put("5H", "JTQY");
		demo24.put("6H", "GFHZQY");
		demo24.put("7H", "LYQY");
		demo24.put("8H", "QZGYKG1");
		demo24.put("9H", "GFGS");
		demo24.put("10H", "QZGYKG2");
		demo24.put("11H", "SYQY");
		demo24.put("12H", "GATTZQY");
		demo24.put("13H", "QZGYKG3");
		demo24.put("14H", "WSTZQY");
		demo24.put("15H", "QZGYKG4");
		demo24.put("16H", "QTQY");
		demo24.put("17H", "GTJKKQY");

		demo25.put("3L", "QMYEZJ");
		demo25.put("4L", "QMYE1GNZZS");
		demo25.put("5L", "QMYE2GNXFS");
		demo25.put("6L", "QMYE3YYS");
		demo25.put("7L", "QMYE4QYSDS");
		demo25.put("8L", "QMYE5GRSDS");
		demo25.put("9L", "QMYE6ZYS");
		demo25.put("10L", "QMYE7GDTZFXDJS");
		demo25.put("11L", "QMYE8CSWHJSS");
		demo25.put("12L", "QMYE9FCS");
		demo25.put("13L", "QMYE10YHS");
		demo25.put("14L", "QMYE11CSTDSYS");
		demo25.put("15L", "QMYE12TDZZS");
		demo25.put("16L", "QMYE13CCS");
		demo25.put("17L", "QMYE14CLGZS");
		demo25.put("18L", "QMYE15YYS");
		demo25.put("19L", "QMYE16GDZYS");
		demo25.put("20L", "QMYE17QS");
		demo25.put("21L", "QMYE18QTSS");
		demo25.put("22L", "DNRKZJ");
		demo25.put("23L", "DNRK1GNZZS");
		demo25.put("24L", "DNRK2GNXFS");
		demo25.put("25L", "DNRK3YYS");
		demo25.put("26L", "DNRK4QYSDS");
		demo25.put("27L", "DNRK5GRSDS");
		demo25.put("28L", "DNRK6ZYS");
		demo25.put("29L", "DNRK7GDTZFXDJS");
		demo25.put("30L", "DNRK8CSWHJSS");
		demo25.put("31L", "DNRK9FCS");
		demo25.put("32L", "DNRK10YHS");
		demo25.put("33L", "DNRKCSTDSYS");
		demo25.put("34L", "DNRKTDZZS");
		demo25.put("35L", "DNRKCCS");
		demo25.put("36L", "DNRKCLGZS");
		demo25.put("37L", "DNRKYYS");
		demo25.put("38L", "DNRKGDZYS");
		demo25.put("39L", "DNRKQS");
		demo25.put("40L", "DNRKQTSS");
		demo25.put("1H", "XH");
		demo25.put("2H", "XM1");
		demo25.put("3H", "XM2");
		demo25.put("4H", "QSHJ");
		demo25.put("5H", "1WNCQXJ");
		demo25.put("6H", "2WNCQ5NYS");
		demo25.put("7H", "3WNCQ2012N");
		demo25.put("8H", "4WNCQ2013N");
		demo25.put("9H", "5WNCQ2014N");
		demo25.put("10H", "6WNCQ2015N");
		demo25.put("11H", "7WNCQ2016N");
		demo25.put("12H", "2BNXQ");
		demo25.put("13H", "3GTJKKQYQSWN");
		demo25.put("14H", "4GTJKKQYQSBN");

		demo26.put("2L", "ZJ");
		demo26.put("3L", "QZ1Y");
		demo26.put("4L", "2J");
		demo26.put("5L", "3YJ");
		demo26.put("6L", "4MT");
		demo26.put("7L", "5YY");
		demo26.put("8L", "6CPY");
		demo26.put("9L", "7HG");
		demo26.put("10L", "8DL");
		demo26.put("11L", "9FZP");
		demo26.put("12L", "10QC");
		demo26.put("13L", "11MTC");
		demo26.put("14L", "12JRBX");
		demo26.put("15L", "13JTYS");
		demo26.put("1H", "XH");
		demo26.put("2H", "XM");
		demo26.put("3H", "HJ");
		demo26.put("4H", "GNZZS");
		demo26.put("5H", "GNXFS");
		demo26.put("6H", "YYS");
		demo26.put("7H", "QYSDS");
		demo26.put("8H", "CSWHJSS");
		demo26.put("9H", "QTGS");

		demo27.put("2L", "ZJ");
		demo27.put("3L", "YGSMS");
		demo27.put("4L", "1ZF");
		demo27.put("5L", "2JZJZJ");
		demo27.put("6L", "3JZZY");
		demo27.put("7L", "4ZJYFC");
		demo27.put("8L", "5SHBZ");
		demo27.put("9L", "6TGJMSR");
		demo27.put("10L", "7QT");
		demo27.put("11L", "EGLGXJS");
		demo27.put("12L", "1JSZR");
		demo27.put("13L", "2KJFZ");
		demo27.put("14L", "3ZZCX");
		demo27.put("15L", "4KYJGZZ");
		demo27.put("16L", "5TZCY");
		demo27.put("17L", "6WBFW");
		demo27.put("18L", "7GXJS");
		demo27.put("19L", "8QT");
		demo27.put("20L", "SCJXWQYFZ");
		demo27.put("21L", "1JRSC");
		demo27.put("22L", "2WDQZD");
		demo27.put("23L", "3MZZZSHYYSZC");
		demo27.put("24L", "4QT1");
		demo27.put("25L", "SZZSJ");
		demo27.put("26L", "1QYFZ");
		demo27.put("27L", "2QYZZGZ");
		demo27.put("28L", "3QT");
		demo27.put("29L", "WJNHB");
		demo27.put("30L", "1HJBH");
		demo27.put("31L", "2DLJS");
		demo27.put("32L", "3ZYZHLY");
		demo27.put("33L", "4QT2");
		demo27.put("34L", "LCJQYFZ");
		demo27.put("35L", "1XBKF");
		demo27.put("36L", "2DBFZ");
		demo27.put("37L", "3LAJL");
		demo27.put("38L", "4QT3");
		demo27.put("39L", "QZCWHJYTY");
		demo27.put("40L", "1JY");
		demo27.put("41L", "2TY");
		demo27.put("42L", "3WH");
		demo27.put("43L", "BZCJRZBSC");
		demo27.put("44L", "1ZBSC");
		demo27.put("45L", "2JRSC");
		demo27.put("46L", "JZCSN");
		demo27.put("47L", "1NCJS");
		demo27.put("48L", "2FLSL");
		demo27.put("49L", "3CYSJ");
		demo27.put("50L", "4JRSC");
		demo27.put("51L", "5QT");
		demo27.put("52L", "SZCQTGXSY");
		demo27.put("53L", "1FJZZ");
		demo27.put("54L", "2JCSSJS");
		demo27.put("55L", "3CPY");
		demo27.put("56L", "4GFJS");
		demo27.put("57L", "5GJF");
		demo27.put("58L", "6YLWS");
		demo27.put("59L", "7JTYS");
		demo27.put("60L", "8WCYZ");
		demo27.put("61L", "9GY");
		demo27.put("62L", "10SPCB");
		demo27.put("63L", "11WJRY");
		demo27.put("64L", "12ZXCZXZJ");
		demo27.put("65L", "13XSSSXDDY");
		demo27.put("66L", "GX");
		demo27.put("67L", "LX");
		demo27.put("68L", "TXQSYF");
		demo27.put("69L", "CCSY");
		demo27.put("70L", "QT");
		demo27.put("71L", "14QT");
		demo27.put("1H", "XH");
		demo27.put("2H", "XM");
		demo27.put("3H", "HJ");
		demo27.put("4H", "CKY");
		demo27.put("5H", "ZZY");
		demo27.put("6H", "DLRQJSDSCHGYY");
		demo27.put("7H", "JZY");
		demo27.put("8H", "JTYSCCJYZY");
		demo27.put("9H", "PFHLSY");
		demo27.put("10H", "JRY");
		demo27.put("11H", "XXCSJSJFWHRJY");
		demo27.put("12H", "ZLHSWFWY");
		demo27.put("13H", "FDCY");
		demo27.put("14H", "QTXY");

		demo28.put("3L", "ZJ");
		demo28.put("4L", "YGSMS");
		demo28.put("5L", "1ZF");
		demo28.put("6L", "2JZJZJ");
		demo28.put("7L", "3JZZY");
		demo28.put("8L", "4ZJYFC");
		demo28.put("9L", "5SHBZ");
		demo28.put("10L", "6TGJMSR");
		demo28.put("11L", "7QT");
		demo28.put("12L", "EGLGXJS");
		demo28.put("13L", "1JSZR");
		demo28.put("14L", "2KJFZ");
		demo28.put("15L", "3ZZCX");
		demo28.put("16L", "4KYJGZZ");
		demo28.put("17L", "5TZCY");
		demo28.put("18L", "6WBFW");
		demo28.put("19L", "7GXJS");
		demo28.put("20L", "8QT");
		demo28.put("21L", "SCJXWQYFZ");
		demo28.put("22L", "1JRSC");
		demo28.put("23L", "2WDQZD");
		demo28.put("24L", "3MZZZSHYYSZC");
		demo28.put("25L", "4QT1");
		demo28.put("26L", "SZZSJ");
		demo28.put("27L", "1QYFZ");
		demo28.put("28L", "2QYZZGZ");
		demo28.put("29L", "3QT");
		demo28.put("30L", "WJNHB");
		demo28.put("31L", "1HJBH");
		demo28.put("32L", "2DLJS");
		demo28.put("33L", "3ZYZHLY");
		demo28.put("34L", "4QT2");
		demo28.put("35L", "LCJQYFZ");
		demo28.put("36L", "1XBKF");
		demo28.put("37L", "2DBFZ");
		demo28.put("38L", "3LAJL");
		demo28.put("39L", "4QT3");
		demo28.put("40L", "QZCWHJYTY");
		demo28.put("41L", "1JY");
		demo28.put("42L", "2TY");
		demo28.put("43L", "3WH");
		demo28.put("44L", "BZCJRZBSC");
		demo28.put("45L", "1ZBSC");
		demo28.put("46L", "2JRSC");
		demo28.put("47L", "JZCSN");
		demo28.put("48L", "1NCJS");
		demo28.put("49L", "2FLSL");
		demo28.put("50L", "3CYSJ");
		demo28.put("51L", "4JRSC");
		demo28.put("52L", "5QT");
		demo28.put("53L", "SZCQTGXSY");
		demo28.put("54L", "1FJZZ");
		demo28.put("55L", "2JCSSJS");
		demo28.put("56L", "3CPY");
		demo28.put("57L", "4GFJS");
		demo28.put("58L", "5GJF");
		demo28.put("59L", "6YLWS");
		demo28.put("60L", "7JTYS");
		demo28.put("61L", "8WCYZ");
		demo28.put("62L", "9GY");
		demo28.put("63L", "10SPCB");
		demo28.put("64L", "11WJRY");
		demo28.put("65L", "12ZXCZXZJ");
		demo28.put("66L", "13XSSSXDDY");
		demo28.put("67L", "GX");
		demo28.put("68L", "LX");
		demo28.put("69L", "TXQSYF");
		demo28.put("70L", "CCSY");
		demo28.put("71L", "QT");
		demo28.put("72L", "14QT");
		demo28.put("1H", "XH");
		demo28.put("2H", "XM");
		demo28.put("3H", "HJ");
		demo28.put("4H", "NZQYXJ");
		demo28.put("5H", "NZQYGYQY");
		demo28.put("6H", "NZQYJTQY");
		demo28.put("7H", "NZQYGFHZQY");
		demo28.put("8H", "NZQYLYQY");
		demo28.put("9H", "NZQYGFGS");
		demo28.put("10H", "NZQYSYQY");
		demo28.put("11H", "NZQYQTNZQY");
		demo28.put("12H", "GATTZQY");
		demo28.put("13H", "WSTZQY");
		demo28.put("14H", "GTJY");

		demo29.put("2L", "ZJ");
		demo29.put("3L", "YGSMS");
		demo29.put("4L", "1ZF");
		demo29.put("5L", "2JZJZJ");
		demo29.put("6L", "3JZZY");
		demo29.put("7L", "4ZJYFC");
		demo29.put("8L", "5SHBZ");
		demo29.put("9L", "6TGJMSR");
		demo29.put("10L", "7QT");
		demo29.put("11L", "EGLGXJS");
		demo29.put("12L", "1JSZR");
		demo29.put("13L", "2KJFZ");
		demo29.put("14L", "3ZZCX");
		demo29.put("15L", "4KYJGZZ");
		demo29.put("16L", "5TZCY");
		demo29.put("17L", "6WBFW");
		demo29.put("18L", "7GXJS");
		demo29.put("19L", "8QT");
		demo29.put("20L", "SCJXWQYFZ");
		demo29.put("21L", "1JRSC");
		demo29.put("22L", "2WDQZD");
		demo29.put("23L", "3MZZZSHYYSZC");
		demo29.put("24L", "4QT1");
		demo29.put("25L", "SZZSJ");
		demo29.put("26L", "1QYFZ");
		demo29.put("27L", "2QYZZGZ");
		demo29.put("28L", "3QT");
		demo29.put("29L", "WJNHB");
		demo29.put("30L", "1HJBH");
		demo29.put("31L", "2DLJS");
		demo29.put("32L", "3ZYZHLY");
		demo29.put("33L", "4QT2");
		demo29.put("34L", "LCJQYFZ");
		demo29.put("35L", "1XBKF");
		demo29.put("36L", "2DBFZ");
		demo29.put("37L", "3LAJL");
		demo29.put("38L", "4QT3");
		demo29.put("39L", "QZCWHJYTY");
		demo29.put("40L", "1JY");
		demo29.put("41L", "2TY");
		demo29.put("42L", "3WH");
		demo29.put("43L", "BZCJRZBSC");
		demo29.put("44L", "1ZBSC");
		demo29.put("45L", "2JRSC");
		demo29.put("46L", "JZCSN");
		demo29.put("47L", "1NCJS");
		demo29.put("48L", "2FLSL");
		demo29.put("49L", "3CYSJ");
		demo29.put("50L", "4JRSC");
		demo29.put("51L", "5QT");
		demo29.put("52L", "SZCQTGXSY");
		demo29.put("53L", "1FJZZ");
		demo29.put("54L", "2JCSSJS");
		demo29.put("55L", "3CPY");
		demo29.put("56L", "4GFJS");
		demo29.put("57L", "5GJF");
		demo29.put("58L", "6YLWS");
		demo29.put("59L", "7JTYS");
		demo29.put("60L", "8WCYZ");
		demo29.put("61L", "9GY");
		demo29.put("62L", "10SPCB");
		demo29.put("63L", "11WJRY");
		demo29.put("64L", "12ZXCZXZJ");
		demo29.put("65L", "13XSSSXDDY");
		demo29.put("66L", "GX");
		demo29.put("67L", "LX");
		demo29.put("68L", "TXQSYF");
		demo29.put("69L", "CCSY");
		demo29.put("70L", "QT");
		demo29.put("71L", "14QT");
		demo29.put("1H", "XH");
		demo29.put("2H", "XM");
		demo29.put("3H", "HJ");
		demo29.put("4H", "ZQJM");
		demo29.put("5H", "TKJM");
		demo29.put("6H", "DDQS");

		demo33.put("2L", "HJ");
		demo33.put("3L", "YDYCY");
		demo33.put("4L", "EDECY");
		demo33.put("5L", "YCKY");
		demo33.put("6L", "1MTKCHXXY");
		demo33.put("7L", "2SYHTRQKCY");
		demo33.put("8L", "3HSJSKCXY");
		demo33.put("9L", "4YSJSKCXY");
		demo33.put("10L", "5FJSKCXY");
		demo33.put("11L", "6QTCKY");
		demo33.put("12L", "EZZY");
		demo33.put("13L", "1NFSPJGY");
		demo33.put("14L", "2SPZZY");
		demo33.put("15L", "3JYLHJZCZZY");
		demo33.put("16L", "4YCZPY");
		demo33.put("17L", "5FZY");
		demo33.put("18L", "6FZFZFSY");
		demo33.put("19L", "7PGMPYMJQZPHZXY");
		demo33.put("20L", "8MCJGHMZTZCZPY");
		demo33.put("21L", "9JJZZY");
		demo33.put("22L", "10ZZHZZPY");
		demo33.put("23L", "11YSHJLMJFZY");
		demo33.put("24L", "12WJGMTYHYLYPZZY");
		demo33.put("25L", "13SYJGLJHHRLJGY");
		demo33.put("26L", "14HXYLHHXZPZZY");
		demo33.put("27L", "15YYZZY");
		demo33.put("28L", "16HXXWZZY");
		demo33.put("29L", "17XJHSLZPY");
		demo33.put("30L", "18FJSKWZPY");
		demo33.put("31L", "19HSJSYLHYYJGY");
		demo33.put("32L", "20YSJSYLHYYJGY");
		demo33.put("33L", "21JSZPY");
		demo33.put("34L", "22TYSBZZY");
		demo33.put("35L", "23ZYSBZZY");
		demo33.put("36L", "24QCZZY");
		demo33.put("37L", "25TLCBHKHTHQTYSSBZZY");
		demo33.put("38L", "26DQJXHQCZZY");
		demo33.put("39L", "27JSJTXHQTDZSBZZY");
		demo33.put("40L", "28YBYQZZY");
		demo33.put("41L", "29QTZZY");
		demo33.put("42L", "SDLRLRQJSDSCHGYY");
		demo33.put("43L", "1DLRLSCHGYY");
		demo33.put("44L", "2RQSCHGYY");
		demo33.put("45L", "3SDSCHGYY");
		demo33.put("46L", "SJZY");
		demo33.put("47L", "1FWJZY");
		demo33.put("48L", "2TMGCJZY");
		demo33.put("49L", "3JZAZY");
		demo33.put("50L", "4JZZSHQTJZY");
		demo33.put("51L", "SDSCY");
		demo33.put("52L", "YPFHLSY");
		demo33.put("53L", "1PFY");
		demo33.put("54L", "2LSY");
		demo33.put("55L", "EJTYSCCHYZY");
		demo33.put("56L", "1TLYSY");
		demo33.put("57L", "2DLYSY");
		demo33.put("58L", "3SSYSY");
		demo33.put("59L", "4HKYSY");
		demo33.put("60L", "5GDYSY");
		demo33.put("61L", "6ZXBYHYSDLY");
		demo33.put("62L", "7CCY");
		demo33.put("63L", "8YZY");
		demo33.put("64L", "SZSHCYY");
		demo33.put("65L", "1ZSY");
		demo33.put("66L", "2CYY");
		demo33.put("67L", "SXXCSRJHXXJSFWY");
		demo33.put("68L", "1DXGBDSHWXCSFWY");
		demo33.put("69L", "2HLWHXGFW");
		demo33.put("70L", "3RJHXXJSFWY");
		demo33.put("71L", "WJRY");
		demo33.put("72L", "1HBJRFW");
		demo33.put("73L", "2ZBSCFW");
		demo33.put("74L", "3BXY");
		demo33.put("75L", "4QTJRY");
		demo33.put("76L", "LFDCY");
		demo33.put("77L", "1FDCKFJYY");
		demo33.put("78L", "2WYGL");
		demo33.put("79L", "3FDCZJFW");
		demo33.put("80L", "4ZYFDCJYHD");
		demo33.put("81L", "5QTFDCY");
		demo33.put("82L", "QZLHSWFWY");
		demo33.put("83L", "1ZLY");
		demo33.put("84L", "2SWFWY");
		demo33.put("85L", "QZZXYDC");
		demo33.put("86L", "GGY");
		demo33.put("87L", "ZSCQFW");
		demo33.put("88L", "HYZLFW");
		demo33.put("89L", "BKXYJHJSFWY");
		demo33.put("90L", "1YJHSYFZ");
		demo33.put("91L", "2ZYJSFWY");
		demo33.put("92L", "QZZYHSJFW");
		demo33.put("93L", "3KJTGHYYFWY");
		demo33.put("94L", "JSLHJHGGSSGLY");
		demo33.put("95L", "QZGGSSGLY");
		demo33.put("96L", "SJMFWXLHQTFWY");
		demo33.put("97L", "SYJY");
		demo33.put("98L", "SEWSHSHGZ");
		demo33.put("99L", "SSWHTYHYLY");
		demo33.put("100L", "SSGGGLSHBZHSHZZ");
		demo33.put("101L", "SWQTXY");
		demo33.put("1H", "XH");
		demo33.put("2H", "XM");
		demo33.put("3H", "HJ");
		demo33.put("4H", "YJTYSFW");
		demo33.put("5H", "1LLYSFW");
		demo33.put("6H", "2SLYSFW");
		demo33.put("7H", "3HKYSFW");
		demo33.put("8H", "4GDYSFW");
		demo33.put("9H", "EYZFW");
		demo33.put("10H", "1YZPBFW");
		demo33.put("11H", "2YZTSFW");
		demo33.put("12H", "3QTYZFW");
		demo33.put("13H", "SDXFW");
		demo33.put("14H", "1JCDXFW");
		demo33.put("15H", "2ZZDXFW");
		demo33.put("16H", "SJZFW");
		demo33.put("17H", "1GCFW");
		demo33.put("18H", "2AZFW");
		demo33.put("19H", "3XSFW");
		demo33.put("20H", "4ZSFW");
		demo33.put("21H", "5QTJZFW");
		demo33.put("22H", "WJRFW");
		demo33.put("23H", "1DKFW");
		demo33.put("24H", "2ZJSFJRFW");
		demo33.put("25H", "3BXFW");
		demo33.put("26H", "4JRSPZR");
		demo33.put("27H", "LXDFW");
		demo33.put("28H", "1YFHJSFW");
		demo33.put("29H", "2XXJSFW");
		demo33.put("30H", "3WHCYFW");
		demo33.put("31H", "4WLFZFW");
		demo33.put("32H", "5ZLFW");
		demo33.put("33H", "6JZZXFW");
		demo33.put("34H", "7GBYSFW");
		demo33.put("35H", "8SWFZFW");
		demo33.put("36H", "9QTXDFW");
		demo33.put("37H", "QSHFW");
		demo33.put("38H", "1WHTYFW");
		demo33.put("39H", "2JYYLFW");
		demo33.put("40H", "3LYYLFW");
		demo33.put("41H", "4CYZSFW");
		demo33.put("42H", "5JMRCFW");
		demo33.put("43H", "6QTSHFW");
		demo33.put("44H", "BXSWXZC");
		demo33.put("45H", "1ZLHFZLJS");
		demo33.put("46H", "2SBHZZQ");
		demo33.put("47H", "3TDSYQ");
		demo33.put("48H", "4QTZRZYSYQ");
		demo33.put("49H", "5QTQYXWXZC");
		demo33.put("50H", "JXSBDC");
		demo33.put("51H", "1JZW");
		demo33.put("52H", "QZESFJY1");
		demo33.put("53H", "2GZW");
		demo33.put("54H", "QZESFJY2");

		demo34.put("3L", "HJ");
		demo34.put("4L", "YDYCY");
		demo34.put("5L", "EDECY");
		demo34.put("6L", "YCKY");
		demo34.put("7L", "1MTKCHXXY");
		demo34.put("8L", "2SYHTRQKCY");
		demo34.put("9L", "3HSJSKCXY");
		demo34.put("10L", "4YSJSKCXY");
		demo34.put("11L", "5FJSKCXY");
		demo34.put("12L", "6QTCKY");
		demo34.put("13L", "EZZY");
		demo34.put("14L", "1NFSPJGY");
		demo34.put("15L", "2SPZZY");
		demo34.put("16L", "3JYLHJZCZZY");
		demo34.put("17L", "4YCZPY");
		demo34.put("18L", "5FZY");
		demo34.put("19L", "6FZFZFSY");
		demo34.put("20L", "7PGMPYMJQZPHZXY");
		demo34.put("21L", "8MCJGHMZTZCZPY");
		demo34.put("22L", "9JJZZY");
		demo34.put("23L", "10ZZHZZPY");
		demo34.put("24L", "11YSHJLMJFZY");
		demo34.put("25L", "12WJGMTYHYLYPZZY");
		demo34.put("26L", "13SYJGLJHHRLJGY");
		demo34.put("27L", "14HXYLHHXZPZZY");
		demo34.put("28L", "15YYZZY");
		demo34.put("29L", "16HXXWZZY");
		demo34.put("30L", "17XJHSLZPY");
		demo34.put("31L", "18FJSKWZPY");
		demo34.put("32L", "19HSJSYLHYYJGY");
		demo34.put("33L", "20YSJSYLHYYJGY");
		demo34.put("34L", "21JSZPY");
		demo34.put("35L", "22TYSBZZY");
		demo34.put("36L", "23ZYSBZZY");
		demo34.put("37L", "24QCZZY");
		demo34.put("38L", "25TLCBHKHTHQTYSSBZZY");
		demo34.put("39L", "26DQJXHQCZZY");
		demo34.put("40L", "27JSJTXHQTDZSBZZY");
		demo34.put("41L", "28YBYQZZY");
		demo34.put("42L", "29QTZZY");
		demo34.put("43L", "SDLRLRQJSDSCHGYY");
		demo34.put("44L", "1DLRLSCHGYY");
		demo34.put("45L", "2RQSCHGYY");
		demo34.put("46L", "3SDSCHGYY");
		demo34.put("47L", "SJZY");
		demo34.put("48L", "1FWJZY");
		demo34.put("49L", "2TMGCJZY");
		demo34.put("50L", "3JZAZY");
		demo34.put("51L", "4JZZSHQTJZY");
		demo34.put("52L", "SDSCY");
		demo34.put("53L", "YPFHLSY");
		demo34.put("54L", "1PFY");
		demo34.put("55L", "2LSY");
		demo34.put("56L", "EJTYSCCHYZY");
		demo34.put("57L", "1TLYSY");
		demo34.put("58L", "2DLYSY");
		demo34.put("59L", "3SSYSY");
		demo34.put("60L", "4HKYSY");
		demo34.put("61L", "5GDYSY");
		demo34.put("62L", "6ZXBYHYSDLY");
		demo34.put("63L", "7CCY");
		demo34.put("64L", "8YZY");
		demo34.put("65L", "SZSHCYY");
		demo34.put("66L", "1ZSY");
		demo34.put("67L", "2CYY");
		demo34.put("68L", "SXXCSRJHXXJSFWY");
		demo34.put("69L", "1DXGBDSHWXCSFWY");
		demo34.put("70L", "2HLWHXGFW");
		demo34.put("71L", "3RJHXXJSFWY");
		demo34.put("72L", "WJRY");
		demo34.put("73L", "1HBJRFW");
		demo34.put("74L", "2ZBSCFW");
		demo34.put("75L", "3BXY");
		demo34.put("76L", "4QTJRY");
		demo34.put("77L", "LFDCY");
		demo34.put("78L", "1FDCKFJYY");
		demo34.put("79L", "2WYGL");
		demo34.put("80L", "3FDCZJFW");
		demo34.put("81L", "4ZYFDCJYHD");
		demo34.put("82L", "5QTFDCY");
		demo34.put("83L", "QZLHSWFWY");
		demo34.put("84L", "1ZLY");
		demo34.put("85L", "2SWFWY");
		demo34.put("86L", "QZZXYDC");
		demo34.put("87L", "GGY");
		demo34.put("88L", "ZSCQFW");
		demo34.put("89L", "HYZLFW");
		demo34.put("90L", "BKXYJHJSFWY");
		demo34.put("91L", "1YJHSYFZ");
		demo34.put("92L", "2ZYJSFWY");
		demo34.put("93L", "QZZYHSJFW");
		demo34.put("94L", "3KJTGHYYFWY");
		demo34.put("95L", "JSLHJHGGSSGLY");
		demo34.put("96L", "QZGGSSGLY");
		demo34.put("97L", "SJMFWXLHQTFWY");
		demo34.put("98L", "1JMFWY");
		demo34.put("99L", "2JDCDZCPHRYCPXLY");
		demo34.put("100L", "3QTFWY");
		demo34.put("101L", "SYJY");
		demo34.put("102L", "SEWSHSHGZ");
		demo34.put("103L", "1WS");
		demo34.put("104L", "2SHGZ");
		demo34.put("105L", "SSWHTYHYLY");
		demo34.put("106L", "1XWHCBY");
		demo34.put("107L", "2GBDSDYHYSLYZZY");
		demo34.put("108L", "3WHYSY");
		demo34.put("109L", "4TY");
		demo34.put("110L", "5YLY");
		demo34.put("111L", "SSGGGLSHBZHSHZZ");
		demo34.put("112L", "SWQTXY");
		demo34.put("1H", "XH");
		demo34.put("2H", "XM");
		demo34.put("3H", "HJ");
		demo34.put("4H", "QZMDDK");
		demo34.put("5H", "NZQYXJ");
		demo34.put("6H", "NZQYGYQY");
		demo34.put("7H", "NZQYJTQY");
		demo34.put("8H", "NZQYGFHZQY");
		demo34.put("9H", "NZQYLYQY");
		demo34.put("10H", "NZQYQZGYKG1");
		demo34.put("11H", "NZQYGFGS");
		demo34.put("12H", "NZQYQZGYKG2");
		demo34.put("13H", "NZQYSYQY");
		demo34.put("14H", "NZQYQTQY");
		demo34.put("15H", "GATTZQY");
		demo34.put("16H", "QZGYKG1");
		demo34.put("17H", "WSTZQY");
		demo34.put("18H", "QZGYKG2");
		demo34.put("19H", "GTJY");

		demo35.put("3L", "HJ");
		demo35.put("4L", "YJTYSFW");
		demo35.put("5L", "1LLYSFW");
		demo35.put("6L", "1TLYSFW");
		demo35.put("7L", "2QTLLYSFW");
		demo35.put("8L", "2SLYSFW");
		demo35.put("9L", "3HKYSFW");
		demo35.put("10L", "4GDYSFW");
		demo35.put("11L", "EYZFW");
		demo35.put("12L", "1YZPBFW");
		demo35.put("13L", "2YZTSFW");
		demo35.put("14L", "3QTYZFW");
		demo35.put("15L", "SDXFW");
		demo35.put("16L", "1JCDXFW");
		demo35.put("17L", "2ZZDXFW");
		demo35.put("18L", "SJZFW");
		demo35.put("19L", "1GCFW");
		demo35.put("20L", "2AZFW");
		demo35.put("21L", "3XSFW");
		demo35.put("22L", "4ZSFW");
		demo35.put("23L", "5QTJZFW");
		demo35.put("24L", "WJRFW");
		demo35.put("25L", "1DKFW");
		demo35.put("26L", "2ZJSFJRFW");
		demo35.put("27L", "3BXFW");
		demo35.put("28L", "1RSBXFW");
		demo35.put("29L", "2CCBXFW");
		demo35.put("30L", "4JRSPZR");
		demo35.put("31L", "LXDFW");
		demo35.put("32L", "1YFHJSFW");
		demo35.put("33L", "1YFFW");
		demo35.put("34L", "2HTNYGLFW");
		demo35.put("35L", "3GCKCKTFW");
		demo35.put("36L", "4ZYJSFW");
		demo35.put("37L", "2XXJSFW");
		demo35.put("38L", "1RJFW");
		demo35.put("39L", "2DLSJJCSFW");
		demo35.put("40L", "3XXXTFW");
		demo35.put("41L", "4YWLCGLFW");
		demo35.put("42L", "5XXXTZZFW");
		demo35.put("43L", "3WHCYFW");
		demo35.put("44L", "1SJFW");
		demo35.put("45L", "2ZSCQFW");
		demo35.put("46L", "3GGFW");
		demo35.put("47L", "4HYZLFW");
		demo35.put("48L", "4WLFZFW");
		demo35.put("49L", "1HKFW");
		demo35.put("50L", "2GKMTFW");
		demo35.put("51L", "3HYKYCZFW");
		demo35.put("52L", "4DLJZFW");
		demo35.put("53L", "5ZXBYFW");
		demo35.put("54L", "6CCFW");
		demo35.put("55L", "7SPFW");
		demo35.put("56L", "5ZLFW");
		demo35.put("57L", "1BDCRZZL");
		demo35.put("58L", "2BDCJYZL");
		demo35.put("59L", "3YXDCRZZL");
		demo35.put("60L", "4YXDCJYZL");
		demo35.put("61L", "6JZZXFW");
		demo35.put("62L", "1RZFW");
		demo35.put("63L", "2JZFW");
		demo35.put("64L", "3ZXFW");
		demo35.put("65L", "7GBYSFW");
		demo35.put("66L", "1GBYSJMZPZZFW");
		demo35.put("67L", "2GBYSJMZPFXFW");
		demo35.put("68L", "3GBYSJMZPBYFW");
		demo35.put("69L", "8SWFZFW");
		demo35.put("70L", "1QYGLFW");
		demo35.put("71L", "2JJDLFW");
		demo35.put("72L", "3RLZYFW");
		demo35.put("73L", "4AQBHFW");
		demo35.put("74L", "9QTXDFW");
		demo35.put("75L", "QSHFW");
		demo35.put("76L", "1WHTYFW");
		demo35.put("77L", "1WHFW");
		demo35.put("78L", "2TYFW");
		demo35.put("79L", "2JYYLFW");
		demo35.put("80L", "1JYFW");
		demo35.put("81L", "2YLFW1");
		demo35.put("82L", "3LYYLFW");
		demo35.put("83L", "1LYFW");
		demo35.put("84L", "2YLFW2");
		demo35.put("85L", "4CYZSFW");
		demo35.put("86L", "1CYFW");
		demo35.put("87L", "2ZSFW");
		demo35.put("88L", "5JMRCFW");
		demo35.put("89L", "6QTSHFW");
		demo35.put("90L", "BXSWXZC");
		demo35.put("91L", "1ZLHFZLJS");
		demo35.put("92L", "2SBHZZQ");
		demo35.put("93L", "3TDSYQ");
		demo35.put("94L", "4QTZRZYSYQ");
		demo35.put("95L", "5QTQYXWXZC");
		demo35.put("96L", "JXSBDC");
		demo35.put("97L", "1JZW");
		demo35.put("98L", "QZESFJY1");
		demo35.put("99L", "2GZW");
		demo35.put("100L", "QZESFJY2");
		demo35.put("1H", "XH");
		demo35.put("2H", "XM");
		demo35.put("3H", "HJ");
		demo35.put("4H", "QZMDDK");
		demo35.put("5H", "NZQYXJ");
		demo35.put("6H", "NZQYGYQY");
		demo35.put("7H", "NZQYJTQY");
		demo35.put("8H", "NZQYGFHZQY");
		demo35.put("9H", "NZQYLYQY");
		demo35.put("10H", "NZQYQZGYKG1");
		demo35.put("11H", "NZQYGFGS");
		demo35.put("12H", "NZQYQZGYKG2");
		demo35.put("13H", "NZQYSYQY");
		demo35.put("14H", "NZQYQTQY");
		demo35.put("15H", "GATTZQY");
		demo35.put("16H", "QZGYKG1");
		demo35.put("17H", "WSTZQY");
		demo35.put("18H", "QZGYKG2");
		demo35.put("19H", "GTJY");

		demo36.put("5L", "GNSSSRHJ");
		demo36.put("6L", "1ZZSSR");
		demo36.put("7L", "QZYBNSR");
		demo36.put("8L", "XGMNSR");
		demo36.put("9L", "2XFSSR");
		demo36.put("10L", "3YYS");
		demo36.put("11L", "4QYSDS");
		demo36.put("12L", "5GRSDS");
		demo36.put("13L", "6ZYS");
		demo36.put("14L", "7GDZCTZFXDJS");
		demo36.put("15L", "8CSWHJSS");
		demo36.put("16L", "9FCS");
		demo36.put("17L", "10YHS");
		demo36.put("18L", "11CZTDSYS");
		demo36.put("19L", "12TDZZS");
		demo36.put("20L", "13CCS");
		demo36.put("21L", "14CLGZS");
		demo36.put("22L", "15YYS");
		demo36.put("23L", "16GDZYS");
		demo36.put("24L", "17QS");
		demo36.put("25L", "18QTGS");
		demo36.put("1H", "XH");
		demo36.put("2H", "SZ");
		demo36.put("3H", "HJHS");
		demo36.put("4H", "HJSSSR");
		demo36.put("5H", "DXQYHS");
		demo36.put("6H", "DXQYSSSR");
		demo36.put("7H", "ZXQYHS");
		demo36.put("8H", "ZXQYSSSR");
		demo36.put("9H", "XWQYXJHS");
		demo36.put("10H", "XWQYXJSSSR");
		demo36.put("11H", "XWQYXXQYHS");
		demo36.put("12H", "XWQYXXQYSSSR");
		demo36.put("13H", "XWQYWXQYHS");
		demo36.put("14H", "XWQYWXQYSSSR");

		demo37.put("5L", "HJ");
		demo37.put("6L", "YDYCY");
		demo37.put("7L", "EDECY");
		demo37.put("8L", "YCKY");
		demo37.put("9L", "EZZY");
		demo37.put("10L", "1NFSPJGY");
		demo37.put("11L", "2SPZZY");
		demo37.put("12L", "3JYLHJZCZZY");
		demo37.put("13L", "4YCZPY");
		demo37.put("14L", "5FZY");
		demo37.put("15L", "6FZFZFSY");
		demo37.put("16L", "7PGMPYMJQZPHZXY");
		demo37.put("17L", "8MCJGHMZTZCZPY");
		demo37.put("18L", "9JJZZY");
		demo37.put("19L", "10ZZHZZPY");
		demo37.put("20L", "11YSHJLMJFZY");
		demo37.put("21L", "12WJGMTYHYLYPZZY");
		demo37.put("22L", "13SYJGLJHHRLJGY");
		demo37.put("23L", "14HXYLHHXZPZZY");
		demo37.put("24L", "15YYZZY");
		demo37.put("25L", "16HXXWZZY");
		demo37.put("26L", "17XJHSLZPY");
		demo37.put("27L", "18FJSKWZPY");
		demo37.put("28L", "19HSJSYLHYYJGY");
		demo37.put("29L", "20YSJSYLHYYJGY");
		demo37.put("30L", "21JSZPY");
		demo37.put("31L", "22TYSBZZY");
		demo37.put("32L", "23ZYSBZZY");
		demo37.put("33L", "24QCZZY");
		demo37.put("34L", "25TLCBHKHTHQTYSSBZZY");
		demo37.put("35L", "26DQJXHQCZZY");
		demo37.put("36L", "27JSJTXHQTDZSBZZY");
		demo37.put("37L", "28YBYQZZY");
		demo37.put("38L", "29QTZZY");
		demo37.put("39L", "SDLRLRQJSDSCHGYY");
		demo37.put("40L", "1DLRLSCHGYY");
		demo37.put("41L", "2RQSCHGYY");
		demo37.put("42L", "3SDSCHGYY");
		demo37.put("43L", "SJZY");
		demo37.put("44L", "1FWJZY");
		demo37.put("45L", "2TMGCJZY");
		demo37.put("46L", "3JZAZY");
		demo37.put("47L", "4JZZSHQTJZY");
		demo37.put("48L", "SDSCY");
		demo37.put("49L", "YPFHLSY");
		demo37.put("50L", "1PFY");
		demo37.put("51L", "2LSY");
		demo37.put("52L", "EJTYSCCHYZY");
		demo37.put("53L", "1JTYSY");
		demo37.put("54L", "x1TLYSY");
		demo37.put("55L", "x2QTJTYSY");
		demo37.put("56L", "2CCY");
		demo37.put("57L", "3YZY");
		demo37.put("58L", "SZSHCYY");
		demo37.put("59L", "1ZSY");
		demo37.put("60L", "2CYY");
		demo37.put("61L", "SXXCSRJHXXJSFWY");
		demo37.put("62L", "1DXGBDSHWXCSFWY");
		demo37.put("63L", "2HLWHXGFW");
		demo37.put("64L", "3RJHXXJSFWY");
		demo37.put("65L", "WJRY");
		demo37.put("66L", "1HBJRFW");
		demo37.put("67L", "2ZBSCFW");
		demo37.put("68L", "3BXY");
		demo37.put("69L", "4QTJRY");
		demo37.put("70L", "LFDCY");
		demo37.put("71L", "1FDCKFJY");
		demo37.put("72L", "2WYGL");
		demo37.put("73L", "3QTFDCY");
		demo37.put("74L", "QZLHSWFWY");
		demo37.put("75L", "1ZLY");
		demo37.put("76L", "2SWFWY");
		demo37.put("77L", "BKXYJHJSFWY");
		demo37.put("78L", "JJMFWXLHQTFWY");
		demo37.put("79L", "SJY");
		demo37.put("80L", "SYWSHSHGZ");
		demo37.put("81L", "SEWHTYHYLY");
		demo37.put("82L", "SSGGGLSHBZHSHZZ");
		demo37.put("83L", "SSQTXY");
		demo37.put("1H", "XH");
		demo37.put("2H", "SZ");
		demo37.put("3H", "HJHS");
		demo37.put("4H", "HJSSSR");
		demo37.put("5H", "DXQYHS");
		demo37.put("6H", "DXQYSSSR");
		demo37.put("7H", "ZXQYHS");
		demo37.put("8H", "ZXQYSSSR");
		demo37.put("9H", "XWQYXJHS");
		demo37.put("10H", "XWQYXJSSSR");
		demo37.put("11H", "XWQYXXQYHS");
		demo37.put("12H", "XWQYXXQYSSSR");
		demo37.put("13H", "XWQYWXQYHS");
		demo37.put("14H", "XWQYWXQYSSSR");

		demo38.put("5L","HJ");
		demo38.put("6L","YNZQYXJ");
		demo38.put("7L","YNZQY1GYQY");
		demo38.put("8L","YNZQY2JTQY");
		demo38.put("9L","YNZQY3GFHZQY");
		demo38.put("10L","YNZQY4LYQY");
		demo38.put("11L","YNZQYQZGYKG1");
		demo38.put("12L","YNZQY5GFGS");
		demo38.put("13L","YNZQYQZGYKG2");
		demo38.put("14L","YNZQY6SYQY");
		demo38.put("15L","YNZQY7QTQY");
		demo38.put("16L","EGATTZQY");
		demo38.put("17L","QZGYKG1");
		demo38.put("18L","SWSTZQY");
		demo38.put("19L","QZGYKG2");
		demo38.put("20L","SGTJY");
		demo38.put("1H","XH");
		demo38.put("2H","QYLX1");
		demo38.put("3H","QYLX2");
		demo38.put("4H","HJHS");
		demo38.put("5H","HJSSSR");
		demo38.put("6H","DXQYHS");
		demo38.put("7H","DXQYSSSR");
		demo38.put("8H","ZXQYHS");
		demo38.put("9H","ZXQYSSSR");
		demo38.put("10H","XWQYXJHS");
		demo38.put("11H","XWQYXJSSSR");
		demo38.put("12H","XWQYXXQYHS");
		demo38.put("13H","XWQYXXQYSSSR");
		demo38.put("14H","XWQYWXQYHS");
		demo38.put("15H","XWQYWXQYSSSR");

		demo39.put("3L", "YXSEHJ");
		demo39.put("4L", "1ASYSLZSHWJLWXSE");
		demo39.put("5L", "2AJYZSBFZSHWXSE");
		demo39.put("6L", "3MDTBFCKHWXSE");
		demo39.put("7L", "4MSHWJLWXSE");
		demo39.put("8L", "EYNSEHJ");
		demo39.put("9L", "1XXSE");
		demo39.put("10L", "2JXSE");
		demo39.put("11L", "SQLDSE");
		demo39.put("12L", "JXSEZC");
		demo39.put("13L", "MDTHWYTSE");
		demo39.put("14L", "ASYSLJSDNSJCYBJSE");
		demo39.put("15L", "3YDKSE");
		demo39.put("16L", "4SJDKSE");
		demo39.put("17L", "5QMLDSE");
		demo39.put("18L", "6JYZSBFJSDYNSE");
		demo39.put("19L", "7YNSEJZE");
		demo39.put("1H", "XH");
		demo39.put("2H", "XM");
		demo39.put("3H", "HJ");
		demo39.put("4H", "GY");
		demo39.put("5H", "JYDZZ");
		demo39.put("6H", "JDZZ");
		demo39.put("7H", "FZY");
		demo39.put("8H", "YYJGJSYZPZZ");
		demo39.put("9H", "HXYLJHXZPZZY");
		demo39.put("10H", "FJSKWZPY");
		demo39.put("11H", "HSJSYLHYYJGY");
		demo39.put("12H", "QCZZY");
		demo39.put("13H", "MTKCHXXY");
		demo39.put("14H", "SYHTRQKCY");
		demo39.put("15H", "DLRLSCHGYY");
		demo39.put("16H", "PFY");
		demo39.put("17H", "LSY");

	}

	
	

	private static String getiiiName(String s) {
		if (s.contains("SJ_01(")) {
			return "SJ01";
		}
		else if(s.contains("SJ_02("))	 { iii = 2;	return "SJ02";}
		else if(s.contains("SJ_03("))	 { iii = 3;	return "SJ03";}
		else if(s.contains("SJ_04("))	 { iii = 4;	return "SJ04";}
		else if(s.contains("SJ_05("))	 { iii = 5;	return "SJ05";}
		else if(s.contains("SJ_06("))	 { iii = 6;	return "SJ06";}
		else if(s.contains("SJ_07("))	 { iii = 7;	return "SJ07";}
		else if(s.contains("SJ_08("))	 { iii = 8;	return "SJ08";}
		else if(s.contains("SJ_09("))	 { iii = 9;	return "SJ09";}
		else if(s.contains("SJ_10("))	 { iii = 10;	return "SJ10";}
		else if(s.contains("SJ_11("))	 { iii = 11;	return "SJ11";}
		else if(s.contains("SJ_12("))	 { iii = 12;	return "SJ12";}
		else if(s.contains("SJ_13("))	 { iii = 13;	return "SJ13";}
		else if(s.contains("SJ_14("))	 { iii = 14;	return "SJ14";}
		else if(s.contains("SJ_15("))	 { iii = 15;	return "SJ15";}
		else if(s.contains("SJ_16("))	 { iii = 16;	return "SJ16";}
		else if(s.contains("SJ_17("))	 { iii = 17;	return "SJ17";}
		else if(s.contains("SJ_18("))	 { iii = 18;	return "SJ18";}
		else if(s.contains("SJ_19("))	 { iii = 19;	return "SJ19";}
		else if(s.contains("SJ_20("))	 { iii = 20;	return "SJ20";}
		else if(s.contains("SJ_21("))	 { iii = 21;	return "SJ21";}
		else if(s.contains("SJ_22("))	 { iii = 22;	return "SJ22";}
		else if(s.contains("SJ_23("))	 { iii = 23;	return "SJ23";}
		else if(s.contains("SJ_24("))	 { iii = 24;	return "SJ24";}
		else if(s.contains("SJ_25("))	 { iii = 25;	return "SJ25";}
		else if(s.contains("SJ_26("))	 { iii = 26;	return "SJ26";}
		else if(s.contains("SJ_27("))	 { iii = 27;	return "SJ27";}
		else if(s.contains("SJ_28("))	 { iii = 28;	return "SJ28";}
		else if(s.contains("SJ_29("))	 { iii = 29;	return "SJ29";}
		else if(s.contains("SJ_30("))	 { iii = 30;	return "SJ30";}
		else if(s.contains("SJ_31("))	 { iii = 31;	return "SJ31";}
		else if(s.contains("SJ_32("))	 { iii = 32;	return "SJ32";}
		else if(s.contains("SJ_33("))	 { iii = 33;	return "SJ33";}
		else if(s.contains("SJ_34("))	 { iii = 34;	return "SJ34";}
		else if(s.contains("SJ_35("))	 { iii = 35;	return "SJ35";}
		else if(s.contains("SJ_36("))	 { iii = 36;	return "SJ36";}
		else if(s.contains("SJ_37("))	 { iii = 37;	return "SJ37";}
		else if(s.contains("SJ_38("))	 { iii = 38;	return "SJ38";}
		else if(s.contains("SJ_39("))	 { iii = 39;	return "SJ39";}
		else if(s.contains("SJ_40("))	 { iii = 40;	return "SJ40";}
		else if(s.contains("SJ_41("))	 { iii = 41;	return "SJ41";}
		else if(s.contains("SJ_42("))	 { iii = 42;	return "SJ42";}
		else if(s.contains("SJ_43("))	 { iii = 43;	return "SJ43";}
		else if(s.contains("SJ_44("))	 { iii = 44;	return "SJ44";}
		else if(s.contains("SJ_45("))	 { iii = 45;	return "SJ45";}
		else if(s.contains("SJ_46("))	 { iii = 46;	return "SJ46";}
		else if(s.contains("SJ_47("))	 { iii = 47;	return "SJ47";}
		else if(s.contains("SJ_48("))	 { iii = 48;	return "SJ48";}
		else if(s.contains("SJ_49("))	 { iii = 49;	return "SJ49";}
		else if(s.contains("SJ_50("))	 { iii = 50;	return "SJ50";}
		else if(s.contains("SJ_51("))	 { iii = 51;	return "SJ51";}
		else if(s.contains("SJ_52("))	 { iii = 52;	return "SJ52";}
		else if(s.contains("SJ_53("))	 { iii = 53;	return "SJ53";}
		else if(s.contains("SJ_54("))	 { iii = 54;	return "SJ54";}
		else if(s.contains("SJ_55("))	 { iii = 55;	return "SJ55";}
		else if(s.contains("SJ_56("))	 { iii = 56;	return "SJ56";}
		else if(s.contains("SJ_57("))	 { iii = 57;	return "SJ57";}
		else if(s.contains("SJ_58("))	 { iii = 58;	return "SJ58";}
		else if(s.contains("SJ_59("))	 { iii = 59;	return "SJ59";}
		else if(s.contains("SJ_60("))	 { iii = 60;	return "SJ60";}
		else if(s.contains("SJ_61("))	 { iii = 61;	return "SJ61";}
		else if(s.contains("SJ_62("))	 { iii = 62;	return "SJ62";}
		else if(s.contains("SJ_63("))	 { iii = 63;	return "SJ63";}
		else if(s.contains("SJ_64("))	 { iii = 64;	return "SJ64";}
		else if(s.contains("SJ_65("))	 { iii = 65;	return "SJ65";}
		else if(s.contains("SJ_66("))	 { iii = 66;	return "SJ66";}
		else if(s.contains("SJ_67("))	 { iii = 67;	return "SJ67";}
		else if(s.contains("SJ_68("))	 { iii = 68;	return "SJ68";}
		else if(s.contains("SJ_69("))	 { iii = 69;	return "SJ69";}
		else if(s.contains("SJ_70("))	 { iii = 70;	return "SJ70";}
		else if(s.contains("SJ_71("))	 { iii = 71;	return "SJ71";}
		else if(s.contains("SJ_72("))	 { iii = 72;	return "SJ72";}
		else if(s.contains("SJ_73("))	 { iii = 73;	return "SJ73";}
		else if(s.contains("SJ_74("))	 { iii = 74;	return "SJ74";}
		else if(s.contains("SJ_75("))	 { iii = 75;	return "SJ75";}
		else if(s.contains("SJ_76("))	 { iii = 76;	return "SJ76";}
		else if(s.contains("SJ_77("))	 { iii = 77;	return "SJ77";}
		else if(s.contains("SJ_78("))	 { iii = 78;	return "SJ78";}
		else if(s.contains("SJ_79("))	 { iii = 79;	return "SJ79";}
		else if(s.contains("SJ_80("))	 { iii = 80;	return "SJ80";}
		else if(s.contains("SJ_81("))	 { iii = 81;	return "SJ81";}
		else if(s.contains("SJ_82("))	 { iii = 82;	return "SJ82";}
		else if(s.contains("SJ_83("))	 { iii = 83;	return "SJ83";}
		else if(s.contains("SJ_84("))	 { iii = 84;	return "SJ84";}
		else if(s.contains("SJ_85("))	 { iii = 85;	return "SJ85";}
		else if(s.contains("SJ_86("))	 { iii = 86;	return "SJ86";}
		else if(s.contains("SJ_87("))	 { iii = 87;	return "SJ87";}
		else if(s.contains("SJ_88("))	 { iii = 88;	return "SJ88";}
		else if(s.contains("SJ_89("))	 { iii = 89;	return "SJ89";}
		else if(s.contains("SJ_90("))	 { iii = 90;	return "SJ90";}
		else if(s.contains("SJ_91("))	 { iii = 91;	return "SJ91";}
		else if(s.contains("SJ_92("))	 { iii = 92;	return "SJ92";}
		else if(s.contains("SJ_93("))	 { iii = 93;	return "SJ93";}
		else if(s.contains("SJ_94("))	 { iii = 94;	return "SJ94";}
		else if(s.contains("SJ_95("))	 { iii = 95;	return "SJ95";}
		else if(s.contains("SJ_96("))	 { iii = 96;	return "SJ96";}
		else if(s.contains("SJ_97("))	 { iii = 97;	return "SJ97";}
		else if(s.contains("SJ_98("))	 { iii = 98;	return "SJ98";}
		else if(s.contains("SJ_99("))	 { iii = 99;	return "SJ99";}
		else if(s.contains("SJ_100("))	 { iii = 100;	return "SJ100";}
		
		return iiiName;
	}
	
	
	
	public static String cleanBlank(String str) {
		str = str.replace(" ", "");
		str = str.replace("	", "");
		return str;
	}

}
