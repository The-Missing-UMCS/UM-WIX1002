package com.fyiernzy.Lab7;

import java.io.*;

public class L7Q5 {
	public static void main(String[] args) {
		new L7Q5().run();
	}
	
	public void run() {
		String textFile = "../WIX1002/io_files/person.txt";
		String binaryFile = "../WIX1002/io_files/person.dat";
		
		generateTextFile(textFile);
		generateBinaryFile(textFile, binaryFile);
		showNameList(binaryFile);
	}
	
	public void generateTextFile(String file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			
			writer.println(4);
			writer.println("Ali/19/M");
			writer.println("Siti/16/F");
			writer.println("Muttu/19/M");
			writer.println("Mei Mei/20/F");
			
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void generateBinaryFile(String textFile, String binaryFile) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(textFile));
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(binaryFile));
			
			int n = Integer.parseInt(reader.readLine());
			String line = "";
			
			output.writeInt(n);
			
			for(int i = 0; i < n; i++) {
				if((line = reader.readLine()) != null) {
					String[] info = line.split("/");
					output.writeObject(info[0]);
					output.writeInt(Integer.parseInt(info[1]));
					output.writeChar((int) info[2].charAt(0));
				}
			}
			
			reader.close();
			output.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void showNameList(String file) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			int n = input.readInt();
			
			for(int i = 0; i < n; i++) {
				System.out.printf("Name:  %-8s | Age: %3d | Gender: %s\n",
						input.readObject(), input.readInt(), input.readChar());
			}
			
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}



