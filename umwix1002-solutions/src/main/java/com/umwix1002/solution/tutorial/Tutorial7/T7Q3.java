package com.umwix1002.solution.tutorial.Tutorial7;

import java.io.*;

public class T7Q3 {
	public static void main(String[] agrs) {
		new T7Q3().run();
	}
	
	public void run() {
		String file = "./io_files/ascii.txt";
		generateTextFile(file);
		readTextFile(file);
	}
	
	public void generateTextFile(String file) {
		String sentence = "Hello world";
		
		try (PrintWriter writer = new PrintWriter(file)){
			for(char c : sentence.toCharArray()) {
				int ascii = (int) c;
				writer.println(Integer.toBinaryString(ascii));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void readTextFile(String file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			String binary = "";
			int ascii;
			
			while((binary = reader.readLine()) != null) {
				ascii = Integer.parseInt(binary, 2);
				System.out.print((char) ascii);
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
