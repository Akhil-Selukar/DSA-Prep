package org.akhil;

public class Solution {
    // two rectangles will only overlap only if any of the point in second lies inside the second rectangle that is what we will check here
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2]   // checking if left-right corner lies inside or not horizontally
                && rec1[1] < rec2[3] && rec2[1] < rec1[3];   // checking if left-right corner lies inside or not vertically
    }
}
