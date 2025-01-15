package com.umwix1002.solution.lab.Lab7;

import java.io.*;


public class L7Q3 {
	public static void main(String[] args) {
		generateReverseTextFile(Generator.TEXT_FILE, Generator.ROOT + "Q3.txt");
	}

	public static void generateReverseTextFile(String fromFile, String toFile) {
		try(BufferedReader reader = new BufferedReader(new FileReader(fromFile));
			PrintWriter writer = new PrintWriter(toFile);) {
			String line = "";
			
			while((line = reader.readLine()) != null)
				writer.println(new StringBuilder(line).reverse());

		} catch (Exception ex) { }
	}

}
