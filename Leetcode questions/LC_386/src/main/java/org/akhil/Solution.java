package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Here we know that space complexity of recursive function is depth of the recursion tree (to store recursive call stacks).
    // in this question it is given that N value can maximum be 5*10^4 which is nothing but a 5 digit number, and for every additional digit we have 1 level in recursion tree
    // Hence max depth of recursion tree will be 5. So space complexity will be O(5) which is constant O(1).
    // For time complexity we can see that we are calculating each number from 1 to N exactly 1 time hence time complexity will be O(N).
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();

        for(int i=1; i<=9; i++){
            helper(i, n, answer);
        }

        return answer;
    }

    private void helper(int currentNo, int n, List<Integer> answer) {
        if(currentNo > n){
            return;
        }

        answer.add(currentNo);
        for(int i=0; i<=9; i++){
            helper(currentNo*10+i, n, answer);
        }
    }
}
