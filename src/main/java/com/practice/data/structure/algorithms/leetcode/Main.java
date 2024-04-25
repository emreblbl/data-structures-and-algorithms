package com.practice.data.structure.algorithms.leetcode;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,6,7,4,1}; // Replace with the input array
        int maxArea = arrayChallenge(arr);
        System.out.println("The maximum area is: " + maxArea);
    }

    public static int arrayChallenge(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < arr.length) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            } else {
                // If this bar is lower than the top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar.
                // 'i' is 'right index' for the top and element before top in stack is 'left index'
                int top = stack.pop();
                // Calculate the area with arr[top] stack as smallest bar
                int area;
                if (stack.isEmpty()) {
                    area = arr[top] * i;
                } else {
                    area = arr[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
