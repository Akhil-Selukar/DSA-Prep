package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 8;

        System.out.println(arrangeCoins(n));
    }

    // O(N) Time complexity
    public static int arrangeCoins(int n) {
        int i = 0;
        int j = 0;
        int count = 0;

        while(n>0){
            if(i == j && n>0){
                i++;
                j = 0;
                n--;
                count++;
            }else{
                n--;
                j++;
            }
        }
        return count;
    }

    // O(N) time complexity
    public static int arrangeCoins2(int n) {
        int count = 0;

        while(n>0){
            if(n-(count+1)>=0) {
                count++;
            }
            n-=count;
        }
        return count;
    }

    // O(log(N)) time complexity
    public static int arrangeCoins3(int n) {
        long start = 0;
        long end = n;

        while(start<=end){
            long mid = start + (end-start)/2;
            long coinsUsed = (long)(mid*(mid+1))/2;

            if(coinsUsed == n){
                return (int)mid;
            } else if(coinsUsed < n){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return (int)start-1;
    }
}