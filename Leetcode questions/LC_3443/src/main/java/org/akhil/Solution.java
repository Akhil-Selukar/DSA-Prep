package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int maxDistance(String s, int k) {
        int sCount = 0;
        int nCount = 0;
        int wCount = 0;
        int eCount = 0;
        int maxMHDistance = 0;

        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i);

            if(ch == 'N'){
                nCount++;
            } else if(ch == 'E'){
                eCount++;
            } else if(ch == 'W'){
                wCount++;
            } else {
                sCount++;
            }

            int mhDistance = Math.abs(eCount - wCount) + Math.abs(nCount - sCount);
            int wastedSteps = (i+1) - mhDistance;        // i+1 = total steps

            int wastedDistance = 0;
            if(wastedSteps != 0){
                wastedDistance = Math.min(2*k, wastedSteps);
            }

            maxMHDistance = Math.max(maxMHDistance, mhDistance+wastedDistance);
        }

        return maxMHDistance;
    }
}
