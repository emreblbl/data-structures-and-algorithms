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
    public Integer remove(){
        if(heap.size()==0) return null;

        if(heap.size() ==1) return heap.remove(0);


        int rootValue = heap.get(0);
        heap.set(0,heap.remove(heap.size()-1));
        sinkDown(0);

        return rootValue;

    }

    private void sinkDown(int index) {
        int maxIndex = index;

        while (true) {
            int leftIndex = getLeftChild(index);
            int rightIndex = getRightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
                maxIndex = rightIndex;
        }
        if (maxIndex != index) {
            swap(index, maxIndex);
            index = maxIndex;
        } else {
            return;
        }
    }
    }



}
