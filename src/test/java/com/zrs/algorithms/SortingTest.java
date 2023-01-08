package com.zrs.algorithms;

import com.zrs.algorithms.common.ArrayMinElement;
import com.zrs.algorithms.sorting.BubbleSorting;
import com.zrs.algorithms.sorting.MergeSorting;
import com.zrs.algorithms.sorting.QuickSorting;
import com.zrs.algorithms.sorting.SelectionSorting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortingTest {

    @ParameterizedTest
    @MethodSource("minArrayElementArguments")
    public void searchMinElementInArrayTest(int[] numbers, int expectedOutPut) {

        int result = ArrayMinElement.searchMinElementInArray(numbers);
        assertEquals(expectedOutPut, result);
    }

    @ParameterizedTest
    @MethodSource("arraySortingArguments")
    public void bubbleSortingTest(int[] numbers, int[] expectedOutPut) {

        assertArrayEquals(expectedOutPut, BubbleSorting.bubbleSorting(numbers));
        assertArrayEquals(expectedOutPut, BubbleSorting.bubbleSortingOptimized(numbers));
    }

    @Test
    public void bubbleOptimizedSortingTest() {
        int[] randomIntArray = new int[100_000];
        int[] randomIntArray2 = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < randomIntArray.length; i++) {
            randomIntArray[i] = random.nextInt(10_000_000);
        }
        randomIntArray2 = Arrays.copyOf(randomIntArray, randomIntArray.length);
        LocalTime start = LocalTime.now();
        System.out.println("Start time: " + start);
        BubbleSorting.bubbleSorting(randomIntArray);
        LocalTime end = LocalTime.now();
        System.out.println("End time: " + end);
        System.out.println("Time spent: " + Duration.between(start, end).getSeconds());

        start = LocalTime.now();
        System.out.println("Start time (optimized): " + start);
        BubbleSorting.bubbleSorting(randomIntArray2);
        end = LocalTime.now();
        System.out.println("End time (optimized): " + end);
        System.out.println("Time spent (optimized): " + Duration.between(start, end).getSeconds());
    }

    @ParameterizedTest
    @MethodSource("arraySortingArguments")
    public void selectionSortingTest(int[] numbers, int[] expectedOutPut) {

        assertArrayEquals(expectedOutPut, SelectionSorting.selectionSorting(numbers));
    }

    @ParameterizedTest
    @MethodSource("arraySortingArguments")
    public void quickSortingTest(int[] numbers, int[] expectedOutPut) {

        assertArrayEquals(expectedOutPut, QuickSorting.quickSorting(numbers));
    }

    @ParameterizedTest
    @MethodSource("arraySortingArguments")
    public void mergeSortingTest(int[] numbers, int[] expectedOutPut) {

        assertArrayEquals(expectedOutPut, MergeSorting.mergeSorting(numbers));
    }

    static Stream<Arguments> minArrayElementArguments() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 2),
                arguments(new int[]{3, 2, 4}, 2),
                arguments(new int[]{3, 3}, 3)
        );
    }

    static Stream<Arguments> arraySortingArguments() {
        return Stream.of(
                arguments(new int[]{15, 2, 7, 11, 18, 9, 4, 3}, new int[]{2, 3, 4, 7, 9, 11, 15, 18}),
                arguments(new int[]{3, 2, 4}, new int[]{2, 3, 4}),
                arguments(new int[]{3, 3}, new int[]{3, 3})
        );
    }
}
