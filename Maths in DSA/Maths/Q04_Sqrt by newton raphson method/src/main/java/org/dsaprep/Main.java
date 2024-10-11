package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int n = 40;

        System.out.println(sqrtByNewtonRaphson(n));
    }

    protected static double sqrtByNewtonRaphson(int n) {
        double x = n;
        double root;

        while(true){
            root = 0.5 * (x + (n/x));

            if(Math.abs(root - x) < 0.5){       // here 0.5 is the allowed error.
                return root;
            }
            x = root;
        }
    }
}