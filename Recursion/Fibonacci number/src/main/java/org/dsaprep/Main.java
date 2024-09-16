package org.dsaprep;

public class Main {
    public static void main(String[] args) {
//        This program will print n th fibonacci number where n is input from user.
        int n = 6; //8

        int ans = nThFibonacci(n);
        System.out.println(ans);
    }

    private static int nThFibonacci(int n) {
        if(n<2){
            return n;
        }
        return nThFibonacci(n-2) + nThFibonacci(n-1);
    }
}