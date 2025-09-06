package com.practice.data.structure.algorithms.leetcode;

public class MinimumOperationsToMakeIntegerZero {

    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }

public static void main(String[] args) {
    MinimumOperationsToMakeIntegerZero solver = new MinimumOperationsToMakeIntegerZero();

    int num1_1 = 3, num2_1 = -2;
    int result1 = solver.makeTheIntegerZero(num1_1, num2_1);
    System.out.println("Input: num1 = " + num1_1 + ", num2 = " + num2_1);
    System.out.println("Output: " + result1); // Expected: 3

    int num1_2 = 5, num2_2 = 7;
    int result2 = solver.makeTheIntegerZero(num1_2, num2_2);
    System.out.println("Input: num1 = " + num1_2 + ", num2 = " + num2_2);
    System.out.println("Output: " + result2); // Expected: -1
}
}
