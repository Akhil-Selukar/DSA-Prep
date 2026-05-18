package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};

        Solution solution = new Solution();
        System.out.println(solution.minJumps(arr));
    }
}