package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Solution 1 - O(NlogN)/O(N) where N is the number of rectangles.
//    public boolean checkValidCuts(int n, int[][] rectangles) {
//        List<int[]> x = new ArrayList<>();
//        List<int[]> y = new ArrayList<>();
//
//        for(int[] rect:rectangles){
//            x.add(new int[]{rect[0], rect[2]});
//            y.add(new int[]{rect[1], rect[3]});
//        }
//
//        Collections.sort(y, (a,b)-> a[0]-b[0]);
//        int horizontalCuts = getCuts(y);
//        if(horizontalCuts >= 2){
//            return true;
//        }
//
//        Collections.sort(x, (a, b)-> a[0]-b[0]);
//        int verticalCuts = getCuts(x);
//        if(verticalCuts >= 2){
//            return true;
//        }
//
//        return false;
//    }
//
//    private int getCuts(List<int[]> coordinates){
//        int start = coordinates.get(0)[0];
//        int end = coordinates.get(0)[1];
//        int cut = 0;
//
//        for(int i=1; i<coordinates.size(); i++){
//            if(end > coordinates.get(i)[0]){
//                end = Math.max(end, coordinates.get(i)[1]);
//            } else {
//                cut++;
//                start = coordinates.get(i)[0];
//                end = coordinates.get(i)[1];
//                if (cut >= 2) return cut;
//            }
//        }
//
//        return cut;
//    }

    // Solution 2 - Same logic as that of above just sorting is changed and applied on 2D array
    // O(NlogN)/O(logN) where N is the number of rectangles (space complexity for sorting algorithm)
    public boolean checkValidCuts(int n, int[][] rectangles) {

        return checkCuts(rectangles, 0, 0, 2) || checkCuts(rectangles, 1, 1, 3);
    }

    private boolean checkCuts(int[][] rectangles, int sortIndex, int startIndex, int endIndex){
        Arrays.sort(rectangles, (a, b) -> a[sortIndex]-b[sortIndex]);

        int end = rectangles[0][endIndex];
        int cut = 0;

        for(int i=1; i<rectangles.length; i++) {
            if (end > rectangles[i][startIndex]) {
                end = Math.max(end, rectangles[i][endIndex]);
            } else {
                cut++;
                end = rectangles[i][endIndex];
                if (cut >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
