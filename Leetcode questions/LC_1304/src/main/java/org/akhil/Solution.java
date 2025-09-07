package org.akhil;

public class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];

        // we need odd number of elements so middle we will keep as 0 and add complementing numbers to each end
        if(n%2 != 0){
            for(int i=0, j=n-1; i<n/2 && j>n/2; i++, j--){
                result[i] = -1*((n/2)-i);
                result[j] = ((n/2)-i);
            }
        } else {
            for(int i=0, j=n-1; i<=n/2 && j>=n/2; i++, j--){
                result[i] = -1*((n/2)-i);
                result[j] = ((n/2)-i);
            }
        }
        return result;
    }
}
