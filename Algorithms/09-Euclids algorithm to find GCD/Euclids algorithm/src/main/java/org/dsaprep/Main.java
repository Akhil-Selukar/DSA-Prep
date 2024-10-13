package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        System.out.println(euclidGcd(a,b));
    }

    protected static int euclidGcd(int a, int b) {
        if(a == 0){
            return b;
        }
        return euclidGcd(b%a, a);
    }
}