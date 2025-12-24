package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1
    // O(N+MlogM)/O(1)
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = Arrays.stream(apple).sum();
        Arrays.sort(capacity);

        int count = 0;
        for(int i=capacity.length-1; i>=0; i--){
            count++;
            totalApples = totalApples - capacity[i];
            if(totalApples <= 0){
                return count;
            }
        }

        return -1;
    }
}
