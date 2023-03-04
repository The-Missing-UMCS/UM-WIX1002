package PastYear2021.Q4_2;

public class Main {
	public static void main(String[] args) {
		String file = "./src/PastYear2021/Q4/data.dat";
		
		DivideF1 f1 = new DivideF1(file);
		DivideF2 f2 = new DivideF2(file);
		
		System.out.println(f1.divide());
		System.out.println(f2.divide());
	}
}
