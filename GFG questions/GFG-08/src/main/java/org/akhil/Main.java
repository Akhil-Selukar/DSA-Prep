package org.akhil;

public class Main {
    public static void main(String[] args) {
        int num = 17;

        System.out.println(isPrime(num));
    }

    protected static String isPrime(int num) {
        return primeHelper(num, 2);
    }

    private static String primeHelper(int num, int i) {
        if(num == 1){
            return "Yes";
        }
        if(i*i <= num){
            if(num%i == 0){
                return "No";
            } else {
                return primeHelper(num, i+1);
            }
        } else {
            return "Yes";
        }
    }
}