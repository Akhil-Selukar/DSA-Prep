package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // (O(N*2^N)/O(2^n))
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        helper(s, 0, temp, answer);
        return answer;
    }

    private void helper(String s, int index, List<String> temp, List<List<String>> answer) {
        if(index == s.length()){
            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<s.length(); i++){
            String subStr = s.substring(index, i+1);
            if(isPalindrome(subStr)){
                temp.add(subStr);
                helper(s, i+1, temp, answer);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String subStr) {
        int startIndex = 0;
        int endIndex = subStr.length()-1;

        while(startIndex < endIndex){
            if(!(subStr.charAt(startIndex) == subStr.charAt(endIndex))){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
