package com.umwix1002.solution.lab.lab5.l5q5;

import com.umwix1002.solution.lab.constants.CommonConstant;

import java.util.*;

/**
 * This class demonstrates searching algorithms with self-defined {@code SearchResult}
 * and {@code SearchCriteria} classes. The version 1 code is simpler but lacks maintainability 
 * The refactoring process emphasizes writing modular code, adhering to 
 * the Single Responsibility Principle (SRP) and Open-Closed Principle (OCP).
 * Lombok is used to simplify the creation of getters and setters.
 *
 * @see <a href="https://www.baeldung.com/java-lombok">Lombok</a>
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        int[] randomNumbers = new Random().ints(20, 0, 101).toArray();
        System.out.println("A list of 20 random integers within 0 and 20: " + Arrays.toString(randomNumbers));
        System.out.println("Array in descending order: " + Arrays.toString(Arrays.stream(randomNumbers)
            .boxed().sorted(Comparator.reverseOrder()).toArray()));
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to search: ");
            int target = scanner.nextInt();
            SearchResult binarySearchResult = binarySearch(randomNumbers, target);
            
            System.out.printf("%d %s found. Binary search - %d loops(s)\n", 
                target, binarySearchResult.getResult() == null ? "not" : CommonConstant.BLANK, 
                binarySearchResult.getNumberOfLoops());
            
            SearchResult linearSearchResult = linearSearch(randomNumbers, target);
            System.out.printf("%d %s found. Linear search - %d loops(s)\n", 
                    target, linearSearchResult.getResult() == null ? "not" : CommonConstant.BLANK, 
                    linearSearchResult.getNumberOfLoops());
        }
    }

    /**
     * Searches for a key in an array using binary search.
     * The array is sorted before searching to ensure correct results.
     *
     * @param arr the array to search (can be sorted or unsorted)
     * @param key the key to search for
     * @return a {@link SearchResult} containing the index of the key if found, otherwise null
     */
    public static SearchResult binarySearch(int[] arr, int key) {
        SearchResult searchResult = getDefaultSearchResult(arr, key);
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int low = 0, high = arr.length - CommonConstant.ONE, mid = 0;
        while(low <= high) {
            searchResult.loop();
            // You might want to use (low + high) / 2, but it might cause overflow.
            mid = low + (high - low) / CommonConstant.TWO;
            if(copy[mid] == key) {
                searchResult.setResult(mid);
                return searchResult;
            } else if(copy[mid] < key) {
                low = mid + CommonConstant.ONE;
            } else {
                high = mid - CommonConstant.ONE;
            }
        }
        return searchResult;
    }

    /**
     * Searches for a key in an array using linear search.
     * The array can be sorted or unsorted.
     *
     * @param arr the array to search
     * @param key the key to search for
     * @return a {@link SearchResult} containing the index of the key if found, otherwise null
     */
    public static SearchResult linearSearch(int[] arr, int key) {
        SearchResult searchResult = getDefaultSearchResult(arr, key);
        for(int i = CommonConstant.ZERO; i < arr.length; i++) {
            searchResult.loop();
            if(arr[i] == key) {
                searchResult.setResult(i);
                return searchResult;
            }
        }
        return searchResult;
    }

    /**
     * Retrieves a default {@link SearchResult} for a given array and key.
     *
     * @param arr the array to search
     * @param key the key to search for
     * @return a {@link SearchResult} containing the sorted array and the key wrapped in a {@link SearchCriteria}
     */
    private static SearchResult getDefaultSearchResult(int[] arr, int key) {
        SearchCriteria searchCriteria = SearchCriteria.of(arr, key);
        return SearchResult.of(searchCriteria);
    }
}
