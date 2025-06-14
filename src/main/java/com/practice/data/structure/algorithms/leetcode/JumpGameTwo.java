package com.practice.data.structure.algorithms.leetcode;

public class JumpGameTwo {
    public int jump(int[] nums) {
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // [2,3,1,1,4]
        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1: " + jumpGameTwo.jump(nums1)); // Expected: 2
        // [2, 3, 0, 1, 4]
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test 2: " + jumpGameTwo.jump(nums2)); // Expected: 2

        // [1, 2, 1, 1, 1]
        int[] nums3 = {1, 2, 1, 1, 1};
        System.out.println("Test 3: " + jumpGameTwo.jump(nums3)); // Expected: 3
    }
}
