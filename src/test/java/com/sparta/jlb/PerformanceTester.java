package com.sparta.jlb;

import com.sparta.jlb.sorters.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {

    private static int[] arrayToSort;
    private int[] unsortedArray;

    @BeforeClass
    public static void setupClass(){
        Random random = new Random();
        arrayToSort = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            arrayToSort[i]=random.nextInt(100_000);
        }
    }

    @Before
    public void setup(){
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBubbleSorter(){
        Sorter sorter = new BubbleSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(), end-start, sortedArray);

    }

    @Test
    public void testQuickSorter(){
        Sorter sorter = new QuickSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(), end-start, sortedArray);
    }

    @Test
    public void testMergeSorter(){
        Sorter sorter = new MergeSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(), end-start, sortedArray);

    }

    @Test
    public void testBinarySorter(){
        Sorter sorter = new BinarySorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(), end-start, sortedArray);

    }

    private void printResults(String sorter, long time, int[] unsortedArray){
        DecimalFormat decimalFormat = new DecimalFormat("###,###.####");
        System.out.println(sorter + ":" );
        System.out.println(Arrays.toString(unsortedArray));
        System.out.println("Time taken: " + (decimalFormat.format(time))+ " nano seconds");
    }
}
