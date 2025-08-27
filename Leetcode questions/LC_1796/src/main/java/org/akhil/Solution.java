package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N)/O(N)
//    public int[] minOperations(String boxes) {
//        char[] chars = boxes.toCharArray();
//        int[] result = new int[chars.length];
//        List<Integer> oneIndices = new ArrayList<>();
//
//        for(int i=0; i<chars.length; i++){
//            char ch = chars[i];
//            if(ch == '1'){
//                oneIndices.add(i);
//            }
//        }
//
//        for(int i=0; i<chars.length; i++){
//            int sum = 0;
//            for(int index:oneIndices){
//                sum = sum + Math.abs(i-index);
//            }
//            result[i] = sum;
//        }
//
//        return result;
//    }

    // -----------------
//    // Solution 2 - Same concept just removed a loop and List
//    // O(N)/O(N)
//    public int[] minOperations(String boxes) {
//        char[] chars = boxes.toCharArray();
//        int[] result = new int[chars.length];
//
//        for(int i=0; i<chars.length; i++){
//            char ch = chars[i];
//            if(ch == '1'){
//                for(int j=0; j<chars.length; j++){
//                    result[j] = result[j] + Math.abs(i-j);
//                }
//            }
//        }
//        return result;
//    }

    //--------------
    // Solution 3 - Removed the char array
    // O(N)/O(N)
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            char ch = boxes.charAt(i);
            if(ch == '1'){
                for(int j=0; j<n; j++){
                    result[j] = result[j] + Math.abs(i-j);
                }
            }
        }
        return result;
    }
}
