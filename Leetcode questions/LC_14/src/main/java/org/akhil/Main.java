package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length-1];
        int common = 0;
        while(common < firstWord.length() && common < lastWord.length()){
            if(firstWord.charAt(common) == lastWord.charAt(common)){
                common++;
            } else {
                break;
            }
        }
        return firstWord.substring(0, common);
    }
}