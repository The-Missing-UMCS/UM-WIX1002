package Tutorial3;

public class WIX1002_T3_Q3 {
	public static void main(String[] args) {
		int x = 9, y = 10;
		
		System.out.println("Question A");
		if (x < 10)
			if (y > 10)
			System.out.println("*****");
			else
			System.out.println("#####");
			System.out.println("$$$$$");
			
		System.out.println("Question B");
		if (x < 10) {
			if (y < 10)
				System.out.println("*****");
			else {
				System.out.println("#####");
				System.out.println("$$$$$");
			}
		}
		
		System.out.println("Question C");
		if (x < 10) {
			if (y < 10)
				System.out.println("*****");
			System.out.println("#####");
		} else {
			System.out.println("$$$$$");
		}
		
		System.out.println("Question D");
		if (x > 10) {
			if (y > 10) {
				System.out.println("*****");
				System.out.println("#####");
			} else
				System.out.println("$$$$$");
		}

	}
}
