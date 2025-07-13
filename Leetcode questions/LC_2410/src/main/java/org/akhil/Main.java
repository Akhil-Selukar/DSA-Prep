package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};

        Solution solution = new Solution();
        System.out.println(solution.matchPlayersAndTrainers(players, trainers));
    }
}