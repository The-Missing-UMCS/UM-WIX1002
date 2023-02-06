package PastYear2020.Q2;

import static java.lang.Math.*;

public class CoordinateDistanceCalculator {
	public static final int R = 6371;
	private Coordinate c1;
	private Coordinate c2;
	
	public CoordinateDistanceCalculator(Coordinate c1, Coordinate c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public double getLatitudeDiff() {
		return c2.getLatitude() - c1.getLatitude();
	}
	
	public double getLongitudeDiff() {
		return c2.getLongitude() - c1.getLongitude();
	}
	
	public double calcDistance() {
		double la1 = Math.toRadians(c1.getLatitude());
		double la2 =  Math.toRadians(c2.getLatitude());
		double laDiff =  Math.toRadians(getLatitudeDiff());
		double loDiff = Math.toRadians(getLongitudeDiff());
		
		double a = pow(sin(laDiff / 2), 2) + cos(la1) * cos(la2) * pow(sin(loDiff / 2), 2);
		double c = 2 * atan2(sqrt(a), sqrt(1 - a));
		
		return R * c;
	}
	
}
