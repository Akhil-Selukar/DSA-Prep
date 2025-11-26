package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10,8,0,5,3};
//        int[] speed = {2,4,1,1,3};

        int target = 10;
        int[] position = {0,4,2};
        int[] speed = {2,1,3};

        Solution solution = new Solution();
        System.out.println(solution.carFleet(target, position, speed));
    }
}