package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] apple = {1,3,2};
        int[] capacity = {4,3,1,5,2};

        Solution solution = new Solution();
        System.out.println(solution.minimumBoxes(apple, capacity));
    }
}