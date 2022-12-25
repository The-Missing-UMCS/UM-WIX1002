package com.fyiernzy.Lab7;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

public class L7Q5_ArrayList {
	public static void main(String[] args) {
		String path = "../WIX1002/io_files/Lab07/person.dat";
		
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
			final int N = input.readInt();
			
		    ArrayList<Person> personList = new ArrayList<Person>();

		    for(int i = 0; i < N; i++)
		        personList.add(new Person(input.readUTF(), input.readInt(), input.readChar()));

		    Collections.sort(personList);

		    for(Person person : personList)
		        System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender());

		} 
		catch (FileNotFoundException ex) { ex.printStackTrace(); }
		catch (IOException ex) { ex.printStackTrace(); }
	}
}





