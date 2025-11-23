package com.umwix1002.solution.pastyear.PastYear2023;

public class DataBuoy {
	private String buoyID;
	private int latitude;
	private int longitude;
	private double airT;
	private double waterT;
	
	public DataBuoy(String buoyID, int latitude, int longitude, double airT, double waterT) {
		super();
		this.buoyID = buoyID;
		this.latitude = latitude;
		this.longitude = longitude;
		this.airT = airT;
		this.waterT = waterT;
	}

	public String getBuoyID() {
		return buoyID;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public double getAirT() {
		return airT;
	}

	public double getWaterT() {
		return waterT;
	}
}
