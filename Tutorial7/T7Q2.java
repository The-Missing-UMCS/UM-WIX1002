package Tutorial7;

import java.io.*;
import java.util.Scanner;

public class T7Q2 {
	public static void main(String[] args) {

	}
	
	public void correctA() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream("d:/data/matrix.txt"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void correctB() {
		try {
			 PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
			 out.close();
		} catch (FileNotFoundException e) {
			 System.out.println("Problem with file output");
		}
	}
	
	public void correctC() {
		try {
			int num;
			Scanner a = new Scanner(new FileInputStream("data.dat"));
			num = a.nextInt();
			a.close();
		} catch (Exception ex) {}
	}
	
	public void correctD() {
		try {
			ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("data.dat"));
			o.writeChar('A');
			o.close();
		} catch (Exception ex) {}
		
	}	
}
