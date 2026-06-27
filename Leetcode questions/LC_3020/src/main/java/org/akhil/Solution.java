package org.akhil;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // Space and time complexity analysis
    // build the count map
    // space -> O(N) and time -> O(N)
    // N is length of nums. (if all values in nums are unique then space will be O(N) i.e. worst case)
    //
    // now outer loop runs O(N) times i.e. the unique keys present in count map.
    // now the inner loop might seem like running O(N) times but it is not (THIS IS WHAT IMPORTANT)
    // every time we are doing currNum = currNum * currNum (i.e. currNum^2)
    // so after k iterations the value of currNum will be currNum = num^(2^k) where num is the start value of currNum
    // and this can at max go till 10^9 because that is the upper bound as per constraints
    // so the stopping condition for inner loop will become
    // num^(2^k) > 10^9
    // lets say 10^9 = M
    // num^(2^k) > m    (the stopping condition)
    // log(num^(2^k)) > logM
    // (2^k)log(num) > logM
    // log(num) is can be considered constant and removed from TC
    // 2^k > logM
    // again taking log
    // klog2 > log(logM)
    // again log2 is constant hence we get
    // k > log(logM) as stopping condition
    // so at max we can run inner loop till
    // k <= log(log(M))
    // hence TC for inner loop is O(log(log(M)))
    // now this inner loop will run for N outer loop iterations hence overall TC for both the loops will be
    // O(N log(logM))
    // and the space compleity for loops is O(1)

    // hence the overall time and space complexity will be (considering dominant terms)
    // Space -> O(N)
    // time -> O(N log(log(M)))
    //
    // for this problem constraints M can be at max 10^9
    // so maximum iterations we can perform are for num=2 i.e. 2^5 means 5 iterations (because 2^6 goes beyond 10^9)
    // hence here we can say that the TC will also be O(N)
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int ones = 0;   // case of 1 is simple so we can handle it saperately

        for(int num:nums){
            count.put(num, count.getOrDefault(num, 0)+1);
            if(num == 1){
                ones++;
            }
        }

        // any power of 1 is always 1 (i.e 1^k = 1) hence in case of 1 we can say max ODD count of 1 can be possible answer
        // why odd count because the required sequence is of the form [1^1, 1^2, 1^4, 1^8, 1^4, 1^2, 1^1]. The 1^8 i.e. middle element makes
        // the sequence length odd.
        int result = (ones%2 == 0) ? ones-1 : ones;

        // now as one count is already considered we can remove it from count
        count.remove(1);

        // now check for every unique value from given nums (which will be key of the count map)
        for(int num:count.keySet()){

            int currLength = 0;
            int currNum = num;

            // check the sequence
            while(count.containsKey(currNum)){
                if(count.get(currNum) >= 2){    // if the frequency is >= 2 then we can add this number to the both side of middle number
                    currLength = currLength + 2;
                } else {
                    currLength++;
                    break;      // as this number is present only 1 time hence we can not add it to the both side so this has to be middle element
                }

                // if it was not middle element then check if we can add another element in the sequence
                currNum = currNum * currNum;
            }

            // we can end up with sequence like [2,4,8,8,4,2]
            // but we need middle element only 1 time hence we need to consider only [2,4,8,4,2]
            // Which means if the current length is even we have to let go of 1 value
            if(currLength % 2 == 0){
                result = Math.max(result, currLength-1);
            } else {
                result = Math.max(result, currLength);
            }
        }

        return result;
    }
}