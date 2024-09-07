package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n){
        for(int i=1; i<=n; i++){
            for(int space=1; space<=2*(n-i); space++){
                System.out.print(" ");
            }
            int numbers = (2*i)-1;
            int num=i;
            boolean decrement = true;
            for(int j=1; j<=numbers; j++){
                System.out.print(num +" ");
                if(decrement){
                    num--;
                }else{
                    num++;
                }
                if(num == 0){
                    decrement = false;
                    num+=2;
                }
            }
            System.out.println();
        }
    }
}