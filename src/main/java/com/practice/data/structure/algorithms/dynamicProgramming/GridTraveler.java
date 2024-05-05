package com.practice.data.structure.algorithms.dynamicProgramming;

public class GridTraveler {

    public Long gridTraveler(int m, int n){
        if(m ==0 || n ==0) return 0L;
        if(m == 1 && n == 1) return 1L;

        return gridTraveler(m-1,n) + gridTraveler(m,n-1);

    }

    public static void main(String[] args) {
        GridTraveler gridTraveler = new GridTraveler();
        System.out.println(gridTraveler.gridTraveler(2,3));
        System.out.println(gridTraveler.gridTraveler(3,3));
        System.out.println(gridTraveler.gridTraveler(18,18));
    }
}
