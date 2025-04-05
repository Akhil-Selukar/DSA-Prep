package org.akhil;

public class Solution {
    public int reverseDegree(String s) {
        int rDegree = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            rDegree += ((i+1) * (26-(ch-'a')));
        }

        return rDegree;
    }
}
