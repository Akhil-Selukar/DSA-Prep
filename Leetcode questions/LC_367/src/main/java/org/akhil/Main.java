package org.akhil;

public class Main {
    public static void main(String[] args) {
        int num = 16;

        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }

        int start = 0;
        int end = num/2;

        while(start <= end){
            long mid = start + (end - start)/2;

            if((mid*mid) == num){
                return true;
            } else if ((mid*mid) > num){
                end = (int)mid-1;
            } else {
                start = (int)mid+1;
            }
        }
        return false;
    }
}