package com.practice.data.structure.algorithms.interviewQuestion;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();

    }
    public static int[] subArraySum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum -target)){
                return new int[]{map.get(sum-target)+1, i};
            }
            map.put(sum,i);
        }
        return new int[] {};
    }
}
