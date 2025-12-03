package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Here the important points to note are we are looking for trapezoids so any 2 lines forming the trapezoid must be parallel.
    // Now to check the parallel lines we need to fnd the slope of the lines with formula (y2-y1)/(x2-x1). If we have two lines with same
    // slope then we can join the points to form a trapezoid.

    // Edge case 1 -> There might be 3 or 4 points in a straight which can give us 2 slopes (with p1-p2 and p2-p3) but as they are on
    // a same straight line the trapezoid can not be formed. Hence we will have to keep track of points with same slope and on a same line.
    // Now the question is how we can find out that the points are on same line?
    // The equation for a line is 'y = mx + c' where m is the slope and c is a constant. We already have slope calculated above so we can
    // calculate y intersection of the line by putting x = 0 (so we will get y=c), now we have x and y from give points and m as slope so we can
    // calculate the c i.e. intercept as (c = y-mx). And of the intercept value is same for both the lines having same slope then that means it is
    // essentially the same line and all points forming those lines are on a single straight line.

    // Edge case 2 -> Another important thing to note here is if we have two different parallel lines then joining the points by using other two points
    // will make a trapezoid but what if those other two lines are also parallel and the trapezoid formed is a parallelogram in that case above algorithm
    // will count that as 2 different trapezoids but we want to calculate it only once hence we need to keep track of such parallelograms as well.
    // To do that we can use property of parallelograms i.e. opposite sides of parallelogram have same length. Hence we will calculate length of
    // each sizes as well and if two lines have same slope and same length they will form a parallelogram and we can count it once only.

    private String frac(int a, int b) {
        if (b == 0) return "1/0";
        int g = gcd(Math.abs(a), Math.abs(b));
        a /= g; b /= g;
        if (b < 0) { a = -a; b = -b; }
        return a + "/" + b;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public int countTrapezoids(int[][] points) {
        int n = points.length;

        int traps = 0;
        int parallelograms = 0;

        // For trapeziums
        Map<String,Integer> slopeCount = new HashMap<>();
        Map<String,Integer> lineCount = new HashMap<>();

        // For parallelograms
        Map<String,Integer> slopeDistCount = new HashMap<>();
        Map<String,Integer> collinearDistCount = new HashMap<>();

        for (int i = 0; i < n; i++) { // O(n^2)
            // O(n)
            int[] p2 = points[i];
            for (int j = i+1; j < n; j++) {
                int[] p1 = points[j];

                int dx = p2[0] - p1[0];
                int dy = p2[1] - p1[1];

                String slope = (dx != 0) ? frac(dy, dx) : "inf";

                String intercept;
                if (!slope.equals("inf")) {
                    intercept = frac(p1[1] * dx - dy * p1[0], dx);
                } else {
                    intercept = "x=" + p1[0];
                }

                String lineKey = slope + "|" + intercept;

                int dist = (dx * dx) + (dy * dy);

                String slopeDistKey = slope + "|" + dist;
                String collinearDistKey = slope + "|" + intercept + "|" + dist;

                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                lineCount.put(lineKey, lineCount.getOrDefault(lineKey, 0) + 1);

                traps += slopeCount.getOrDefault(slope, 0)
                        - lineCount.getOrDefault(lineKey, 0);

                slopeDistCount.put(slopeDistKey, slopeDistCount.getOrDefault(slopeDistKey, 0) + 1);
                collinearDistCount.put(collinearDistKey, collinearDistCount.getOrDefault(collinearDistKey, 0) + 1);

                parallelograms += slopeDistCount.getOrDefault(slopeDistKey, 0)
                        - collinearDistCount.getOrDefault(collinearDistKey, 0); // twice


            }
        }

        // each parallelogram counted twice
        return traps - parallelograms / 2;
    }
}
