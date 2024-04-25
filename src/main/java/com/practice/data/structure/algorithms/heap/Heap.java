package com.practice.data.structure.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }
    public List<Integer> printHeap(){
        return new ArrayList<>(heap);
    }
    private int getLeftChild(int currentIndex){
        return (currentIndex)/2+1;
    }
    private int getRightChild(int currentIndex){
        return (currentIndex)/2+2;
    }
    private int getParentIndex(int currentIndex){
        return(currentIndex-1)/2;
    }
    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }
    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size()-1 ;

        while(currentIndex > 0 && heap.get(currentIndex) > heap.get(getParentIndex(currentIndex))){
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }
}
