package com.practice.data.structure.algorithms.dynamicProgramming;

import java.util.HashMap;

public class Fib {

    public Long fib (int n){
        HashMap<Integer,Long> hashMap = new HashMap<>();
        return fib(n,hashMap);

    }
    private Long fib (int n, HashMap hashMap){
        if(hashMap.get(n) != null) return (Long) hashMap.get(n);
        if(n <=2) return 1L;
        Long memo = fib(n - 1,hashMap) + fib(n - 2,hashMap);
        hashMap.put(n, memo);
        return memo;

    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(50));

    }



}
