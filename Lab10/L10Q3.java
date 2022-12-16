package com.fyiernzy.Lab10;

// Reference code :https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2010/L10Q3/ShuffleCipher.java
// Reference code: https://github.com/Rescue9/CIS-149-Java-Programming-1/blob/master/src/Ch8/Lab3/ShuffleCipher.java
public class L10Q3 {
	public static void main(String[] args) {
		
	}
}

class ShuffleCipher implements MessageEncoder {
	@Override
	public StringBuilder encode(StringBuilder plainText) {
		return new StringBuilder();
	}
	
	@Override
	public StringBuilder decode(StringBuilder cipherText) {
		return new StringBuilder();
	}
	
	public StringBuilder shuffle(StringBuilder str) {
		StringBuilder sb = new StringBuilder();
		int mid = str.length() / 2;
		
		String left = str.substring(0, mid); // .subString(int startIndex, int endIndex)
		String right = str.substring(mid); // .subString(int startIndex)
		
		for(int i = 0; i < left.length(); i++) 
			sb.append(left.charAt(i)).append(right.charAt(i));
		
		sb.append((right.length() > left.length()) ? right.charAt(mid) : "");
		
		return sb;
	}
}