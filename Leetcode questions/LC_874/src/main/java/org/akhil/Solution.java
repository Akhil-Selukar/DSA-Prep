package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // TC -> O(M+S) where M is length of Obstacles and S is sum of all +ve values in commands
    // SC -> O(M) where M is length of Obstacles array
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int robotSim(int[] commands, int[][] obstacles) {

        // to check obstacles in O(1)
        Set<String> obs = new HashSet<>();
        for(int[] val:obstacles){
            obs.add(val[0]+"_"+val[1]);
        }

        // 0-> north
        // 1-> east
        // 2-> south
        // 3-> west
        int direction = 0;
        int currX = 0;
        int currY = 0;
        int result = 0;

        for(int cmd:commands){
            if(cmd == -1){
                direction = (direction+1)%4;
            } else if(cmd == -2){
                direction = (direction+3)%4;    // move 90 degree left 1 time = move 90 degree right 3 times
            } else {
                while(cmd > 0){
                    int newX = currX + dir[direction][0];
                    int newY = currY + dir[direction][1];

                    if(obs.contains(newX+"_"+newY)){
                        break;      // cant move ahead because of blocked path
                    }

                    currX = newX;
                    currY = newY;

                    // as we moved so the distance has to be changed so there might be a chance that this is the max so check
                    result = Math.max(result, (currX*currX)+(currY*currY));
                    cmd--;
                }
            }
        }
        return result;
    }
}
