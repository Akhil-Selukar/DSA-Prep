package org.akhil;

public class Solution {

    // O(LogN)/O(1)
    public boolean isUgly(int n) {
        // -ve value means it will have atleast 1 negative factor which means it will have atleast 1 factor apart from 2,3 and 5
        if(n <=0){
            return false;
        }

        // divide by all possible even factors (i.e. 2, 4, 6, 8, ...)
        while(n % 2 == 0){
            n = n/2;
        }

        // divide all possible 3's multiple (i.e. 3, 6, 9, 12,...)
        while(n % 3 == 0){
            n = n/3;
        }

        // divide all possible 5's multiple (i.e. 5, 10, 15,...)
        while(n % 5 == 0){
            n = n/5;
        }

        // the only thing remaining will be product of factors apart from 2, 3 and 5
        return n == 1;
    }
}
