package com.practice.data.structure.algorithms.leetcode;

public class RemoveDuplicatesfromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        RemoveDuplicatesfromSortedArray2 removeDuplicatesfromSortedArray2 = new RemoveDuplicatesfromSortedArray2();
        int result = removeDuplicatesfromSortedArray2.removeDuplicates(nums);
        System.out.println("Result: "+result);
    }

    public int removeDuplicates(int[] nums) {
        int reader=1,writer=0;
        int upperLimit= 0;
        int temp=0;
        if(nums.length <=2){
            return nums.length;
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
                else if(nums[reader] != nums[writer] && (upperLimit > 0 && upperLimit<2)){
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
        return writer;
    }
}
