package org.akhil;

public class Solution {

    // Solution using prefix sum concept
    // O(N)/O(N)
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixCount = new int[n];
        prefixCount[0] = customers.charAt(0) == 'Y' ? 1 : 0;

        for(int i=1; i<n; i++){
            prefixCount[i] = prefixCount[i-1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int minPenalty = Integer.MAX_VALUE;
        int resultIndex = n;

        for(int i=0; i<=n; i++){
            int leftPenalty = 0;
            int rightPenalty = prefixCount[n-1];

            if(i != 0){
                leftPenalty = i - prefixCount[i-1];
                rightPenalty = prefixCount[n-1] - prefixCount[i-1];
            }

            if((leftPenalty + rightPenalty) < minPenalty){
                minPenalty = (leftPenalty + rightPenalty);
                resultIndex = i;
            }
        }

        return resultIndex;
    }
}
