package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(gicco(input));
    }

    protected static int gicco(String input) {
        String[] ip = input.split(" ");
        int firstValue = Integer.parseInt(ip[0]);
        int secondValue = Integer.parseInt(ip[1]);
        int thirdValue = Integer.parseInt(ip[2]);
        int targetIndex = Integer.parseInt(ip[3]);

        return giccoHelper(firstValue, secondValue, thirdValue, targetIndex);
    }

    private static int giccoHelper(int firstValue, int secondValue, int thirdValue, int targetIndex) {
        if(targetIndex == 1){
            return firstValue;
        }
        if(targetIndex == 2){
            return secondValue;
        }
        if(targetIndex == 3){
            return thirdValue;
        }

        return giccoHelper(firstValue, secondValue, thirdValue, targetIndex-1)
                + giccoHelper(firstValue, secondValue, thirdValue, targetIndex-2)
                + giccoHelper(firstValue, secondValue, thirdValue, targetIndex-3);
    }
}