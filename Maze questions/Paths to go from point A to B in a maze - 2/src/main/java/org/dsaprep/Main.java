package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;

        travelTheMaze(rows, columns);
        System.out.println(travelPathsList("",rows, columns));
    }

    protected static void travelTheMaze(int rows, int columns) {
        travelPaths("", rows, columns);
    }

    private static void travelPaths(String path, int rows, int columns) {
        if(rows == 1 && columns == 1){
            System.out.println(path);
            return;
        }

        if(rows !=1 && columns != 1){
            travelPaths(path+"X", rows-1, columns-1);   // X represents diagonal movement.
        }

        if(rows != 1){
            travelPaths(path+"D", rows-1, columns);
        }
        if(columns != 1){
            travelPaths(path+"R", rows, columns-1);
        }
    }

    protected static List<String> travelPathsList(String path, int rows, int columns) {
        List<String> ans = new ArrayList<>();
        if(rows == 1 && columns == 1){
            ans.add(path);
            return ans;
        }

        if(rows !=1 && columns != 1){
            ans.addAll(travelPathsList(path+"X", rows-1, columns-1));   // X represents diagonal movement.
        }
        if(rows != 1){
            ans.addAll(travelPathsList(path+"D", rows-1, columns));
        }
        if(columns != 1){
            ans.addAll(travelPathsList(path+"R", rows, columns-1));
        }
        return ans;
    }
}