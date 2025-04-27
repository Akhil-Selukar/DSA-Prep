package org.akhil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // O(V+E)/O(V)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);

        for(int i=0; i<rooms.size(); i++){
            if(!visited.contains(i)){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int node) {
        visited.add(node);

        for(int neighbour:rooms.get(node)){
            if(!visited.contains(neighbour)){
                dfs(rooms, visited, neighbour);
            }
        }
    }
}
