package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int n = 36;

        System.out.println(findSqrt(n));
    }

    protected static int findSqrt(int n) {
        int firstNum = 1;
        int lastNum = n;

        while(firstNum<=lastNum){
            int midNum = firstNum + (lastNum-firstNum)/2;

            if((midNum*midNum) == n){
                return midNum;
            }
            if((midNum*midNum)<n){
                firstNum = midNum+1;
            } else {
                lastNum = midNum-1;
            }
        }
        return -1;
    }
}