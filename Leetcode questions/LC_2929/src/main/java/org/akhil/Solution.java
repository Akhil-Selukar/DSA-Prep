package org.akhil;

public class Solution {

    // Bruteforce solutions are same as that of LC-2928 but all those will give TLE.

    // O(X)/O(1)    where X -> min(n, limit)
    public long distributeCandies(int n, int limit) {
        long ways = 0;

        // calculate min and max candies possible for child 1
        int minToChild1 = Math.max(0, n - 2*limit);         // n-2*limit because apart from child 1 we have 2 more children and if we give max to those children automatically child1 will have min possible candies. This value can go -ve hence we limit min value to 0.
        int maxToChild1 = Math.min(n, limit);           // it is possible that we have 3 candies and limit is 5 in that case as we have less candies than limit so we can not assign candies = limit to the child as we dont have that many candies.

        // fix the candies for child1 and calculate combinations for remaining two children
        for(int i=minToChild1; i<=maxToChild1; i++){
            int remainingCandies = n-i;

            // distribute remaining candies to the two children.
            int minToChild2 = Math.max(remainingCandies, remainingCandies - limit);
            int maxToChild2 = Math.min(remainingCandies, limit);

            int waysToDistributeIn2 = maxToChild2 - minToChild2 + 1;

            ways =ways + waysToDistributeIn2;
        }

        return ways;
    }
}
