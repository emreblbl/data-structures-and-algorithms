package com.practice.data.structure.algorithms.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }

        return maxSubarray;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        // Example 1: nums = [-2,1,-3,4,-1,2,1,-5,4], Expected: 6
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Example 1: " + result1 + " (Expected: 6)");

        // Example 2: nums = [1], Expected: 1
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Example 2: " + result2 + " (Expected: 1)");

        // Example 3: nums = [5,4,-1,7,8], Expected: 23
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Example 3: " + result3 + " (Expected: 23)");
    }
}
