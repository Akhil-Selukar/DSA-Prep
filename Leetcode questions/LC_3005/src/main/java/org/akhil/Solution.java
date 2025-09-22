package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // O(1)/O(1) -  as iterations of freq are constant no matter what is the length of nums.
//    public int maxFrequencyElements(int[] nums) {
//        int[] freq = new int[101];
//        int maxFreq = 0;
//        int result = 0;
//
//        for(int num:nums){
//            freq[num]++;
//            if(freq[num] > maxFreq){
//                maxFreq = freq[num];
//            }
//        }
//
//        for(int i=0; i<101; i++){
//            if(freq[i] == maxFreq){
//                result = result + maxFreq;
//            }
//        }
//
//        return result;
//    }

    // Solution 2 - optimized
    // O(N)/O(1) where N is length of nums.
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        int countOfMaxFreq = 0;

        for(int num:nums){
            freq[num]++;
            if(freq[num] > maxFreq){
                maxFreq = freq[num];
                countOfMaxFreq = 0;
            }
            if(freq[num] == maxFreq){
                countOfMaxFreq++;
            }
        }

        return countOfMaxFreq*maxFreq;
    }
}
