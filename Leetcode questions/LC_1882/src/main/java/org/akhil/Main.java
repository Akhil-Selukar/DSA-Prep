package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.assignTasks(servers, tasks)));
    }
}