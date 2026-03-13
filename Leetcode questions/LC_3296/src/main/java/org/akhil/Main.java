package org.akhil;

public class Main {
    public static void main(String[] args) {
        int mountainHeight = 4;
        int[] workerTimes = {2,1,1};

        Solution solution = new Solution();
        System.out.println(solution.minNumberOfSeconds(mountainHeight, workerTimes));
    }
}