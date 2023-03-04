package PastYear2016.S2;

import java.util.Random;
public class Q5 {
	public static void main(String[] args) {
		int N = 3;
		boolean[][] board = new boolean[N][N];
		Random rand = new Random();
		
		// Generate board
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				board[row][col] = rand.nextBoolean();
			}
		}
		
		// board = new boolean[][] {{true, true, true}, {true, true, true}, {true, true, true}};
		
		for(boolean[] row : board) {
			for(boolean element : row) {
				System.out.print((element ? 1 : 0) + " ");
			}
			System.out.println();
		}
		
		// row first search
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N - 1; col++) {
				if(!(board[row][col] == board[row][col + 1]))
					break;
				
				if(col == N - 2) {
					int value = (board[row][col]) ? 1 : 0;
					System.out.printf("All %ds in on row %d\n", value, row);
				}
			}
		}
		
		// column first search
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N - 1; col++) {
				if(!(board[col][row] == board[col + 1][row]))
					break;
				
				if(col == N - 2) {
					int value = (board[col][row]) ? 1 : 0;
					System.out.printf("All %ds in on column %d\n", value, row);
				}
			}
		}
		
		// first diagonal search
		for(int i = 0; i < N - 1; i++) {
			if(!(board[i][i] == board[i + 1][i + 1]))
				break;
			
			if(i == N - 2) {
				int value = (board[i][i]) ? 1 : 0;
				System.out.printf("All %ds in on left top to right bottom diagonal\n", value);
			}
		}
		
		// second diagonal search
		for(int i = 0, j = N - 1; i < N - 1; i++, j--) {
			if(!(board[i][j] == board[i + 1][j - 1]))
				break;
			
			if(i == N - 2) {
				int value = (board[i][j]) ? 1 : 0;
				System.out.printf("All %ds in on right top to left bottom diagonal\n", value);
			}
		}
		
		
		
		
		
		
		
	}
}
