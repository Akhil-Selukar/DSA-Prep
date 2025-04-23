package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(N*log(N))/ O(1) - Here Space complexity is O(1) because max possible value of N is of digits 10^4 (and digit sum can go max till 36 i.e. 9999)
    // hence Map will have at max 37 keys (including 0) hence we can consider this as constant space. Also time to iterate over map will be considered as constant (at max O(37)).
//    public int countLargestGroup(int n) {
//        int count = 0;
//        int maxFreq = Integer.MIN_VALUE;
//        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
//        for(int i=1; i<=n; i++){
//            int digitSum = 0;
//            int num = i;
//
//            while(num > 0){
//                digitSum = digitSum + num % 10;
//                num = num / 10;
//            }
//            freq.put(digitSum, freq.getOrDefault(digitSum, 0)+1);
//            maxFreq = Math.max(maxFreq, freq.get(digitSum));
//        }
//
//        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
//            if(maxFreq == entry.getValue()){
//                count++;
//            }
//        }
//
//        return count;
//    }


    // Slight modification in code even though it will not impact time/space complexity neither improve time in this
    // problem but it is good to know that we can eliminate second loop and track count in first loop itself.

    public int countLargestGroup(int n) {
        int count = 0;
        int maxFreq = Integer.MIN_VALUE;
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i=1; i<=n; i++){
            int digitSum = 0;
            int num = i;

            while(num > 0){
                digitSum = digitSum + num % 10;
                num = num / 10;
            }
            freq.put(digitSum, freq.getOrDefault(digitSum, 0)+1);
            int frequency = freq.get(digitSum);

            if(frequency > maxFreq){
                count = 0;
                maxFreq = frequency;
            }
            if(maxFreq == frequency){
                count++;
            }
        }

        return count;
    }
}
