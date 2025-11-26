package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    // Solution 1 - Using stack
    // O(NlogN)/O(N)
    public int carFleet(int target, int[] position, int[] speed) {
        // first thing is we need to place each car at its starting point and their speed we need to keep track of
        // Given cars are at random order hence we will need to sort which can disturb the car and speed mapping (i.e car[i] has speed[i])
        // Hence to keep track of that we need to merge car and its speed together in single unit (i.e. int[] here) and then sort the cars
        // based on starting point
        List<int[]> cars = new ArrayList<>();
        Stack<Double> stack = new Stack<>();

        for(int i=0; i<position.length; i++){
            cars.add(new int[]{position[i], speed[i]});
        }

        Collections.sort(cars, (a, b)->{
            return a[0]-b[0];
        });

        // now as from question we can infer that the cars can not overtake each other (they can form fleet) hence, no matter what speed we have
        // for any car, either all cars reaches target together or last car will reach first. There is no chance that any other car reaches before
        // last car.
        // So we start from last car first and calculate the time required for it to reach target.
        // if the car is not the closest to target then there will be some time stored in stack (i.e. time for last car)
        // if current car can reach target in less time that the car in front of it (i.e. car in stack) then for sure the two cars
        // will meet and form a fleet before target. Now it is given in question that after forming fleet, the fleet will travel at the speed of
        // slower car (in our case slower car is already in stack hence we will not add faster car in stack and keep the slower one)
        // at the end all cars which can form fleet will not be added in stack and the cars in the stack will be the number of fleets that will reach
        // to the target.
        for(int i=cars.size()-1; i>=0; i--){
            int[] car = cars.get(i);
            double finishTime = (target - car[0])/(car[1]*1.0);

            if(!stack.isEmpty() && stack.peek() >= finishTime){
                continue;
            }
            stack.push(finishTime);
        }
        return stack.size();
    }

    //------------------
    // Solution 2 - Same code just simplified.
    // O(NlogN)/O(N)
//    public int carFleet(int target, int[] position, int[] speed) {
//        List<int[]> cars = new ArrayList<>();
//        Stack<Double> stack = new Stack<>();
//
//        for(int i=0; i<position.length; i++){
//            cars.add(new int[]{position[i], speed[i]});
//        }
//
//        Collections.sort(cars, (a, b)->{
//            return b[0]-a[0];
//        });
//
//        for(int[] car:cars){
//            double finishTime = (target - car[0])/(car[1]*1.0);
//
//            if(!stack.isEmpty() && stack.peek() >= finishTime){
//                continue;
//            }
//            stack.push(finishTime);
//        }
//        return stack.size();
//    }
}
