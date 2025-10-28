package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Sieve of eratosthenes algorithm
     *
     * This algorithm is used to find all prime numbers till N
     *
     * TC -> O(N log(log(N)))
     * SC -> O(N)
     *
     * @param n Number till which primes need to be identified
     * @return result List of all prime numbers till n
     * @throws IllegalArgumentException in case of -ve n value
     */
    public List<Integer> getPrimeList(int n) throws IllegalArgumentException {
        // write your code here
        if (n < 0) {
            throw new IllegalArgumentException("Illegal argument");
        }

        List<Integer> result = new ArrayList<>();

        if(n == 0){
            return result;
        }

        boolean[] flag = new boolean[n + 1];
//        Arrays.fill(flag, true);
        flag[0] = true;
        flag[1] = true;

        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    flag[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if(!flag[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
