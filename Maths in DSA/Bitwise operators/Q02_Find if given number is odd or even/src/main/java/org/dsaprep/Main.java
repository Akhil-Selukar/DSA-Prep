package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int num = 39;

        System.out.println(isEven(num));
    }

    protected static boolean isEven(int num) {
        return !((num & 1) == 1);
    }
}