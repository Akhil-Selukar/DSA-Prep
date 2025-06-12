package org.akhil;

public class Solution {

    // Solution 1 - O(Nlog(N))/O(N)
//    public int[] countBits(int n) {
//        int[] ans = new int[n+1];
//
//        for(int i=0; i<=n; i++){
//            ans[i] = count(i);
//        }
//
//        return ans;
//    }
//
//    private int count(int i) {
//        int count = 0;
//        while(i != 0){
//            count += i & 1;
//            i = i>>1;
//        }
//        return count;
//    }


    // Solution 2 - O(N)/O(N)
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        ans[0] = 0;     // initial state (binary of 0 has no set bit.

        for(int i=1; i<=n; i++){
            ans[i] = ans[i/2] + i%2;
        }

        return ans;
    }
}
