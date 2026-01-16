package org.akhil;

public class Solution {

    // O(N)/O(1)
    public double separateSquares(int[][] squares) {
        double startY = Double.MAX_VALUE;
        double endY = 0.0;

        double totalArea = 0.0;

        // loop to find the min and max value of Y coordinate and total area we have
        for(int[] square:squares){
            double y_coordinate = square[1];
            double sideLength = square[2];

            totalArea = totalArea + (sideLength * sideLength);

            endY = Math.max(endY, y_coordinate+sideLength);
            startY = Math.min(startY, y_coordinate);
        }

        // do a binary search and check for Y value withing limit
        // O(N * log(endY - startY)) ~O(N)
        while(startY <= endY){
            // if withing allowed limit then return the value
            // we can return any of startY or endY
            if(endY-startY <= 1e-5){
                return startY;
            }

            double midY = startY + (endY-startY)/2.0;

            double areaAboveYLine = getArea(midY, squares);

            double areaBelowYLine = totalArea - areaAboveYLine;

            if(areaAboveYLine > areaBelowYLine){
                startY = midY;
            } else {
                endY = midY;
            }
        }

        return startY;
    }

    // O(N)
    private double getArea(double midY, int[][] squares){
        double area = 0.0;

        for(int[] square:squares){
            double yCordinate = square[1];
            double length = square[2];

            // in case of square is fully above the midY line
            if(yCordinate >= midY){
                area = area + (length * length);
            }

            // in case of square partially above the midY line
            else if((yCordinate + length) > midY){
                double htAboveMidLine = yCordinate + length - midY;
                area = area + (htAboveMidLine * length);
            }

            // in case of square below midY we dont want to include it so we can skip
        }

        return area;
    }
}
