package org.akhil;

public class Solution {

    String ans = "";
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];

        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }

        // if char is not present at-least k times then it can not be used to create subsequence as we will not be able to repeat it k times
        for(int i=0; i<26; i++){
            if(freq[i] < k){
                freq[i] = 0;
            } else {
                freq[i] = freq[i]/k;        // as we have to repeat the subsequence k times hence allowed in subsequence will be freq/k.
            }
        }

        int maxLengthOfSubsequence = n / k;
        StringBuilder sb = new StringBuilder();

        helper(s, sb, freq, k, maxLengthOfSubsequence);

        return ans;
    }

    private void helper(String s, StringBuilder sb, int[] freq, int k, int maxLengthOfSubsequence) {
        if(sb.length() > maxLengthOfSubsequence){
            return;
        }

        // current string we have
        String currStr = sb.toString();

        // either length should be greater (strictly) or if length is equal then currStr must be lexicographically greater.
        if(currStr.length() > ans.length() || (currStr.length() == ans.length() && currStr.compareTo(ans) > 0)){
            if(isValidSubsequence(s, currStr, k)) {
                ans = currStr;
            }
        }

        // explore all subsequence combinations
        for(int i=25; i>=0; i--){       // checking from 'z' to 'a' as we need lexicographically largest first.
            if(freq[i] == 0){   // if the char is not allowed then skip it.
                continue;
            }

            sb.append((char)(i + 'a'));
            freq[i]--;
            helper(s, sb, freq, k, maxLengthOfSubsequence);
            // backtracking
            sb.deleteCharAt(sb.length()-1);
            freq[i]++;
        }
    }

    private boolean isValidSubsequence(String s, String currStr, int k) {
        int p1 = 0;
        int p2 = 0;

        while(p1 < s.length() && p2 < k * currStr.length()){
            if(s.charAt(p1) == currStr.charAt(p2 % currStr.length())){
                p2++;
            }
            p1++;
        }

        return p2 == (currStr.length() * k);
    }
}
