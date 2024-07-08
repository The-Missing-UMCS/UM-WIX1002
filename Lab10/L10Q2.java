package Lab10;

import java.io.*;

public class L10Q2 {
	public static void main(String[] args) {
		SubstitutionCipher sc1 = new SubstitutionCipher("plainText.txt", "cipherText.txt", 3);
		sc1.convertTextToFile("encode");
		
		SubstitutionCipher sc2 = new SubstitutionCipher("cipherText.txt", "plainText.txt", 3);
		sc2.convertTextToFile("decode");
	}
}

interface MessageEncoder {
	StringBuilder encode(StringBuilder plainText);
	StringBuilder decode(StringBuilder cipherText);
}

class SubstitutionCipher implements MessageEncoder {
	String inputFileName;
	String outputFileName;
	final String PATH = "C:\\Users\\User\\Desktop\\"; // Can be replaced
	int shiftKey;
	
	SubstitutionCipher(String inputFileName, String outputFileName, int shiftKey) {
		this.inputFileName = PATH + inputFileName;
		this.outputFileName = PATH + outputFileName;
		this.shiftKey = shiftKey;
	}
	
	public StringBuilder readTextFromFile() {
		StringBuilder sb = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
			String line = "";
			while((line = reader.readLine()) != null) 
				sb.append(line + "\n");
		} catch (Exception ex) { ex.printStackTrace(); }
		
		return sb;
	}
	
	public void convertTextToFile(String type) {
		try (PrintWriter writer = new PrintWriter(outputFileName)){
			if (type.equals("encode"))
				writer.print(encode(readTextFromFile()));
			else if (type.equals("decode"))
				writer.print(decode(readTextFromFile()));
			System.out.println("Successful");
		} catch (Exception ex) { ex.printStackTrace(); }
	}
	
	@Override
	public StringBuilder encode(StringBuilder plainText) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < plainText.length(); i++) {
			char ch = plainText.charAt(i);
			if (Character.isLowerCase(ch))
				sb.append(encode(ch, 96));
			else if (Character.isUpperCase(ch))
				sb.append(encode(ch, 65));
			else
				sb.append(ch);
		}
		
		return sb;
	}
	
	@Override
	public StringBuilder decode(StringBuilder cipherText) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < cipherText.length(); i++) {
			char ch = cipherText.charAt(i);
			if (Character.isLowerCase(ch))
				sb.append(decode(ch, 122));
			else if (Character.isUpperCase(ch))
				sb.append(decode(ch, 90));
			else
				sb.append(ch);
		}
		return sb;
	}
	
	private char encode(char ch, int startKey) {
		int ascii = (int) ch;
		return (char) ((ascii + shiftKey - startKey) % 26 + startKey - (ascii + shiftKey - startKey) / 26);
	}
	
	private char decode(char ch, int endKey) {
		int ascii = (int) ch;
		return (char) (endKey - (endKey - ascii + shiftKey) % 26);
	}
}