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
        if(n < 0){
            throw new IllegalArgumentException();
        }
        if(n == 0){
            return new ArrayList<>();
        }
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for(int i=2; i*i<=n; i++){
            if(arr[i]){
                for(int j=i*i; j<=n; j=j+i){        // start from i*i or i*2 i*i is more efficient. because first occurrence will be the prime one
                                                    // i.e. 2 is prime but 2*2 i.e. 4 and all other multiple of 2 are not. Or 3 is prime but 6 or 9 and all other multiple of 3 are not.
                    arr[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<=n; i++){
            if(arr[i]){
                result.add(i);
            }
        }
        return result;
    }
}
