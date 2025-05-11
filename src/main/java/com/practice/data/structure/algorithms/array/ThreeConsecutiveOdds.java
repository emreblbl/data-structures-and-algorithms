package com.practice.data.structure.algorithms.array;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int product = arr[i] * arr[i + 1] * arr[i + 2];
            if (product % 2 == 1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ThreeConsecutiveOdds obj = new ThreeConsecutiveOdds();
        int[] arr = {2, 6, 4, 1};
        System.out.println(obj.threeConsecutiveOdds(arr)); // Output: false

        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(obj.threeConsecutiveOdds(arr2)); // Output: true

    }
}
