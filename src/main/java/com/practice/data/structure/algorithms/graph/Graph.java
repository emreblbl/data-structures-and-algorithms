package com.practice.data.structure.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjacentList = new HashMap<>();


    public boolean addVertex(String vertex) {
        if(adjacentList.get(vertex) ==null){
            adjacentList.put(vertex,new ArrayList<>());
            return true;
        }
        return false;
    }

    public void printGraph(){
        System.out.println(adjacentList);
    }

    public boolean addEdge(String vertex1, String vertex2){
        if(adjacentList.get(vertex1) !=null && adjacentList.get(vertex2) !=null){
            adjacentList.get(vertex1).add(vertex2);
            adjacentList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2){
        if(adjacentList.get(vertex1) !=null && adjacentList.get(vertex2) !=null){
            adjacentList.get(vertex1).remove(vertex2);
            adjacentList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if(adjacentList == null) return false;
        for(String otherVertex: adjacentList.get(vertex)){
            adjacentList.get(otherVertex).remove(vertex);
        }
        adjacentList.remove(vertex);
        return true;
    }
}
