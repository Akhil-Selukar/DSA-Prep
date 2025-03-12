package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(M*N)/O(M*N)
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for (int[] arr : matrix) {
            Arrays.fill(arr, -1);
        }

        int rowStart = 0;
        int colStart = 0;
        int rowEnd = m - 1;
        int colEnd = n - 1;

        while (head != null) {
            // fill first row
            for (int i = colStart; i <= colEnd && head != null; i++) {
                matrix[rowStart][i] = head.val;
                head = head.next;
            }
            rowStart++;

            // fill last column
            for (int i = rowStart; i <= rowEnd && head != null; i++) {
                matrix[i][colEnd] = head.val;
                head = head.next;
            }
            colEnd--;

            // fill last row
            for (int i = colEnd; i >= colStart && head != null; i--) {
                matrix[rowEnd][i] = head.val;
                head = head.next;
            }
            rowEnd--;

            // fill first column
            for (int i = rowEnd; i >= rowStart && head != null; i--) {
                matrix[i][colStart] = head.val;
                head = head.next;
            }
            colStart++;
        }

        return matrix;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
