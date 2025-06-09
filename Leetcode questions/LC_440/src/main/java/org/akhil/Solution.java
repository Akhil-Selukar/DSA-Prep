package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 -> bruteforce O(N)/O(N) -> Memory limit exceeds
//    public int findKthNumber(int n, int k) {
//        List<Integer> numbers = new ArrayList<>();
//
//        for(int i=1; i<=9; i++){
//            helper(i, n, numbers);
//        }
//
//        return numbers.get(k-1);
//    }
//
//    private void helper(int curr, int n, List<Integer> numbers) {
//        if(curr > n){
//            return;
//        }
//
//        numbers.add(curr);
//
//        for(int i=0; i<=9; i++){
//            int next = curr * 10 + i;
//            if(next > n){
//                return;
//            }
//            helper(next, n, numbers);
//        }
//    }


    // Solution 2 - skipping values
    // Here if we see constraints then N can go till 10^9 and we need solution in 10^8 ms. Also generating all the values are pointless as we need specific value.
    // Hence we have to somehow think about skipping the values which are not necessary, i.e. if we could somehow find that from what digit our ans will start we can simply
    // skip all digits less than that digit. (suppose the ans starts with 4 then we can skip calculating all values starting from 1, 2 and 3, this will reduce time as well as space.)

    // TC - O(log base10 N)
    // SC - O(1)
    public int findKthNumber(int n, int k) {
        int curr = 1;   //Current number
        k = k-1;        //Skip the number which you are already present at (i.e. 1) because we are already standing at this number means it is considered.

        while(k>0){
            int values = countValues(n, curr, curr+1);        // values = number of values which will be present between curr and curr+1 in lexicographical order
            if(values <= k){
                curr++;
                k = k- values;
            }else{
                curr = curr * 10;
                k--;    // current element is considered hence remove 1 from k;
            }
        }

        return curr;
    }

    private int countValues(int n, long p1, long p2){
        long values=0;

        while(p1 <= n){
            values = values + Math.min(n+1, p2) - p1;       // n+1 because we are including nth value in count

            // move to next level
            p1 = p1 * 10;
            p2 = p2 * 10;
        }

        return (int)values;
    }
}
