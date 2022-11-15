package Tutorial5;

public class T5Q1 {
	public static void main(String[] args) {
		// a.
		float[] arr1 = new float[12];
		
		// b.
		char[] arr2 = {'A','B','C','D','E'};
		
		// c.
		String[] studentNameArr = new String[100];
		
		// d.
		int[][] integerArr = new int[6][2];
		
		// e.
		int[][] arr = {{6, 9},{2, 5},{4, 6}};
		displayArray(arr);
		
		System.out.println("");
		// f.
		arr[1][1] = 4;
		arr[2][0] = 3;
		arr[2][1] = 7;
		displayArray(arr);
		
	}
	
	public static void displayArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
