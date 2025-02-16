package org.akhil;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen > tLen){
            return false;
        }

        int sPointer = 0;
        int tPointer = 0;

        while(sPointer < sLen && tPointer < tLen){
            if(s.charAt(sPointer) == t.charAt(tPointer)){
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }

        return sPointer >= sLen;
    }
}
