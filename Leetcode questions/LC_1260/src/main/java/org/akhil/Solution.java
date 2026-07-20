package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] flattened = new int[rows * cols];
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                flattened[index++] = grid[row][col];
            }
        }

        shift(flattened, k);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < flattened.length; i++) {
            int rowNo = i / cols;
            result.get(rowNo).add(flattened[i]);
        }
        return result;
    }

    private void shift(int[] arr, int k) {
        int n = arr.length;
        int effectiveShift = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, effectiveShift - 1);
        reverse(arr, effectiveShift, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

// 1,2,3,4,5,6,7,8
// k = 2
// 7,8,1,2,3,4,5,6

// 8,7,6,5,4,3,2,1 -> Total reverse
// 7,8,6,5,4,3,2,1 -> 0 to effectiveShift-1 reverse
// 7,8,1,2,3,4,5,6 - effectiveShift to end reverse

}
