package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - Bruteforce
    // O(NlogN)/O(logN) -> space complexity will be logN because at max logN+1 number of elements will be stored in list at a time
    // private final int MOD = (int)(7+1e9);
    // public int concatenatedBinary(int n) {
    //     int result = 0;
    //     for(int i=1; i<=n; i++){        // O(N)
    //         int decimal = i;
    //         List<Integer> bits = new ArrayList<>();
    //         while(decimal>0){           // O(logN) as every time decimal is reduced by /2 factor
    //             // int bit = decimal%2;
    //             bits.add(0, decimal%2);
    //             decimal = decimal/2;
    //         }
    //         for(int bit:bits){
    //             result = ((result*2) + bit)%MOD;
    //         }
    //     }
    //     return result;
    // }


    // ---------------------

    // Solution 2 - Optimized
    // Here important thing to remember is that shift operator (left shift and right shift i.e << and >>) works on binary form of given number.
    // Now if we check the test cases we can observe following.
    // for n=3 we need to concatenate binary representation of 1, 2 and then 3 to make it "11011"
    // so if we start from binary representation of 0 -> 0 (will not impact result as 011011 == 11011)
    // now at i=1, if we append "1" to '0' i.e. previous answer we will get "01"
    // now at i=2, if we append "10" i.e. binary of 2 to previous answer "01" we will get "0110"
    // now at i=3, if we append "11 to previous answer we will get "011011"
    //
    // if we observe carefully at i=1 we shifted the previous answer i.e. 0 to left by 1 bit and added the 1 to shifting result to get 01
    // at i=2, we shifted 01 i.e. previous result to left by 2 bits and then added 2 i.e. 10 to shifted value to get 0110
    // similarly in case of 3 as well.
    // so in general we are first making the space for new bits addition to the right side of previous result by shifting it to the left.
    // But how much shift we need to do, that we can identify if we somehow got to know how many bits are there in current numbers binary representation
    // this we can calculate by using '(log(N) base 2) + 1'
    // so this is what we will use.

    // O(N)/O(1)
//    private final int MOD = (int)(7+1e9);
//    public int concatenatedBinary(int n) {
//        long result = 0;
//        for(int i=1; i<=n; i++){
//            // number of bits in binary representation of curr no.
//            int noOfBits = (int)(Math.log(i)/Math.log(2)) + 1;
//
//            result = (((result << noOfBits)%MOD) + i)%MOD;  // left shift operation happen on binary form hence this will work
//
//        }
//        return (int)result;
//    }

    // --------------------
    // Solution 3 - same comcept but without using Math.log()
    // O(N)/O(1)
    private final int MOD = (int)(7+1e9);
    public int concatenatedBinary(int n) {
        long result = 0;
        int noOfBits = 0;
        for(int i=1; i<=n; i++){

            if((i & (i-1)) == 0){   // whenever no of bits increases it adds new 1 to the left most bit and all rightmost bits becae 1, while just before that all right bits are 1 so if we take & of number and lits previous no and it give 0 then that means new bit was added this time.
                noOfBits++;
            }

            result = (((result << noOfBits)%MOD) + i)%MOD;  // left shift operation happen on binary form hence this will work
        }
        return (int)result;
    }
}
