package PastYear2020.Q2;

abstract class Position {
	protected char direction;
	protected int degree;
	protected int minute;
	protected int second;
	
	public Position(char direction, int degree, int minute, int second) {
		this.direction = direction;
		this.degree = degree;
		this.minute = minute;
		this.second = second;
	}
	
	abstract double get();
}
