package Lab10;

import java.io.*;

public class L10_SRC {
	public static void main(String[] args) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Users\\User\\Desktop\\plainText.txt");
			writer.print(
					"At least 16 people including children have been killed after a landslide enveloped a holiday campsite in "
					+ "Malaysia's Selangor state, officials say. Families were sleeping in their tents when a landslide"
					+ "happened around 03:00 Friday (19:00 GMT Thursday) at a farm stay in Batang Kali township.\n"
					+ "Hundreds of rescuers spent Friday digging through mud to find survivors.\n"
					+ "More than 90 people had been staying at the base.\n"
					+ "Local media reported the farm's managers saying at least 30 children and 51 adults had been registered for an overnight stay.\n"
					+ "The landslide began up a slope more than 30m (100ft) higher than the campsite, and rolled through an acre of land.");
			writer.close();
			System.out.println("Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
