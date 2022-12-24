package com.zrs.algorithms;

import java.util.Arrays;

/**
 * Implementations of different popular sorting algorithms
 */
public class Sorting {

    /**
     * Searching min element in array
     * Max complexity = O(n)
     * Min complexity = O(n)
     * Avg complexity = O(n)
     */
    public static int searchMinElementInArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int minElement = numbers[0];
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minElement) {
                minElement = numbers[i];
                minIndex = i;
            }
        }
        System.out.println("Minimum element is element number " + minIndex + " with value = " + minElement);
        return minElement;
    }

    /**
     * Bubble searching
     * Max complexity = O(n2)
     * Min complexity = O(n)
     * Avg complexity = O(n2)
     */
    public static int[] bubbleSorting(int[] numbers) {
        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        if (numbers == null || numbers.length < 2) {
            System.out.println("Array is empty or length is less than 2");
        } else {
            boolean arrayIsSorted = false;
            while (!arrayIsSorted) {
                arrayIsSorted = true;
                for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                        int tempNumber = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = tempNumber;
                        arrayIsSorted = false;
                    }
                }
            }
        }
        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }
}
