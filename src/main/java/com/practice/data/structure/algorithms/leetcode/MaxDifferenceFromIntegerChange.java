package com.practice.data.structure.algorithms.leetcode;

public class MaxDifferenceFromIntegerChange {

    public int maxDiff(int num) {
        int min_num = num;
        int max_num = num;
        for (int x = 0; x < 10; ++x) {
            for (int y = 0; y < 10; ++y) {
                String res = change(num, x, y);

                if (res.charAt(0) != '0') {
                    int res_i = Integer.parseInt(res);
                    min_num = Math.min(min_num, res_i);
                    max_num = Math.max(max_num, res_i);
                }
            }
        }

        return max_num - min_num;
    }

    public String change(int num, int x, int y) {
        StringBuffer num_s = new StringBuffer(String.valueOf(num));
        int length = num_s.length();
        for (int i = 0; i < length; i++) {
            char digit = num_s.charAt(i);
            if (digit - '0' == x) {
                num_s.setCharAt(i, (char) ('0' + y));
            }
        }
        return num_s.toString();
    }

    public static void main(String[] args) {
        MaxDifferenceFromIntegerChange solver = new MaxDifferenceFromIntegerChange();

        int num1 = 555;
        int result1 = solver.maxDiff(num1);
        System.out.println("Input: num = 555");
        System.out.println("Output: " + result1); // Expected: 888

        int num2 = 9;
        int result2 = solver.maxDiff(num2);
        System.out.println("Input: num = 9");
        System.out.println("Output: " + result2); // Expected: 8
    }
}
