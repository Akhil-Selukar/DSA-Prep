package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    final int MOD = 7+(int)1e9;
    public int[] productQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        List<Integer> nums = new ArrayList<>();

        for(int i=0; i<32; i++){
            if((n & (1<<i)) != 0){
                nums.add((1<<i));       // pow(2,i);
            }
        }

        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            long product = 1;
            for(int j=start; j<=end; j++){
                product = (product * nums.get(j)) % MOD;
            }
            result[i] = (int)product;
        }

        return result;
    }
}
