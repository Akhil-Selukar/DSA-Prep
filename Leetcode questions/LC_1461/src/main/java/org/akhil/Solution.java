package org.akhil;

import java.util.HashSet;
import java.util.Set;

// We need to check the combinations of k length in given binary string.
// As we know in binary representation we can have only 2 digits 0 and 1, and if we want to create all combinations of 0's and 1's of length k.
// then we will have 2^k combinations. So if we break the given binary string into substrings of k length and find all unique out of them.
// then we can simply check if the unique substring count is equal to 2^k or not. if yes than all substrings are there else some substrings are missing.
public class Solution {

    // Bruteforce
    // O(N*k)/O(2^k)
    // TC -> We are running the for loop (n-k) times so O(N-K) ~ O(N) and for each iteration we are extracting substring of length k
    // which will take O(K) time. Hence final time complexity will be O(N*K). But as value of K is <= 20 which is very small hence we can say TC as O(N)
    // SC -> for each value of K at max 2^K unique combinations of binary bits are possible and hence we will be storing at max 2^K strings in the set
    // Hence SC is O(2^K) (though this is exponential but as value is K is small hence this is fine)
    public boolean hasAllCodes(String s, int k) {
        int start = 0;
        int n = s.length();
        Set<String> uniqueStr = new HashSet<>();

        while(start <= n-k){
            uniqueStr.add(s.substring(start, start+k));
            start++;
        }

        if(uniqueStr.size() == Math.pow(2, k)){
            return true;
        }
        return false;
    }
}
