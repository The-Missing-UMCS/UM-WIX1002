package Lab1;

public class L1Q3 {
	String[][] shapes = new String[4][9];
	
	public static void main(String[] args) {
		new L1Q3().run();
		// use array to save each of them and using loop to iterate through each of them
		// make sure the height is the same for four element
		// make sure the width for each element in the array is the same
	}
	
	public void run() {
		makeSquare();
		makeCircle();
		makeArrow();
		makeDiamond();
		
		System.out.println("");
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print("	" + shapes[j][i] + "\t");
			}
			System.out.println("");
		}
	}
	
	public void makeSquare() {
		shapes[0][0] = "*".repeat(10);
		for(int i = 1; i < 8; i++) {
			shapes[0][i] = "*" + " ".repeat(8) + "*";
		}
		shapes[0][8] = "*".repeat(10);
	}
	
	public void makeCircle() {
		shapes[1][0] = " ".repeat(4) + "*".repeat(2) + " ".repeat(4);
		shapes[1][1] = " " + "*" + " ".repeat(6) + "*" + " ";
		for(int i = 2; i < 7; i++) {
			shapes[1][i] = "*" + " ".repeat(8) + "*";
		}
		shapes[1][7] = " " + "*" + " ".repeat(6) + "*" + " ";
		shapes[1][8] = " ".repeat(4) + "*".repeat(2) + " ".repeat(4);
	}
	
	public void makeArrow() {
		for(int i = 0; i < 3; i++) {
			shapes[2][i] = " ".repeat(2-i) + "*".repeat(1 + 2 * i) + " ".repeat(2-i);
		}
		for(int i = 3; i < 9; i++) {
			shapes[2][i] = "  *  ";
		}
	}
	
	public void makeDiamond() {
		shapes[3][0] = " ".repeat(4) + "*" + " ".repeat(4);
		int factor;
		
		factor = 1;
		for(int i = 1; i < 5; i++) {
			shapes[3][i] = " ".repeat(3-i+factor) + "*" + " ".repeat(1 + 2 * (i-factor)) + "*" + " ".repeat(3-i+factor);
		}
		
		factor = 5;
		for(int i = 5; i < 8; i++) {
			shapes[3][i] = " ".repeat(1+i-factor) + "*" + " ".repeat(5 - 2 * (i-factor)) + "*" + " ".repeat(1+i-factor);
		}
		
		shapes[3][8] = " ".repeat(4) + "*" + " ".repeat(4);
	}
}
