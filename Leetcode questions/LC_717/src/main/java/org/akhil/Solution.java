package org.akhil;

public class Solution {

//    // O(N)/O(1)
//    public boolean isOneBitCharacter(int[] bits) {
//        int i=0;
//        int n = bits.length;
//
//        // Most important edge case (it is given that array ends with 0 so if array has only 1 element then it must be 0 which is one-bit character
//        // so return true.
//        if(n == 1){
//            return true;
//        }
//
//        while(i<n){
//            if(bits[i] == 1){
//                i = i+2;
//            } else {
//                i++;
//            }
//            if(i == n-1){
//                return true;
//            }
//        }
//        return false;
//    }

    // ---------------
    // Solution 2 - slightly compact code
    // O(N)/O(1)
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        int n = bits.length-1;

        for(;i<n; i++){
            if(bits[i] == 1){
                i++;
            }
        }
        return i == n;
    }
}
