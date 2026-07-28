package org.akhil;

public class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }

        char[] result = new char[n];
        int index = 0;
        for(int i=0; i<26; i++){
            while(freq[i] >= 2){
                result[index] = (char)((int)'a'+i);
                result[n-1-index] = (char)((int)'a'+i);

                index++;
                freq[i] -= 2;
            }

            if(freq[i] == 1){   // there can be at max 1 such case hence directly assign to min index
                result[n/2] = (char)((int)'a'+i);
            }
        }

        return new String(result);
    }
}
