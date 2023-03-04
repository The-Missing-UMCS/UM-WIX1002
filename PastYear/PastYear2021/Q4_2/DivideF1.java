package PastYear2021.Q4_2;

public class DivideF1 extends Eleven {
	public DivideF1(String fileName) {
		super(fileName);
	}
	
	public static void main(String[] args) {
		DivideF1 f1 = new DivideF1("./src/PastYear2021/Q4/data.dat");
		System.out.println(f1.divide());
	}
	
	@Override
	public String divide() {
		StringBuilder sb = new StringBuilder();
		sb.append("Divisibility Rule 1").append("\n");
		
		for(int value : arr) {
			sb.append(divide(value)).append("\n");
		}
		
		return sb.toString();
	}
	
	private String divide(int value) {
		final int N = 5;
		int[][] values = new int[2][N];
		int seq = 0, x = 0;
		
		for(int tmp = value; tmp > 0; seq++, tmp /= 10) {
			int val = values[seq & 1][seq >> 1] = tmp % 10;
			x += (seq & 1) * -1 * val;
		}
		
		x = Math.abs(x);
		String upperLine = String.format("%d : |x| = | %s - %s | = %d", value, concatenate(values[0], (seq >> 1) + (seq & 1)), concatenate(values[1], seq >> 1), x);
		String lowerLine;
		
		if(x % 11 == 0) {
			lowerLine = String.format("%d modulus 11 = 0, %d is divisible by 11", x, value);
		} else {
			lowerLine = String.format("%d modulus 11 is not equal to 0, %d is not divisible by 11", x, value);
		}
		
		return String.format("%s\n%s\n", upperLine, lowerLine);
	}
	
	private String concatenate(int[] arr, int seq) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		int i = seq - 1;
		for( ; i > 0; i--) {
			sb.append(arr[i]).append(" + ");
		}
		sb.append(arr[i]).append(")");
		
		return sb.toString();
		
	}
}
