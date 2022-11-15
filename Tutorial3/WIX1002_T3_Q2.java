package Tutorial3;

public class WIX1002_T3_Q2 {
	public static void main(String[] args) {
		// Question A
		int num1 = 1, num2 = 2;
		if (num1 == num2)
			System.out.println("Number 1 equals number 2.");
		
		// Question B
		int x = 9, y = 8, z = 7;
		if (x > y && y > z)
			System.out.println("X is the largest numebr");
	
		// Question C
		String s1, s2;
		s1 = "Hello";
		s2 = "Hello";
		if (s1.equals(s2) == true)
			System.out.println("They are equal strings");
		else if (s1.equals(s2) == false)
			System.out.println("They are not equal strings");
		/* or 
		else 
			System.out.println("They are not equal strings");
		*/
		
		// Question D
		if (x > 0 || y > 0)
			System.out.println("Either x or y is positive.");
		/* or 
		 * if (x > 0 | y > 0)
		 * System.out.prinltn("Either x or y is positive.");
		 */
	}
}
