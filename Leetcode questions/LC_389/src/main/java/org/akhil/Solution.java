package org.akhil;

public class Solution {
    public char findTheDifference(String s, String t) {
        int sCount = 0;
        int tCount = 0;

        for(char ch:s.toCharArray()){
            sCount = sCount + ch;
        }

        for(char ch:t.toCharArray()){
            tCount = tCount + ch;
        }

        return (char)(tCount-sCount);
    }
}
