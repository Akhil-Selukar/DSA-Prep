package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int countCollisions(String directions) {
        int start = 0;
        int end = directions.length()-1;
        int collisions = 0;
        int n = directions.length();

        // all consecutive cars moving in left direction and at start will never collide and keep on moving
        // similarly all consecutive car moving to the right and at the end will never collide and keep moving.
        // so we don't have to count those cars.
        while(start < n && directions.charAt(start) == 'L'){
            start++;
        }

        while(end >= 0 && directions.charAt(end) == 'R'){
            end--;
        }

        // now for remaining cars we for sure know that they will collide to either opposite moving car or stationary car.
        // if opposite moving cars are colliding then we need to add 2 in collisions (i.e. 1 for each car) while if a moving
        // car is colliding with stationary car then we need to add 1 in the collisions. So only moving cars are affecting the result
        // hence we can simply iterate through the cars which are going to collide and if a car is moving, add 1 to collisions and if it is
        // stationary then skip it (or add 0)

        while(start <= end){
            if(directions.charAt(start) != 'S'){
                collisions++;
            }
            start++;
        }
        return collisions;
    }
}
