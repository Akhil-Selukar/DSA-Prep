package org.akhil;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String digits = "234";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return letterCombinationsHelper("", digits, mappings);
    }

    private static List<String> letterCombinationsHelper(String processedString, String digits, String[] mappings) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            ans.add(processedString);
            return ans;
        }
        String letters = mappings[digits.charAt(0)-'0'];
        for(int i=0; i<letters.length(); i++){
            ans.addAll(letterCombinationsHelper(processedString+letters.charAt(i), digits.substring(1), mappings));
        }
        return ans;
    }
}