package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        boolean[] arr = new boolean[n+1]; // n+1 because array index starts from 0 and we need array index 20 as well (as we will be considering array index as number.)
        sieveOfEratosthenes(arr, n);
    }

    protected static void sieveOfEratosthenes(boolean[] arr, int n) {
        for(int i=2; i*i<n; i++){
            if(!arr[i]){
                for(int j=i*2; j<=n; j+=i){
                    arr[j] = true;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(!arr[i]){
                System.out.print(i+" ");
            }
        }
    }
}