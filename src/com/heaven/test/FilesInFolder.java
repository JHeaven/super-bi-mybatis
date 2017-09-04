package com.heaven.test;

import java.io.File;

public class FilesInFolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = null;
		file = new File("D:/2017年会统报表");
		String [] files = file.list();
		for (int i = 0; i < files.length; i++) {
			if (files[i].endsWith(".npf")) {
				System.out.println(files[i]);
			}
			
		}
	}

}
