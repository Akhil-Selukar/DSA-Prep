package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printValues(n);
    }

    private static void printValues(int n) {
        if(n == 0){
            return;
        }
        printValues(n-1);
        System.out.println(n);
    }
}