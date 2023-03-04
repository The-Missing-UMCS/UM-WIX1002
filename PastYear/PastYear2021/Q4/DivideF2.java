package PastYear2021.Q4;

import java.util.ArrayList;

public class DivideF2 extends Eleven {
	public DivideF2(String fileName) {
		super(fileName);
	}
	
	class State {
		int beforeLast;
		int lastDigit;
		
		State(int beforeLast, int lastDigit) {
			this.beforeLast = beforeLast;
			this.lastDigit = lastDigit;
		}
		
		public int getDifference() {
			return beforeLast - lastDigit;
		}
		
		@Override
		public String toString() {
			return String.format("%d - %d * 1 = %d, ", beforeLast, lastDigit, getDifference());
		}
	}
	
//	public static void main(String[] args) {
//		DivideF2 f2 = new DivideF2("./src/PastYear2021/Q4/data.dat");
//		System.out.println(f2.divide());
//	}
	
	public String divide() {
		StringBuilder sb = new StringBuilder();
		sb.append("Divisibility Rule 2").append("\n");
		
		for(int value : arr) {
			sb.append(divide(value)).append("\n");
		}
		
		return sb.toString();
	}
	
	public String divide(int value) {
		var states = new ArrayList<State>();
		int x = value;
		
		while(x > 100) {
			State state = new State(x / 10, x % 10);
			states.add(state);
			x = state.getDifference();
		}
		
		int mod = x % 11;
		
		String upperLine = String.format("%d, : %sx = %s", value, concatenate(states), x);
		String lowerLine;
		if(mod == 0) {
			lowerLine = String.format("%d modulus 11 = 0, %d is divisible by 11", x, value);
		} else {
			lowerLine = String.format("%d modulus 11 is not equal to 0, %d is not divisible by 11", x, value);
		}
		
		return String.format("%s\n%s\n", upperLine, lowerLine);
	}
	
	public String concatenate(ArrayList<State> ls) {
		StringBuilder sb = new StringBuilder();
		ls.forEach(sb::append);
		return sb.toString();
	}
	
	
}
