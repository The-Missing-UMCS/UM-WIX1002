package Lab9.L9Q1;

public class Square extends Shape {
	private double side;

	Square(double side) {
		super("Square");
		this.side = side;
	}

	@Override
	public void computeAreaAndPerimeter() {
		this.area = side * 2;
		this.perimeter = 4 * side;
	}

	public void setSide(double side) {
		this.side = side;
	}
}
