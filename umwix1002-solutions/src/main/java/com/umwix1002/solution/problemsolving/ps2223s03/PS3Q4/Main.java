package com.umwix1002.solution.problemsolving.ps2223s03.PS3Q4;

import java.io.*;

public class Main {
	private static final String DEFAULT_BIN_FILE_PATH = "umwix1002-core/src/main/java/com/umwix1002/solution/problemsolving/Problem_Solving_3/io_files/Q4.dat";

	public static void main(String[] args) {
		// 1. Prepare the binary file
		boolean isDefault = true;
        String binFilePath = isDefault ? DEFAULT_BIN_FILE_PATH : chooseFile();
        writeBinaryFile(binFilePath);

		// 2. Read the binary file
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(binFilePath))) {
            while (true) {
                DayOfTheWeek dayOfTheWeek = new DayOfTheWeek(input.readInt(), input.readInt(), input.readInt());
                System.out.printf("%d/%d/%d is %s\n",
                    dayOfTheWeek.getDayOfMonth(), dayOfTheWeek.getMonth(), dayOfTheWeek.getYear(),
                    (dayOfTheWeek.isValidDate() ? ("on " + dayOfTheWeek.getDayOfWeek()) : "invalid Input"));
            }
        } catch (EOFException ignored) {
        } catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void writeBinaryFile(String file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            // Each record in the binary file contains q, m and y in order
            output.writeInt(25);
            output.writeInt(3);
            output.writeInt(2017);
            output.writeInt(29);
            output.writeInt(2);
            output.writeInt(2100);
            output.writeInt(19);
            output.writeInt(1);
            output.writeInt(2017);
            output.writeInt(31);
            output.writeInt(9);
            output.writeInt(2015);
            output.writeInt(31);
            output.writeInt(5);
            output.writeInt(2017);
            output.writeInt(29);
            output.writeInt(2);
            output.writeInt(2016);
        } catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
        }
    }

	private static String chooseFile() {
		String binFilePath = "";
//		try {
//			JFileChooser chooser = new JFileChooser("./");
//			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//			chooser.showOpenDialog(null);
//			binFilePath = chooser.getSelectedFile().getAbsolutePath() + "\\Q4.dat";
//		} catch (Exception ex) {
//			binFilePath = "umwix1002-core/src/main/java/com/umwix1002/solution/problemsolving/Problem_Solving_3/io_files/Q4.dat";
//		}
		return binFilePath;
	}
}