package org.akhil;

public class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;

        while(temp > 0){
            sum = sum + temp%10;
            prod = prod * (temp%10);
            temp = temp/10;
        }

        return n%(sum+prod) == 0;
    }
}
