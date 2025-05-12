package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[9];

        for (int num : digits) {
            freq[num]++;
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 8; k += 2) {
                    if (freq[i] > 0
                            && freq[j] > (i == j ? 1 : 0)
                            && freq[k] > ((i == k ? 1 : 0) + (k == j ? 1 : 0))) {
                        answer.add((i * 100) + (j * 10) + k);
                    }
                }
            }
        }

        int[] ans = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
}
