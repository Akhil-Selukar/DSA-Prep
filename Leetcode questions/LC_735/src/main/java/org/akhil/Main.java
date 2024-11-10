package org.akhil;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid:asteroids){
            if(asteroid > 0){
                stack.push(asteroid);       // If asteroid is going right then add to stack directly.
            } else {
                // a right going asteroid can only be destroyed by left going asteroid. So check all right going asteroids
                // with current left going asteroid, and destroy all lighter ones.
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek() < 0){       // if there is no right going asteroid or no asteroid at-all then add this left going asteroid to the stack.
                   stack.push(asteroid);
                } else if(stack.peek() == -asteroid){      // if both left and right going asteroids have same weight then destroy the right going and don't add left going. i.e. both are destroyed.
                    stack.pop();
                }
            }
        }
        int remainingAsteroids = stack.size();
        int[] answer = new int[remainingAsteroids];

        for(int i= answer.length-1; i>=0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}