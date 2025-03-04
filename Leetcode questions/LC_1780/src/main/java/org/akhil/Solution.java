package org.akhil;

public class Solution {

    // O(log(N))/O(1)    ideally time complexity will be O(log<sub>3<sub>N) i.e. log to the base 3 of N.
    public boolean checkPowersOfThree(int n) {
        while(n != 0){
            if((n % 3) >=2){
                return false;
            }
            n = n/3;
        }
        return true;
    }
}
