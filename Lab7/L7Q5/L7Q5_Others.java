package com.fyiernzy.Lab7;

import java.io.*;

public class L7Q5_Others {

    public static void main(String[] args) {
    	String file = "../WIX1002/io_files/Lab07/person.dat";
    	
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            int num = input.readInt();
            
            String[] nameArr = new String[num];
            int[] ageArr = new int[num];
            char[] genderArr = new char[num];
            int[] indexArr = new int[num];
           
            
            for(int i = 0; i < num; i++) {
            	indexArr[i] = i;
                nameArr[i] = input.readUTF();
                ageArr[i] = input.readInt();
                genderArr[i] = input.readChar();
            }

            sortIndexByName(indexArr, nameArr);
            
            System.out.printf(" | %9s     | %4s | %5s |\n", "Name", "Age", "Gender");
            System.out.printf(" | %-13s | %-4s | %5s |\n", "-".repeat(13), "-".repeat(4), "-".repeat(6));
            for(int i : indexArr) 
            	System.out.printf(" | %-13s | %3d  | %3s    |\n", nameArr[i], ageArr[i], genderArr[i]);
            
                
            System.out.printf(" | %-13s | %-4s | %5s |\n", "-".repeat(13), "-".repeat(4), "-".repeat(6));
            
        } catch (Exception ex) { ex.printStackTrace(); }

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
    
    public static int compareName(String first, String second) {
    	int diff;
    	int limit = Math.min(first.length(), second.length()); // Prevent IndexOutOfBoundException
    	
    	for(int i = 0; i < limit; i++) {
    		if ((diff = Character.compare(first.charAt(i), second.charAt(i))) != 0) {
    			return diff;
    		}
    	}
    	
    	// The String with longer length will have higher weight
    	return first.length() > second.length() ? 1 : -1; 
    }
}

