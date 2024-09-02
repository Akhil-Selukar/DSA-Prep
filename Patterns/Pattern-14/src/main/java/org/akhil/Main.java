package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {

        for(int i=0; i<n; i++){

            if(i == 0){ // print first row
                for(int star=0; star<2*n-1;star++){
                    System.out.print("*");
                }
            }
            if(i == n-1){ // print last row
                for(int space=1; space<n; space++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            if(i != 0 && i != n-1){
                for(int space=1; space<=i; space++){
                    System.out.print(" ");
                }
                System.out.print("*");
                for(int space = 0; space<((2*n-1)-(2*(i+1))); space++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}