package org.akhil;

public class Main {
    public static void main(String[] args) {
        String moves = "UD";

        System.out.println(judgeCircle(moves));
        System.out.println(judgeCircle1(moves));
        System.out.println(judgeCircle2(moves));
    }

    public static boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;

        for(int i=0; i<moves.length(); i++){
            if(moves.charAt(i) == 'U')
                vertical++;
            if(moves.charAt(i) == 'D')
                vertical--;
            if(moves.charAt(i) == 'R')
                horizontal++;
            if(moves.charAt(i) == 'L')
                horizontal--;
        }

        return ((horizontal == 0) && (vertical == 0));
    }

    public static boolean judgeCircle1(String moves) {
        int[] position = new int[91];

        for(int i=0; i<moves.length(); i++){
            position[moves.charAt(i)]++;
        }

        return (position['U'] == position['D']) && (position['L'] == position['R']);
    }

    public static boolean judgeCircle2(String moves) {
        int vertical = 0;
        int horizontal = 0;

        for(int i=0; i<moves.length(); i++){
            switch(moves.charAt(i)){
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'R':
                    horizontal++;
                    break;
                case 'L':
                    horizontal--;
                    break;
            }
        }
        return ((horizontal == 0) && (vertical == 0));
    }
}