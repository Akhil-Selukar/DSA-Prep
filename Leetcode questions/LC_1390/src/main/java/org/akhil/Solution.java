package org.akhil;

public class Solution {

    // Solution 1 - Bruteforce
    // O(N*M)/O(1) where N is length of nums and M is the largest number in nums.
//    public int sumFourDivisors(int[] nums) {
//        int result = 0;
//
//        for(int num:nums){
//            int sum = 0;
//            int factorCount = 0;
//
//            for(int i=1; i<=num; i++){
//                if(num%i == 0){
//                    factorCount++;
//                    sum = sum + i;
//                }
//
//                if(factorCount > 4){
//                    break;
//                }
//            }
//
//            if(factorCount == 4){
//                result = result + sum;
//            }
//        }
//
//        return result;
//    }


    // ----------------
    // Solution 2 - Optimized
    // O(N*Sqrt(M)/O(1) where N is length of nums and M is the largest number in nums.
    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for(int num:nums){
            int sum = 0;
            int factorCount = 0;

            for(int i=1; i*i<=num; i++){
                if(num%i == 0){
                    factorCount += 2;
                    sum = sum + i + (num/i);
                }

                if(factorCount > 4){
                    break;
                }
            }

            if(factorCount == 4 && !isPerfectSq(num)){      // because in case of perfect sq same factor will be counted twice
                result = result + sum;
            }
        }

        return result;
    }

    private boolean isPerfectSq(int num){
        int sqRoot = (int)Math.sqrt(num);
        if((sqRoot * sqRoot) == num){
            return true;
        }
        return false;
    }
}
