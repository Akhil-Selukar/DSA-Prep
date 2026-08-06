package org.akhil;

public class Solution {
    // O(N)/O(1) where N is number of digits in n
    public int smallestNumber(int n, int t) {
        while(!check(n, t)){
            n++;
        }
        return n;
    }

    private boolean check(int n, int t){
        int product = 1;
        while(n > 0){
            product = product * (n%10);
            n = n/10;
        }
        int remainder = product%t;
        return remainder == 0;
    }
}
