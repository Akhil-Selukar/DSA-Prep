package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] colors = {0,1,0,1,0};
//        int k = 3;

//        int[] colors = {0,1,0,0,1,0,1};
//        int k = 6;

        int[] colors = {1,1,0,1};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.numberOfAlternatingGroups(colors, k));
    }
}