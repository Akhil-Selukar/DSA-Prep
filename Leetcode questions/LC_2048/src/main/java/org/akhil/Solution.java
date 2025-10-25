package org.akhil;

public class Solution {
//    // Solution 1 - Bruteforce
//    // TC -> O(1224444 * log10(num)) if we consider 1224444 as upper limit U.
//    // As we are starting from n+1 So TC will be O(U-N)
//    // SC -> O(1)
//    public int nextBeautifulNumber(int n) {
//        // O(1224444)
//       for(int start = n+1; start <= 1224444; start++){     // <= 1224444 because upper limit of n is 10^6 so last balanced number we can get is 1224444
//           if(isBalanced(start)){
//               return start;
//           }
//       }
//       return -1;
//    }
//
//    // O(1) i.e. (O(7+10))
//    private boolean isBalanced(int num){
//        int[] count = new int[10];
//
//        // O(D) i.e. O(log10(num)) because D is number of digits in num.
//        // At max D can be 7 because upper limit is 10^6 hence this can be considered as O(7)
//        while(num > 0){
//            int unitDigit = num%10;
//            count[unitDigit]++;
//            num = num/10;
//        }
//
//        for(int i=0; i<10; i++){        // O(10)
//            if(count[i] > 0 && count[i] != i){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // ----------------------
    // Solution 2 - Using backtracking
    // TC -> O(9^d) where d is number of digits we need in result. Because of constraints d can at max be 7 hence
    // TC will be O(9^7) i.e. constant
    // SC -> O(1)
    public int nextBeautifulNumber(int n) {
        int[] freq = {0,1,2,3,4,5,6,7,8,9};         // these are the allowed digit counts.
        int numOfDigits = String.valueOf(n).length();   // minimum number of digits that has to be there in result.

        // backtracking
        int result = helper(0, n, numOfDigits , freq);
        if(result == 0){
            result = helper(0, n, numOfDigits+1, freq);        // because with allowed number of digits it is not possible to for a balanced number
        }

        return result;
    }

    // there are number of digits places which we want to fill and each place has 9 options so total possible values are
    // 9^d where d is number of digits hence O(9^d)
    private int helper(int currNum, int n, int allowedDigits, int[] freq){
        // base case
        if(allowedDigits == 0){
            if(isBalanced(currNum) && currNum > n){
                return currNum;
            }
            return 0;
        }

        // backtracking calls
        int result = 0;
        for(int i=1; i<10; i++){
            if(freq[i] > 0 && freq[i] <= allowedDigits){
                freq[i]--;
                int newNum = currNum * 10 + i;
                result = helper(newNum, n, allowedDigits - 1, freq);
                freq[i]++;
            }
            if(result != 0){
                return result;
            }
        }
        return result;
    }

    // O(1) i.e. (O(7+10))
    private boolean isBalanced(int num){
        int[] count = new int[10];

        // O(D) i.e. O(log10(num)) because D is number of digits in num.
        // At max D can be 7 because upper limit is 10^6 hence this can be considered as O(7)
        while(num > 0){
            int unitDigit = num%10;
            count[unitDigit]++;
            num = num/10;
        }

        for(int i=0; i<10; i++){        // O(10)
            if(count[i] > 0 && count[i] != i){
                return false;
            }
        }

        return true;
    }
}
