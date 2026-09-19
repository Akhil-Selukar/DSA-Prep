package org.akhil;

public class Solution {
    // here find a point on edge of rectangle which is nearest to the circle center.
    // Then we can find the distance of center of circle from that point.
    // if that distance is less than radius then that means there is an overlap between circle and rectangle
    // O(1)/O(1)
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX;
        int nearestY;

        // x coordinate of nearest point
        if(x1 >= xCenter){
            nearestX = x1;
        } else if(x2 <= xCenter){
            nearestX = x2;
        } else {
            nearestX = xCenter;
        }

        // y coordinate of the nearest point
        if(y1 >= yCenter){
            nearestY = y1;
        } else if(y2 <= yCenter){
            nearestY = y2;
        } else {
            nearestY = yCenter;
        }

        // diat from center
        int dx = xCenter - nearestX;
        int dy = yCenter - nearestY;

        double dist = Math.sqrt(dx*dx + dy*dy);

        return dist <= radius;
    }
}
