package com.fyiernzy.Lab7;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class L7Q5_Array {
	public static void main(String[] args) {
		String path = "../WIX1002/io_files/Lab07/person.dat";
		
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
			final int N = input.readInt();
			
		    Person[] personList = new Person[N];

		    for(int i = 0; i < N; i++)
		        personList[i] = new Person(input.readUTF(), input.readInt(), input.readChar());

		    Arrays.sort(personList);

		    for(Person person : personList)
		        System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender());

		} 
		catch (FileNotFoundException ex) { ex.printStackTrace(); }
		catch (IOException ex) { ex.printStackTrace(); }
	}
}
