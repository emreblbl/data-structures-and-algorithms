package com.practice.data.structure.algorithms.leetcode;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = {1,2,2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.removeDuplicates(nums);
        System.out.println("Result: "+result);
    }

    public int removeDuplicates(int[] nums) {
        int reader=1,writer=0;
        int upperLimit= 0;
        int temp=0;
        if(nums.length ==0){
            return 0;
        }
        if(nums.length ==1){
            return 1;
        }

        while(reader <= nums.length-1){
            if(nums[reader] ==nums[writer] && upperLimit<2){
                writer++;
                reader++;
                upperLimit++;
            }else{
                if(nums[reader]==nums[writer]){
                    reader++;
                }
                else if(nums[reader] != nums[writer] && (upperLimit >= 0 && upperLimit<2)){
                    writer++;
                    reader++;
                    upperLimit=0;
                }
                else{
                    upperLimit =0;
                    temp = nums[writer];
                    nums[writer] = nums[reader];
                    nums[reader] =temp;
                    writer++;
                    reader++;
                }
            }
        }
        return reader- writer == 1 ? reader : writer;
    }
}
