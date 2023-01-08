package com.zrs.algorithms.searching;

import com.zrs.algorithms.sorting.MergeSorting;

import java.util.Arrays;

public class BinarySearching {

    public static int sortAndSearchBinaryAndRecursively(int[] arr, int element) {
        System.out.println("Initial array: " + Arrays.toString(arr));
        MergeSorting.mergeSorting(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        return callRecursiveSearch(arr, 0, arr.length - 1, element);
    }

    private static int callRecursiveSearch(int[] arr, int startIdx, int endIdx, int element) {
        if (startIdx <= endIdx) {
            int middleIdx = startIdx + (endIdx - startIdx) / 2;
            if (arr[middleIdx] == element) {
                return middleIdx;
            }

            if (arr[middleIdx] < element) {
                return callRecursiveSearch(arr, middleIdx + 1, endIdx, element);
            } else {
                return callRecursiveSearch(arr, startIdx, middleIdx - 1, element);
            }
        }
        return -1;
    }
}
