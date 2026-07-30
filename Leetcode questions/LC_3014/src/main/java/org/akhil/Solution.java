package org.akhil;

public class Solution {
    public int minimumPushes(String word) {
        int wordLen = word.length();

        int mulFact = 1;
        int keyPress = 0;
        while(wordLen > 0){
            if(wordLen >= 8){
                keyPress = keyPress + (8*mulFact);
            } else {
                keyPress = keyPress + (wordLen*mulFact);
            }
            wordLen = wordLen-8;
            mulFact++;
        }

        return keyPress;
    }
}
