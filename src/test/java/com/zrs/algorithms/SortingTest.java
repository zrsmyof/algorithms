package com.zrs.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortingTest {

    @ParameterizedTest
    @MethodSource("minArrayElementArguments")
    public void searchMinElementInArrayTest(int[] numbers, int expectedOutPut) {

        int result = Sorting.searchMinElementInArray(numbers);
        assertEquals(expectedOutPut, result);
    }

    @ParameterizedTest
    @MethodSource("bubbleSearchingArguments")
    public void bubbleSearchingTest(int[] numbers, int[] expectedOutPut) {

        int[] result = Sorting.bubbleSorting(numbers);
        assertArrayEquals(expectedOutPut, result);
    }

    static Stream<Arguments> minArrayElementArguments() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 2),
                arguments(new int[]{3, 2, 4}, 2),
                arguments(new int[]{3, 3}, 3)
        );
    }

    static Stream<Arguments> bubbleSearchingArguments() {
        return Stream.of(
                arguments(new int[]{15, 2, 7, 11, 18, 9, 4, 3}, new int[]{2, 3, 4, 7, 9, 11, 15, 18}),
                arguments(new int[]{3, 2, 4}, new int[]{2, 3, 4}),
                arguments(new int[]{3, 3}, new int[]{3, 3})
        );
    }
}
