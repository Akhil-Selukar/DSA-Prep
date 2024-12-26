package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> answer = new ArrayList<>();
        int count = 0;

        for(int i=0; i<operators.length; i++){
            int row = operators[i][0];
            int col = operators[i][1];

            if(visited[row][col]){
                answer.add(count);
                continue;
            }
            visited[row][col] = true;
            count++;

            for(int[] direction:directions){
                int adjRow = row + direction[0];
                int adjCol = col + direction[1];

                if(isValid(adjRow, adjCol, rows, cols)){
                    if(visited[adjRow][adjCol]){
                        int originalNodeNo = row * cols + col;      // 1 row means column number of elements (i.e. m elements) hence n rows means n*m elements + col extra elements.
                        int adjacentNodeNo = adjRow * cols + adjCol;
                        if(ds.findParent(originalNodeNo) != ds.findParent(adjacentNodeNo)){
                            count--;
                            ds.unionBySize(originalNodeNo, adjacentNodeNo);
                        }
                    }
                }
            }
            answer.add(count);
        }
        return answer;
    }

    private boolean isValid(int adjRow, int adjCol, int rows, int cols) {
        return (adjRow >= 0 && adjCol >= 0 && adjRow < rows && adjCol < cols);
    }
}
