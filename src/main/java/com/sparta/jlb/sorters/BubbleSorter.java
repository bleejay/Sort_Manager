package com.sparta.jlb.sorters;

public class BubbleSorter implements Sorter{

    public int[] sortArray(int[] arrayToSort) {
        int[] unsortedArray = arrayToSort.clone();
        if (unsortedArray.length < 1){
            return null;
        }
        else{
        boolean swapped;
        do {
            swapped = false;
            int n = unsortedArray.length;
            for (int i = 0; i < n -1; i++) {
                if (unsortedArray[i] > unsortedArray[i+1]) {
                    int x = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i+1];
                    unsortedArray[i+1] = x;
                    swapped = true;
                }
        }
        }while (swapped);
        return unsortedArray;
        }
    }
    @Override
    public String toString(){
        return "Bubble Sorter method";
    }
}
