package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // in first glance this might seem like optimal game strategy probblem by reading "every senator is smart enough and will play the
    // best strategy for his own party", but it is not. The two choices we have here revoke all rights from other candidate or to anounce
    // victory are not always valid. If we read carefully we can announce victory only in case of otherparty does not have any candidate
    // left. So unless one part looses all it's candidate we are effectivelly have only 1 move to make and once any party looses all it's
    // candidate the other party can not revoke any voting rights from that party so in this case as well we have only 1 choice. So
    // at any point in time we have only 1 choice. This is what makes this problem as simulation problem than optimal game strategy

    // Now the other observations are "the round based procedure start form the first senator to the last" so the senator which is at
    // index 0 will get first chance to make decision and the senator at index 2 will get second and so on. So we can conclude that based
    // on index we can decide who amongst two can make the decision.
    // Now it might happen that two senators of same party are at adjacent indices, they can't fight against each other. So we need to
    // separate senators from both parties, Also we need to perform the voting in circular manner unless one party wins. So we can use
    // queue for each party. The winner will go back to the queue of his party and looser will simply leave the queue. So at the end
    // loosing party will not have anyonw in it's queue and winning party can simply declare the win.

    // one important thing to ensure here is that when winner goes back to queue it's index should increase. If we does not perform this
    // then in case of "RDD" first R->0 and D->1 R will win and gors back in R queue as this is only 1 person in R so in next iteration
    // again R will be 0 and D will be 2 and R will win. But we want D to win in this case because even though in queue R is ahead of D
    // but in actual game we are moving R to the back of given string which will be back of remaining D so it's index will definitely be >
    // D.

    // O(N)/O(N)
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int nextIndex = 1;

        for(int i=0; i<senate.length(); i++){
            char ch = senate.charAt(i);

            if(ch == 'R'){
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
            nextIndex++;
        }

        // simulate the first move till one party looses
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if(rIndex < dIndex){
                radiant.offer(nextIndex);
            } else {
                dire.offer(nextIndex);
            }
            nextIndex++;
        }

        if(radiant.isEmpty()){
            return "Dire";
        }
        return "Radiant";
    }
}
