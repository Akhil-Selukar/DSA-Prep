package org.akhil;

public class Solution {
    // Solution 1 - using bruteforce
    // O(N)/O(1)
    public boolean isNumber(String s) {
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numSeen = false;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= '0' && ch <= '9'){
                numSeen = true;
            } else if(ch == '.'){
                // after 'e' there should not be any '.' or in a number there can not be two '.'
                if(eSeen || dotSeen){
                    return false;
                }
                dotSeen = true;
            } else if(ch == 'e' || ch == 'E'){
                // 'e' can not be at the start (means there must be a num before e) and at the end (at the end condition is handled by switching numSeen to false here)
                if(eSeen || !numSeen){
                    return false;
                }
                numSeen = false;
                eSeen = true;
            } else if(ch == '-' || ch == '+'){
                // if sign is not at the start then there must be an 'e' or 'E' before it
                if(i != 0 && !(s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')){
                    return false;
                }
            } else {
                return false;       // there is something else at ith index that allowed chars.
            }
        }
        return numSeen;
    }
}
