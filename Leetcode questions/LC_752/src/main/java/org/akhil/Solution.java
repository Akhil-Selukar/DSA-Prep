package org.akhil;

import java.util.*;

// Here we are visiting each and every node (i.e. possible combination) so TC will be O(V)
// now given that 4 bits are there and each bit can have 10 different values so total possible combinations are O(10^4) so O(1)
// Similarly space complexity will also be O(1) because there can be at max O(10^4) values in visited set in worst case.
public class Solution {

    class Pair{
        String state;
        int turn;
        public Pair(String state,int turn){
            this.state=state;
            this.turn=turn;
        }
    }
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for(String end:deadends){
            visited.add(end);
        }
        // important edge case
        if(visited.contains("0000")){
            return -1;
        }

        visited.add("0000");

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair("0000", 0));

        while(!queue.isEmpty()){
            Pair polled = queue.poll();
            String currState = polled.state;
            int currTurns = polled.turn;

            if(currState.equals(target)){
                return currTurns;
            }

            List<String> nextPossibleStates = getNextStates(currState);

            for(String nextState:nextPossibleStates){
                if(!visited.contains(nextState)){
                    queue.offer(new Pair(nextState, currTurns+1));
                    visited.add(nextState);
                }
            }
        }
        return -1;
    }

    private List<String> getNextStates(String currState) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = currState.toCharArray();

        for(int i=0; i<4; i++) {
            char originalChar = chars[i];

            // can move forward
            chars[i] = (char)((originalChar-'0' + 1) % 10 + '0');
            nextStates.add(new String(chars));

            // can move backwards
            chars[i] = (char)((originalChar-'0' + 9) % 10 + '0');
            nextStates.add(new String(chars));

            chars[i] = originalChar;    // because for next index curr need to be restored
        }

        return nextStates;
    }
}
