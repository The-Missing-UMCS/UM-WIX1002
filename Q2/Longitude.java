package PastYear2020.Q2;

public class Longitude extends Position {
	public Longitude(char direction, int degree, int minute, int second) {
		super(direction, degree, minute, second);
	}
	
	public double get() {
		int flag = direction == 'E' ? 1 : -1;
		return flag * (degree + (minute * 60 + second) / (double) 3600);
	}
	
	@Override
	public String toString() {
		return String.format("%.6f Longitude", get());
	}
}
