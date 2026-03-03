package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^2)/O(N)
    // Keep in mind that here value of n and k is given by considering indexing starts from 1
//    public char findKthBit(int n, int k) {
//        String s = "0";
//
//        for(int i=1; i<n; i++){
//            StringBuilder sb = new StringBuilder(s);
//            sb.append("1");
//
//            int len = s.length();
//            for(int j=0; j<len; j++){
//                sb.append((s.charAt(len-1-j) == '0') ? "1" : "0");
//            }
//
//            s = sb.toString();
//        }
//
//        return s.charAt(k-1);
//    }

    // -------------------------
    // Solution 2 - Optimized
    // as per the string construction formula we know that the concatenated "1" will always be at the middle of the string.
    // so if K is middle of the string then we can return "1". But how can we get the final length of string, that can be
    // easily calculated by observing some testcases.
    // After that if k is to the left of mid point we can shrink the string else we can grow the string but
    // we will need to invert the bit and count the bit from right i.e. end.
    // O(N)/O(N) for recursive stack
    public char findKthBit(int n, int k) {
        if(n == 1){
            return '0';
        }

        int lenOfFinalStr = (int)Math.pow(2,n)-1;

        if(k == (lenOfFinalStr/2)+1){       // k is midpoint of final string
            return '1';
        } else if( k <= (lenOfFinalStr/2)){
            // shrink the string
            return findKthBit(n-1, k);
        } else {
            char bit = findKthBit(n-1, lenOfFinalStr-k+1);
            return bit == '0' ? '1' : '0';
        }
    }
}
