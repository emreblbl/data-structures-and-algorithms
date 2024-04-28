package com.practice.data.structure.algorithms.binarySearchTree;

public class BinarySearchTree {

    public Node root;

    class Node{
         int value;
         Node left;
         Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node node = new Node(value);
        if(this.root ==null) {
            root=node;
            return true;
        }
        Node temp = root;
        while(true){
            if(node.value == temp.value) return false;
            if(node.value< temp.value){
                if(temp.left == null){
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right ==null){
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    public boolean contain(int value){
        Node temp = root;
        while(temp !=null){
            if(value<temp.value)  temp = temp.left;
            else if(value>temp.value) temp = temp.right;
            else  return true;
        }
        return false;
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private boolean rContains(Node root, int value) {
        if(root ==null) return false;

        if(root.value == value) return true;
        if(root.value > value){
            return rContains(root.left,value);
        }else{
            return rContains(root.right,value);
        }
    }
}
