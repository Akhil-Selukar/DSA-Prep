package org.akhil;

public class Main {
    public static void main(String[] args) {
        int num = 4;

        System.out.println(mySqrt(num));
    }

    public static int mySqrt(int x) {

        if(x==0 || x==1){
            return x;
        }
        long start = 0;
        long end = x/2;

        while(start <= end){
            long mid = start + (end - start)/2;

            if(x == mid*mid){
                return (int)mid;
            } else if(x < (mid*mid)){
                end = mid - 1;
            } else {
                start = mid+1;
            }
        }
        return (int)end;
    }
}