package org.akhil;

public class Main {
    public static void main(String[] args) {
        int radius = 1;
        int xCenter = 0;
        int yCenter = 0;
        int x1 = 1;
        int y1 = -1;
        int x2 = 3;
        int y2 = 1;

        Solution solution = new Solution();
        System.out.println(solution.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}