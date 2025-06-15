package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - Using ArrayList
    // O(3L) -> O(L)/O(L) where L is length of num or number of digits in num
//    public int maxDiff(int num) {
//        List<Integer> digits = new ArrayList<>();
//        while(num > 0){
//            digits.add(num%10);
//            num = num/10;
//        }
//
//        int changeForMax = -1;
//        int changeForMin = -1;
//        int minReplacement = 0;
//
//        for(int i=digits.size()-1; i>=0; i--){
//            int digit = digits.get(i);
//            if(changeForMax == -1 && digit != 9){
//                changeForMax = digit;
//            }
//            if(changeForMin == -1){
//                if(i == digits.size()-1 && digit != 1) {
//                    changeForMin = digit;
//                    minReplacement = 1;
//                }
//                if(i != digits.size()-1 && digit > 1){
//                    changeForMin = digit;
//                    minReplacement = 0;
//                }
//            }
//            if(changeForMin != -1 && changeForMax != -1){
//                break;
//            }
//        }
//
//        int maxNumber = 0;
//        int minNumber = 0;
//        for(int i = digits.size()-1; i>=0; i--){
//            int digit = digits.get(i);
//
//            if(digit == changeForMax){
//                maxNumber = (maxNumber * 10) + 9;
//            } else {
//                maxNumber = (maxNumber * 10) + digit;
//            }
//
//            if(digit == changeForMin){
//                minNumber = (minNumber * 10) + minReplacement;
//            } else {
//                minNumber = (minNumber * 10) + digit;
//            }
//        }
//
//        return maxNumber - minNumber;
//    }


    // Solution 2 - using char array
    // concept is same
    public int maxDiff(int num) {
        String number = Integer.toString(num);

        char[] maxNumber = number.toCharArray();
        char[] minNumber = number.toCharArray();
        int length =number.length();

        // generate max number
        for(int i=0; i<length; i++){
            if(maxNumber[i] != '9'){
                char target = maxNumber[i];
                for(int j=i; j<length; j++){
                    if(maxNumber[j] == target){
                        maxNumber[j] = '9';
                    }
                }
                break;
            }
        }

        // generate min number
        if(minNumber[0] > '1'){
            char target = minNumber[0];
            for(int i=0; i<length; i++){
                if(minNumber[i] == target){
                    minNumber[i] = '1';
                }
            }
        } else {
            // find first number > 1 from index 1 onwards
            for(int i=1; i<length; i++){
                if(minNumber[i] > '1'){
                    char target = minNumber[i];
                    for(int j=i; j<length; j++){
                        if(minNumber[j] == target){
                            minNumber[j] = '0';
                        }
                    }
                    break;
                }
            }
        }

        int max = Integer.parseInt(new String(maxNumber));
        int min = Integer.parseInt(new String(minNumber));

        return max-min;
    }
}
