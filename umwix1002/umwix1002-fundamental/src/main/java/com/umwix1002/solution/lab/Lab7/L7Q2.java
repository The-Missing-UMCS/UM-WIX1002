package Lab7;

import java.util.Scanner;
import java.net.URL;
import java.io.*;
import java.net.URLConnection;

public class L7Q2 {
	public static void main(String[] args) {
		 try {
			 URL link = new URL("http://fsktm.um.edu.my");
			 URLConnection connect = link.openConnection();
			 InputStream stream = connect.getInputStream();
			 Scanner scanner = new Scanner(stream);
			 
			 PrintWriter writer = new PrintWriter("../WIX1002/io_files/fsktm.htm");
			 // The path "WIX1002" can be replaced by the project name.
			 
			 while(scanner.hasNext()) {
				 writer.println(scanner.nextLine());
			 }
			 
			 writer.close();
			 scanner.close();
		 }
		 catch (IOException e) {
			 System.out.println("IO Error:" + e.getMessage());
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
	}
}
