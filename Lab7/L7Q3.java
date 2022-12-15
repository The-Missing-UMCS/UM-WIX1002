package com.fyiernzy.Lab7;

import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class L7Q3 {
	public static void main(String[] args) {
		new L7Q3().run();
	}
	
	public void run() {
		String initialFile = "../WIX1002/io_files/news_extract.txt";
		String finalFile = "../WIX1002/io_files/reverse.txt";
		
		generateTextFile(initialFile);
		generateReverseTextFile(initialFile, finalFile);
		
	}
	
	public void generateTextFile(String toFile) {
		try {
			String newsExtract = "Hoping to fight this was 28-year-old Park Ji-hyun, a women's rights campaigner,\n"
					+ "who, following the divisive election, was asked to lead the liberal opposition party.\n"
					+ "The party told her they needed her help to reform politics and represent young women.\n"
					+ "And so, despite having never been a politician, she agreed.";
			
			PrintWriter writer = new PrintWriter(toFile);
			writer.print(newsExtract);
			writer.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void generateReverseTextFile(String fromFile, String toFile) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fromFile));
			PrintWriter writer = new PrintWriter(toFile);
			
			String line = "";
			StringBuilder content = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				content.append(line);
				writer.println(content.reverse());
				content.setLength(0);
			}
			
			writer.close();
			reader.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
