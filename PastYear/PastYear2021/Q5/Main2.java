package PastYear2021.Q5;

import java.util.Scanner;

public class Main2 {
	static final char FRONT = '1';
	static final char BACK = '0';
	
	public static void main(String[] args) {
		char[] operator = {'+', '-', '*', '/'};
		
		int a, b, c, ans = 18;
		Scanner sc = new Scanner(System.in);
	
		while(true) {
			char[][] solutions = new char[16][3]; // 4 * 4 = 16 possible combinations
			int seq = 0;
			System.out.print("Enter 3 numbers [1 - 9] : ");
			boolean flag = false;
			a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
			for(char front : operator) {
				for(char end : operator) {
					
					if(evaluate(end, evaluate(front, a, b), c) == ans) {
						solutions[seq][0] = FRONT; // Status = front
						solutions[seq][1] = front;
						solutions[seq][2] = end;
						seq++;
					}
					
					if(evaluate(front, a, evaluate(end, b, c)) == ans) {
						solutions[seq][0] = BACK; // Status = back
						solutions[seq][1] = front;
						solutions[seq][2] = end;
						seq++;
					}
				}
			}
			
			if(seq == 0) {
				System.out.println("No solution");
			} else {
				for(int i = 0; i < seq; i++) {
					if(solutions[i][0] == FRONT) {
						char front = solutions[i][1];
						char end = solutions[i][2];
						flag = (front == '+' || front == '-') && (end == '*' || end == '/');					
						System.out.printf("%s%d %c %d%s %c %d = %d\n", (flag) ? "("  : "", a, front, b, (flag) ? ")"  : "", end, c, ans);
					} else {
						char front = solutions[i][1];
						char end = solutions[i][2];
						flag = (end == '+' || end == '-') && (front == '*' || front == '/');					
						System.out.printf("%d %c %s%d %c %d%s = %d\n", a, front, (flag) ? "("  : "", b, end, c, (flag) ? ")"  : "", ans);
					}
				}
			}
			
		 
		}
	}
		
	public static int evaluate(char op, int a, int b) {
		try {
			switch(op) {
			case '+': return a + b;
			case '-': return a - b;
			case '*': return a * b;
			case '/': return a / b;
			default: return 0;
			}
		} catch(ArithmeticException ex) {
			// in case of 6 7 8, 7 / 8 = 0, thus / by 0
			return 0;
		}
		
	}
}
