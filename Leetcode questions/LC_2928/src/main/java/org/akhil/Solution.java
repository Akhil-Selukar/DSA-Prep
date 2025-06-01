package org.akhil;

public class Solution {

    // Solution 1 - Explore all combinations and select only those where sum of all candies equal to n
    // O(Limit^3)/O(1)
//    public int distributeCandies(int n, int limit) {
//        int ways = 0;
//
//        for(int i=0; i<=limit; i++){
//            for(int j=0; j<=limit; j++){
//                for(int k=0; k<=limit; k++){
//                    if((i+j+k) == n){
//                        ways++;
//                    }
//                }
//            }
//        }
//        return ways;
//    }


    // Solution 2 - explore all combinations but with only 2 loops (children-1)
    // O(Limit^2)/O(1)
    public int distributeCandies(int n, int limit) {
        int ways = 0;

        for(int i=0; i<=limit; i++){
            for(int j=0; j<=limit; j++){
                int k = n-(i+j);
                if(k >=0 && k<=limit){
                    ways++;
                }
            }
        }
        return ways;
    }
}
