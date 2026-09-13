package org.akhil;

public class Solution {
    // O(N^4)/O(1)
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int result = 0;

        for(int xOffset=-n+1; xOffset<n; xOffset++){
            for(int yOffset=-n+1; yOffset<n; yOffset++){
                result = Math.max(result, countOverlaps(img1, img2, xOffset, yOffset));
            }
        }
        return result;
    }

    private int countOverlaps(int[][] img1, int[][] img2, int xOffset, int yOffset){
        int n = img1.length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row + xOffset < 0 || row + xOffset >= n || col + yOffset < 0 || col + yOffset >= n) {
                    continue;
                }
                count = count + img1[row][col] * img2[row + xOffset][col + yOffset];
            }
        }

        return count;
    }
}
