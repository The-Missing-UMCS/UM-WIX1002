package Tutorial8;

public class T8Q3 {
	public static void main(String[] args) {
		new Coordinate(5, 6).showCoordinate();
	}
}

class Coordinate {
	private int x;
	private int y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void showCoordinate() {
		System.out.printf("Coordinate: (%d , %d)\n", x, y);
	}
}
