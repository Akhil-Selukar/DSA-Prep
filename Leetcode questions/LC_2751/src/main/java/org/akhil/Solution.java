package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    // Solution 1 - Using stack
    // SLight optimization possible because of unnecessary creation of arrays.
    // O(NlogN)/O(N)
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<int[]> robotPlace = new ArrayList<>();

        for(int i=0; i<positions.length; i++){
            robotPlace.add(new int[]{positions[i], i});
        }
        // we need to keep track of original place of the robot given in positions array hence we are storing i as well
        // and sorting based on actual position of the robot.
        Collections.sort(robotPlace, (a, b)-> {
            return a[0]-b[0];
        });

        Stack<int[]> stack = new Stack<>();     // to store right moving robots (because collision is only possible in RL combination)

        for(int[] robot:robotPlace){
            // if it is right moving robot then add to stack
            if(directions.charAt(robot[1]) == 'R'){
                stack.push(robot);
                continue;
            }

            // if it is left moving robot then collide it with available right moving from stack till
            // either there is no robot left to collide or robot moving left (i.e. current robot) dies
            while(!stack.isEmpty() && healths[robot[1]] > 0){
                int rightMovingIndex = stack.peek()[1];
                // case 1 :  both robots has same health
                if(healths[rightMovingIndex] == healths[robot[1]]){
                    // mark both robots dead in healths array and remove right moving robot from stack
                    stack.pop();
                    healths[rightMovingIndex] = 0;
                    healths[robot[1]] = 0;
                    break;
                } else
                    // case 2: if right moving robot has more health
                    if(healths[rightMovingIndex] > healths[robot[1]]){
                        healths[rightMovingIndex]--;
                        healths[robot[1]]=0;    // left moving is dead
                    } else
                        // case 3: if robot moving left has more health
                        if(healths[stack.peek()[1]] < healths[robot[1]]){
                            stack.pop(); // right mpoving is dead
                            healths[rightMovingIndex] = 0;
                            healths[robot[1]]--;
                        }
            }
        }
        // at the end whatever is left in stakc is the answer
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<healths.length; i++){
            if(healths[i] > 0){
                result.add(healths[i]);
            }
        }

        return result;
    }

    // ----------------------
    // Solution 2 - same approach without unnecessary array creation
    // public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    //     List<Integer> robotPlace = new ArrayList<>();

    //     for(int i=0; i<positions.length; i++){
    //         robotPlace.add(i);
    //     }
    //     // dont save actual value of position just sort on the basisi of it
    //     Collections.sort(robotPlace, (a, b)-> {
    //         return positions[a]-positions[b];
    //     });

    //     Stack<Integer> stack = new Stack<>();     // to store right moving robots (because collision is only possible in RL combination)

    //     for(int robotIndex:robotPlace){
    //         // if it is right moving robot then add to stack
    //         if(directions.charAt(robotIndex) == 'R'){
    //             stack.push(robotIndex);
    //             continue;
    //         }

    //         // if it is left moving robot then collide it with available right moving from stack till
    //         // either there is no robot left to collide or robot moving left (i.e. current robot) dies
    //         while(!stack.isEmpty() && healths[robotIndex] > 0){
    //             int rightMovingIndex = stack.peek();
    //             // case 1 :  both robots has same health
    //             if(healths[rightMovingIndex] == healths[robotIndex]){
    //                 // mark both robots dead in healths array and remove right moving robot from stack
    //                 stack.pop();
    //                 healths[rightMovingIndex] = 0;
    //                 healths[robotIndex] = 0;
    //                 break;
    //             } else
    //             // case 2: if right moving robot has more health
    //             if(healths[rightMovingIndex] > healths[robotIndex]){
    //                 healths[rightMovingIndex]--;
    //                 healths[robotIndex]=0;    // left moving is dead
    //             } else
    //             // case 3: if robot moving left has more health
    //             if(healths[rightMovingIndex] < healths[robotIndex]){
    //                 stack.pop(); // right mpoving is dead
    //                 healths[rightMovingIndex] = 0;
    //                 healths[robotIndex]--;
    //             }
    //         }
    //     }
    //     // at the end whatever is left in stakc is the answer
    //     List<Integer> result = new ArrayList<>();
    //     for(int i=0; i<healths.length; i++){
    //         if(healths[i] > 0){
    //             result.add(healths[i]);
    //         }
    //     }

    //     return result;
    // }
}
