package com.sparta.jlb.sorters.BinaryTreeSorter;

public class Node {

    private int value;
    private Node LeftChild;
    private Node RightChild;
    private int count   ;

    Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(Node leftChild) {
        LeftChild = leftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }

    public void setRightChild(Node rightChild) {
        RightChild = rightChild;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
