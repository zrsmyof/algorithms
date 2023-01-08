package com.zrs.algorithms;

import com.zrs.algorithms.searching.BinarySearching;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Random;

public class SearchingTest {

    @Test
    public void binarySearchingTest() {
        int[] randomIntArray = new int[100];

        Random random = new Random();
        for (int i = 0; i < randomIntArray.length; i++) {
            randomIntArray[i] = random.nextInt(100);
        }

        ZonedDateTime start = ZonedDateTime.now();
        int elementIndex = BinarySearching.sortAndSearchBinaryAndRecursively(randomIntArray, 8);
        ZonedDateTime end = ZonedDateTime.now();
        long millis = end.toInstant().toEpochMilli() - start.toInstant().toEpochMilli();
        System.out.println("Time searching: " + millis);
        System.out.println("Found element placed at index: " + elementIndex);
    }

}
