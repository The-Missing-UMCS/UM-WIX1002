package com.fyiernzy.Lab7;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class L7Q5_Multiple_Array {
	public static void main(String[] args) {
		String path = "../WIX1002/io_files/Lab07/person.dat";
		
	    try {
	        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
			final int N = input.readInt();
            
		    String[] nameArr = new String[N];
		    int[] ageArr = new int[N];
		    char[] genderArr = new char[N];
		    int[] indexArr = new int[N];


		    for(int i = 0; i < N; i++) {
		        indexArr[i] = i;
		        nameArr[i] = input.readUTF();
		        ageArr[i] = input.readInt();
		        genderArr[i] = input.readChar();
		    }
		    
		    input.close();
		    
		    sortIndexByName(indexArr, nameArr);

		    for(int i : indexArr) 
		        System.out.printf(" %-13s %3d %3s \n", nameArr[i], ageArr[i], genderArr[i]);
		    
		    
		}
	    catch (FileNotFoundException ex) { ex.printStackTrace(); }
		catch (IOException ex) { ex.printStackTrace(); }
    }
	
	public static void sortIndexByName(int[] indexArr, String[] nameArr) {
	    for(int i = 0; i < indexArr.length; i++) {
	        for(int j = 0 ; j < indexArr.length - i - 1; j++) {
	            int before = indexArr[j];
	            int after = indexArr[j + 1];
	            
	            if(nameArr[before].compareTo(nameArr[after]) > 0) {
	                indexArr[j] = after;
	                indexArr[j + 1] = before;
	            }
	        }
	    }
	}
}
