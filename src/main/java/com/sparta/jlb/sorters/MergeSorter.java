package com.sparta.jlb.sorters;

import java.util.Arrays;

public class MergeSorter implements Sorter{

    public int[] sortArray(int[] initialArray){
        if (initialArray.length == 1){
            return initialArray;
        }
        if (initialArray.length < 1){
            return null;
        }
        int[] left = Arrays.copyOfRange(initialArray, 0, initialArray.length/2);
        int[] right = Arrays.copyOfRange(initialArray, initialArray.length/2, initialArray.length);
        return merge(sortArray(left), sortArray(right));
    }
    private int[] merge(int[] first, int[] second){
        int i = 0;
        int j = 0;
        int[] answer = new int[first.length + second.length];
        for (int k = 0; k < answer.length; k++) {
            if ( i >= first.length){
                answer[k] = second[j];
                j++;
            }
            else if (j >= second.length){
                answer[k] = first[i];
                i++;
            }
            else if (first[i] >= second[j]){
                answer[k] = second[j];
                j++;
            }
            else if (first[i] < second[j]){
                answer[k] = first[i];
                i++;
            }
        }
        return answer;
    }
    @Override
    public String toString(){
        return "Merge Sorter method";
    }
}
