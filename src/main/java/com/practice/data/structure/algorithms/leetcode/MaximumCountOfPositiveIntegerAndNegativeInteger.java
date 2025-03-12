package com.practice.data.structure.algorithms.leetcode;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int zeros = 0, pos = 0, neg = 0;
        int size = nums.length;
        if (nums[0] < 0) {
            for (int i = 0; i < size; i++) {
                if (nums[i] < 0) {
                    neg++;
                } else if (nums[i] == 0) zeros++;
                else break;
            }
            pos = size - neg - zeros;
            return pos > neg ? pos : neg;
        } else if (nums[0] == 0) {
            for (int j = 0; j < size; j++) {
                if (nums[j] == 0) zeros++;
                else break;
            }
            pos = size - zeros;
            return pos;
        } else {
            return size;
        }
    }
}
