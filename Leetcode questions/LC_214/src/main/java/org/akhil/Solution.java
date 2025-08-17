package org.akhil;

public class Solution {
    // Solution 1 - bruteforce
    // O(N^2)/O(N)
//    public String shortestPalindrome(String s) {
//        int length = s.length();
//        String reversedString = new StringBuilder(s).reverse().toString();
//
//        // Iterate through the string to find the longest palindromic prefix
//        for (int i = 0; i < length; i++) {
//            if (s.substring(0, length - i).equals(reversedString.substring(i))) {
//                return new StringBuilder(reversedString.substring(0, i))
//                        .append(s)
//                        .toString();
//            }
//        }
//        return "";
//    }

    // Solution 2 - using Karp-rabin concept (rolling hash)
    // O(N)/O(N)
    public String shortestPalindrome(String s) {
        int n = s.length();
        int index = -1;
        int prime = 79;
        long mod = (int)(1e9+7);         // because hash value can be huge
        long pow = 1;
        long hash1 = 0;
        long hash2 = 0;

        for (int i=0; i<n; i++) {
            hash1 = (hash1 * prime + s.charAt(i) - 'a' + 1) % mod;
            hash2 = (hash2 + (s.charAt(i) - 'a' + 1) * pow) % mod;
            pow = pow * prime % mod;

            if (hash1 == hash2){
                index = i;
            }
        }
        return new StringBuilder().append(s.substring(index + 1, n)).reverse().append(s).toString();
    }
}