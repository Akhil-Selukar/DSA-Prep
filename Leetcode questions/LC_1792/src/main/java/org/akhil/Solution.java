package org.akhil;

import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<double[]>((a, b) -> Double.compare(b[0], a[0]));
        // at index 0 will store the current increment we can get by adding 1 student

        for (int[] cl : classes) {
            double pass = cl[0];
            double total = cl[1];

            double increment = ((pass + 1) / (total + 1)) - (pass) / (total);

            queue.offer(new double[] { increment, pass, total });
        }

        while (extraStudents > 0) {
            double[] polled = queue.poll(); // fetch the class which gives most increment
            double pass = polled[1] + 1; // +1 because added new student in class
            double total = polled[2] + 1; // +1 because added new student in class

            double increment = ((pass + 1) / (total + 1)) - (pass) / (total); // calculate new increment for the class
            queue.offer(new double[] { increment, pass, total });
            extraStudents--;
        }

        double sum = 0.0;
        for (double[] cl : queue) {
            sum = sum + (cl[1] / cl[2]);
        }
        return sum / classes.length;
    }
}
