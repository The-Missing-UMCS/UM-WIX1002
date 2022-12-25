package com.fyiernzy.Lab7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

// Credit to: https://gitlab.com/fop2022/group05/-/blob/main/22004835/lab%207/L7Q6.java

public class L7Q6_Multiple_Array {
    public static void main(String[] args) {
        String[][] productArr = loadDataMatrix("../WIX1002/io_files/Lab07/product.txt");
        String[][] orderArr = loadDataMatrix("../WIX1002/io_files/Lab07/order.txt");
        showOrder(productArr, orderArr);
    }

    public static int findIndex(String orderId, String[][] productArr) {
        for(int i = 0; i < productArr.length; i++){
            if(productArr[i][0].equals(orderId))
                return i;
        }
        
        return -1;
    }
    
    public static String[][] loadDataMatrix(String fromFile) {
    	// Initialize a matrix. The matrix may expand later.
    	String[][] matrix = new String[3][3];
    	
    	try (Scanner scanner = new Scanner(new FileInputStream(fromFile))) {

            for(int i = 0; scanner.hasNextLine(); i++) {
            	if (i == matrix.length) {
            		// Expand the matrix by 1 when reaches it's limit.
            		matrix = Arrays.copyOf(matrix, i + 1);
            		i--; continue;
            	}
            	
            	matrix[i] = scanner.nextLine().split(",");
            }
                
            
    	} catch (IOException ex) { ex.printStackTrace(); }
    	
    	return matrix;
    }
    
    public static void showOrder(String[][] productMatrix, String[][] orderMatrix) {
    	// Header
    	System.out.printf(" %-15s%-25s%-10s%15s%15s\n",
				"ProductID","ProductName","Quantity","PricePerUnit","Total");
    	
    	for(int i = 0 ; i < orderMatrix.length; i++){
            int index = findIndex(orderMatrix[i][1], productMatrix);

            if(index > 0) {
            	// For the sake of readability
            	String[] product = productMatrix[index];
            	int count = Integer.parseInt(orderMatrix[i][2]);
            	double price = Double.parseDouble(product[2]);
            	
            	// Print order list
                System.out.printf(" %-15s%-25s%-10s%15s%15.2f\n", 
                		product[0], product[1], count, product[2], price * count);
            }
        }
    }
}


