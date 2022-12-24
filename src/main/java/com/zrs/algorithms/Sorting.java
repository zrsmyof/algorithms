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
        System.out.println("Array before sorting: " + Arrays.toString(numbers));
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

    /**
     * Quick Sort
     * Max complexity = O(n2)
     * Min complexity = O(n)
     * Avg complexity = O(n*log(n))
     */
    public static int[] quickSorting(int[] numbers) {
        System.out.println("Array before sorting: " + Arrays.toString(numbers));
        if (numbers == null || numbers.length < 2) {
            System.out.println("Array is empty or length is less than 2");
        } else {
            quickPartitionSorting(numbers, 0, numbers.length - 1);
        }
        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }

    private static void quickPartitionSorting(int[] numbers, int startIdx, int endIdx) {
        System.out.println("Sorting step: " + Arrays.toString(numbers) +
                " startIdx = " + startIdx + "; endIdx = " + endIdx);
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

    /**
     * Merge Sort
     * Max complexity = O(n*log(n))
     * Min complexity = O(n*log(n))
     * Avg complexity = O(n*log(n))
     */
    public static int[] mergeSorting(int[] numbers) {
        System.out.println("Array before sorting: " + Arrays.toString(numbers));
        if (numbers == null || numbers.length < 2) {
            System.out.println("Array is empty or length is less than 2");
        } else {
            int[] tmp;
            int[] currentArray = numbers;
            int[] destinationArray = new int[numbers.length];

            int size = 1;
            while (size < numbers.length) {
                for (int i = 0; i < numbers.length; i += 2 * size) {
                    merge(currentArray, i, currentArray, i + size, destinationArray, i, size);
                }

                tmp = currentArray;
                currentArray = destinationArray;
                destinationArray = tmp;

                size = size * 2;

                System.out.println("Merge sorting step. Current array: " + Arrays.toString(currentArray));
                System.out.println("Merge sorting step. Destination array: " + Arrays.toString(destinationArray));
            }
            numbers = currentArray;
        }
        System.out.println("Array after sorting: " + Arrays.toString(numbers));
        return numbers;
    }

    private static void merge(int[] firstArray, int firstArrayStartIdx,
                              int[] secondArray, int secondArrayStartIdx,
                              int[] destArray, int destArrayStartIdx, int size) {
        int index1 = firstArrayStartIdx;
        int index2 = secondArrayStartIdx;

        int firstArrayEndIdx = Math.min(firstArrayStartIdx + size, firstArray.length);
        int secondArrayEndIdx = Math.min(secondArrayStartIdx + size, secondArray.length);

        if (firstArrayStartIdx + size > firstArray.length) {
            for (int i = firstArrayStartIdx; i < firstArrayEndIdx; i++) {
                destArray[i] = firstArray[i];
            }
            return;
        }

        //iteration count is equivalent for elements count in both merging arrays
        int iterationCount = firstArrayEndIdx - firstArrayStartIdx + secondArrayEndIdx - secondArrayStartIdx;

        for (int i = destArrayStartIdx; i < destArrayStartIdx + iterationCount; i++) {
            if (index1 < firstArrayEndIdx && (index2 >= secondArrayEndIdx || firstArray[index1] < secondArray[index2])) {
                destArray[i] = firstArray[index1];
                index1++;
            } else {
                destArray[i] = secondArray[index2];
                index2++;
            }
        }
    }
}
