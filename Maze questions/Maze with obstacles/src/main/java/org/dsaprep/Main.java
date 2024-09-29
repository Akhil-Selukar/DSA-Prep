package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        boolean[][] maze = {
//                {true, true, true},
//                {true, false, true},
//                {true, true, true}};
        boolean[][] maze = {
                {true, true, false, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true}};

        System.out.println(findMazePath(maze));
    }

    protected static List<String> findMazePath(boolean[][] maze) {
        return pathFinder("", maze, 0,0);
    }

    private static List<String> pathFinder(String path, boolean[][] maze, int row, int column) {
        List<String> ans = new ArrayList<>();
        if(row == maze.length-1 && column == maze[0].length-1){
            ans.add(path);
            return ans;
        }

        if(!maze[row][column]){
            return new ArrayList<>();
        }
        if(row < maze.length-1){
            ans.addAll(pathFinder(path+"D", maze, row+1, column));
        }
        if(column < maze[0].length-1){
            ans.addAll(pathFinder(path+"R", maze, row, column+1));
        }
        return ans;
    }
}