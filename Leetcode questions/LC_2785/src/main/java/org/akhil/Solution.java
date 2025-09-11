package org.akhil;

import java.util.*;

class Solution {
    // // Solution 1 - Bruteforce
    // // O(N + NlogN)/O(N)
    // public String sortVowels(String s) {
    //     List<Character> chars = new ArrayList<>();

    //     for(char ch:s.toCharArray()){       // O(N)
    //         if(isVowel(ch)){
    //             chars.add(ch);
    //         }
    //     }

    //     Collections.sort(chars);        // O(NlogN)

    //     StringBuilder sb = new StringBuilder();

    //     for(char ch:s.toCharArray()){       // O(N)
    //         if(isVowel(ch)){
    //             sb.append(chars.remove(0));
    //         } else {
    //             sb.append(ch);
    //         }
    //     }

    //     return sb.toString();
    // }

    // private boolean isVowel(char ch){
    //     ch = Character.toLowerCase(ch);
    //     return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    // }


    // ---------------------------
    // Solution 2 - using the fact that we have finite number of vowels
    // O(N)/O(N)
    public String sortVowels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        String vowels = "AEIOUaeiou";
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                int i = 0;
                while(map.getOrDefault(vowels.charAt(i), 0) == 0){
                    i++;
                }
                sb.append(vowels.charAt(i));
                map.put(vowels.charAt(i), map.get(vowels.charAt(i))-1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
