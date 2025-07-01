package org.akhil;

public class Solution {

    // O(N)/O(1)
//    public int possibleStringCount(String word) {
//        int count = 0;
//
//        for(int i=1; i<word.length(); i++){
//            int freq = 1;
//            while(i<word.length() && word.charAt(i-1) == word.charAt(i)){
//                freq++;
//                i++;
//            }
//
//            if(freq > 1){
//                count = count + freq-1;
//            }
//        }
//
//        return count+1;
//    }


    // Solution 2 - Slightly improved
    // O(N)/O(1)

    public int possibleStringCount(String word) {
        int count = 0;
        char prevCh = word.charAt(0);

        for(char ch:word.toCharArray()){
            if(prevCh == ch){
                count++;
            } else {
                prevCh = ch;
            }
        }
        return count+1;
    }
}
