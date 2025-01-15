package Lab5;

import java.util.Scanner;

public class L5Q6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of row of Pascal Triangle to generate: ");
		int n = scanner.nextInt();
		scanner.close();

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr[i][j] = 1; // Fill the one at both the leftmost and rightmost.
				} else {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]; // simple arithmetic calculation
				}
			}
		}

		System.out.println("The Pascal Triangle with " + n + " row(s)");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d", arr[i][j]); // Default value of int[] is 0;
			}
			System.out.println("");
		}

	}
}
