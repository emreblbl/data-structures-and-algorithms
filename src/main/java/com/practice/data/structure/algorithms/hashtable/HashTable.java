package com.practice.data.structure.algorithms.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    int size = 7;

    Node[] dataMap;

    public HashTable() {
        this.dataMap = new Node[size];
    }

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }


    }

    public void printTable() {
        Node temp = null;
        for (int i = 0; i < dataMap.length; i++) {
            temp = dataMap[i];
            System.out.println(i + ":");
            while (temp != null) {
                System.out.println(temp.key + " :" + temp.value);
                temp = temp.next;
            }

        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int ascii = chars[i];
            hash = hash + ascii * 23;
        }
        return hash % size;
    }

    public void set(String key, int value) {
        Node node = new Node(key, value);
        int index = hash(key);

        if (dataMap[index] == null) {
            dataMap[index] = node;
        } else {
            Node temp = dataMap[index];
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public int get(String key){
        int index = hash(key);

        Node temp = dataMap[index];

        while(temp !=null){
            if(temp.key.equals(key)) return temp.value;
            temp=temp.next;
        }
        return 0;
    }

    public List<String> keys(){
        List<String> keys = new ArrayList<>();
        for(int i=0;i< dataMap.length;i++){
            Node temp = dataMap[i];
            while(temp !=null){
                keys.add(temp.key);
                temp=temp.next;
            }
        }
        return keys;
    }
}
