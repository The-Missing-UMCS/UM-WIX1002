package PastYear2020.Q2;


public class Main {
	public static void main(String[] args) {
		Factory factory = new Factory();
		System.out.println("Enter Location 1: ");
		Coordinate c1 = factory.getCoordinate();
		
		System.out.println("Enter Location 2: ");
		Coordinate c2 = factory.getCoordinate();
		
		factory.close();
		
		System.out.println("Location 1: " + c1);
		System.out.println("Location 2: " + c2);
		
		CoordinateDistanceCalculator calc = new CoordinateDistanceCalculator(c1, c2);
		System.out.printf("Distance: %.2f KM\n", calc.calcDistance());
	}
}
