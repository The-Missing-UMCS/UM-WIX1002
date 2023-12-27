package PastYear2016.Semester2;

public class Q2 {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000: ");
		int sum = 0;
		for(int val = sc.nextInt(); val > 0; val /= 10) {
			sum += val % 10;
		}
		System.out.println("The sum of the digits is " + sum);
		sc.close();
	}
}
