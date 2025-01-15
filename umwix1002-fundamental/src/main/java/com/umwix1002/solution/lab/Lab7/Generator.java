package com.umwix1002.solution.lab.Lab7;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {
    public static final String ROOT = "umwix1002-fundamental/src/main/java/com/umwix1002/solution/lab/Lab7/io_files/";
    public static final String COURSE_FILE = ROOT + "coursename.dat";
    public static final String TEXT_FILE = ROOT + "text.txt";
    public static final String ORDER_FILE = ROOT + "order.txt";
    public static final String PRODUCT_FILE = ROOT + "product.txt";
    public static final String PERSON_FILE = ROOT + "person.dat";

    @SneakyThrows
    public static void main(String[] args) {
        // 1. Create the directory if not exists
        Path path = Paths.get("./Lab7/io_files/");

        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.out.println(new File("./Lab7/io_files/").mkdir());
        }

        // 2. Prepare the content
        String products = Stream.of(
            Product.of("SK079", "Dettol Natural", 4.99),
            Product.of("SK013", "100 Plus", 6.49),
            Product.of("SK088", "Jasmine Pearl", 37.99),
            Product.of("SK042", "Ayamas Nuget Crispy", 9.99),
            Product.of("SK066", "Ali Cafe", 8.99)
        ).map(Product::toString).collect(Collectors.joining(System.lineSeparator()));

        String orders = Stream.of(
            Order.of("SK079", "Dettol Natural", 20),
            Order.of("SK013", "100 Plus", 74),
            Order.of("SK088", "Jasmine Pearl", 27),
            Order.of("SK042", "Ayamas Nuget Crispy", 60),
            Order.of("SK066", "Ali Cafe", 79)
        ).map(Order::toString).collect(Collectors.joining(System.lineSeparator()));

        String textContent = """
            Hoping to fight this was 28-year-old Park Ji-hyun, a women's rights campaigner,
            who, following the divisive election, was asked to lead the liberal opposition party.
            The party told her they needed her help to reform politics and represent young women.
            And so, despite having never been a politician, she agreed.
            """;

        // 3. Generate the files
        writeCourseFile();
        writeIfNotExists(TEXT_FILE, textContent);
        writeIfNotExists(PRODUCT_FILE, products);
        writeIfNotExists(ORDER_FILE, orders);
    }

    @SneakyThrows
    private static void writeIfNotExists(String filename, String content) {
        generateIfNotExists(filename, () -> {
            var lines = Arrays.asList(content.split("\n"));
            try {
                Files.write(Path.of(filename), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @SneakyThrows
    private static void writeCourseFile() {
        generateIfNotExists(COURSE_FILE, () -> {
            try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(COURSE_FILE))) {
                writer.writeObject("WXES1116,Programming I");
                writer.writeObject("WXES1115,Data Structure");
                writer.writeObject("WXES1110,Operating System");
                writer.writeObject("WXES1112,Computing Mathematics I");
            } catch (IOException e) {
                throw new RuntimeException("Error writing to course file: " + COURSE_FILE, e);
            }
        });
    }


    private static void generateIfNotExists(String filename, Runnable generator) {
        if (!new File(filename).exists()) {
            generator.run();
        }
    }

    @AllArgsConstructor(staticName = "of")
    static class Product {
        private String id;
        private String name;
        private double price;

        @Override
        public String toString() {
            return String.format("%s,%s,%.2f", id, name, price);
        }
    }

    @AllArgsConstructor(staticName = "of")
    static class Order {
        private String id;
        private String name;
        private int quantity;

        @Override
        public String toString() {
            return String.format("%s,%s,%d", id, name, quantity);
        }
    }
}
