package Lab9.L9Q1;

public class Main {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[] {
				new Rectangle(4, 5),
				new Square(7),
				new Circle(14)
		};

		for (Shape shape : shapes) {
			shape.computeAreaAndPerimeter();
			shape.showDetails();
		}
	}
}







