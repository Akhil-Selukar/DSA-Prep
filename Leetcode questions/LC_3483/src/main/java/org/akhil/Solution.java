package org.akhil;

public class Solution {
    // Here bruteforce can be form each and every three digit number using recursion and check if it is even or not and based on that
    // update the count. But recursion will be a overkill here as we know that we need exactly 3 digit numbers and that too even
    // so units place of the number has to be either 0,2,4,6,8.
    // so we can simply form a frequency array and use 3 loops to fill three places and ensure units place is even.
    // as the constraints are 3<=n<=10 so it will be O(N^3) i.e O(1000) at max so well within limit

    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        int result = 0;

        for(int digit:digits){
            count[digit]++;
        }

        for(int i=1; i<10; i++){    // since hundred's place digit can not be 0 (will make num 2 digit) hence start from 1
            count[i]--;
            for(int j=0; j<10; j++){
                count[j]--;
                for(int k=0; k<10; k++){
                    count[k]--;
                    if(count[i] >= 0 && count[j] >= 0 && count[k] >= 0 && k%2 == 0){
                        result++;
                    }
                    count[k]++;
                }
                count[j]++;
            }
            count[i]++;
        }
        return result;
    }
}
