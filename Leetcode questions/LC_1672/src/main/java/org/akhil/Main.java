package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5}};

        System.out.println(maximumWealth(accounts));
    }

    static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] customer:accounts){
            int total = 0;
            for(int amount:customer){
                total += amount;
            }
            if(max<total)
                max = total;
        }
        return max;
    }
}