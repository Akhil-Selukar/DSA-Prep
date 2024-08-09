package org.akhil;

public class Main {
    static int pick = 6;
    public static void main(String[] args) {
        int n = 10;

        System.out.println(guessNumber(n));
    }

    public static int guessNumber(int n) {
        int start = 0;
        int end = n;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(guess(mid) == 0){
                return mid;
            } else if(guess(mid) == -1){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int guess(int num){
        if(pick == num)
            return 0;
        else if(pick>num)
            return 1;
        else
            return -1;
    }
}