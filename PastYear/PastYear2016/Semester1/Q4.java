package PastYear2016.S1;

import java.util.Scanner;
import java.io.FileInputStream;

public class Q4 {
	public static void main(String[] args) {
		boolean hasEightChar, hasUppercase, hasLowercase, hasDigit, hasSymbol;
		
		try(Scanner sc = new Scanner(new FileInputStream("./src/PastYear2016/S1/Q4.txt"))){
			while(sc.hasNextLine()) {
				hasEightChar = hasUppercase = hasLowercase = hasDigit = hasSymbol = false;
				String password = sc.nextLine();
				hasEightChar = password.length() >= 8 ? true : false;
				
				if(hasEightChar) {
					for(int i = 0; i < password.length(); i++) {
						char ch = password.charAt(i);
						if(!hasUppercase && Character.isUpperCase(ch)) { hasUppercase = true; }
						if(!hasLowercase && Character.isLowerCase(ch)) { hasLowercase = true; }
						if(!hasDigit && Character.isDigit(ch)) { hasDigit = true;}
						if(!hasSymbol && !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) { hasSymbol = true; }
						if(hasUppercase && hasLowercase && hasDigit && hasSymbol) break;
					}
				}
				if(hasEightChar && hasUppercase && hasLowercase && hasDigit && hasSymbol) 
					System.out.println("Strong password");
				else 
					System.out.println("Not a strong password");
			}
		} catch (Exception ex) {}
	}
}
