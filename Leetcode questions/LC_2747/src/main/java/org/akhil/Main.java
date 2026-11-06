package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] logs = {{1,3},{2,6},{1,5}};
        int x = 5;
        int[] queries = {10,11};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countServers(n, logs, x, queries)));
    }
}