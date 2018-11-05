package com.sparta.jlb.sorters.BinaryTreeSorter;

import com.sparta.jlb.control.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree{

    private int elementCount = 0;
    private final Node rootElement;
    private int index = 0;

    public BinaryTreeImpl(final int value){
        rootElement = new Node(value);
        elementCount++;
    }

    public BinaryTreeImpl(final int[] values){
        rootElement = new Node(values[0]);
        elementCount++;
        for (int i = 1; i < values.length ; i++) {
            addElement(values[i]);
        }
    }

    @Override
    public int getRootElement() {
        return rootElement.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return elementCount;
    }

    @Override
    public void addElement(int element) {

        Node node = rootElement;
        boolean exit = false;

        while (exit == false) {
            if (element < node.getValue()) {
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new Node(element));
                    elementCount++;
                    exit = true;
                } else {
                    node = node.getLeftChild();
                }
            }

            if (element > node.getValue()) {
                if (node.getRightChild() == null) {
                    node.setRightChild(new Node(element));
                    elementCount++;
                    exit = true;
                } else {
                    node = node.getRightChild();
                }
            }
            if (element == node.getValue()){
            node.setCount(node.getCount()+1);
            elementCount++;
            exit = true;
            }
    }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length ; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public boolean findElement(int value) {
        Node node = findNode(value);
        if (node != null){
            return true;
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
            Node node = findNode(element);
            if (node.getLeftChild() != null){
                return node.getLeftChild().getValue();
            }
            throw new ChildNotFoundException("No Child Found");
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {

        Node node = findNode(element);
        if (node.getRightChild() != null){
            return node.getRightChild().getValue();
        }
        throw new ChildNotFoundException("No Child Found");
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArray = new int[getNumberOfElements()];
        fillArrayAsc(rootElement, sortedArray);
        return sortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArray = new int[getNumberOfElements()];
        fillArrayDec(rootElement, sortedArray);
        return sortedArray;
    }

    private void fillArrayAsc(Node fillingNode, int[] arrayToFill){
        if (fillingNode.getLeftChild() != null){
            fillArrayAsc(fillingNode.getLeftChild(), arrayToFill);
        }
        arrayToFill[index++] = fillingNode.getValue();

        if (fillingNode.getRightChild() != null){
            fillArrayAsc(fillingNode.getRightChild(), arrayToFill);
        }
    }

    private void fillArrayDec(Node fillingNode, int[] arrayToFill){
        if (fillingNode.getRightChild() != null){
            fillArrayDec(fillingNode.getRightChild(), arrayToFill);
        }
        arrayToFill[index++] = fillingNode.getValue();

        if (fillingNode.getLeftChild() != null){
            fillArrayDec(fillingNode.getLeftChild(), arrayToFill);
        }
    }

    private Node findNode(int element){
        Node node = rootElement;

        while(node != null){
            if (element < node.getValue()){
                node = node.getLeftChild();
            }
            if (element > node.getValue()){
                node = node.getRightChild();
            }
            if (element == node.getValue()){
                return node;
            }
        }
        return null;
    }

}
