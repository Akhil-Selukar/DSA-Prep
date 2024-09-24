package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

//    Above problem can be solved much faster without using recursion, but it takes more space as we need to create an array of size n.

    public static int fib_2(int n) {
        if(n<=1){
            return n;
        }
        int[] tempArray = new int[n+1];

        tempArray[0] = 0;
        tempArray[1] = 1;

        for(int i=2; i<=tempArray.length-1; i++){
            tempArray[i] = tempArray[i-1]+tempArray[i-2];
        }
        return tempArray[n];
    }
}