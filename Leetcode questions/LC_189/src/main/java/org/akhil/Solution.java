package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - Not optimized and will give TLE.
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        List<Integer> list = new ArrayList<>();
//
//        for(int num:nums){
//            list.add(num);
//        }
//
//        for(int i=0; i<k; i++){
//            list.add(0, list.get(list.size()-1));
//            list.remove(list.size()-1);
//        }
//
//        for(int i=0; i<nums.length; i++){
//            nums[i] = list.get(i);
//        }
//    }

    // Solution 2 - Accepted but still not optimized ( O(N)/O(N))
//    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n;
//        int[] rotated = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            rotated[(i + k) % n] = nums[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = rotated[i];
//        }
//    }

    // Solution 3 - Faster but still not fully optimized. (O(N)/O(N))
    /*
     * Rotation of array by 'k' places means nothing but take last k values from the array and copy it to the start.
     * Which itself means in an empty array first place last 'k' elements, then place elements from i=0 to i=length-k.
     */
//    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n;
//
//        if(k != 0){     // if k = 0 then no need to rotate.
//            int[] temp = new int[n];
//            System.arraycopy(nums, n-k, temp, 0, k);  // O(k)  // copy from nums's n-k th index to temp. place at 0th index in temp copy k elements.
//            System.arraycopy(nums, 0, temp, k, n-k);   // O(N-k)
//            System.arraycopy(temp, 0, nums, 0, n);    // O(N) hence overall TC = O(N)
//        }
//    }

    // Solution 4 - Fully optimized (in place rotation (O(n)/O(1)))
    /*
     * In this approach first reverse entire array. Then split array from kth index and reverse both split arrays individually
     * The resultant will be the answer.
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-1);    // reverse entire array
        reverse(nums, 0, k-1); // reverse first part
        reverse(nums, k, n-1);  // reverse second part
    }

    private void reverse(int[] nums, int startIndex, int endIndex){
        while(startIndex<=endIndex){
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
