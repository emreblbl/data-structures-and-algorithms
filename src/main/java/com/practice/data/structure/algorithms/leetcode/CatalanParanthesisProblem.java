package com.practice.data.structure.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CatalanParanthesisProblem {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;

    }

    private static void backtrack(int n, int eCount, int aCount, StringBuilder sb, List<String> res) {

        if (eCount == n && aCount == n) {
            res.add(sb.toString());
            return;
        }

        if (eCount < n) {
            sb.append('(');
            backtrack(n, eCount + 1, aCount, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (aCount < eCount) {
            sb.append(')');
            backtrack(n, eCount, aCount + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        CatalanParanthesisProblem solver = new CatalanParanthesisProblem();

        int n1 = 3;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solver.generateParenthesis(n1));
        // Expected: ["((()))","(()())","(())()","()(())","()()()"]

        int n2 = 1;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solver.generateParenthesis(n2));
        // Expected: ["()"]
    }
}
