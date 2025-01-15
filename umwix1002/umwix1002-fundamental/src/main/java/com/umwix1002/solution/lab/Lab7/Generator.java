package Lab7;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Generator {
	public static final String ROOT = "./Lab7/io_files/";
	public static final String COURSE_FILE = ROOT + "coursename.dat";
	public static final String TEXT_FILE = ROOT + "text.txt";
	public static final String ORDER_FILE = ROOT + "order.txt";
	public static final String PRODUCT_FILE = ROOT + "product.txt";
	public static final String PERSON_FILE = ROOT + "person.dat";

	public static void main(String[] args) {
		Path path = Paths.get("./Lab7/io_files/");

		if (!Files.exists(path) || !Files.isDirectory(path))
			System.out.println(new File("./Lab7/io_files/").mkdir());

		if (!new File(COURSE_FILE).exists())
			generateCourseFile();

		if (!new File(TEXT_FILE).exists())
			generateTextFile();

		if (!new File(PRODUCT_FILE).exists())
			writeProductFile();

		if (!new File(ORDER_FILE).exists())
			writeOrderFile();
	}

	// Method 1
	public static void generateCourseFile() {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(COURSE_FILE))) {
			writer.writeObject("WXES1116,Programming I");
			writer.writeObject("WXES1115,Data Structure");
			writer.writeObject("WXES1110,Operating System");
			writer.writeObject("WXES1112,Computing Mathematics I");
			writer.flush();
		} catch (Exception ex) { }
	}

	public static void generateTextFile() {
		try (PrintWriter writer = new PrintWriter(TEXT_FILE)) {
			String newsExtract = "Hoping to fight this was 28-year-old Park Ji-hyun, a women's rights campaigner,\n"
					+ "who, following the divisive election, was asked to lead the liberal opposition party.\n"
					+ "The party told her they needed her help to reform politics and represent young women.\n"
					+ "And so, despite having never been a politician, she agreed.";
			writer.print(newsExtract);
		} catch (Exception ex) { }
	}

	public static void writeProductFile() {
		try(PrintWriter writer = new PrintWriter(PRODUCT_FILE)) {
			writer.println("SK079,Dettol Natural,4.99");
			writer.println("SK013,100 Plus,6.49");
			writer.println("SK088,Jasmine Pearl,37.99");
			writer.println("SK042,Ayamas Nuget Crispy,9.99");
			writer.println("SK066,Ali Cafe,8.99");
		} catch (Exception ex) { }
	}

	public static void writeOrderFile() {
		try (PrintWriter writer = new PrintWriter(ORDER_FILE)) {
			writer.println("SK079,Dettol Natural,20");
			writer.println("SK013,100 Plus,74");
			writer.println("SK088,Jasmine Pearl,27");
			writer.println("SK042,Ayamas Nuget Crispy,60");
			writer.println("SK066,Ali Cafe,79");
		} catch (Exception ex) { }
	}

	// Method 1
	// public static void generateCourseFile() {
	// var courseList = Map.of(
	// "WXES1116", "Programming I",
	// "WXES1115", "Data Structure",
	// "WXES1110", "Operating System",
	// "WXES1112", "Computing Mathematics I"
	// );

	// try(ObjectOutputStream writer = new ObjectOutputStream(new
	// FileOutputStream(COURSE_FILE))) {

	// for (Map.Entry<String, String> course : courseList.entrySet())
	// writer.writeObject(String.format("%s,%s", course.getKey(),
	// course.getValue()));

	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// }

}
