package org.akhil;

public class Solution {

    // Solution - 1 (Not optimized and gives TLE)
//    public int countPrimes(int n) {
//        int count = 0;
//        n=n-1;
//        while(n>=2){
//            boolean flag = false;
//            for(int i=2; i<n; i++){
//                if(n%i == 0){
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag){
//                count++;
//            }
//            n--;
//        }
//        return count;
//    }

    // Solution 2 - (optimized)
    /*
     * Here if 2 < n then we can count 2 as prime and all multiples of 2 can be eliminated as they are not prime (multiple of 2 hence)
     * if 3 < n then we can count 3 as prime and all multiples of 3 can also be eliminated.
     * if 4 < n then it will already be eliminated in first iteration. if 5 < n then we can count 5 as prime and eliminate all multiples of 5
     * and so on. By this we will only count primes and all non primes will be eliminated.
     */
    public int countPrimes(int n) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=2; i<=n; i++){
            if(visited[i]){
                continue;       // if i is visited then all multiples of i will also be visited.
            }
            count++;            // as this is first occurrence of i.

            // mark all multiples of i as visited
            for(int j=i*2; j<n; j=j+i){
                visited[j] = true;
            }
        }
        return count;
    }
}
