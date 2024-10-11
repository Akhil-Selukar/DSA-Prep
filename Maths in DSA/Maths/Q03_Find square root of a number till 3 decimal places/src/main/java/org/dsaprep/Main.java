package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int n = 50;
        int precision = 4;

        System.out.printf("%.4f", findSqrt(n, precision));
    }

    protected static double findSqrt(int n, int precision) {
        int firstNum = 1;
        int lastNum = n;

        while (firstNum <= lastNum) {
            int midNum = firstNum + (lastNum - firstNum) / 2;

            if ((midNum * midNum) == n) {
                return midNum;
            }
            if ((midNum * midNum) < n) {
                firstNum = midNum + 1;
            } else {
                lastNum = midNum - 1;
            }
        }

        double root = lastNum;   // because in above code we were unable to find the root so root is in between firstNum and lastNum. lastNum < firstNum hence we are taking lesser part and incrementing to precision.

        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (root * root <= n) {
                root = root + increment;
            }
            root = root - increment;
            increment = increment / 10;
        }
        return root;
    }
}