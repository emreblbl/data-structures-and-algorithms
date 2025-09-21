package com.practice.data.structure.algorithms.leetcode;

public class LongestPalindromicString {
    public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    private boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: s = "babad"
        //Output: "bab"
        //Explanation: "aba" is also a valid answer.
        //Example 2:
        //
        //Input: s = "cbbd"
        //Output: "bb"
        LongestPalindromicString solver = new LongestPalindromicString();

        String exampleOne = "babad";
        String exampleTwo = "cbbd";

        System.out.printf("Input: %s -> Longest palindrome: %s%n", exampleOne, solver.longestPalindrome(exampleOne));
        System.out.printf("Input: %s -> Longest palindrome: %s%n", exampleTwo, solver.longestPalindrome(exampleTwo));
    }
}
