package org.akhil;


public class Main {
    public static void main(String[] args) {
        int eventTime = 10;
        int[] startTime = {0,3,7,9};
        int[] endTime = {1,4,8,10};

        Solution solution = new Solution();

        System.out.println(solution.maxFreeTime(eventTime, startTime, endTime));
    }
}