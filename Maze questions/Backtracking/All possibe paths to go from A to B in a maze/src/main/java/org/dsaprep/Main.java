package org.dsaprep;

import java.util.ArrayList;
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
        return printAllPathHelper("", maze, 0, 0);
    }

    private static List<String> printAllPathHelper(String path, boolean[][] maze, int row, int column) {
        List<String> ans = new ArrayList<>();
        if(row == maze.length-1 && column == maze.length-1){
            ans.add(path);
            return ans;
        }

        // If the block is already visited then skip that block.
        if(!maze[row][column]){
            return new ArrayList<>();
        }

        maze[row][column] = false; // Mark the current visited block as false.

        if(row < maze.length-1){
            ans.addAll(printAllPathHelper(path+"D", maze, row+1, column));
        }
        if(column < maze[0].length-1){
            ans.addAll(printAllPathHelper(path+"R", maze, row, column+1));
        }
        if(row > 0){
            ans.addAll(printAllPathHelper(path+"U", maze, row-1, column));
        }
        if(column > 0){
            ans.addAll(printAllPathHelper(path+"L", maze, row, column-1));
        }
        maze[row][column] = true;       // Restore the false marked block to true while returning back from recursion.

        return ans;
    }
}