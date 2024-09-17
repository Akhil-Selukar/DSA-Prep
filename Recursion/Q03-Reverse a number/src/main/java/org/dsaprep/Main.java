package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        // write a program using recursion which will reverse a given number.
        // Ex: if given number is 1234 then it should print 4321

        int num = 12345;
        // way 1
//        reverse(num);
//        System.out.println(sum);

        // way 2
        System.out.println(reverse1(num));
    }

    // way 1 using static variable sum
//    static int sum = 0;
//    private static void reverse(int num){
//        if(num == 0){
//            return;
//        }
//        sum = sum*10 + num%10;
//        reverse(num/10);
//    }

    // way 2 without using static variable.

    private static int reverse1(int num) {
        int digits = (int)Math.log10(num)+1;  // this will give the number of digits in given number.

        return helper(num, digits);     // here we have created another helper function. (whenever we need to pass extra values/variables to help us in result generation we should create helper function and pass values in it)
    }

    private static int helper(int num, int digits) {
        if(num%10 == num){
            return num;
        }
        return num%10 * (int)Math.pow(10, digits-1) + helper(num/10, digits-1);
    }
}