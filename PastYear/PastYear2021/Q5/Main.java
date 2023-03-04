package PastYear2021.Q5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		char[] operator = {'+', '-', '*', '/'};
		
		int a, b, c, ans = 18;
		Scanner sc = new Scanner(System.in);
		char[][] solutions = new char[16][3]; // 4 * 4 = 16 possible combinations
		int seq = 0;
		
		while(true) {
			System.out.print("Enter 3 numbers [1 - 9] : ");
			boolean flag = false;
			a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
			
			boolean hasSolution = false;
			Outer:
			for(char front : operator) {
				for(char end : operator) {
					
					if(evaluate(end, evaluate(front, a, b), c) == ans) {
						flag = (front == '+' || front == '-') && (end == '*' || end == '/');					
						System.out.printf("%s%d %c %d%s %c %d = %d\n", (flag) ? "("  : "", a, front, b, (flag) ? ")"  : "", end, c, ans);
						hasSolution = true;
						break Outer;
					}
					
					if(evaluate(front, a, evaluate(end, b, c)) == ans) {
						flag = (end == '+' || end == '-') && (front == '*' || front == '/');					
						System.out.printf("%d %c %s%d %c %d%s = %d\n", a, front, (flag) ? "("  : "", b, end, c, (flag) ? ")"  : "", ans);
						hasSolution = true;
						break Outer;
					}
				}
			}
			
			if(!hasSolution) {
				System.out.println("No solution");
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
