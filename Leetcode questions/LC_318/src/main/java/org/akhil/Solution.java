package org.akhil;

public class Solution {

    // O(N*M + N^2) which will become O(N^2)/O(N)
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        int maxValue = 0;

        // O(N*M) where N is number of words in words array and M is length of longest word.
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                bits[i] = bits[i] | (1 << (words[i].charAt(j) - 'a'));
            }
        }

        // O(N^2) where N is the length of bits array or words array (as both will be same) (for every value of i we are
        // not checking all values of j but still in worst case for a value of i we will check for N values of J hence we
        // can say that it is N^2 but actually it will be slightly less that O(N^2). This is the dominating factor in overall
        // complexity calculation
        for(int i=0; i<bits.length; i++){
            for(int j=i; j<bits.length; j++){
                if((bits[i] & bits[j]) == 0){
                    maxValue = Math.max(maxValue, words[i].length() * words[j].length());
                }
            }
        }

        return maxValue;
    }
}
