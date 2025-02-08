package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        int openP = 0;
        int closeP = 0;
        helper(n, openP, closeP, "", answer);

        return answer;
    }

    private void helper(int n, int openP, int closeP, String temp, List<String> answer) {
        if(openP == n && closeP == n){
            answer.add(temp);
            return;
        }

        if(openP < n){
            helper(n, openP+1, closeP, temp + "(", answer);
        }

        if(closeP < openP){
            helper(n, openP, closeP+1, temp + ")", answer);
        }
    }
}
