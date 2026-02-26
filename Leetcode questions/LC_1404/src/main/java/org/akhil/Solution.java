package org.akhil;

public class Solution {

    // Solution 1 - Bruteforce
    // This approach is fine but because of length of s i.e. 500 it will go till 2^500 which is way beyond long limit
    // so this approach will fail after a point.
    // O(N)/O(1)
    // public int numSteps(String s) {
    //     int n = s.length()-1;
    //     long num = 0;
    //     int result = 0;

    //     for(int i=0; i<s.length(); i++){
    //         int bit = s.charAt(i) == '1' ? 1 : 0;
    //         num = num + (long)(bit*Math.pow(2,n));
    //         n--;
    //     }

    //     while(num > 1){
    //         if(num%2 == 1){
    //             num = num+1;
    //         } else {
    //             num = num/2;
    //         }
    //         result++;
    //     }

    //     return result;
    // }

    // --------------------------
    // Solution 2 - Optimized (in terms of code not complexity)
    // O(N)/O(1)
    // public int numSteps(String s) {
    //     // we know that in binary representation of any number if LSB i.e. last bit/rightmmost bit is 1 then it is a odd number
    //     // and if it is 0 then it is a even number.
    //     // Now we are allowed below 2 operations
    //     // 1-> in case of even number, divide the number by 2.
    //     //     when we divide a binary number by 2 it is nothing but the right shift or the rightmost bit gets dropped.
    //     // 2 -> in case of odd number, add 1 to the number.
    //     //     when we add 1 to a binary number it always reflect at the first 0 from right and flips all bits to the right of that 0
    //     //     ex -> 10110111 + 1 = 10111000  (all the 3 one's from the right before 0 are flipped and the added 1 is reflected at the 4th place from right)
    //     // This is what we can use here, we can start iterating from right and check if the LSB is 0 or 1 and perform respective operation.
    //     // Now we don't have to actually modify the string we can just keep track of carry in case of addition of 1 and add 2 operations in the result.
    //     // Why 2 and not 1? because 1 operation is for addition (there we are not dropping the LSB but making the LSB as 0 so that we can drop it in next operation)
    //     // but in our loop we will keep track of carry and move to next index (i-1) so we are performing the drop operation as well so add 2 in final count of operation.
    //     // While in case of even number we can simply drop the LSB and add 1 to the count of moves.

    //     int result = 0;
    //     int n = s.length();
    //     int carry = 0;

    //     for(int i=n-1; i>=1; i--){          // This is IMP 'i>=1' because we need last character as 1 we dont want to change it
    //         if((s.charAt(i) == '0' && carry == 0) || (s.charAt(i) == '1' && carry == 1)){
    //             result++;
    //             // here no need to change carry as if we came with carry then charAt(i) has to be 1 and it will again generate the same carry 1+1=10
    //         } else {        // 1+0/0+1  (+ additional 1) so carry will remain 1
    //             result = result+2;
    //             carry = 1;
    //         }
    //     }

    //     return result+carry;        // + carry because we want last 1 and we are running loop till last but 1 element, hence if there is any carry then we will left with 2 elements 1 because we are runing loop til last but 1 and 1 because of carry, So to eliminate that carry we will need 1 extra operation.
    // }

    // --------------------------
    // Solution 2 - Optimized (slightly cleaned code)
    // O(N)/O(1)
    public int numSteps(String s) {
        int result = 0;
        int n = s.length();
        int carry = 0;

        for(int i=n-1; i>=1; i--){          // This is IMP 'i>=1' because we need last character as 1 we dont want to change it
            int bit = s.charAt(i)-'0';
            if((bit+carry)%2 == 0){     // even number
                result++;
            } else {        // odd number
                result = result+2;
                carry = 1;
            }
        }

        return result + carry;  // if we have carry that means we dont have only 1 left so need to add extra step (i.e carry to reove additional bit)
    }
}
