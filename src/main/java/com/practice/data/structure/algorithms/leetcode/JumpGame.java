package com.practice.data.structure.algorithms.leetcode;

public class JumpGame {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1)
            return true;

        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public static void main(String[] args) {
        /*
        Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
         */
        JumpGame jumpGame = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1: " + jumpGame.canJump(nums1)); // Expected: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test 2: " + jumpGame.canJump(nums2)); // Expected: false

    }
}
