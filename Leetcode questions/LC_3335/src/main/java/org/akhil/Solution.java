package org.akhil;

public class Solution {

    // O(N+T)/O(1)      where N is length of string and T is total number of transformations.
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = (int)(1e9 + 7);

        int[] currentState = new int[26];

        for(char ch:s.toCharArray()){
            currentState[ch - 'a']++;
        }

        while(t > 0){
            int[] futureState = new int[26];

            for(int i=0; i<26; i++){
                if(i<25){
                    futureState[i+1] = currentState[i];
                } else {        // i.e. the last char 'z'
                    futureState[0] = currentState[i];
                    futureState[1] = (futureState[1] + currentState[i])%MOD;
                }
            }
            currentState = futureState;
            t--;
        }

        int length = 0;

        for(int num:currentState){
            length = (length+num)%MOD;
        }

        return length;
    }
}
