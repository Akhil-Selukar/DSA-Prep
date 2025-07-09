package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int eventTime = 5;
//        int k = 1;
//        int[] startTime = {1,3};
//        int[] endTime = {2,5};

//        int eventTime = 10;
//        int k = 1;
//        int[] startTime = {0,2,9};
//        int[] endTime = {1,4,10};

        int eventTime = 5;
        int k = 2;
        int[] startTime = {0,1,2,3,4};
        int[] endTime = {1,2,3,4,5};

        Solution solution = new Solution();
        System.out.println(solution.maxFreeTime(eventTime, k, startTime, endTime));
    }
}