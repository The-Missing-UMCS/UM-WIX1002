package Lab9.L9Q1;

public abstract class Shape {
	protected final String NAME;
	protected double perimeter;
	protected double area;

	Shape(String name) {
		this.NAME = name;
	}

	public void showDetails() {
		System.out.printf("%-10s: Perimeter = %-7.2f, Area = %-7.2f\n", this.NAME, this.perimeter, this.area);
	}

	abstract void computeAreaAndPerimeter();
}