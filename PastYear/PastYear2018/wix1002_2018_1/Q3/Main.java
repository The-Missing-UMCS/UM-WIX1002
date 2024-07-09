package wix1002_2018_1.Q3;

import java.util.Scanner;

public class Main {
    static final int VERTICAL = 1;
    static final int HORIZONTAL = 2;

    public static void main(String[] args) {
        int fontSize, format;
        char fontType;
        Scanner sc = new Scanner(System.in);

        fontSize = getIntInput(sc, "Enter font size: ");
        System.out.print("Enter font type: ");
        fontType = sc.nextLine().charAt(0);
        format = getIntInput(sc, "Enter format [1 - Vertical, 2 - Horizontal]: ");
        System.out.println(eightString(fontSize, String.valueOf(fontType), format));
    }

    static int getIntInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static String eightString(int fontSize, String fontType, int format) {
        int horizontalLength = 2 + format / 2 + format * fontSize;

        StringBuilder sb = new StringBuilder();

        sb.append(fontType.repeat(horizontalLength))
                .append(System.lineSeparator());

        int numberOfVerticalSegments = (format == VERTICAL ? 2 : 1);

        for (int verticalSegmentIndex = 0; verticalSegmentIndex < numberOfVerticalSegments; verticalSegmentIndex++) {
            for (int lineIndex = 0; lineIndex < fontSize; lineIndex++) {
                sb.append(fontType);
                for (int horizontalSegmentIndex = 0; horizontalSegmentIndex < format; horizontalSegmentIndex++)
                    sb.append(" ".repeat(fontSize)).append(fontType);
                sb.append(System.lineSeparator());
            }
            sb.append(fontType.repeat(horizontalLength))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
