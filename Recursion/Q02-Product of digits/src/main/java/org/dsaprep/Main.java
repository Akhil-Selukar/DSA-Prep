package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        // Write a program using recursion which will calculate and print product of all digits in given number.
        // Ex: if given number is 1256 should return 60 (because 1*2*5*6 = 60)

        int num = 1256;
        System.out.println(productOfDigits(num));
    }

    private static int productOfDigits(int num){
        if(num == 0){
            return 1;
        }
        return num%10 * productOfDigits(num/10);
    }
}