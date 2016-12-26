package com.rcstest.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class GenerateString {

    public static void main(String[] args) throws IOException{
    	
    	/**
    	 * Function:Generate a 4100 bytes txt
    	 * ===Run it standalone===
    	 * @author Li Yanxi
    	 * @Description 使用 System.setOut 方法将标准输出流重定向到其他地方去
    	 * 但是原来在控制台的输出就不会显示出来了，都写到txt文件里去了。
    	 *
    	 */

        File f=new File("GenerateString.txt");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
//        System.out.println("默认输出到控制台的这一句，输出到了文件 out.txt");
    	
    	
//    	int score[] = new int[]{34,32,232,23,3};
    	
    	String[] alphabet = {"0","1","2","3","4","5","6","7","8","9"};
    	/*
    	 * "+","-","*","/","%","a","b","c","d","e","f","g",
    	 * "h","i","j","k","l","m","n","o","p","q",
    	 * "r","s","t","u","v","w","x","y","z",
    	 * 
    	 */
    	
    	System.out.println("字母表字符数:"+alphabet.length);
		System.out.println("750字符：");
        
		for (int i = 1; i <= 75; i++) {//行数	
//			System.out.println();//换行
			for (String str : alphabet) {
				System.out.print(str);
			}
		}
	}
}
