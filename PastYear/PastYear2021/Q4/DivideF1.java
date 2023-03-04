package PastYear2021.Q4;

import java.util.ArrayList;

public class DivideF1 extends Eleven {
	public DivideF1(String fileName) {
		super(fileName);
	}
	
	public static void main(String[] args) {
		DivideF1 f1 = new DivideF1("./src/PastYear2021/Q4/data.dat");
		System.out.println(f1.divide());
		System.out.println(Integer.MAX_VALUE);
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
		var lsOne = new ArrayList<Integer>();
		var lsTwo = new ArrayList<Integer>();
		
		int tmp = value;
		boolean isOneTurn = true;
		
		while(tmp > 0) {
			int digit = tmp % 10;
			
			if(isOneTurn)
				lsOne.add(digit);
			else
				lsTwo.add(digit);
			
			isOneTurn = !isOneTurn;
			tmp /= 10;
		}
		
		int oneSum = lsOne.stream().mapToInt(x -> x).sum();
		int twoSum = lsTwo.stream().mapToInt(x -> x).sum();
		int x = Math.abs(oneSum - twoSum);
		int mod = x % 11;
		
		String upperLine = String.format("%d : |x| = | %s - %s | = %d", value, concatenate(lsOne), concatenate(lsTwo), x);
		String lowerLine;
		
		if(mod == 0) {
			lowerLine = String.format("%d modulus 11 = 0, %d is divisible by 11", x, value);
		} else {
			lowerLine = String.format("%d modulus 11 is not equal to 0, %d is not divisible by 11", x, value);
		}
		
		return String.format("%s\n%s\n", upperLine, lowerLine);
	}
	
	private String concatenate(ArrayList<Integer> ls) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		int i = ls.size() - 1;
		for( ; i > 0; i--) {
			sb.append(ls.get(i)).append(" + ");
		}
		sb.append(ls.get(i)).append(")");
		
		return sb.toString();
		
	}
}
