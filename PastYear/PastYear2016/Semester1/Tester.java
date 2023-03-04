package PastYear2016.S1;

import java.util.regex.*;

public class Tester {
	public static void main(String[] args_) {
//		Pattern pattern = Pattern.compile("(ATG)+([ATCG]*)(ATT)");
//		Matcher m = pattern.matcher("ATGATGTTTGTTCATATTAATGTTTATT");
//		
//		if(m.matches()) {
//			System.out.println(m.group(2));
//		}
		System.out.println((Math.round(25 / 10.0)) * 10);
		displayAppro(new int[] {25, 34, 78, 91});
		
//		Pattern pattern = Pattern.compile("type(apple)");
//		Matcher m = pattern.matcher("hello typeapple hello yellowapple");
//		
//		if(m.matches()) 
//			System.out.println(m.group(1));
//		while(m.find()) 
//			System.out.println(m.group());
//		
//		String line = "hello typeapple hello yellowapple";
//		String word = "typeapple";
//		int index = line.indexOf(word);
//		System.out.println(line.substring(index, index + word.length() + 1));
		
		
	}
	
	public static void displayAppro(int[] randNum) { 
        System.out.print("The approximation of the integer to the nearest tenth: ");
        for (int i : randNum) {
            System.out.print(Math.round(i / 10.0) * 10 + " "); 
        } 
        System.out.println(""); 
    }
}
