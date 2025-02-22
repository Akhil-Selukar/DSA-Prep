package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(NM)/O(N) where N is the length of words array and M is the length of longest word in words array.
    public String[] findWords(String[] words) {
        String s1 = "QWERTYUIOPqwertyuiop";
        String s2 = "ASDFGHJKLasdfghjkl";
        String s3 = "ZXCVBNMzxcvbnm";
        List<String> list = new ArrayList<>();

        for(String word:words){
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int n = word.length();

            for(int i=0; i<n; i++){
                if(s1.contains(Character.toString(word.charAt(i)))){
                    count1++;
                }
                if(s2.contains(Character.toString(word.charAt(i)))){
                    count2++;
                }
                if(s3.contains(Character.toString(word.charAt(i)))){
                    count3++;
                }

                if(count1 == n || count2 == n || count3 == n){
                    list.add(word);
                }
            }
        }

        String[] ans = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
