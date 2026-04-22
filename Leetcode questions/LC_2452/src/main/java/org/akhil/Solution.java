package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // O(M*N*L)/O(M) where M is length of queries array and N is length of dictionary array and L is length of words.
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for(String qWord:queries){
            for(String dWord:dictionary){
                if(isValid(qWord, dWord)){
                    result.add(qWord);
                    break;
                }
            }
        }

        return result;
    }

    private boolean isValid(String qWord, String dWord){
        int count = 0;
        int index = 0;

        while(count < 3 && index < qWord.length()){
            if(qWord.charAt(index) != dWord.charAt(index)){
                count++;
                if(count >= 3){
                    return false;
                }
            }
            index++;
        }

        return true;
    }
}
