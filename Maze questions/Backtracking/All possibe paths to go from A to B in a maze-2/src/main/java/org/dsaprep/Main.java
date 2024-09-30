package org.dsaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, false, true},
                {true, true, true},
                {true, true, true}};

        System.out.println(printAllPaths(maze));
    }

    protected static List<String> printAllPaths(boolean[][] maze) {
        int[][] pathInMaze = new int[maze.length][maze[0].length];
        return printAllPathHelper("", maze, 0, 0, pathInMaze, 1);
    }

    private static List<String> printAllPathHelper(String path, boolean[][] maze, int row, int column, int[][] pathInMaze, int step) {
        List<String> ans = new ArrayList<>();
        if(row == maze.length-1 && column == maze.length-1){
            ans.add(path);
            pathInMaze[row][column] = step;
            System.out.println(path);
            for(int[] r: pathInMaze) {
                System.out.println(Arrays.toString(r));
            }
            System.out.println("==============");
            return ans;
        }

        // If the block is already visited then skip that block.
        if(!maze[row][column]){
            return new ArrayList<>();
        }

        maze[row][column] = false; // Mark the current visited block as false.
        pathInMaze[row][column] = step;

        if(row < maze.length-1){
            ans.addAll(printAllPathHelper(path+"D", maze, row+1, column, pathInMaze, step+1));
        }
        if(column < maze[0].length-1){
            ans.addAll(printAllPathHelper(path+"R", maze, row, column+1, pathInMaze, step+1));
        }
        if(row > 0){
            ans.addAll(printAllPathHelper(path+"U", maze, row-1, column, pathInMaze, step+1));
        }
        if(column > 0){
            ans.addAll(printAllPathHelper(path+"L", maze, row, column-1, pathInMaze, step+1));
        }
        maze[row][column] = true;       // Restore the false marked block to true while returning back from recursion.
        pathInMaze[row][column] = 0;

        return ans;
    }
}