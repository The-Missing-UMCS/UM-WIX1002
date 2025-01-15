package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model;

public record Address(String address) {
    private static int nextNonWhitespaceIndex(String address, int inclusiveStart) {
        int length = address.length();
        while (inclusiveStart < length && Character.isWhitespace(address.charAt(inclusiveStart))) {
            inclusiveStart++;
        }
        boolean hasReachedEnd = inclusiveStart == length;
        return hasReachedEnd ? -1 : inclusiveStart;
    }

    public boolean sameAs(Address o) {
        int index1 = -1, index2 = -1;
        while (true) {
            index1 = nextNonWhitespaceIndex(address, index1 + 1);
            index2 = nextNonWhitespaceIndex(o.address, index2 + 1);

            // If index1 == index2 == -1, this means both addresses
            // have reached their end and they are equal
            if (index1 == -1 || index2 == -1) {
                return index1 == index2;
            }

            if (Character.toLowerCase(address.charAt(index1)) != Character.toLowerCase(o.address.charAt(index2))) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Address a1 = new Address("No. 67Jalan BP 10 / 12 Kelang");
        Address a2 = new Address("No. 67 Jalan BP10/12 Kelang");
        System.out.println(a1.sameAs(a2));
    }
}
