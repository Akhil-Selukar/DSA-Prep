package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - using Map
//    Map<String, Integer> map = new HashMap<>();
//    {
//        map.put("A", 1);
//        map.put("B", 2);
//        map.put("C", 3);
//        map.put("D", 4);
//        map.put("E", 5);
//        map.put("F", 6);
//        map.put("G", 7);
//        map.put("H", 8);
//        map.put("I", 9);
//        map.put("J", 10);
//        map.put("K", 11);
//        map.put("L", 12);
//        map.put("M", 13);
//        map.put("N", 14);
//        map.put("O", 15);
//        map.put("P", 16);
//        map.put("Q", 17);
//        map.put("R", 18);
//        map.put("S", 19);
//        map.put("T", 20);
//        map.put("U", 21);
//        map.put("V", 22);
//        map.put("W", 23);
//        map.put("X", 24);
//        map.put("Y", 25);
//        map.put("Z", 26);
//    }
//    public int titleToNumber(String columnTitle) {
//        return helper(columnTitle);
//    }
//
//    private int helper(String columnTitle) {
//        if(map.containsKey(columnTitle)){
//            return map.get(columnTitle);
//        }
//
//        return (helper(columnTitle.substring(0, columnTitle.length()-1)) * 26) + helper(columnTitle.substring(columnTitle.length()-1, columnTitle.length()));
//    }

    // Solution 2 - using arrays (O(N)/O(N))
//    int[] value = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
//    public int titleToNumber(String columnTitle) {
//        return helper(columnTitle);
//    }
//
//    private int helper(String columnTitle) {
//        if(columnTitle.length() == 1){
//            return value[columnTitle.charAt(0) - 65];
//        }
//
//        return (helper(columnTitle.substring(0, columnTitle.length()-1)) * 26) + helper(columnTitle.substring(columnTitle.length()-1, columnTitle.length()));
//    }

    // Solution 3 - without recursion (O(N)/O(1))
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(int i=0; i<columnTitle.length(); i++){
            result = result * 26 + (columnTitle.charAt(i)-'A'+1);
        }
        return result;
    }
}
