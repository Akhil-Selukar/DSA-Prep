package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> watchedVideos = List.of(List.of("A","B"),List.of("C"),List.of("B","C"),List.of("D"));
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        int id = 0;
        int level = 1;

        Solution solution = new Solution();

        System.out.println(solution.watchedVideosByFriends(watchedVideos, friends, id, level));
    }
}