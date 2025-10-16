package org.akhil;

public class Solution {
    // O(N+V)/O(V)
    public int findSmallestInteger(int[] nums, int value) {

        int[] count = new int[value];
        for (int num : nums) {
            // int rem = Math.abs(num) % value;     // we cant do this directly because mod value will differ.
            int rem = ((num % value) + value) % value;      // to handle mod of negative numbers
            count[rem]++;
        }

        int result = 0;
        // if we have remainder 1 two times that means in our array by performing operations we can get 1 (1%5 = 1) and
        // 6 (6%5 = 1) so it is important to keep count.
        while(count[result%value] > 0){
            count[result%value]--;
            result++;
        }
        return result;
    }
}
