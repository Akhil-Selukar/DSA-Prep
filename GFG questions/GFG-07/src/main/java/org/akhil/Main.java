package org.akhil;

public class Main {
    public static void main(String[] args) {
        int num = 12345;

        System.out.println(sumOfDigits(num));
    }

    protected static int sumOfDigits(int num) {
        if(num%10 == num){
            return num;
        }
        return num%10 + sumOfDigits(num/10);
    }
}