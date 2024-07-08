package Lab10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

// Reference code :https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2010/L10Q3/ShuffleCipher.java
// Reference code: https://github.com/Rescue9/CIS-149-Java-Programming-1/blob/master/src/Ch8/Lab3/ShuffleCipher.java
public class L10Q3 {
	public static void main(String[] args) {
		ShuffleCipher sc1 = new ShuffleCipher("plainText.txt", "shuffleCipherText.txt", 3);
		sc1.convertTextToFile("encode");
		
		ShuffleCipher sc2 = new ShuffleCipher("shuffleCipherText.txt", "plainText.txt", 3);
		sc2.convertTextToFile("decode");
	}
}

class ShuffleCipher implements MessageEncoder {
	String inputFileName;
	String outputFileName;
	final String PATH = "C:\\Users\\User\\Desktop\\"; // Can be replaced
	int shuffleCount;
	
	ShuffleCipher(String inputFileName, String outputFileName, int count) {
		this.inputFileName = PATH + inputFileName;
		this.outputFileName = PATH + outputFileName;
		this.shuffleCount = count;
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
		StringBuilder sb = plainText;
		
		for(int i = 0; i < this.shuffleCount; i++)
			sb = shuffle(sb);
		
		return sb;
	}
	
	@Override
	public StringBuilder decode(StringBuilder cipherText) {
		StringBuilder sb = cipherText;
		
		for(int i = 0; i < this.shuffleCount; i++)
			sb = unshuffle(sb);
		
		return sb;
	}
	
	public StringBuilder shuffle(StringBuilder str) {
		StringBuilder sb = new StringBuilder();
		int mid = str.length() / 2;
		
		String left = str.substring(0, mid); // .subString(int startIndex, int endIndex)
		String right = str.substring(mid); // .subString(int startIndex)
		
		for(int i = 0; i < mid; i++) 
			sb.append(left.charAt(i)).append(right.charAt(i));
		
		sb.append((right.length() > left.length()) ? right.charAt(mid) : "");
		
		return sb;
	}
	
	public StringBuilder unshuffle(StringBuilder str) {
		StringBuilder sb = new StringBuilder();
		
		int length = (str.length() / 2) * 2;

		//abc123
		//a1b2dc3

		// a - 0, b = 2, c = 4
		// a b c 1 2 3
		
		for(int i = 0; i < length; i += 2) 
			sb.append(str.charAt(i)); 
			
		for(int i = 1; i < length; i += 2) 
			sb.append(str.charAt(i));

		sb.append((str.length() % 2 == 1) ? str.charAt(str.length() - 1) : "");
		
		return sb;
	}

}