package org.akhil;

public class Solution {
    // Solution - Greedy (actually form 2 triangle one with red as top ball and another as blue as top ball)
    // O(sqrt(N))/O(1)
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(formTriangle(red, blue), formTriangle(blue, red));
    }

    private int formTriangle(int color1, int color2){
        int height = 0;
        int ballsRequired = 1;

        while(true){
            if((height % 2) == 1) {     // means color1 to use
                if(ballsRequired <= color1) {
                    color1 = color1 - ballsRequired;
                } else {
                    break;
                }
            } else {    // means color2 to use
                if(ballsRequired <= color2) {
                    color2 = color2 - ballsRequired;
                } else {
                    break;
                }
            }
            height++;
            ballsRequired++;
        }

        return height;
    }
}
