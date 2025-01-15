package com.umwix1002.solution.lab.Lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L7Q4 {
	public static void main(String[] args) {
		int[] counts = wordCount(Generator.TEXT_FILE);
		System.out.printf("Char: %d, Word: %d, Line: %d", counts[0], counts[1], counts[2]);
	}

	public static int[] wordCount(String file) {
		int numOfLine = 0, numOfWord = 0, numOfChar = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				numOfLine++;
				numOfWord += line.split(" ").length;
				numOfChar += line.length();
			}
		} catch (IOException ex) {}
		
		return new int[] { numOfChar, numOfWord, numOfLine };
	}
}
