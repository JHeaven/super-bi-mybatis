package com.heaven.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.heaven.dao.impl.CellBYDaoImpl;
import com.heaven.model.CellBy;

public class Get_Option {
	public static void getOption(String oriStr,CellBy cellTop,CellBYDaoImpl cellDao) {
	
		List<String> optionList = getStrings(oriStr ,Pattern.quote("<option>")+"(.*?)"+Pattern.quote("</option>"));
		
		
		
		
		CellBy cell = null;
		
		for (Iterator iterator = optionList.iterator(); iterator.hasNext();) {
			
			cell = new CellBy();
			// add
			cell.setId(100L);
			cell.setReportAlias(cellTop.getReportAlias());
			cell.setReportCaption(cellTop.getReportCaption());
			cell.setReportId(cellTop.getReportId());
			cell.setReportName(cellTop.getReportName());
			cell.setReportTaskid(cellTop.getReportTaskid());
			cell.setReportType(cellTop.getReportType());
			
			
			String string = (String) iterator.next();
			//each
			String strs[] = string.split("\\r\\n");
			for (int i = 0; i < strs.length; i++) {
				//half
				String half[] =null;
				int tempEq = strs[i].indexOf("=");
				if (tempEq>0) {
					half = new String[2];
					half[0] = strs[i].substring(0, tempEq).trim();
					half[1] = strs[i].substring(tempEq + 1).trim();

					
						
					if ("cell".equals(half[0])) {
						//System.out.println("=" + half[1]+"=");
						cell.setByCell( half[1]);
					}
					if ("float".equals(half[0])) {
						//System.out.println("=" + half[1]+"=");
						cell.setByFloat( half[1]);
					}
					if ("floatrange".equals(half[0])) {
						//System.out.println("=" + half[1]+"=");
						cell.setByFloatrange( half[1]);
					}
					if ("floattype".equals(half[0])) {
						//System.out.println("=" + half[1]+"=");
						cell.setByFloattype( half[1]);
					}
					if ("fixcaption".equals(half[0])) {
						//System.out.println("=" + half[1]+"=");
						cell.setByFixcaption( half[1]);
					}
					if ("condition".equals(half[0])) {
						//System.out.println("=" + half[1]+"=");
						cell.setByCondition( half[1]);
					}
				}
				
				
			}
			
			
			System.out.println(cellDao.insertSelective(cell) > 0 ?  "record + 1" :  "record failed !");
			System.out.println("-----["+cell.getByCell()+"]-----");
		}
	}
	
	
	
	
	
	
	
	public static List<String> getStrings(String input, String regex) {
		List<String> result = new LinkedList<String>();
		Pattern pat = Pattern.compile(regex, Pattern.DOTALL);
		Matcher mat = pat.matcher(input);
		while (mat.find()) {
			result.add(mat.group(1).trim());
		}
		return result;
	}
	
}
