package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(NLogN + MlogM)/O(N+logM)
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        // first thing here is that robots are not sorted and we are given that if a bullet fired by a robot hit another robot then it stops immediately
        // Hence we need the order in which robots appear so we need to sort them.
        // But with each robot we have associated distance which the bullet from that robot travels, So we need ot first make a pair of
        // robots position and the distance of its bullet

        int n = robots.length;
        Map<Integer, Integer> bulletDistForRobot = new HashMap<>();   // taking map because we can randomly access the robot and get its corresponding distance
        for(int i=0; i<n; i++){
            bulletDistForRobot.put(robots[i], distance[i]);
        }

        // now sort the array and walls to get them in proper order
        Arrays.sort(robots);
        Arrays.sort(walls);

        // calculate the no of walla a robot can destroy if it shoots in a direction
        int[] canDestroyLeft = new int[n];      // walls a robot can destroy to its left
        int[] canDestroyRight = new int[n];     // walls a robot can destroy to its right
        int[] totalWalls = new int[n];

        for(int i=0; i<n; i++){
            // calculate no of walls present to the left of current robot
            int totalWallsToLeft = upperBound(walls, robots[i]);

            int leftUnreachable = 0;        // this will store the first unreachable wall to left for current robot (i.e. first wall out of range)
            if(i >= 1){
                // max range to left is either distance the bullet can cover from current position or if any robot is present in between the path of
                // bullet then till that robot which ever is closest to the current robot.
                int leftBoundary = Math.max(robots[i] - bulletDistForRobot.get(robots[i]), robots[i-1]+1);

                leftUnreachable = lowerBound(walls, leftBoundary);  // this will give us number of walls to the left of current robot's left range
                // so we can calculate walls current robot can destroy to the left (total walls - unreachable walls) = walls that can be destroyed
            } else {
                leftUnreachable = lowerBound(walls, robots[i] - bulletDistForRobot.get(robots[i])); // no robot present to the left
            }

            canDestroyLeft[i] = totalWallsToLeft - leftUnreachable;

            // NOW SAME CALCULATIONS FOR RIGHT SIDE (i.e. if robot fires to the right then how many walls can be destroyed)
            int totalWallsToRight = lowerBound(walls, robots[i]);

            int rightUnreachable = 0;
            if(i < n-1){        // there are some robots to the right of curr robot
                int rightBoundary = Math.min(robots[i] + bulletDistForRobot.get(robots[i]), robots[i+1]-1);

                rightUnreachable = upperBound(walls, rightBoundary);
            } else {        // no robot to the right
                rightUnreachable = upperBound(walls, robots[i] + bulletDistForRobot.get(robots[i]));
            }

            canDestroyRight[i] = rightUnreachable - totalWallsToRight;

            // to avoid duplicate counts
            if (i == 0) {
                continue;
            }
            int pos3 = lowerBound(walls, robots[i - 1]);
            totalWalls[i] = totalWallsToLeft - pos3;
        }

        int subLeft = canDestroyLeft[0];
        int subRight = canDestroyRight[0];
        for (int i = 1; i < n; i++) {
            int currentLeft = Math.max(
                    subLeft + canDestroyLeft[i],
                    subRight -
                            canDestroyRight[i - 1] +
                            Math.min(canDestroyLeft[i] + canDestroyRight[i - 1], totalWalls[i])
            );
            int currentRight = Math.max(
                    subLeft + canDestroyRight[i],
                    subRight + canDestroyRight[i]
            );
            subLeft = currentLeft;
            subRight = currentRight;
        }

        return Math.max(subLeft, subRight);

    }


    private int lowerBound(int[] walls, int target){
        int start = 0;
        int end = walls.length;
        while (start < end) {
            int mid = start+(end-start)/2;

            if (walls[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int upperBound(int[] walls, int target){
        int start = 0;
        int end = walls.length;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if (walls[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
