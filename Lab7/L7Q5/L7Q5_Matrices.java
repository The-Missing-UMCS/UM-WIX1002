package com.fyiernzy.Lab7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class L7Q5_Matrices {
	public static void main(String[] args) {
		String path = "../WIX1002/io_files/Lab07/personList.dat";
		
	    try {
	        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
			final int N = input.readInt();
			String[][] personList = new String[N][3];

		    for(int i = 0; i < N; i++) {
		        personList[i][0] = input.readUTF();
		        personList[i][1] = Integer.toString(input.readInt());
		        personList[i][2] = Character.toString(input.readChar());
		    }

		    sortMatrixByName(personList);

		    for(String[] person : personList) 
		            System.out.printf(" %-13s %3d %3s \n", person[0], person[1], person[2]);
	    
	    }
	    catch (FileNotFoundException ex) { ex.printStackTrace(); }
	    catch (IOException ex) { ex.printStackTrace(); }
	}
	
	public static void sortMatrixByName(String[][] personList) {
	    // Bubble Sort
	    for(int i = 0; i < personList.length; i++) {
	        for(int j = 0; j < personList.length - 1 - i; j++) {
	            if(personList[j][0].compareTo(personList[j + 1][0]) > 0) {
	                String[] tmp = personList[j];
	                personList[j] = personList[j + 1];
	                personList[j + 1] = tmp;
	            }
	        }
	    }
	} 
}
