package com.zrs.algorithms.common;

public class ArrayMinElement {

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
}
