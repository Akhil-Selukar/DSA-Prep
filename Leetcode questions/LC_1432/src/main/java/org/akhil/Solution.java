package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(3L) -> O(L)/O(L) where L is length of num or number of digits in num
    public int maxDiff(int num) {
        List<Integer> digits = new ArrayList<>();
        while(num > 0){
            digits.add(num%10);
            num = num/10;
        }

        int changeForMax = -1;
        int changeForMin = -1;
        int minReplacement = 0;

        for(int i=digits.size()-1; i>=0; i--){
            int digit = digits.get(i);
            if(changeForMax == -1 && digit != 9){
                changeForMax = digit;
            }
            if(changeForMin == -1){
                if(i == digits.size()-1 && digit != 1) {
                    changeForMin = digit;
                    minReplacement = 1;
                }
                if(i != digits.size()-1 && digit > 1){
                    changeForMin = digit;
                    minReplacement = 0;
                }
            }
            if(changeForMin != -1 && changeForMax != -1){
                break;
            }
        }

        int maxNumber = 0;
        int minNumber = 0;
        for(int i = digits.size()-1; i>=0; i--){
            int digit = digits.get(i);

            if(digit == changeForMax){
                maxNumber = (maxNumber * 10) + 9;
            } else {
                maxNumber = (maxNumber * 10) + digit;
            }

            if(digit == changeForMin){
                minNumber = (minNumber * 10) + minReplacement;
            } else {
                minNumber = (minNumber * 10) + digit;
            }
        }

        return maxNumber - minNumber;
    }
}
