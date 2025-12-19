package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 1;

        Solution solution = new Solution();
        System.out.println(solution.findAllPeople(n, meetings, firstPerson));
    }
}