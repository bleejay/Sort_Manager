package com.sparta.jlb.display;

import java.util.Arrays;

public class DisplayToConsole implements Display{

    public void displayUnsortedArray(int[] unsortedArray){
        System.out.println("Your initial array was " + Arrays.toString(unsortedArray));
    }

    public void displaySortedArray(int[] sortedArray,String typeOfSort){
        System.out.println("Your sorted array is " + Arrays.toString(sortedArray) + " Sorted by the " + typeOfSort);
    }

    @Override
    public void displayExceptionMessage(String message) {

        System.out.println("The following error has occurred - " + message);
    }
}
