package com.zrs.algorithms.sorting;

import java.util.Arrays;

public class SelectionSorting {

    /**
     * Selection Sort Algorithm
     * Max complexity = O(n2)
     * Min complexity = O(n2)
     * Avg complexity = O(n2)
     */
    public static int[] selectionSorting(int[] numbers) {
        System.out.println("Array before sorting: " + Arrays.toString(numbers));
        if (numbers == null || numbers.length < 2) {
            System.out.println("Array is empty or length is less than 2");
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                int minElement = numbers[i];
                int minIndex = i;
                //searching minimum element in the part of array
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] < minElement) {
                        minElement = numbers[j];
                        minIndex = j;
                    }
                }
                //moving minimum element to the first place
                if (i != minIndex) {
                    int tempNumber = numbers[i];
                    numbers[i] = numbers[minIndex];
                    numbers[minIndex] = tempNumber;
                }
            }
        }
        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }
}
