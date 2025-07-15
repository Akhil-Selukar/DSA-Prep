package org.akhil;

public class Solution {
    public boolean isValid(String word) {
        int length = word.length();
        if(length < 3){
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for(char ch:word.toCharArray()){
            if(Character.isLetter(ch)){
                if("aeiouAEIOU".indexOf(ch) != -1){
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if(!Character.isDigit(ch)) {
                return false;
            }
        }

        if(hasConsonant && hasVowel){
            return true;
        }
        return false;
    }
}
