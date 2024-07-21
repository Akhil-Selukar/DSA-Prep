package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {555,901,482,1771};
        int[] nums = {12,345,2,6,7896};
        int answer = findNumbers(nums);
        System.out.println(answer);
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for(int num:nums){
            int digits = getDigits(num);
            if(digits%2 == 0)
                count++;
        }
        return count;
    }

     static int getDigits(int num) {
        if(num == 0)
            return 1; // Check 'Interview tips question 1' from readme. If the number in array itself is 0 that means there is 1 digit i.e. 0.
        
        if(num < 0)
            num = num * -1; // Check 'Interview tips question 2' from readme. If number is -ve then below while loop will never execute and it will not calculate number of digits. Hence we need to make the number +ve for calculation.
        
//        int digits = 0;
//        while(num > 0){
//            digits++;
//            num = num/10;
//        }
//        return digits;

        // Above for loop has O(N) time complexity, and it can be optimized by using number system and maths like below.
         // Below code also find the number of digits in given number.
        return (int)(Math.log10(num))+1;
    }
}