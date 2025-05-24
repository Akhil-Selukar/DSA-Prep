package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - Bruteforce
    // TC -> O(W*C) where W is length of words array and C is length of the longest word.
    // SC -> O(W)
//    public List<Integer> findWordsContaining(String[] words, char x) {
//        List<Integer> ans = new ArrayList<>();
//
//        for(int i=0; i<words.length; i++){              // O(W)
//            for(char ch:words[i].toCharArray()){        // O(C)
//                if(ch == x){
//                    ans.add(i);
//                    break;
//                }
//            }
//        }
//
//        return ans;
//    }


    // Solution 2 - using indexOf method
    // Here complexities are same still this one is faster as there is no explicit need to convert String to char array and all.
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            if(words[i].indexOf(x) >= 0){
                ans.add(i);
            }
        }

        return ans;
    }
}
