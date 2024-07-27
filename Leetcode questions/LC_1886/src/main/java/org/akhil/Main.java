package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};

        System.out.println(findRotation(mat, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int count0 = 0;
        int count90 = 0;
        int count180 = 0;
        int count270 = 0;
        int length = mat.length;

        for(int row=0; row<length; row++){
            for(int col=0; col<length; col++){
                // checking 0 or 360 degree rotation
                if(target[row][col] == mat[row][col]){
                    count0++;
                }
                // checking 90 degree rotation
                if(target[row][col] == mat[length-col-1][row]){
                    count90++;
                }
                // checking 180 degree rotation
                if(target[row][col] == mat[length-row-1][length-col-1]){
                    count180++;
                }
                // checking 270 degree rotation
                if(target[row][col] == mat[col][length-row-1]){
                    count270++;
                }
            }
        }
        if((count0 == length*length) || (count90 == length*length) || (count180 == length*length) || (count270 == length*length))
            return true;
        return false;
    }
}