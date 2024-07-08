package wix1002_2017_1.Q3;

public class Q3 {
    static final char ASCENDING = '>';
    static final char DESCENDING = '<';
    static final int MIN = 65;
    static final int MAX = 122;
    static final int STRING_LENGTH = 6;

    public static void main(String[] args) {
        char[] string = generateRandomString(STRING_LENGTH);
        System.out.println("The string generated is " + new String(string));

        sortCharacters(string, ASCENDING);
        System.out.println("String sorted in ascending order: " + new String(string));

        sortCharacters(string, DESCENDING);
        System.out.println("String sorted in descending order: " + new String(string));
    }

    public static char[] generateRandomString(int length) {
        char[] string = new char[length];
        for (int i = 0; i < length; i++) {
            while (true) {
                int rand = (int) (Math.random() * (MAX - MIN + 1) + MIN);
                if (rand < 91 || rand > 96) {
                    string[i] = (char) rand;
                    break;
                }
            }
        }
        return string;
    }

    public static void sortCharacters(char[] characters, char order) {
        if (order == ASCENDING) {
            bubbleSort(characters, 1);
        } else if (order == DESCENDING) {
            bubbleSort(characters, -1);
        }
    }

    public static void bubbleSort(char[] characters, int flag) {
        for (int i = 0; i < characters.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < characters.length - i - 1; j++) {
                if (flag * characters[j] > flag * characters[j + 1]) {
                    char temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
