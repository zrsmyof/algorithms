package com.zrs.algorithms.sorting;

public class BubbleSorting {

    /**
     * Bubble searching
     * Max complexity = O(n2)
     * Min complexity = O(n)
     * Avg complexity = O(n2)
     */
    public static int[] bubbleSorting(int[] numbers) {
//        System.out.println("Array before sorting: " + Arrays.toString(numbers));
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
//        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }

    public static int[] bubbleSortingOptimized(int[] numbers) {
//        System.out.println("Array before sorting: " + Arrays.toString(numbers));
        if (numbers == null || numbers.length < 2) {
            System.out.println("Array is empty or length is less than 2");
        } else {
            boolean arrayIsSorted = false;
            int j = numbers.length;
            while (j > 1 && !arrayIsSorted) {
                arrayIsSorted = true;
                for (int i = 0; i < j - 1; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                        int tempNumber = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = tempNumber;
                        arrayIsSorted = false;
                    }
                }
                j--;
            }
        }
//        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }
}
