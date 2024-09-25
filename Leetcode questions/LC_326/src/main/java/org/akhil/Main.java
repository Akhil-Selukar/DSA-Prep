package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(isPowerOfThree(n));
    }

    protected static boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        if(n == 0 || n%3 != 0){
            return false;
        }
        return isPowerOfThree(n/3);
    }
}