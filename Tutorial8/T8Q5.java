package com.fyiernzy.Tutorial8;

import java.util.ArrayList;

public class T8Q5 {
	public static void main(String[] args) {
		Connection one = new Connection("AE016");
		Connection two = new Connection("AE017");
		Connection three = new Connection("AE018");
		
		Connection.showConnection();
		
		one.disconnect();
		
		Connection.showConnection();
	}
}

class Connection {
	private static int connectionCount = 0;
	private static ArrayList<String> connectionList = new ArrayList<String>();
	private final String LOCAL_ID;
	
	Connection(String ID) {
		connectionCount++;
		this.LOCAL_ID = ID;
		connectionList.add(LOCAL_ID);
	}
	
	public void disconnect() {
		connectionCount--;
		connectionList.removeIf(this.getID()::equals);
	}
	
	public static void showConnection() {
		System.out.printf("Current connection: %d\n", connectionCount);
		for(int i = 0; i < connectionList.size(); i++) {
			System.out.printf("%d. %s\n", (i + 1), connectionList.get(i));
		}
	}
	
	public String getID() {
		return this.LOCAL_ID;
	}
}