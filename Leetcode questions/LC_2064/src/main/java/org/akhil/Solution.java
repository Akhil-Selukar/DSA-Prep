package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(L*logL + L*log(MaxQ))/O(1)
    // As per constraints MaxQ can be 10^9 and L can be 10^5 hence dominant is MaxQ so time complexity can be simplified as O(L*log(MaxQ))
//    public int minimizedMaximum(int n, int[] quantities) {
//        Arrays.sort(quantities);        // O(L*logL) where L is length of quantities array.
//
//        int start = 0;
//        int end = quantities[quantities.length-1];
//        int answer = Integer.MAX_VALUE;
//
//        // O(log(MaxQ))  MaxQ is largest element in quantity array
//        while(start <= end){
//            int mid = start + (end-start)/2;
//
//            if(isPossible(mid, quantities, n)){
//                answer = Math.min(answer, mid);
//                end = mid-1;
//            } else {
//                start = mid+1;
//            }
//        }
//        return answer;
//    }
//
//
//    // O(Nums.length)   i.e. O(L) where L is length of quantity array.
//    private boolean isPossible(int mid, int[] nums, int n){
//        if(mid == 0){
//            return false;
//        }
//        int totalShopsServed = 0;
//        for(int num:nums){
//            totalShopsServed = totalShopsServed + num/mid;
//            if(num%mid != 0){
//                totalShopsServed++;
//            }
//        }
//        return totalShopsServed <= n;
//    }

    //---------------
    // Small enhancement which reduces the runtime

    public int minimizedMaximum(int n, int[] quantities) {
//        Arrays.sort(quantities);        // O(L*logL) where L is length of quantities array.

        int start = 0;
//        int end = quantities[quantities.length-1];
        int end = (int)1e5;     // as max value of quantities[i] can be 10^5
        int answer = Integer.MAX_VALUE;

        // O(log(MaxQ))  MaxQ is largest element in quantity array
        while(start <= end){
            int mid = start + (end-start)/2;

            if(isPossible(mid, quantities, n)){
                answer = Math.min(answer, mid);
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return answer;
    }


    // O(Nums.length)   i.e. O(L) where L is length of quantity array.
    private boolean isPossible(int mid, int[] nums, int n){
        if(mid == 0){
            return false;
        }
        int totalShopsServed = 0;
        for(int num:nums){
            totalShopsServed = totalShopsServed + num/mid;
            if(num%mid != 0){
                totalShopsServed++;
            }
        }
        return totalShopsServed <= n;
    }
}
