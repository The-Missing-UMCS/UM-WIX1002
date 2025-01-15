package com.umwix1002.solution.lab.Lab10.L10Q3;

import com.umwix1002.solution.lab.Lab10.L10Q2.AbstractCipher;

// Reference code :https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2010/L10Q3/ShuffleCipher.java
// Reference code: https://github.com/Rescue9/CIS-149-Java-Programming-1/blob/master/src/Ch8/Lab3/ShuffleCipher.java
public class Main {
	public static final String ROOT = "umwix1002-fundamental/src/main/java/com/umwix1002/solution/lab/Lab10/io_files/";

	public static void main(String[] args) {
		String encodeInputFile = ROOT + "l10q3_encode_from.txt";
		String encodeOutputFile = ROOT + "l10q3_encode_to.txt";
		String decodeInputFile = ROOT + "l10q3_decode_from.txt";
		String decodeOutputFile = ROOT + "l10q3_decode_to.txt";
		int shuffleCount = 3;

		ShuffleCipher sc1 = new ShuffleCipher(encodeInputFile, encodeOutputFile, shuffleCount);
		sc1.convertTextToFile(AbstractCipher.ENCODE);
		
		ShuffleCipher sc2 = new ShuffleCipher(decodeInputFile, decodeOutputFile, shuffleCount);
		sc2.convertTextToFile(AbstractCipher.DECODE);
	}
}

