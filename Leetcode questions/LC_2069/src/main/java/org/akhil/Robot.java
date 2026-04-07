package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    // as we know that robot can only move across perimeter of the grid hence at any point it can never be inside somewhere.
    // Also the perimeter of the grid is nothing but a circular list hence we can simply store all cells in the perimeter and
    // after every movement call we can simply get the position using (no of steps to move/perimeter length) and fetch the coordinate
    // of that place from precomputed list.

    // list to store all coordinates of the list with direction [x, y, direction]
    private List<int[]> cells;
    int stepCount; // to track how many steps to travel
    public Robot(int width, int height) {

        cells = new ArrayList<>();
        stepCount = 0;

        // directions 0->east, 1->North, 2->west, 3->south
        cells.add(new int[]{0,0,3});    // at (0,0) robot will be looking down i.e. south

        // add east facing cells in list
        for(int i=1; i<width; i++){
            cells.add(new int[]{i, 0, 0});
        }

        // add all north facing cells
        for(int i=1; i<height; i++){
            cells.add(new int[]{width-1, i, 1});
        }

        // add all west facing cells
        for(int i=width-2; i>=0; i--){
            cells.add(new int[]{i, height-1, 2});
        }

        // add all south facing cells
        for(int i=height-2; i>0; i--){      // i>0 and not i>=0 because (0,0) is already handled at start
            cells.add(new int[]{0, i, 3});
        }
    }

    public void step(int num) {
        stepCount = stepCount + num;
    }

    public int[] getPos() {
        int posIndex = stepCount % cells.size();
        int x = cells.get(posIndex)[0];
        int y = cells.get(posIndex)[1];

        return new int[]{x, y};
    }

    public String getDir() {

        // edge case (if we have not moved once the at (0,0) direction is east otherwise at (0,0) direction will be south
        if(stepCount == 0){
            return "East";
        }

        int posIndex = stepCount % cells.size();
        int dir = cells.get(posIndex)[2];

        if(dir == 0){
            return "East";
        } else if(dir == 1){
            return "North";
        } else if(dir == 2){
            return "west";
        } else {
            return "South";
        }
    }
}
