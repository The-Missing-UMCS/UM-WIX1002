package com.umwix1002.solution.lab.lab08.l8q1b;

import java.util.*;

public class Number {

    private static final Random RANDOM = new Random();

    private final Integer size;
    private final Integer upperBound;
    private final Integer lowerBound;
    private final Boolean isDuplicateAllowed;
    private final int[] array;

    public Number() {
        this(null, null, null, null);
    }

    public Number(int size) {
        this(size, null, null, null);
    }

    public Number(int size, int upperBound) {
        this(size, null, upperBound, null);
    }

    /*
     * We're going to define a centralized default values here rather than
     * scatter them all around our codebase
     */
    public Number(Integer size,
                  Integer lowerBound,
                  Integer upperBound,
                  Boolean isDuplicateAllowed) {
        this.size = Objects.requireNonNullElse(size, 10);
        this.upperBound = Objects.requireNonNullElse(upperBound, 100);
        this.lowerBound = Objects.requireNonNullElse(lowerBound, 0);
        this.isDuplicateAllowed = Objects.requireNonNullElse(isDuplicateAllowed, false);
        this.array = generateIntArray();
    }

    private int[] generateIntArray() {
        if (isDuplicateAllowed) {
            return RANDOM.ints(size, lowerBound, upperBound + 1).toArray();
        } else {
            Set<Integer> set = new HashSet<>();
            while (set.size() < size) {
                set.add(RANDOM.nextInt());
            }
            return set.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public int[] getNumbers() {
        /*
         * We are going to return a copy of array to avoid others from
         * accidentally modifying our original array.
         */
        return Arrays.copyOf(array, array.length);
    }
}
