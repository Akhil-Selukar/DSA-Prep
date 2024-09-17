package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        // Write a code to calculate and return the count of 0's in given number.
        // Ex: If given number is 1020304 then it should return 3 because we have total 3 zeros.

        int num = 1020304;
        System.out.println(countZeros(num));
    }

    private static int countZeros(int num) {
        return helper(num, 0);
    }

    private static int helper(int num, int count) {
        if(num%10 == num){
            return count;
        }

        if(num%10 == 0){
            return helper(num/10, count+1);
        }
        return helper(num/10, count);
    }
}