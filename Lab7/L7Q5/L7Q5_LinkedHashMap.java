package com.fyiernzy.Lab7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class L7Q5_LinkedHashMap {
	public static void main(String[] args) {
		String path = "../WIX1002/io_files/Lab07/person.dat";
		
	    try {
	        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
	        LinkedHashMap<String, Integer> data_1 = new LinkedHashMap<>();
	        LinkedHashMap<String, Character> data_2 = new LinkedHashMap<>();

	        final int N = input.readInt();

	        String[] names = new String[N];

	        for (int i = 0; i < N; i++) {

	            names[i] = input.readUTF();

	            data_1.put(names[i], input.readInt());
	            data_2.put(names[i], input.readChar());
	        }
	        
	        input.close();
	        
	        Arrays.sort(names); // Sorting

	        for (String name: names) {
	            System.out.printf("Name: %-12s, Age: %-2d, Gender: %1s\n", name, data_1.get(name), data_2.get(name));
	        }
		}
	    catch (FileNotFoundException ex) { ex.printStackTrace(); }
		catch (IOException ex) { ex.printStackTrace(); }
	}
}
