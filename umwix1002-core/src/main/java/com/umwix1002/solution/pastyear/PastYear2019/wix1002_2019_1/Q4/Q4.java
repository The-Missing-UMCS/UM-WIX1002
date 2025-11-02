package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_1.Q4;

import java.io.*;

public class Q4 {
	public static void main(String[] args) {
		String content = readContent("./src/PY19/myAmbition.txt");
		int[] result = countAll(content);
		
		System.out.println("The essay is: \n" + content);
		System.out.println();
		System.out.printf("Number of sentences: %d\n", result[0]);
		System.out.printf("Number of words: %d\n", result[1]);
		for(int i = 1, j = 2; j < result.length; i++, j++) {
			System.out.printf("%c : %d ", (char) j + 63, result[j]);
			if(i % 8 == 0)
				System.out.println();
		}
	}
	
	public static String readContent(String file) {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[8192];
			int byteRead;
			while((byteRead = reader.read(buff)) != -1) {
				sb.append(buff, 0, byteRead);
			}
			return sb.toString();
		} catch(IOException ex) {
			return "";
		}
	}
	
	public static int[] countAll(String content) {
		int[] count = new int[28];
		// regular expression -> syntax \\. (special? normal?)
		// My mom. I am a ... | \\. -> [My Mom.] [ I am a....], \\.(\\s)? -> [My Mom. ] [I am a...]
		// My mom.I
		String[] lines = content.split("\\.(\\s)?");
		count[0] = lines.length;
		// lines.split(" ").length = words My mom is a hero -> [My, mom, is, a, hero.]
		
		String[] words = content.toUpperCase().split(String.format("\\,?\\s?%s|(\\,)?\\s|(\\.)(\\s)?", System.lineSeparator()));
		count[1] = words.length;

		int[] alphabetCount = new int[26];

		
		for(String word : words) {
			for(char ch : word.toCharArray()) {
//				count[(int) ch - (int) 'A' + 2]++;
				if(ch >= 'A' || ch <= 'Z') {
					alphabetCount[(int) ch - (int) 'A'] += 1;
				}

			}
		}
		
		
		return count;
	}
	
	
}
