package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> answer = new ArrayList<>();
        if(label == 1){
            answer.add(1);
            return answer;
        }

        while(label != 1){
            int level = (int)(Math.log(label)/Math.log(2))+1;
            answer.add(label);

            if(level % 2 == 0){     // in case of even level
                int distFromStart = (int)(Math.pow(2, level))-1-label;
                int nodeNumber = (int)(Math.pow(2, level-1))+distFromStart;
                label = nodeNumber/2;
            } else {        // in case of odd level
                int distFromStart = label - (int) (Math.pow(2, level - 1));
                int nodeNumber = (int) (Math.pow(2, level) - 1 - distFromStart);
                label = nodeNumber / 2;
            }
        }
        answer.add(label);
        Collections.reverse(answer);
        return answer;
    }
}
