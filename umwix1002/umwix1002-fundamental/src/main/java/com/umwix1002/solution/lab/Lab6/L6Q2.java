package Lab6;

public class L6Q2 {
	public static void main(String[] args) {
		printTriangle(3);
		printDiamond(10);
	}
	
	public static void multiprint(int n, char c) {
		for(int i = 1; i <= n; i++) 
			System.out.print(String.format("%c", c) + ((i == n) ? "" : " "));
	}
	
	public static void printTriangle(int size) {
		for(int i = 1; i <= size; i++) {
			System.out.print(" ".repeat(size - i + 1));
			multiprint(i, '*');
			System.out.println("");
		}
	}
	
	public static void printDiamond(int size) {
		printTriangle(size);
		for(int i = size - 1, j = 1; i >= 1; i--, j++) {
			System.out.print(" ".repeat(j + 1));
			multiprint(i, '*');
			System.out.println("");
		}
		
	}
}
