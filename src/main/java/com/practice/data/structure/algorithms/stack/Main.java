package com.practice.data.structure.algorithms.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(20);
        System.out.println("Stack size :"+ stack.height);
        System.out.println("Elements of Stack :"+ stack.toString() );

        stack.pop();

        System.out.println("Stack size after pop :"+stack.height);
        System.out.println("Elements of Stack :"+ stack.toString() );
    }

}
