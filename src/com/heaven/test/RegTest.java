package com.heaven.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) {
		String page = "<option>\r\n" + 
				"cell=G1\r\n" + 
				"float=horz\r\n" + 
				"floatrange=0.0.-1.0\r\n" + 
				"floattype=fix\r\n" + 
				"fixcaption=中  央\r\n" + 
				"</option>\r\n" + 
				"<customgroup grouptype=0>\r\n" + 
				"</customgroup>\r\n" + 
				"</floatcell>\r\n" + 
				"<floatcell>\r\n" + 
				"<option>\r\n" + 
				"cell=B4\r\n" + 
				"float=vert\r\n" + 
				"floatrange=0.0.0.-1\r\n" + 
				"floattype=fix\r\n" + 
				"fixcaption=一、税收收入合计\r\n" + 
				"</option>\r\n" + 
				"<customgroup grouptype=0>\r\n" + 
				"</customgroup>\r\n" + 
				"</floatcell>\r\n" + 
				"<floatcell>\r\n" + 
				"<option>\r\n" + 
				"cell=B5\r\n" + 
				"float=vert\r\n" + 
				"floatrange=0.0.0.-1\r\n" + 
				"floattype=fix\r\n" + 
				"fixcaption=   1.增值税收入\r\n" + 
				"</option>\r\n" + 
				"<customgroup grouptype=0>\r\n" + 
				"</customgroup>\r\n" + 
				"</floatcell>\r\n" + 
				"<floatcell>\r\n" + 
				"<option>\r\n" + 
				"cell=B6\r\n" + 
				"float=vert\r\n" + 
				"floatrange=0.0.0.-1\r\n" + 
				"floattype=fix\r\n" + 
				"fixcaption=     (1)国内增值税\r\n" + 
				"</option>";
		// TODO Auto-generated method stub
		List<String> optionList = getStrings(page ,Pattern.quote("<option>")+"(.*?)"+Pattern.quote("</option>"));

		for (Iterator iterator = optionList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			System.out.println("==========================================");
		}
	}

	/**
	 * 获取多个目标字符串
	 */
	public static List<String> getStrings(String input, String regex) {
		List<String> result = new LinkedList<String>();
		Pattern pat = Pattern.compile(regex, Pattern.DOTALL);
		Matcher mat = pat.matcher(input);
		while (mat.find()) {
			result.add(mat.group(1).trim());
		}
		return result;
	}
	
	//调用：getStrings(page,Pattern.quote("<option>")+"(.*?)"+Pattern.quote("</option>"));

}
