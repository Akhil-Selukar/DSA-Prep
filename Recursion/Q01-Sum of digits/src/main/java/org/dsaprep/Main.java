package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        // Write a program using recursion which will calculate and return sum of all digits in given number.
        // Ex: given number is 1264 so it should print 13 (because 1+2+6+4 = 13)

        int num = 1264;
        System.out.println(sumOfDigits(num));
    }

    private static int sumOfDigits(int num) {
        if(num == 0){
            return 0;
        }
        return num%10 + sumOfDigits(num/10);
    }
}