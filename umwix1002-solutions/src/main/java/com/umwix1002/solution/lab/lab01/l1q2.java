package com.umwix1002.solution.lab.lab01;

import java.util.stream.IntStream;

/**
 * This class demonstrates different ways to print a list of information.
 * While L1Q2 is simple and straightforward, it's a good practice to get started.
 * Using printf is recommended for better control over spacing compared to using \t.
 */
public class l1q2 {
    public static void main(String[] args) {
        // Step 1: Using println
        System.out.println("Name          : name");
        System.out.println("Matric Number : matric number");
        System.out.println("Address       : address");
        System.out.println("Email         : email");
        System.out.println("Contact       : contact");
        System.out.println("Instagram     : instagram");

        // Step 2: Introduce variable
        String name = "name";
        String matriculationNo = "matric number";
        String address = "address";
        String email = "email";
        String contact = "contact";
        String instagram = "instagram";

        System.out.println("Name          : " + name);
        System.out.println("Matric Number : " + matriculationNo);
        System.out.println("Address       : " + address);
        System.out.println("Email         : " + email);
        System.out.println("Contact       : " + contact);
        System.out.println("Instagram     : " + instagram);

        // Step 3: Using printf for granular control
        String nameLabel = "Name";
        String matriculationNoLabel = "Matric Number";
        String addressLabel = "Address";
        String emailLabel = "Email";
        String contactLabel = "Contact";
        String instagramLabel = "Instagram";

        System.out.printf("%-15s : %s\n", nameLabel, name);
        System.out.printf("%-15s : %s\n", matriculationNoLabel, matriculationNo);
        System.out.printf("%-15s : %s\n", addressLabel, address);
        System.out.printf("%-15s : %s\n", emailLabel, email);
        System.out.printf("%-15s : %s\n", contactLabel, contact);
        System.out.printf("%-15s : %s\n", instagramLabel, instagram);

        // Step 4: Using printf with pattern variable
        String pattern = "%-15s : %s\n";

        System.out.printf(pattern, nameLabel, name);
        System.out.printf(pattern, matriculationNoLabel, matriculationNo);
        System.out.printf(pattern, addressLabel, address);
        System.out.printf(pattern, emailLabel, email);
        System.out.printf(pattern, contactLabel, contact);
        System.out.printf(pattern, instagramLabel, instagram);

        // Step 5: Using array and loop
        String[] labels = {nameLabel, matriculationNoLabel, addressLabel, emailLabel, contactLabel, instagramLabel};
        String[] values = {name, matriculationNo, address, email, contact, instagram};
        int numberOfLabels = labels.length;
        for (int i = 0; i < numberOfLabels; i++) {
            System.out.printf(pattern, labels[i], values[i]);
        }

        // Step 6: Using stream
        IntStream.range(0, numberOfLabels)
                .forEach(i -> System.out.printf(pattern, labels[i], values[i]));
    }
}
