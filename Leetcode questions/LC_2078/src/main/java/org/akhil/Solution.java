package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int maxDistance(int[] colors) {
        int firstColorIndex = 0;
        int secondColorIndex = -1;
        int maxDist = 0;

        for(int i=1; i<colors.length; i++){
            if(colors[firstColorIndex] != colors[i]){
                maxDist = Math.max(maxDist, i-firstColorIndex);
                if(secondColorIndex == -1){
                    secondColorIndex = i;
                }
            } else if(secondColorIndex != -1){
                maxDist = Math.max(maxDist, i-secondColorIndex);
            }
        }
        return maxDist;
    }
}
