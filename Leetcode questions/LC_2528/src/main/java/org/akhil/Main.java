package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] stations = {1,2,4,5,0};
        int r = 1;
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxPower(stations, r, k));
    }
}