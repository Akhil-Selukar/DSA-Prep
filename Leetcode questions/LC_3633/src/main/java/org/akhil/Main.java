package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] landStartTime = {2,8};
        int[] landDuration = {4,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        Solution solution = new Solution();
        System.out.println(solution.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}