package Lab4;

import java.util.*;
public class WIX1002_Lab4_Q3 {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		new WIX1002_Lab4_Q3().run();
	}
	
	public void run() {
		getInput();
		System.out.println("Minimum Score: " + findMin());
		System.out.println("Maximum Score: " + findMax());
		System.out.printf("Average Score: %.2f\n",findAverage());
		System.out.printf("Standard Deviation: %.2f\n ", findStd());
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		int num;
		while (true) {
			System.out.print("Enter a score [negative score to quit]: ");
			num = scanner.nextInt();
			if (num < 0)
				break;
			arr.add(num);
		}
		scanner.close();
	}
	
	public int findMin() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < min)
				min = arr.get(i);
		}
		return min;
	}
	
	public int findMax() {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) > max)
				max = arr.get(i);
		}
		return max;
	}
	
	public int findSum() {
		int total = 0;
		for(int i = 0; i < arr.size(); i++) 
			total += arr.get(i);
		return total;
	}
	
	public double findAverage() {
		return ((double)findSum() / (double) arr.size());
	}
	
	public int findSquaredSum() {
		int sum = 0;
		for(int i = 0; i < arr.size(); i++) 
			sum += (int)(Math.pow(arr.get(i), 2));
		return sum;
	}
	
	public double findStd() {
		int n = arr.size();
		double squaredAverage = Math.pow(findAverage(), 2);
		double variance = (findSquaredSum() - (squaredAverage / n)) / (double)(n - 1);
		return Math.sqrt(variance);
	}
}
