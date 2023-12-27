package PastYear2016.Semester1;

import java.util.Scanner;
import java.io.FileInputStream;

public class Q4 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new FileInputStream("./src/PastYear2016/S1/Q4.txt"))) {
			while (sc.hasNextLine())
				System.out.println(isStrongPassword(sc.nextLine()) ? "Strong" : "Not a strong password");
		} catch (Exception ex) {}
	}

	public static boolean isStrongPassword(String password) {
		boolean hasUppercase, hasLowercase, hasDigit, hasSymbol;
		hasUppercase = hasLowercase = hasDigit = hasSymbol = false;

		if (password.length() < 8)
			return false;

		for (char ch : password.toCharArray()) {
			if (!hasUppercase && Character.isUpperCase(ch)) 
				hasUppercase = true;
			
			if (!hasLowercase && Character.isLowerCase(ch)) 
				hasLowercase = true;
			
			if (!hasDigit && Character.isDigit(ch)) 
				hasDigit = true;
			
			if (!hasSymbol && isSymbol(ch)) 
				hasSymbol = true;
			
			if (hasUppercase && hasLowercase && hasDigit && hasSymbol)
				return true;
		}

		return false;
	}

	static boolean isSymbol(char ch) {
		return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
	}
}
