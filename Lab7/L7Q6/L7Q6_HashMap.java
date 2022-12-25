package com.fyiernzy.Lab7;

import java.io.*;
import java.util.*;

public class L7Q6_HashMap {
	public static void main(String[] args) {		
		HashMap<String, Product> productList = new HashMap<String, Product>();
		BufferedReader reader;
		String line;
		
		try {
			
			// Read product file
			reader = new BufferedReader(new FileReader("../WIX1002/io_files/Lab07/product.txt"));
			
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				productList.put(info[0], new Product(info[0], info[1], Double.parseDouble(info[2])));
			}
			
			reader.close();
			
			// Read order file and show order
			reader = new BufferedReader(new FileReader("../WIX1002/io_files/Lab07/order.txt"));
			
			System.out.printf(" %-15s%-25s%-10s%15s%15s\n",
					"ProductID","ProductName","Quantity","PricePerUnit","Total");
			
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				int unit = Integer.parseInt(info[2]);
				Product product = productList.get(info[1]);

				System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f\n", 
						product.productID, product.productName, unit, 
						product.productPrice, product.getTotalPrice(unit));
			}
			
			reader.close();
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}

