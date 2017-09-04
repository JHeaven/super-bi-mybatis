package com.heaven.utils;

public class Get_Cell_Name {

	public static String getName(String text) {
		String v = getKey(text, "name");
		return v != null? v : "no name found!";
	}
	
	public static String getAlias(String text) {
		String v = getKey(text, "alias");
		return v != null? v : "no alias found!";
	}
	
	public static String getCaption(String text) {
		String v = getKey(text, "caption");
		return v != null? v : "no caption found!";
	}
	
	public static String getID(String text) {
		String v = getKey(text, "ID");
		return v != null? v : "no ID found!";
	}
	
	
	
	public static String getTaskId(String text) {
		String v = getKey(text, "taskid");
		return v != null? v : "no taskid found!";
	}
	
	
	public static String getType(String text) {
		String v = getKey(text, "type");
		return v != null? v : "no type found!";
	}
	
	
	
	public static String[] getHead(String text) {
		String temp = text.substring(text.indexOf("<head>")+8,text.indexOf("</head>")-2);
		return temp.split("\\r\\n");
	}
	
	
	

	public static String getKey(String text,String key) {
		String keyV = null;
		String[] strWithE = getHead(text);
		for (int i = 0; i < strWithE.length; i++) {
			String[] str = strWithE[i].split("=");
			if (key.equals(str[0])) {
				keyV = str[1];
				break;
			}
		}
		
		return keyV;
	}
	
	
	

}
