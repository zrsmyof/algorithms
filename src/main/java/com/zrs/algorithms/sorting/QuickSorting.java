package com.zrs.algorithms.sorting;

import java.util.Arrays;

public class QuickSorting {

    /**
     * Quick Sort
     * Max complexity = O(n2)
     * Min complexity = O(n)
     * Avg complexity = O(n*log(n))
     */
    public static int[] quickSorting(int[] numbers) {
//        System.out.println("Array before sorting: " + Arrays.toString(numbers));
        if (numbers == null || numbers.length < 2) {
            System.out.println("Array is empty or length is less than 2");
        } else {
            quickPartitionSorting(numbers, 0, numbers.length - 1);
        }
//        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }

    private static void quickPartitionSorting(int[] numbers, int startIdx, int endIdx) {
//        System.out.println("Sorting step: " + Arrays.toString(numbers) +
//                " startIdx = " + startIdx + "; endIdx = " + endIdx);
        if (startIdx < endIdx) {
            int middleIdx = partition(numbers, startIdx, endIdx);

            quickPartitionSorting(numbers, startIdx, middleIdx - 1);
            quickPartitionSorting(numbers, middleIdx, endIdx);
        }

    }

    /**
     * All elements those are less than startIdx element are moving to the left, others - to the right
     */
    private static int partition(int[] numbers, int startIdx, int endIdx) {
        int leftIdx = startIdx;
        int rightIdx = endIdx;

        int middleElement = numbers[startIdx];
        while (leftIdx <= rightIdx) {
            while (numbers[leftIdx] < middleElement) {
                leftIdx++;
            }
            while (numbers[rightIdx] > middleElement) {
                rightIdx--;
            }

            if (leftIdx <= rightIdx) {
                int tmp = numbers[leftIdx];
                numbers[leftIdx] = numbers[rightIdx];
                numbers[rightIdx] = tmp;
                leftIdx++;
                rightIdx--;
            }
            System.out.println("Partitioning step: " + Arrays.toString(numbers));
        }
        return leftIdx;
    }
}
