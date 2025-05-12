package com.practice.data.structure.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        FindEvenNumbers obj = new FindEvenNumbers();
        int[] digits = {2, 1, 3, 0};
        int[] result = obj.findEvenNumbers(digits);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: [102, 120, 130, 132, 210, 230, 302, 310, 312, 320]
        int[] digits2 = {2, 2, 8, 8, 2};
        int[] result2 = obj.findEvenNumbers(digits2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        // Output: [222, 228, 282, 288, 822, 828, 882]
        int[] digits3 = {3, 7, 5};
        int[] result3 = obj.findEvenNumbers(digits3);
        for (int num : result3) {
            System.out.print(num + " ");
        }
        // Output: []
    }
}
