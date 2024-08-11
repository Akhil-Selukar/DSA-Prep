package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int rows = grid.length-1;
        int cols = grid[0].length-1;
        int rowIndex = 0;
        int colIndex = cols;
        int negativeCount = 0;

        while(rowIndex <= rows && colIndex >=0){
            if(grid[rowIndex][colIndex]<0){
                negativeCount = negativeCount + ((rows - rowIndex)+1);
                colIndex--;
            } else {
                rowIndex++;
            }
        }
        return negativeCount;
    }
}