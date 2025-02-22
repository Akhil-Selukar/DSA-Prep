package org.akhil;

public class Solution {

    // O(N)/O(1)
    public boolean detectCapitalUse(String word) {
        int capital = 0;
        int small = 0;
        boolean firstCapital = false;
        if((word.charAt(0) - 'a') < 0){
            firstCapital = true;
        }

        for(int i=1; i<word.length(); i++){
            if((word.charAt(i)-'a') < 0){
                capital++;
            } else {
                small++;
            }
        }

        if(firstCapital && (small == 0 || small == word.length()-1)){
            return true;
        }
        if(!firstCapital && small == word.length()-1){
            return true;
        }
        return false;
    }
}
