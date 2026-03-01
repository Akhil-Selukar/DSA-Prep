package org.akhil;

public class Solution {
    //Solution 1 - bruteforce
    // O(N)/O(1)
    // Here important thing to notice is that the 'deci-binary' are NOT actually binary representation, it just means that the bumbers
    // can only have 1 and 0 in it. So if this is the case then if in final target number 'n' we have 3 at units place then while adding
    // deci-binary numbers we need exactly 3 ones in the numbers we are choosing. So if we keep on checking like this we can see that
    // whatever is the max digit in n that many 1's we will need so that many deci-binary numbers we will need.
    // consider 82734, at units place we need exactly 4 ones at tens we need exactly 3 ones and so on. So it will look like below

    // n ->  8  2  7  3  4
    //   ->  1  1  1  1  1
    //   ->  1  1  1  1  1
    //   ->  1     1  1  1
    //   ->  1     1     1
    //   ->  1     1
    //   ->  1     1
    //   ->  1     1
    //   ->  1
    //      ---------------     // consider 0 at blank spaces
    //   ->  8  2  7  3  4
    // so we need exactly 8 deci-binary numbers. which is nothing but the max digit in n.

    public int minPartitions(String n) {
        int result = 0;
        for(char ch:n.toCharArray()){
            int bit = ch -'0';
            result = Math.max(result, bit);
        }

        return result;
    }
}
