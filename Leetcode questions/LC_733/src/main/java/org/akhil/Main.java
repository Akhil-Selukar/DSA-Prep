package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] image = new int[3][3];

        image[0][0] = 1;
        image[0][1] = 1;
        image[0][2] = 1;
        image[1][0] = 1;
        image[1][1] = 1;
        image[2][0] = 1;
        image[2][2] = 1;

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.floodFill(image, 1, 1, 2)));
    }
}