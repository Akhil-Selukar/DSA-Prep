package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution using sorting
    // TC -> O(NlogN + N^2 + N) ~ O(N^2)
    // SC -> O(N)
    public int[][] reconstructQueue(int[][] people) {
        // Sorting  O(NlogN)
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];       // ascending order of 'ki'
            }
            return b[0] - a[0];         // descending order of 'hi'
        });


        List<int[]> list = new ArrayList<>();

        // rearrange based on observation [hi, ki] at ki th index.
        // O(N^2) because it involves shifting of values which can have N shifts N times.
        for (int[] pair : people) {
            list.add(pair[1], pair);
        }

        int index = 0;
        for (int[] pair : list) {   // O(N)
            people[index] = pair;
            index++;
        }

        return people;
    }
}
