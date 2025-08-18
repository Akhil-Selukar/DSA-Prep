package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // TC -> O(3^N) as after every digit we have 3 choices (i.e. +, - or *)
    // SC -> O(N + number of results) where N is for recursive stack space.
    public List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<>();

        helper(num, target, "", answer, 0, 0, 0);
        return answer;
    }

    private void helper(String num, int target, String curr, List<String> answer, int index, long previousVal, long prevResult){
        // base case
        if(num.length() == index){
            if(prevResult == target){
                answer.add(curr);
            }
            return;
        }

        // construct current number i.e. if given is [1,2,3] the first 1 then 12 then 123
        String currNumStr = "";
        long currNum = 0;

        for(int i=index; i<num.length(); i++){
            // we want to skip the leading 0 (i.e. values like 012, 07, 01)
            if(i>index && num.charAt(index) == '0'){
                break;    // break the loop because no matter which sign we use, leading 0 is not allowed so move out of this recursion call.
            }

            currNumStr = currNumStr + num.charAt(i);
            currNum = (currNum * 10) + num.charAt(i)-'0';

            if(index == 0){     // if this num start from index 0 digit then no sign can be added in front of it.
                helper(num, target, currNumStr, answer, i+1, currNum, currNum);
            } else {
                // explore all 3 options
                // addition
                helper(num, target, curr + "+" + currNumStr, answer, i+1, currNum, prevResult + currNum);
                // subtraction (here for previousVal we are passing -ve value because (1-2*3) in this case if we are at 2 then first * will be performed which need sign as well)
                helper(num, target, curr + "-" + currNumStr, answer, i+1, -currNum, prevResult - currNum);
                // multiplication (here in place of previous value we are passing 'previousVal * currNum' because as per bodmas rule multiplication gets priority before - and +.
                helper(num, target, curr + "*" + currNumStr, answer, i+1, previousVal * currNum, prevResult - previousVal + (previousVal * currNum));
            }
        }
    }
}