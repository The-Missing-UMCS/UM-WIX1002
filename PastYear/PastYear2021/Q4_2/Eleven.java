package PastYear2021.Q4_2;

import java.io.*;
import java.util.ArrayList;

public abstract class Eleven {
	protected int[] arr;
	protected String fileName;
	
	Eleven(String fileName) {
		this.fileName = fileName;
		read();
	}
	
	abstract String divide();
	
	private void read() {
		ArrayList<Integer> ls = new ArrayList<>();
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				ls.add(in.readInt());
			}
		} 
		catch (EOFException ex) { } 
		catch (IOException ex) { ex.printStackTrace(); }
		
		arr = ls.stream().mapToInt(value -> value).toArray();
	}
}
