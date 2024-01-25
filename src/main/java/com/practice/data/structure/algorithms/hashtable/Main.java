package com.practice.data.structure.algorithms.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

//        hashTable.printTable();


        hashTable.set("nails",100);
        hashTable.set("tile",  50);
        hashTable.set("lumber",80);

        hashTable.set("bolts",200);
        hashTable.set("screws",140);

        hashTable.printTable();

        System.out.println(hashTable.get("lumber"));
        System.out.println(hashTable.get("bolts"));
        System.out.println(hashTable.get("boltss"));


        System.out.println(hashTable.keys());
    }
}
