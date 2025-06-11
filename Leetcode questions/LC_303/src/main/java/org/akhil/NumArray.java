package org.akhil;

// Solution 1 - Accepted but not the best one (will not be accepted in interview)
//class NumArray {
//    int[] arr = null;
//    public NumArray(int[] nums) {
//        arr = nums;
//    }
//
//    // O(N)/O(1) -> Not acceptable
//    public int sumRange(int left, int right) {
//        int sum = 0;
//        for(int i=left; i<=right; i++){
//            sum = sum + arr[i];
//        }
//        return sum;
//    }
//}


// This is more efficient as constructor calls will be less query is evaluated more often
class NumArray {
//    int[] arr = null;
    int[] prefixSum = null;

    // O(N)/O(N)
    public NumArray(int[] nums) {
//        arr = nums;
        prefixSum = new int[nums.length];

        int preSum = 0;
        for(int i=0; i<nums.length; i++){
            preSum = preSum + nums[i];
            prefixSum[i] = preSum;
        }
    }

    // O(1)/O(1)
    public int sumRange(int left, int right) {
        if(left == 0){
            return prefixSum[right];
        }

        return prefixSum[right] - prefixSum[left-1];
    }
}