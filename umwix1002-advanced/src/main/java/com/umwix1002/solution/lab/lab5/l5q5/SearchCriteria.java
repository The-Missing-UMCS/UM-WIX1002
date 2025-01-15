package com.umwix1002.solution.lab.lab5.l5q5;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

/**
 * This class stores the search criteria for the search method.
 * It contains a copy of the original array to preserve a history of searches,
 * reflecting the parameters specified by the user rather than the original array.
 *
 * @author Ng Zhi Yang
 */
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchCriteria {
    private int[] array;
    private int target;

    /**
     * Creates a new {@link SearchCriteria} object with the specified array and target.
     * A copy of the original array is created to maintain a history of the search,
     * reflecting the parameters passed by the user.
     *
     * @param arr the array to search
     * @param target the target value to search for
     * @return a new {@link SearchCriteria} object
     */
    public static SearchCriteria of(int[] arr, int target) {
        SearchCriteria searchCriteria = new SearchCriteria();
        int[] copy = Arrays.copyOf(arr, arr.length);
        searchCriteria.setArray(copy);
        searchCriteria.setTarget(target);
        return searchCriteria;
    }
}
