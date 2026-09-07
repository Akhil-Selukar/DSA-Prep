package org.akhil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // // Bruteforce - O(N*2^N)/O(N*2^N)
    // // TLE
    // public int distinctSubseqII(String s) {
    //     Set<String> strs = new HashSet<>();
    //     helper(s, 0, new StringBuilder(), strs);

    //     return strs.size()%(int)(1e9+7);
    // }

    // private void helper(String s, int index, StringBuilder sb, Set<String> strs){
    //     if(index>=s.length()){
    //         return;
    //     }

    //     for(int i=index; i<s.length(); i++){
    //         sb.append(s.charAt(i));
    //         strs.add(sb.toString());
    //         helper(s, i+1, sb, strs);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }

    // -----------------------
    // Optimized O(N)/O(N)
    // here if we try to create subsequence we can easily observe that at index 0 we previously had an empty subsequence
    // (we can consider that as 1) so adding 0th index element will give us two option (i.e. add 0th index element or skip it)
    // making total subsequence 2. now if we consider 1st index element we will again have two choices (add or not add)
    // if we choose to not add the 1st index value then we will have original 2 subsequences and if we add 1st index value
    // then we will get 2 new subsequence making it total of 4 and so on if we try we will observe that addition of
    // each new value doubles the number of subsequence.
    // This is fine till we get duplicate char.
    // in case of duplicate consider example in s="abcb",
    // till index 1 we will have values ["", "a", "b", "ab"], now when we add c we will get double i.e. 8 values
    // ["", "a", "b", "ab", "c", "ac", "bc", "abc"] (observe first 4 as as it was before and next 4 are appended with c)
    // Now here is the important part, if we add next b. we will also encounter values which we had seen before adding previous b.
    // i.e. ["", "a"], in this only we added 1st b to get ["", "a", "b", "ab"] right. So now when we add 2nd be we will be
    // adding it again to all which are there before it (i.e. 8 values formed after including c) these 8 values also contain
    // ["", "a"] which we know if added with this 2nd b is going to give us ["b", "ab"] which we had already got by adding
    // 1st b. So from here we can observe a very important thing that is if we had encountered current char before, then it
    // will produce duplicate values exactly equal to the values we had obtained before adding previously encountered same char.
    // this is the hint that we need to store when we had observed the value previously and if observed then what was the
    // subsequence count before that.

    private static final int MOD = (int)(1e9+7);
    int[] dp = new int[2001];
    int[] prev; // to store when was the same char seen.

    public int distinctSubseqII(String s) {
        int n = s.length();

        Arrays.fill(dp, -1);
        prev = new int[n+1];

        int[] lastSeen = new int[26];
        for(int i = 1; i <= n; i++) {
            int idx = s.charAt(i-1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        return (helper(n) - 1 + MOD) % MOD;
    }

    private int helper(int n) {
        if(n == 0)
            return 1;
        if(dp[n] != -1)
            return dp[n];

        int total = (2 * helper(n-1)) % MOD;
        if(prev[n] != 0) {
            int duplicates = helper(prev[n] - 1);
            total = (total - duplicates + MOD) % MOD;
        }
        return dp[n] = total;
    }
}
