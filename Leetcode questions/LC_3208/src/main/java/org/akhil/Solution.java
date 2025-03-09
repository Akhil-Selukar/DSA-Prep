package org.akhil;

public class Solution {

    // Solution 1 - O(KN)/O(1) TLE
//    public int numberOfAlternatingGroups(int[] colors, int k) {
//        int count = 0;
//        int n = colors.length;
//        int start = 0;
//        int end = 0;
//        for(int i=0; i<n; i++){
//            start = i;
//            end = (i+k);
//
//            while(start < end-1){
//                int rotatedStart = start%n;
//                if(colors[rotatedStart] == colors[(rotatedStart+1)%n]){
//                    break;
//                }
//                start++;
//            }
//            if(start == end-1){
//                count++;
//            }
//        }
//        return count;
//    }

    // Solution 2 - O(N+k)/O(1)
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;
        int alternating = 1;

        for(int i=1; i<n+k-1; i++){
            int currentIndex = i%n;
            int previousIndex = (i-1)%n;
            alternating = colors[currentIndex] == colors[previousIndex] ? 1 : alternating + 1;
            if(alternating >= k){
                count++;
            }
        }
        return count;
    }
}
