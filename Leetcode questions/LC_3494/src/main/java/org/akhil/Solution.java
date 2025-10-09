package org.akhil;

public class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;       // total number of wizards we have
        long[] brewingTime = new long[n];     // brewing time for current potion

        // iterate through the mana to calculate at max what time will be required by each wizard to finish the brewing process
        for(int i=0; i<mana.length; i++){
            brewingTime[0] = brewingTime[0] + (long)skill[0] * mana[i];     // first wizard will start as soon as he is free.

            // now for all other wizards either they can start either as soon as they are free or as soon as potion is available from them.
            for(int j=1; j<n; j++){
                brewingTime[j] = Math.max(brewingTime[j-1], brewingTime[j]) + (long) mana[i] * skill[j];
            }

            // Above calculated value is without considering the condition 'As soon as previous wizard finishes brewing next has to start)
            // this means previous wizard need to adjust his start time based on when next will be finishing the previous brewing
            for(int j=n-1; j>0; j--){
                brewingTime[j-1] = brewingTime[j] - (long)mana[i] * skill[j];
            }
        }

        return brewingTime[n-1];
    }
}
