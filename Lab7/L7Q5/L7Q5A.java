package Lab7.L7Q5;

import java.io.*;

import Lab7.Generator;

public class L7Q5A {
    public static void main(String[] args) {

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(Generator.PERSON_FILE))) {
            int num = input.readInt();

            String[] nameArr = new String[num];
            int[] ageArr = new int[num];
            char[] genderArr = new char[num];
            int[] indexArr = new int[num];

            for (int i = 0; i < num; i++) {
                indexArr[i] = i;
                nameArr[i] = input.readUTF();
                ageArr[i] = input.readInt();
                genderArr[i] = input.readChar();
            }

            sortIndexByName(indexArr, nameArr);
            prettyPrint(indexArr, nameArr, ageArr, genderArr);

        } catch (Exception ex) { }
    }

    public static void sortIndexByName(int[] index, String[] name) {
        for (int i = 0; i < index.length; i++)
            for (int j = 0; j < index.length - i - 1; j++)
                if (name[j].compareTo(name[j + 1]) > 0) {
                    int tmp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = tmp;
                }
    }

    public static void prettyPrint(int[] index, String[] name, int[] age, char[] gender) {
        final String FORMAT = " | %13s  | %4s | %7s |\n";
        String line = String.format(FORMAT, "-".repeat(13), "-".repeat(4), "-".repeat(6));

        System.out.printf(FORMAT, "Name", "Age", "Gender");
        System.out.print(line);
        for (int i : index)
            System.out.printf(FORMAT, name[i], age[i], gender[i]);
        System.out.print(line);
    }
}
