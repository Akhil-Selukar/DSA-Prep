package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] rains = {1,2,3,4};
//        int[] rains = {69,0,0,0,69};
//        int[] rains = {0,1,1};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.avoidFlood(rains)));
    }
}