package com.fyiernzy.Lab7;

import java.io.PrintWriter;

public class L7Q6_Source_Output {
	public static void main(String[] args) {
		writeProductFile("./io_files/product.txt");
		writeOrderFile("./io_files/order.txt");
	}
	
	public static void writeProductFile(String toFile) {
		try {
			PrintWriter writer = new PrintWriter(toFile);
			writer.println("SK079,Dettol Natural,4.99");
			writer.println("SK013,100 Plus,6.49");
			writer.println("SK088,Jasmine Pearl,37.99");
			writer.println("SK042,Ayamas Nuget Crispy,9.99");
			writer.println("SK066,Ali Cafe,8.99");
			
			writer.close();
		} catch (Exception ex) {
			
		}
	}
	
	public static void writeOrderFile(String toFile) {
		try {
			PrintWriter writer = new PrintWriter(toFile);
			writer.println("SK079,Dettol Natural,20");
			writer.println("SK013,100 Plus,74");
			writer.println("SK088,Jasmine Pearl,27");
			writer.println("SK042,Ayamas Nuget Crispy,60");
			writer.println("SK066,Ali Cafe,79");
			
			writer.close();
		} catch (Exception ex) {
			
		}
	}
}
