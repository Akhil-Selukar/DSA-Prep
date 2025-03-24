package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int days = 10;
//        int[][] meetings = {{5,7},{1,3},{9,10}};

        int days = 57;
        int[][] meetings = {{3,49},{23,44},{21,56},{26,55},{23,52},{2,9},{1,48},{3,31}};

        Solution solution = new Solution();
        System.out.println(solution.countDays(days, meetings));
    }
}