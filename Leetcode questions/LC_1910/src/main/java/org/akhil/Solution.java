package org.akhil;

public class Solution {
    // O(N*L)/O(L) where L is the length of s, and N is length of part
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        StringBuilder sb = new StringBuilder(s);

        while(sb.toString().contains(part)){
            int startIndex = sb.toString().indexOf(part);
            sb.delete(startIndex, startIndex+n);
        }

        return sb.toString();
    }
}
