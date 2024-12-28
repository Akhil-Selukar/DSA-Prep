package org.dsaprep;

public class Main {

    // question link - https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
    public static void main(String[] args) {
        int noOfNodes = 5;
        int[][] adj = {{2, 3}, {0}, {1}, {4}, {}};

        Solution solution = new Solution();
        System.out.println(solution.kosaraju(noOfNodes ,adj));
    }
}