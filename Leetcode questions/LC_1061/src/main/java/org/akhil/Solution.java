package org.akhil;

public class Solution {

    // O(M+N)/O(M) where M is length of base string and N is length of S1/S2
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        int length = s1.length();
        DisjointSet ds = new DisjointSet();

        for(int i=0; i<length; i++){
            ds.union(s1.charAt(i) - 'a', s2.charAt(i)-'a');
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<baseStr.length(); i++){
            char ch = baseStr.charAt(i);
            int parent = ds.findParent(ch-'a');

            sb.append((char)(parent+'a'));
        }

        return sb.toString();
    }
}
