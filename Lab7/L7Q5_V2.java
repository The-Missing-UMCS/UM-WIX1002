package com.fyiernzy.Lab7;

import java.io.*;
import java.util.*;

public class L7Q5_V2 {
	public static void main(String[] args) {
		new L7Q5_V2().run();
	}
	
	public void run() {
		String file = "../WIX1002/io_files/person.dat";
		generateBinaryFile(file);
		showNameList(file);
	}
	
	public void generateBinaryFile(String file) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject("4");
			
			output.writeObject(new Person("Ali", 19, 'M'));
			output.writeObject(new Person("Siti", 19, 'F'));
			output.writeObject(new Person("Muttu", 19, 'M'));
			output.writeObject(new Person("Mei Mei", 19, 'F'));
			
			output.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void showNameList(String file) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			int n = Integer.parseInt((String) input.readObject());
			Person person;
			
			for(int i = 0; i < n; i++) {
				person = (Person) input.readObject();
				System.out.printf("Name:  %-8s | Age: %3d | Gender: %C\n",
						person.name, person.age, person.gender);
			}
			
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class Person implements Comparable<Person>, Serializable {
	String name;
	int age;
	char gender;
	
	@Override
	public int compareTo(Person another) {
		return (this.name.compareTo(another.name));
	}
	
	Person(String name, int age, char gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}


