package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<List<Integer>> rooms = List.of(new List[]{
//                List.of(1),
//                List.of(2),
//                List.of(3),
//                List.of()});

        // rooms = [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms = List.of(new List[]{
                List.of(1,3),
                List.of(3,0,1),
                List.of(2),
                List.of()});

        Solution solution = new Solution();
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}