package PastYear2016.S2;

public class Tester {
	public static void main(String[] args) {
		for(int i = 1; i < 1000000; i *= 10) {
			System.out.printf("|%3c|%3d|\n", 'A', i);
		}
	}
}
