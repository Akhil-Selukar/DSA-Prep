package org.akhil;

public class Solution {
    // O(N)/O(1)
    public long countCommas(long n) {
        long count = 0;
        for (long i = 1000; i <= n; i = i * 1000) {
            count = count + (n - i + 1);
        }
        return count;
    }
}
