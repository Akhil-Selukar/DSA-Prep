package org.akhil;

public class Solution {

    // TC - O(K^C * K) where K is number of children and C is length of cookies array.
    // SC - O(K*C) K because of distribution array and C is recursion call stack depth.
//    int result = Integer.MAX_VALUE;
//    public int distributeCookies(int[] cookies, int k) {
//        int[] distribution = new int[k];        // O(1)/O(K)
//
//        helper(cookies, 0, distribution, k);    // O(K^C)/O(C)
//        return result;
//    }
//
//    private void helper(int[] cookies, int index, int[] distribution, int k) {
//        if(index == cookies.length){
//            int currDistMax = 0;
//            for(int val:distribution){
//                currDistMax = Math.max(currDistMax, val);
//            }
//            result = Math.min(result, currDistMax);
//            return;
//        }
//
//        for(int child=0; child<k; child++){         // O(K)/O(1)
//            distribution[child] = distribution[child] + cookies[index];
//            helper(cookies, index+1, distribution, k);
//            distribution[child] = distribution[child] - cookies[index];
//        }
//    }

    // Solution 1.1 - simple condition addition to avoid duplicate calculations which improves time complexity drastically.
    // theoretically there will not be any effect on TC and SC.
    int result = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] distribution = new int[k];        // O(1)/O(K)

        helper(cookies, 0, distribution, k);    // O(K^C)/O(C)
        return result;
    }

    private void helper(int[] cookies, int index, int[] distribution, int k) {
        if(index == cookies.length){
            int currDistMax = 0;
            for(int val:distribution){
                currDistMax = Math.max(currDistMax, val);
            }
            result = Math.min(result, currDistMax);
            return;
        }

        for(int child=0; child<k; child++){         // O(K)/O(1)
            distribution[child] = distribution[child] + cookies[index];
            helper(cookies, index+1, distribution, k);
            distribution[child] = distribution[child] - cookies[index];

            if (distribution[child] == 0){
                break;
            }
        }
    }
}
