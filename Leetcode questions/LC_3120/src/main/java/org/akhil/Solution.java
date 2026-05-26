package org.akhil;

public class Solution {
    // Solution 1 - Using set
    // O(N)/O(1)
    // public int numberOfSpecialChars(String word) {
    //     Set<Character> lowerCase = new HashSet<>();
    //     Set<Character> upperCase = new HashSet<>();

    //     for(char ch:word.toCharArray()){
    //         if(Character.isLowerCase(ch)){
    //             lowerCase.add(ch);
    //         } else {
    //             upperCase.add(Character.toLowerCase(ch));   // convert to lowercase first and then add
    //         }
    //     }

    //     // check all chars in lowerCase are present in upperCase or not
    //     int count = 0;
    //     for(char ch:lowerCase){
    //         if(upperCase.contains(ch)){
    //             count++;
    //         }
    //     }

    //     return count;
    // }

    // -----------------------------

    // Solution 2 - Using array
    // O(N)/O(1)
    public int numberOfSpecialChars(String word) {
        boolean[] lowerCase = new boolean[26];
        boolean[] upperCase = new boolean[26];

        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lowerCase[ch-'a'] = true;
            } else {
                upperCase[ch-'A'] = true;
            }
        }

        // check all chars in lowerCase are present in upperCase or not
        int count = 0;
        for(int i=0; i<26; i++){
            if(lowerCase[i] && upperCase[i]){
                count++;
            }
        }

        return count;
    }
}
