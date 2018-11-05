package com.sparta.jlb.sorters;

import com.sparta.jlb.sorters.BinaryTreeSorter.BinaryTree;
import com.sparta.jlb.sorters.BinaryTreeSorter.BinaryTreeImpl;

public class BinarySorter implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTree binaryTree = new BinaryTreeImpl(arrayToSort);
        return binaryTree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "Binary Sorter";
    }
}

