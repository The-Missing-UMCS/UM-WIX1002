package Lab7.L7Q5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

import Lab7.Generator;

public class L7Q5C {
	public static void main(String[] args) {
		
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(Generator.PERSON_FILE))) {			
		    Person[] personList = new Person[input.readInt()];

		    for(int i = 0; i < personList.length; i++)
		        personList[i] = new Person(input.readUTF(), input.readInt(), input.readChar());

		    Arrays.sort(personList);

		    for(Person person : personList)
		        System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender());
		}
		
		catch(Exception ex) {}
	}
}
