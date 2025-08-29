package org.akhil;

public class Solution {
    // If we observe some testcases we can observe that every time if the total number of flowers in both the rows are odd number Alice will win
    // Solution 1 - Bruteforce
    // O(M*N)/O(1) -> TLE
    // public long flowerGame(int n, int m) {

    //      long result = 0;
    //      for(int i=1; i<=n; i++){
    //          for(int j=1; j<=m; j++){
    //              if((i+j)%2 != 0){
    //                  result++;
    //              }
    //          }
    //      }

    //      return result;
    // }

    // -------------------
    // if we have odd value in first row (i.e. from [1, n] if we select odd value) then we need even value from second row.
    // So if we can find the total number of odd and even values in both the ranges then we can solve this in O(1)

    // Solution 2 - Optimized approach
    // O(1)/O(1)
    public long flowerGame(int n, int m) {
        long result = 0;

        long oddInFirst = (n+1)/2;
        long evenInSecond = m/2;

        result = result + (oddInFirst * evenInSecond);

        long evenInFirst = n/2;
        long oddInSecond = (m+1)/2;

        result = result + (evenInFirst * oddInSecond);

        return result;
    }
}
