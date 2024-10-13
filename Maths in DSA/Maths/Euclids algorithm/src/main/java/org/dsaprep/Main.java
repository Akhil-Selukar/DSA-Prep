package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int a = 33;
        int b = 11;

        System.out.println("HCF = "+ euclidGcd(a,b));
        System.out.println("LCM = "+ lcm(a,b));
    }

    protected static int euclidGcd(int a, int b) {
        if(a == 0){
            return b;
        }
        return euclidGcd(b%a, a);
    }

    protected static int lcm(int a, int b){
        return (a*b)/euclidGcd(a,b);
    }
}