package wix1002_2024_1.Q5.util;

public class AddressUtil {
    public static boolean areAddressesEqual(String address1, String address2) {
        int index1 = -1, index2 = -1;
        int length1 = address1.length(), length2 = address2.length();
        while (index1 < length1 && index2 < length2) {
            index1 = nextNonWhitespaceIndex(address1, ++index1);
            index2 = nextNonWhitespaceIndex(address2, ++index2);
            // If index1 == index2 == -1, this means both addresses
            // have reached their end and they are equal
            if (index1 == -1 || index2 == -1)
                return index1 == index2;
            if (Character.toLowerCase(address1.charAt(index1)) != Character.toLowerCase(address2.charAt(index2)))
                return false;
        }
        return true;
    }

    private static int nextNonWhitespaceIndex(String text, int startIndex) {
        int length = text.length();
        while (startIndex < length && Character.isWhitespace(text.charAt(startIndex)))
            startIndex++;
        return startIndex == length ? -1 : startIndex;
    }
}