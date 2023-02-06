package Lab2;

public class L2Q3 {
	public static void main(String[] args) {
		int[] arr = new int[3];
		
		// Generate three random numbers
		for(int i = 0; i < 3; i++) 
			arr[i] = (int)(Math.random() * 41 + 10);
		
		// Display three numbers
		for(int i = 0; i < 3; i++)
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		
		
		// Calculate the sum of three numbers
		int sum = 0;
		for (int num : arr)
			sum += num;
		System.out.println("Sum     : " + sum);
		
		// Calculate average of three numbers
		double average = (double) sum / arr.length;
		System.out.println(String.format("Average : %.2f", average));
		
	}
}
