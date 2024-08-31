package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "MCMXCIV"; // 1994

        System.out.println(romanToInt(s));
        System.out.println(romanToInt1(s));
    }

    public static int romanToInt(String s) {
        int size = s.length();
        int previous = 0;
        int ans = 0;
        int num = 0;

        for(int i = 0; i<size; i++){
            switch(s.charAt(i)){
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }
            if(num > previous){
                ans = ans - (2*previous) + num;
            } else {
                ans = ans + num;
            }
            previous = num;
        }
        return ans;
    }

    // we can reverse the for loop as well

    public static int romanToInt1(String s) {
        int size = s.length();
        int previous = 0;
        int ans = 0;
        int num = 0;

        for(int i = size-1; i>=0; i--){
            switch(s.charAt(i)){
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }
            if(num < previous){
                ans = ans - num;
            } else {
                ans = ans + num;
            }
            previous = num;
        }
        return ans;
    }
}