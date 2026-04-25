package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Here in question we are asked to maximize the minimum distance which means this is binary search on answer problem.
    // Now to apply binary search on answer we need to know the range of answer. Now as we have to choose k different points and k is at least 4 and at max 25
    // and points given in points[] has integer coordinates (not decimal) so minimum manhattan distance between two points will be the distance between
    // adjacent points i.e. 1 unit and maximum manhattan distance is between two diagonal points of the square which will be (2*side) (Note that this is MANHATTAN distance
    // and not cartesian distance (manhattan distance = |x2-x1| + |y2-y1| and cartesian distance = sqrt(x^2 + y^2)))
    // Now we got the range of answer so we need to check if we can select k points from given points which maximizes the minimum distance. So if we choose
    // the mid-point of answer range then we need to validate if that point satisfies the criteria of having valid point (i.e. there are other k points present which
    // has distance >= mid-point value, as we need to maximize the MINIMUM distance so min-point will be potential minimum distance we are trying to get out of
    // all other distances of k points from each other.
    // So now we need distance of points from each other. We can calculate distances of all points from (0,0) in any one direction (clockwise or anticlockwise)
    // and sort them in ascending order so if we have 3 points for example ((0,0), (0,1) and (0,2)) then their distances for (0,0) in sorted order is [1, 2]
    // (1 -> distance between (0,0) and (0,1), 2 -> distance between (0,0) and (0,2)). So now if we need distance between (0,1) and (0,2) we can simply subtract
    // distance form (0,0) to (0,1) from (0,0) to (0,2) and we will get the required distance 1 (simple number line maths)
    // Now till this point we are able to get the distance of every point from every other point. So what we need to check if our selected mid-value is
    // valid answer or not is to ensure that there exist k points which gives us distance from each other >= mid-value.
    // if this is satisfied then mid-value might be the answer but we need to maximize the answer hence we will shift start to mid+1 and check again for bigger value
    // else we will shift end to mid-1 as there can not be any possible answer to the right of mid-value


    public int maxDistance(int side, int[][] points, int k) {
        List<Long> distances = new ArrayList<>();        // to store the distances of all points from (0,0)

        for(int[] point:points){
            int x = point[0];
            int y = point[1];

            if(x == 0){     // point is on y-axis so dist is y-coordinate
                distances.add((long)y);
            } else if(y == side){   // point has travelled entire Y-axis and now on upper side of line parallel to X-axis
                distances.add((long)side + x);
            } else if(x == side) {  // that means point is at the line parallel to
                distances.add((long)3*side -y);
            } else {
                distances.add((long)4*side - x);
            }
        }

        // sort the distances
        Collections.sort(distances);

        long start = 1;
        long end = (long)2*side;
        long result = 0;

        while(start <= end){
            long mid = start + (end-start)/2;

            if(isValid(distances, k, side, mid)){
                start = mid+1;
                result = mid;
            } else {
                end = mid-1;
            }
        }
        return (int)result;
    }

    private boolean isValid(List<Long> distances, int k, int side, long mid){
        long perimeter = (long)4*side;

        for(int i=0; i<distances.size(); i++){
            long start = distances.get(i);
            long end = start + perimeter - mid;

            for(int j=0; j<k-1; j++){
                int next = lower(distances, start+mid);
                if(next >= distances.size() || distances.get(next) > end){
                    start = -1;
                    break;
                }
                start = distances.get(next);
            }

            if(start >= 0) {
                return true;
            }
        }
        return false;
    }

    private int lower(List<Long> distances, long target){
        int start = 0;
        int end = distances.size();

        while(start < end) {
            int mid = start + (end-start)/2;

            if(distances.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
