package com.practice.data.structure.algorithms.leetcode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        int n = Math.max(parts1.length, parts2.length);
        for (int i = 0; i < n; i++) {
            int rev1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int rev2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

            if (rev1 > rev2) return 1;
            if (rev1 < rev2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers solution = new CompareVersionNumbers();

        // Example 1: version1 = "1.01", version2 = "1.001", Expected: 0
        String version1a = "1.01";
        String version2a = "1.001";
        int result1 = solution.compareVersion(version1a, version2a);
        System.out.println("Example 1: " + result1 + " (Expected: 0)");

        // Example 2: version1 = "1.0", version2 = "1.0.0", Expected: 0
        String version1b = "1.0";
        String version2b = "1.0.0";
        int result2 = solution.compareVersion(version1b, version2b);
        System.out.println("Example 2: " + result2 + " (Expected: 0)");

        // Example 3: version1 = "0.1", version2 = "1.1", Expected: -1
        String version1c = "0.1";
        String version2c = "1.1";
        int result3 = solution.compareVersion(version1c, version2c);
        System.out.println("Example 3: " + result3 + " (Expected: -1)");

        // Example 4: version1 = "1.0.1", version2 = "1", Expected: 1
        String version1d = "1.0.1";
        String version2d = "1";
        int result4 = solution.compareVersion(version1d, version2d);
        System.out.println("Example 4: " + result4 + " (Expected: 1)");

        // Example 5: version1 = "
    }
}
