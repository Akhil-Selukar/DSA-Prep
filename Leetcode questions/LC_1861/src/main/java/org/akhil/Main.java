package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] boxGrid = {{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.rotateTheBox(boxGrid)));
    }
}