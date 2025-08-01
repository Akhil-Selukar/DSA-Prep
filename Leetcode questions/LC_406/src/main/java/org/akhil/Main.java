package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people)));
    }
}