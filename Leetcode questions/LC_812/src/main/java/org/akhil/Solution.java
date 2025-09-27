package org.akhil;

public class Solution {

    // Solution 1 - Using Herons formula (area = sqrt(s*(s-a)*(s-b)*(s-c)))
    // O(N^3)/O(1)
//    public double largestTriangleArea(int[][] points) {
//        double maxArea = 0;
//
//        for(int i=0; i<points.length-2; i++){
//            int x1 = points[i][0];
//            int y1 = points[i][1];
//            for(int j=i+1; j<points.length-1; j++){
//                int x2 = points[j][0];
//                int y2 = points[j][1];
//                for(int k=j+1; k<points.length; k++){
//                    int x3 = points[k][0];
//                    int y3 = points[k][1];
//
//                    // side formed by x1,y1 and x2,y2
//                    double a = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
//                    // side formed by x2,y2 and x3,y3
//                    double b = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2));
//                    // side formed by x3,y3 and x1,y1
//                    double c = Math.sqrt(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2));
//                    double s = (a+b+c)/2;    //semiPerimeter
//
//                    double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
//                    maxArea = Math.max(maxArea, area);
//                }
//            }
//        }
//        return maxArea;
//    }

    //----------------------
    // Solution 2 - Shoelace formula
    // area = 1/2 * abs(x1*(y2-y3) + x2*(y1-y3) + x3*(y1-y2))
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;

        for(int i=0; i<points.length-2; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j<points.length-1; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                for(int k=j+1; k<points.length; k++){
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    double area = 0.5*(Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
