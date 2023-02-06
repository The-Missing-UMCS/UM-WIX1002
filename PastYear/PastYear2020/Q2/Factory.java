package PastYear2020.Q2;

import java.util.Scanner;

public class Factory {
	Scanner scanner;
	
	Factory() {
		Scanner scanner = new Scanner(System.in);
	}
	
	public void close() {
		scanner.close();
		scanner = null; // Help GC
	}
	
	private Position getPos(char direction, int degree, int minute, int second) {
		Position pos = null;
		
		switch(direction) {
		case 'N', 'S' -> pos = new Latitude(direction, degree, minute, second);
		case 'E', 'W' -> pos =  new Longitude(direction, degree, minute, second);
		}
		
		return pos;
	}
	
	private Position getPos() {
		char direction; int degree, minute, second;
		
		System.out.print("Enter Direction: [N, S, E, W]: "); 
		direction = scanner.nextLine().charAt(0); 
		System.out.print("Enter Degree, Minute and Second: ");
		degree = scanner.nextInt(); 
		minute = scanner.nextInt(); 
		second = scanner.nextInt(); 
		scanner.nextLine();
		
		
		return getPos(direction, degree, minute, second);
	}
	
	public Coordinate getCoordinate() {
		Latitude latitude = (Latitude) getPos();
		Longitude longitude = (Longitude) getPos();
		return new Coordinate(latitude, longitude);
	}
	
	
}
