package com.sparta.jlb.sorters;

public class QuickSorter implements Sorter {
    private int[] array;

    public int[] sortArray(int[] arrayToSort) {
        int[] unsortedArray = arrayToSort.clone();
        if (unsortedArray == null || unsortedArray.length == 0) {
            return null;
        }
        this.array = unsortedArray;
        quickSort(0, unsortedArray.length - 1);
        return array;
    }

    private void quickSort(int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = array[(left + right) / 2];

        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        if (left < rightIndex) {
            quickSort(left, rightIndex);
        }
        if (leftIndex < right) {
            quickSort(leftIndex, right);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Quick Sorter method";
    }
}
