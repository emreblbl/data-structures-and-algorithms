package com.practice.data.structure.algorithms.leetcode;

public class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        int p1 = Math.abs(z-x);
        int p2 = Math.abs(z-y);

        if(p1<p2) return 1;
        else if(p1>p2) return 2;
        else return 0;
    }

    public static void main(String[] args) {
        FindClosestPerson solver = new FindClosestPerson();

        int x1 = 1, y1 = 2, z1 = 3;
        int result1 = solver.findClosest(x1, y1, z1);
        System.out.println("Input: x = " + x1 + ", y = " + y1 + ", z = " + z1);
        System.out.println("Output: " + result1); // Expected: 2

        int x2 = 2, y2 = 5, z2 = 4;
        int result2 = solver.findClosest(x2, y2, z2);
        System.out.println("Input: x = " + x2 + ", y = " + y2 + ", z = " + z2);
        System.out.println("Output: " + result2); // Expected: 2
    }
}
