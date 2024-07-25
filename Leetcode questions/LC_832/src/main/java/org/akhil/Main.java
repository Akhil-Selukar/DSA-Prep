package org.akhil;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};

        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int length = image.length;
        int[][] flipped = new int[length][length];

        for(int row=0; row<length; row++){
            for(int col=0; col<length; col++){
//                flipped[row][col] = image[row][Math.abs(col-(length-1))] == 0?1:0;
                flipped[row][col] = image[row][Math.abs(col-(length-1))]^1; // XOR operation with 1 so 0^1 will give 1 and 1^1 will give 0
            }
        }
        return flipped;
    }

//  ############## ANOTHER APPROACH (without extra space) ################
    public static int[][] flipAndInvertImage2(int[][] image) {
        int length = image.length;

        for(int i=0; i<length; i++){
            reverse(image[i]);
        }

        for(int row=0; row<length; row++){
            for(int col=0; col<length; col++){
                image[row][col] = image[row][col]^1;
            }
        }
        return image;
    }

    private static void reverse(int[] ints) {
        int start = 0;
        int end = ints.length-1;

        while(start<end){
            swap(ints, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] ints, int start, int end) {
        int temp = ints[start];
        ints[start] = ints[end];
        ints[end] = temp;
    }
}