package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(NlogN)/O(1)    NlogN for sorting and there will be a component of O(K) (i.e. O(NlogN + K) because of while loop but
    // dominant term is NlogN hence overall TC will be O(NlogN)
    public long maximumHappinessSum(int[] happiness, int k) {
        int takenStudents = 0;
        long result = 0;

        Arrays.sort(happiness);
        int index = happiness.length-1;

        while(index >= 0 && takenStudents < k){
            result = result + Math.max(0, happiness[index] - takenStudents);
            index--;
            takenStudents++;
        }
        return result;
    }
}
