package Lab5;

public class L5Q1 {
	public static void main(String[] args) {
		int n = 10;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random() * 101);
			sum += arr[i];
		
			if (arr[i] > max) {
				max = arr[i];
			} else if (arr[i] < min) {
				min = arr[i];
			}
			
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		System.out.printf("average = %.2f", (sum / (double) n));
	}
}
