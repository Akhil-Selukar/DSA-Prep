package org.akhil;

public class Solution {

    // Solution
    // to convert all values in given array to 1 we need at least a 1. (either it can already be present or we can convert a value
    // to 1 using given operation of GCD) This is because once we get a 1 then GCD of any number with 1 will be 1 and we will be able to
    // eventually convert all values. If there are already few 1's available then we don't need to convert them so the step will be reduced.
    // O(N*log(L))/O(log(L)) where L is the maximum value in nums.
    public int minOperations(int[] nums) {
        int oneCount = 0;
        long gcd = nums[0];

        if(nums[0] == 1){
            oneCount++;
        }

        for(int i=1; i<nums.length; i++){         // O(N)
            if(nums[i] == 1){
                oneCount++;
            }

            gcd = findGCD(gcd, nums[i]);
        }

        if(gcd > 1){    // if we cant get GCD 1 then solution is not possible.
            return -1;
        }

        // if gcd 1 is possible then either it is because we have some 1 present in array or we can convert some values to 1
        // if we have 1 present in nums
        if(oneCount > 0){
            return nums.length - oneCount;
        }

        // if we have to convert then
        int minStepsToGetGCDOne = Integer.MAX_VALUE;

        // nested for loop because we can start from any index i (given in problem) not necessary that we have to start from i=0, we can pick any i.
        // so we need to find such i, by starting from which we can get a 1 in minimum number of steps.
        for(int i=0; i<nums.length; i++){
            int currSteps = 0;
            gcd = nums[i];
            for(int j=i+1; j<nums.length; j++) {
                gcd = findGCD(gcd, nums[j]);
                currSteps++;
                // which we got 1 will also be added hence either subtract 1 from final answer or increment this below if condition
                if (gcd == 1) {
                    minStepsToGetGCDOne = Math.min(minStepsToGetGCDOne, currSteps);
                    break;      // check for new starting point i.
                }
            }
        }

        return nums.length -1 + minStepsToGetGCDOne;    // length -1 because after conversion a value will be 1 only and
                                                        // we will not have to convert it again. As it is counted in stepsToGetGCDOne
    }

    private long findGCD(long a, long b){           // O(log(min(a,b))
        a = Math.abs(a);
        b = Math.abs(b);

        if(a == 0){
            return b;
        }

        return findGCD(b%a, a);
    }
}
