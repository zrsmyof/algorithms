package com.zrs.algorithms.sorting;

public class MergeSorting {

    /**
     * Merge Sort
     * Max complexity = O(n*log(n))
     * Min complexity = O(n*log(n))
     * Avg complexity = O(n*log(n))
     */
    public static int[] mergeSorting(int[] numbers) {
//        System.out.println("Array before sorting: " + Arrays.toString(numbers));
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

//                System.out.println("Merge sorting step. Current array: " + Arrays.toString(currentArray));
//                System.out.println("Merge sorting step. Destination array: " + Arrays.toString(destinationArray));
            }
            numbers = currentArray;
        }
//        System.out.println("Array after sorting: " + Arrays.toString(numbers));
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
