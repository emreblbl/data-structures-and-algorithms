package com.practice.data.structure.algorithms.leetcode;


/*
Intuition
Check if there is the simple case n = 0, otherwise merge two arrays using a sort method.

Approach
Write two arrays into one by comparing each element until end of one array, then fill the rest of the answer array with the leftover numbers.

Complexity
Time complexity: O(n).
Space complexity: O(n).



 */
public class MergeSortArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(n == 0) {}
            else {
                int[] temp = new int[m];
                for(int i = 0; i < m; i++)
                    temp[i] = nums1[i];
                sortNums(nums1, temp, m, nums2, n);
            }
        }
        public void sortNums(int[] nums1, int[] temp, int m, int[] nums2, int n) {
            int  i1 = 0, i2 = 0;
            for(int i = 0; i < m + n; i++) {
                if((i1 < m) && (i2 < n)) {
                    nums1[i] = (temp[i1] <= nums2[i2]) ? temp[i1++] : nums2[i2++];
                }
                else if (i1 < m) {
                    nums1[i] = temp[i1++];
                }
                else if (i2 < n){
                    nums1[i] = nums2[i2++];
                }
            }
        }
    }
}
