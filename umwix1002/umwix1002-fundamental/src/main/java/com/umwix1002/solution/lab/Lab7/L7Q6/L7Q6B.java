package Lab7.L7Q6;

import java.io.*;
import java.util.*;

import Lab7.Generator;

public class L7Q6B {
	public static void main(String[] args) {		
		HashMap<String, Product> productList = new HashMap<String, Product>();
		BufferedReader reader;
		String line;
		
		try {
			// Read product file
			reader = new BufferedReader(new FileReader(Generator.PRODUCT_FILE));
			
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				productList.put(info[0], new Product(info[0], info[1], Double.parseDouble(info[2])));
			}
			
			reader.close();
			
			// Read order file and show order
			reader = new BufferedReader(new FileReader(Generator.ORDER_FILE));
			
			System.out.printf(" %-15s%-25s%-10s%15s%15s\n",
					"ProductID","ProductName","Quantity","PricePerUnit","Total");
			
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				int unit = Integer.parseInt(info[2]);
				Product product = productList.get(info[0]);

				if(product != null)
					System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f\n", 
							product.productID, product.productName, unit, 
							product.productPrice, product.getTotalPrice(unit));
			}
			
			reader.close();
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}

