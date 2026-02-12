package org.akhil;

class Solution {
    // Solution 1 - Bruteforce
    // O(N^2)/O(26) (TLE)
    // public int longestBalanced(String s) {
    //     int maxLen = 0;

    //     for(int i=0; i<s.length(); i++){
    //         for(int j=i; j<s.length(); j++){
    //             if(isBalanced(s, i, j)){
    //                 System.out.println(i+" | "+j);
    //                 maxLen = Math.max(maxLen, j-i+1);
    //             }
    //         }
    //     }
    //     return maxLen;
    // }

    // private boolean isBalanced(String s, int start, int end){
    //     int[] count = new int[26];

    //     for(int i=start; i<=end; i++){
    //         count[s.charAt(i)-'a']++;
    //     }

    //     int prevCount = 0;
    //     for(int n:count){
    //         if(prevCount != 0 && n != 0 && prevCount != n){
    //             return false;
    //         }
    //         if(n == 0){
    //             continue;
    //         }
    //         prevCount = n;
    //     }

    //     return true;
    // }

    // --------------------------------
    // Solution 2 - Bruteforce weith better code placement and clean isBalanced function
    // O(N^2)/O(26) -> (Runtime 2000+ ms)
    // public int longestBalanced(String s) {
    //     int maxLen = 0;

    //     for(int i=0; i<s.length(); i++){
    //         for(int j=i; j<s.length(); j++){
    //             // call isBalanced only when we know that in case of balanced substring that will be the longest
    //             if((j-i+1) > maxLen && isBalanced(s, i, j)){
    //                 maxLen = j-i+1;
    //             }
    //         }
    //     }
    //     return maxLen;
    // }

    // private boolean isBalanced(String s, int start, int end){
    //     int[] count = new int[26];

    //     for(int i=start; i<=end; i++){
    //         count[s.charAt(i)-'a']++;
    //     }

    //     int prevCount = 0;
    //     for(int n:count){
    //         // if the char is not present then it's frequency will be 0 so skip it
    //         if(n == 0){
    //             continue;
    //         }

    //         // set first non-zero frequency to prevCount
    //         if(prevCount == 0){
    //             prevCount = n;
    //         }

    //         if(prevCount != n){
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // --------------------------------
    // Solution 3 - Bruteforce with best code placement and clean isBalanced function
    // O(N^2)/O(26) (Runtime -> less than 100 ms)
    public int longestBalanced(String s) {
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            int[] count = new int[26];
            for(int j=i; j<s.length(); j++){        // if we are iterating here on index then why not store count here only rather than in isBalanced function, because there we will have to again traverse the string.
                count[s.charAt(j)-'a']++;
                // call isBalanced only when we know that in case of balanced substring that will be the longest
                if((j-i+1) > maxLen && isBalanced(count)){
                    maxLen = j-i+1;
                }
            }
        }
        return maxLen;
    }

    private boolean isBalanced(int[] count){

        int prevCount = 0;
        for(int n:count){
            // if the char is not present then it's frequency will be 0 so skip it
            if(n == 0){
                continue;
            }

            // set first non-zero frequency to prevCount
            if(prevCount == 0){
                prevCount = n;
            }

            if(prevCount != n){
                return false;
            }
        }

        return true;
    }
}