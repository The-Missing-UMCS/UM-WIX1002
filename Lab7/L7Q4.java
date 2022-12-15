package com.fyiernzy.Lab7;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;

public class L7Q4 {
	public static void main(String[] args) {
		new L7Q4().run();
	}
	
	public void run() {
		String file = "../WIX1002/io_files/ref_text.txt";
		generateTextFile(file);
		wordCount(file);
	}
	
	public void generateTextFile(String file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			String content = "Hoping to fight this was 28-year-old Park Ji-hyun, a women's rights campaigner,\n"
					+ "who, following the divisive election, was asked to lead the liberal opposition party.\n"
					+ "The party told her they needed her help to reform politics and represent young women.\n"
					+ "And so, despite having never been a politician, she agreed.";
			writer.print(content);
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void wordCount(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int numOfLine = 0, numOfWord = 0, numOfChar = 0;
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				numOfLine++;
				numOfWord += line.split(" ").length;
				numOfChar += line.length();
			}
			
			reader.close();
			
			System.out.printf("Char: %d, Word: %d, Line: %d", numOfChar, numOfWord, numOfLine);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
