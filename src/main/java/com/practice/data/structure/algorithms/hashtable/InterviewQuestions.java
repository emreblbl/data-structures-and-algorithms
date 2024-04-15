package com.practice.data.structure.algorithms.hashtable;

import java.util.*;

public class InterviewQuestions {
    public boolean itemInCommon(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> hashMap = new HashMap<>(7);

        for (int element : arr1){
            hashMap.put(element,element);
        }
        for(int element : arr2){
            if(hashMap.containsValue(element)){
                return true;
            }
        }
        return false;
    }
    public List<Integer> findDuplicates(int[] arr){
        HashMap<Integer,Boolean> hashMap = new HashMap<>(arr.length);
        List<Integer> duplicatedNumbers = new ArrayList<>();
        for(int element : arr){
            if(!hashMap.isEmpty()  && hashMap.containsKey(element) && Boolean.TRUE.equals(hashMap.get(element))) {
                hashMap.put(element,false);
            }
            else if(!hashMap.containsKey(element)){
                hashMap.put(element,true);
            }
        }
        for(Integer value : hashMap.keySet()){
            if(Boolean.FALSE.equals(hashMap.get(value))){
                duplicatedNumbers.add(value);
            }
        }
        return duplicatedNumbers;
    }
    public Character firstNonRepeatingChar(String text){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] characters  = text.toCharArray();

        for(char character : characters){
            hashMap.put(character,hashMap.getOrDefault(character,0)+1);
        }
        for(Map.Entry<Character,Integer> entry: hashMap.entrySet()){
            if(entry.getValue()>1) return entry.getKey();
        }
        return null;
    }
    public List<List<String>> groupAnagrams(String[] strings){
        HashMap<String,List<String>> hashMap = new HashMap<>();

        for(String string : strings){
            char[] chars = string.toCharArray();
            String canonical = chars.toString();
            Arrays.sort(chars);
            if(hashMap.containsKey(canonical)){
                hashMap.get(canonical).add(string);
            }else{
                List<String> anagramGroup = new ArrayList<>();
                hashMap.put(canonical,anagramGroup);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
    public int[] twoSum(int[] nums, int target){
        int[] arr = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int y=i+1;y< nums.length;y++){
                int sum = nums[i] + nums[y];
                if(sum == target){
                    arr[0] = i;
                    arr[1] = y;
                }
            }
        }
        return arr;
    }
    public int[] twoSumHashMap(int[]nums, int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] arr = new int[0];
        for(int i=0;i< nums.length;i++){
            int complement = target-nums[i];
            if(hashMap.containsKey(complement)){
                arr = new int[2];
                arr[0]=hashMap.get(complement);
                arr[1] = hashMap.get(nums[i]);
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return arr;
    }
}
