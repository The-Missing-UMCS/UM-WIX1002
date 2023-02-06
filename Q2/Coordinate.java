package PastYear2020.Q2;

public class Coordinate {	
	private Longitude longitude;
	private Latitude latitude;
	
	public Coordinate(Latitude latitude, Longitude longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude.get();
	}
	
	public double getLongitude() {
		return longitude.get();
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", latitude, longitude);
	}
}
