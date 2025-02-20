package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int findSubstringInWraproundString(String s) {
        int[] count = new int[26];
        int adjacentCharsLength = 0;

        for(int i=0; i<s.length(); i++){
            if(i>0 && ((s.charAt(i)-s.charAt(i-1) == 1) || (s.charAt(i-1)-s.charAt(i) == 25))){
                adjacentCharsLength++;
            } else {
                adjacentCharsLength = 1;
            }

            count[s.charAt(i)-'a'] = Math.max(count[s.charAt(i)-'a'], adjacentCharsLength);     // max value because if we have some value and we are able to find value greater than that value then smaller value will cover in current larger one
        }

        int answer = 0;
        for(int num:count){
            answer = answer + num;
        }

        return answer;
    }
}
