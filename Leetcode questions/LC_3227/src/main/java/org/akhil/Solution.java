package org.akhil;

public class Solution {
    // O(N)/O(1)
    public boolean doesAliceWin(String s) {
        int count = 0;

        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                count++;
            }
        }

        return count != 0;      // if count is 0, then only bob can win otherwise every time alice will win
    }

    private boolean isVowel(char ch){
        return (ch == 'a' || ch =='e' || ch =='i' || ch=='o' || ch=='u');
    }
}
