package org.akhil;

public class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // As we need to find the max area of SQUARE that can be formed by intersection of 2 or more rectangles from given rectangles.
        // the important thing to notice here is the area can be maximized by intersecting only two rectangles, any addition of third rectangle
        // will either reduce the area or keep it same but it can not increase it (Simple logic - after intersection of 2 rectangles
        // we are left with common area only in consideration so 3rd rectangle no matter how we place it, we can at max cover area under
        // consideration only. Any area out of it will not be covered by all 3 rectangles). So in other words we only have to maximixe the
        // area of square formed by intersection of two rectangles.
        // Now to find the area we need side lengths of intersecting sections. For that we need to find the coordinates of intersection.
        // We can easily find the coordinates of intersection if we know the coordinates of two rectangles in consideration.
        // As we need to consider only squares so we will consider minimum of length and width (because that will be the side of largest square
        // we can fit in the intersecting area)
        // In case of non-intersecting rectangles either length or width or both will be -ve so in that case we can ignore it.

        // TC -> O(N^2)
        // SC -> O(1)
        int n = bottomLeft.length;
        long maxSide = 0;

        // check all combinations of 2 rectangles
        for(int i=0; i<n; i++){             // first rectangle
            for(int j=i+1; j<n; j++){       // second rectangle
                int left = Math.max(bottomLeft[i][0],  bottomLeft[j][0]);
                int right = Math.min(topRight[i][0], topRight[j][0]);

                int top = Math.min(topRight[i][1], topRight[j][1]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int length = right - left;
                int width = top - bottom;

                maxSide = Math.max(maxSide, Math.min(length, width));   // this will cover skipping of -ve side. as max of (0, -ve) will be 0;
            }
        }

        return maxSide * maxSide;
    }
}
