package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 36;

        findFactors2(n);
    }

    // Bruteforce : Time complexity O(N), space complexity O(1)
    protected static void findFactors(int n) {
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                System.out.print(i+" ");
            }
        }
    }

    // Optimized : Time complexity O(sqrt(N)), space complexity O(1)
    private static void findFactors1(int n) {
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i+" ");
                } else {
                    System.out.print(i+" "+n/i+" ");
                }
            }
        }
    }

    // Optimized & sorted output : Time complexity O(sqrt(N)), space complexity O(sqrt(N))
    private static void findFactors2(int n) {
        List<Integer> factors = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                if(!(n/i == i)){
                    factors.add(n/i);
                }
                System.out.print(i+" ");
            }
        }
        for(int i=factors.size()-1; i>=0; i--){
            System.out.print(factors.get(i)+" ");
        }
    }
}