package com.umwix1002.solution.lab.lab07;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import static com.umwix1002.solution.lab.Properties.*;

public class l7q2a {
    public static void main(String[] args) throws Exception {
        try (
            InputStream inputStream = new URL("http://fsktm.um.edu.my").openConnection().getInputStream();
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(chainDir(LAB7, OUTPUT, "fkstm.htm"))
        ) {
            while (scanner.hasNext()) {
                writer.println(scanner.nextLine());
            }
        }
    }
}
