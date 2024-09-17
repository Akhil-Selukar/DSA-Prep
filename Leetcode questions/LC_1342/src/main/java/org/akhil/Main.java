package org.akhil;

public class Main {
    public static void main(String[] args) {
        int num = 111;

        System.out.println(numberOfSteps(num));
    }

    public static int numberOfSteps(int num) {
        return findNumberOfSteps(num, 0);
    }

    private static int findNumberOfSteps(int num, int steps){
        if(num == 0){
            return steps;
        }

        if(num%2 == 0){
            return findNumberOfSteps(num/2, steps+1);
        } else {
            return findNumberOfSteps(num-1, steps+1);
        }
    }
}