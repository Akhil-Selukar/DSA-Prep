package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;

        System.out.println(travelTheMaze(rows, columns));
    }

    protected static int travelTheMaze(int rows, int columns) {
        if( rows == 1 || columns == 1){     // as soon as we reach at last row or column the remaining way to reach destination is only 1 (in case of last column you can only go down and in case of last row you can only go right)
            return 1;
        }

        int right = travelTheMaze(rows, columns-1);
        int down = travelTheMaze(rows-1, columns);

        return right+down;
    }
}