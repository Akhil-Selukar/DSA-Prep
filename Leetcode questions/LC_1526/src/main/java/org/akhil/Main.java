package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] target = {1,2,3,2,1};
//        int[] target = {3,1,1,2};
//        int[] target = {3,1,5,4,2};

        Solution solution = new Solution();
        System.out.println(solution.minNumberOperations(target));
    }
}