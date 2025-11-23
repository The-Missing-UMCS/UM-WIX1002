package com.umwix1002.solution.lab.lab07.l7q2;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class l7q2a {

    public static void main(String[] args) throws Exception {
        try (
            InputStream inputStream = URI.create("https://fsktm.um.edu.my").toURL().openStream();
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(chainDir(LAB7, IO_FILES, "fkstm.htm"))
        ) {
            while (scanner.hasNext()) {
                writer.println(scanner.nextLine());
            }
        }
    }
}
