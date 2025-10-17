package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    // Solution 1 - Without Memoization (TLE)
//    // O(2^N * 26)/O(N) space complexity is due to recursion call stack
//    public int maxPartitionsAfterOperations(String s, int k) {
//        return helper(s, k, 0, 0, true);
//    }
//
//    // uniqueChars is used to store the unique chars in currently considered string
//    // we have only lowercase english chars in the given string so there can be at max 26 chars.
//    // if we subtract 'a' from each char we get unique index value for each char (0 to 25) we can set that indexed bit to represent
//    // we have considered the char. If set bit count exceeds k that means it is time for the partition. (Here we can use Set but it will
//    // be hard while memoization, how to represent unique state of set while caching the result for a particular instance.
//    // index is till what index we have considered string (ether checking or partitioned)
//    private int helper(String s, int k, int index, long uniqueChars, boolean isChangeAllowed){
//        if(index >= s.length()){
//            // we have checked the last index, but as we have reached here means there was some
//            // string before which was not added in partition so that we need to add hence returning 1 from here.
//            return 1;       // either return 1 from here or if returning 0 then add 1 to final answer before returning.
//        }
//
//        // check the char at current index
//        char currCh = s.charAt(index);
//        int indexOfCurrChar = currCh - 'a';
//
//        // add this index to track unique chars
//        long updatedUniqueChars = uniqueChars | (1L << indexOfCurrChar);
//        // count of unique chars = number of set bits in uniqueChars
//        int uniqueCharsCount = Long.bitCount(updatedUniqueChars);
//
//        int result;
//        if(uniqueCharsCount > k){
//            // uniqueChars exceed the allowed limit of k
//            // note that we have passed updated uniqueChars value i.e. only considering curr char as current char is causing
//            // limit to exceed hence partition it till last index and current index is considered in next new partition.
//            result = 1 + helper(s, k, index+1, (1L << indexOfCurrChar), isChangeAllowed);
//        } else {
//            result = helper(s, k, index+1, updatedUniqueChars, isChangeAllowed);
//        }
//
//        // Above operations are without using the one allowed change in character. So now change the allowed char and try with it.
//        // we can change a character with 25 other chars.
//        if(isChangeAllowed){
//            for(int i=0; i<26; i++){
//                long newChars = uniqueChars | (1L << i);        // i is the index of char which we are replacing the curr char with.
//                int newUniqueCharCount = Long.bitCount(newChars);
//
//                if(newUniqueCharCount > k){
//                    result = Math.max(result, 1 + helper(s, k, index+1, (1L << i), false));
//                } else {
//                    result = Math.max(result, helper(s, k, index+1, newChars, false));
//                }
//            }
//        }
//
//        return result;
//    }

    // Solution 2 - With Memoization
    // O(N* uniqueChars)/O(N) space complexity is due to recursion call stack
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> dp = new HashMap<>();
        return helper(s, k, 0, 0, true, dp);
    }

    // uniqueChars is used to store the unique chars in currently considered string
    // we have only lowercase english chars in the given string so there can be at max 26 chars.
    // if we subtract 'a' from each char we get unique index value for each char (0 to 25) we can set that indexed bit to represent
    // we have considered the char. If set bit count exceeds k that means it is time for the partition. (Here we can use Set but it will
    // be hard while memoization, how to represent unique state of set while caching the result for a particular instance.
    // index is till what index we have considered string (ether checking or partitioned)
    private int helper(String s, int k, long index, long uniqueChars, boolean isChangeAllowed, Map<Long, Integer> dp){
        long key = (index << 27) | (uniqueChars << 1) | (isChangeAllowed ? 1 : 0);

        if (dp.containsKey(key)) {
            return dp.get(key);
        }


        if(index >= s.length()){
            // we have checked the last index, but as we have reached here means there was some
            // string before which was not added in partition so that we need to add hence returning 1 from here.
            return 1;       // either return 1 from here or if returning 0 then add 1 to final answer before returning.
        }

        // check the char at current index
        char currCh = s.charAt((int)index);
        int indexOfCurrChar = currCh - 'a';

        // add this index to track unique chars
        long updatedUniqueChars = uniqueChars | (1L << indexOfCurrChar);
        // count of unique chars = number of set bits in uniqueChars
        int uniqueCharsCount = Long.bitCount(updatedUniqueChars);

        int result;
        if(uniqueCharsCount > k){
            // uniqueChars exceed the allowed limit of k
            // note that we have passed updated uniqueChars value i.e. only considering curr char as current char is causing
            // limit to exceed hence partition it till last index and current index is considered in next new partition.
            result = 1 + helper(s, k, index+1, (1L << indexOfCurrChar), isChangeAllowed, dp);
        } else {
            result = helper(s, k, index+1, updatedUniqueChars, isChangeAllowed, dp);
        }

        // Above operations are without using the one allowed change in character. So now change the allowed char and try with it.
        // we can change a character with 25 other chars.
        if(isChangeAllowed){
            for(int i=0; i<26; i++){
                long newChars = uniqueChars | (1L << i);        // i is the index of char which we are replacing the curr char with.
                int newUniqueCharCount = Long.bitCount(newChars);

                if(newUniqueCharCount > k){
                    result = Math.max(result, 1 + helper(s, k, index+1, (1L << i), false, dp));
                } else {
                    result = Math.max(result, helper(s, k, index+1, newChars, false, dp));
                }
            }
        }

        dp.put(key, result);
        return result;
    }
}
