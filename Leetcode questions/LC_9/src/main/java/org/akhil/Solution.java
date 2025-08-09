package org.akhil;

public class Solution {
    // O(N)/O(1) where N is length of x (i.e. log(x))
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }

        int reverse = 0;
        int copy = x;

        while(x != 0){
            reverse = (reverse * 10) + x%10;
            x = x/10;
        }

        return reverse == copy;
    }
}
