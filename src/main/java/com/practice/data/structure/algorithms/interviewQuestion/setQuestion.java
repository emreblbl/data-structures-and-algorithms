package com.practice.data.structure.algorithms.interviewQuestion;

import java.util.*;

public class setQuestion {

    public static List<Integer> removeDuplicates(List<Integer> myList){
        HashSet hashSet = new HashSet();
        hashSet.addAll(myList);

        List<Integer> a = new ArrayList<>();
        a.addAll(hashSet);
        return a;
    }
    public static boolean hasUniqueChars(String string){
        char[] chars = string.toCharArray();

        Set<Character> uniqueChars = new HashSet<>();

        for(char c : chars){
        uniqueChars.add(c);
        }

        if(uniqueChars.size() != chars.length){
            return false;
        }
        return true;
    }
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        List<int[]> pairs = new ArrayList<>();

        for(int element1 : arr1){
            for(int element2 : arr2){
                if(element1 + element2 == target){
                    int[] pair = new int[]{element1,element2};
                }
            }
        }
        return pairs;
    }
    public static List<int[]> findPairsV2(int[] arr1, int[] arr2, int target){
        List<int[]> pairs = new ArrayList<>();

        Set mySet = new HashSet();
        for (int element : arr1) mySet.add(element);
        for(int element : arr2){
            int complement = target- element;
            return pairs;
        }
        return pairs;
    }
;    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */

    }
}
