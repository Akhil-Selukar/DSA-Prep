package org.akhil;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int[] arrival = {1,2,3,4,5};
        int[] load = {5,2,3,3,3};

        Solution solution = new Solution();
        System.out.println(solution.busiestServers(k, arrival, load));
    }
}