package org.akhil;

import java.util.Arrays;

public class Solution {
    // Here based on example 3 we can see that there can be duplicate characters and if a character is duplicate then we need to press
    // same key same nuber of times reperepeatedly to get the characters. So to minimize the number of key press we need to make sure
    // the character which appears the most has to be placed at the 1st press of any key.
    // So there will be 8 places where we can place highly repeating characters at 1st key place. For next 8 most repeating characters
    // we need to selsect place which is of 2 key press and so on.
    // So it is clear that we need frequency of how many times each character is repeated. Next we need to sort it as we need top 8
    // repeating characters first.
    // Here as actual character doesnot matter we need count only hence we can use array as well.
    public int minimumPushes(String word) {
        int n = word.length();
        int[] count = new int[26];

        for(char ch:word.toCharArray()){
            count[ch-'a']++;
        }

        Arrays.sort(count);

        int multFact = 1;
        int charsMapped = 0;
        int keyPress = 0;
        for(int i=25; i>=0; i--){
            if(count[i] > 0){
                keyPress = keyPress + (count[i]*multFact);
                charsMapped++;
                if(charsMapped%8 == 0){
                    multFact++;
                }
            }
        }
        return keyPress;
    }
}
