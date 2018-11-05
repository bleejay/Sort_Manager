package com.sparta.jlb;

import com.sparta.jlb.control.FactoryException;
import com.sparta.jlb.control.SortFactory;
import static org.junit.Assert.*;
import com.sparta.jlb.sorters.Sorter;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class TestSorters {

    private Sorter sorter;

    {
        try {
            sorter = SortFactory.getInstanceOf();
        } catch (FactoryException e) {
            e.printStackTrace();
        }
    }

    private int[] unsortedArray;

    @Before
    public void setup(){
        Random random = new Random();
        unsortedArray = new int[100];
        for (int i = 0; i < 100 ; i++) {
            unsortedArray[i] = random.nextInt(50)+1;
        }
    }

    @Test //array is sorted
    public void testSort(){
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < unsortedArray.length-1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i+1]);
        }
    }

    @Test // array is same length
    public void testLength(){
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        assertEquals(unsortedArray.length, sortedArray.length);
    }


    //BESPOKE TESTS

    @Test //empty array
    public void testEmptyArray(){
        int[] unsortedArray = {};
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        assertNull(sortedArray);
}

    @Test //sorted array
    public void testSortedArray(){
        int[] unsortedArray = new int[]{1, 2, 3, 4};
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < unsortedArray.length-1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i+1]);
        }
        assertEquals(unsortedArray.length, sortedArray.length);
    }

    @Test //negative array
    public void testNegativeArray(){
        int[] unsortedArray = new int[]{-3, 1, 0, 4};
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < unsortedArray.length-1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i+1]);
        }
        assertEquals(unsortedArray.length, sortedArray.length);
    }
}


