package com.heaven.main.analyse2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.heaven.utils.FileWriteTest;

public class AnalyseFormulaDistribute {

	public static void main(String[] args) {
		File file = null;
		file = new File("D:\\Project\\20171105审核框架\\计算公式.txt");
		
		String txt = txt2String(file);
		
		int pre = 0;
		
		String prename = "";
		//SJ_79(
		for(int i = 0 ; i <= 80 ;i++){
			if(i==0)
				continue;
			String flag = "SJ_";
			if(i<10) {
				flag = flag + "0" + i;
			}else {
				flag = flag + i;
			}
			
			int temp = txt.indexOf(flag);
			
			
			if (temp < 0) {
				System.out.println(prename+"."+pre+"..."+temp);
				continue;
			}else {
				//write
				FileWriteTest.wirte(prename, txt.substring(pre, temp));
				System.out.println(prename+"."+pre+"..."+temp);
				
			}
			
			prename = flag;
			pre = temp;
			
		}
	}
	
	
	
	
	/**
	 * 读取文本文件的内容
	 * 
	 * @param file
	 *            想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			System.err.println("file not found!");
			System.exit(0);
			// /e.printStackTrace();
		}
		return result.toString();
	}

	

}
