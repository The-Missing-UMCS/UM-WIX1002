package Lab7.L7Q5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collections;

import Lab7.Generator;

import java.util.ArrayList;

public class L7Q5D {
	public static void main(String[] args) {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(Generator.PERSON_FILE))) {
			final int N = input.readInt();
			
		    ArrayList<Person> personList = new ArrayList<Person>();

		    for(int i = 0; i < N; i++)
		        personList.add(new Person(input.readUTF(), input.readInt(), input.readChar()));

		    Collections.sort(personList);

		    for(Person person : personList)
		        System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender());

		} 
		catch(Exception ex) {}
	}
}





