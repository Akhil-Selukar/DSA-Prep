package org.akhil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int i=1; i<2*n; i++){
            // print spaces
            int spaces = i<=n?n-i:i-n;
            for(int space=1; space<=spaces; space++){
                System.out.print(" ");
            }

            // print numbers
            int value = i<=n?i:(2*n)-i;
            int numToPrinnt = i<=n?(2*i)-1:(4*n)-(2*i)-1; // 4n-2i-1 = (2n-1)-i+(2n-i)
            for(int j=1;j<=numToPrinnt; j++){
                System.out.print(Math.abs(value));
                value--;
                if(value == 0){
                    value-=2;
                }
            }
            System.out.println();
        }
    }
}