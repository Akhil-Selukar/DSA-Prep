package org.dsaprep;

import java.util.*;

public class Solution {
    private class Vertex {
        int value;
        int parentValue;

        public Vertex(int value, int parentValue) {
            this.value = value;
            this.parentValue = parentValue;
        }
    }

    public boolean detectCycle(List<List<Integer>> adj)
    {
        boolean[] visited = new boolean[adj.size()];

        for(int i=0;i<adj.size();i++)
            if(!visited[i])
                if(checkForCycle(adj, i, visited))
                    return true;

        return false;
    }

    boolean checkForCycle(List<List<Integer>> adj, int i, boolean[] visited) {
        // BFS
        Queue<Vertex> queue =  new LinkedList<>();
        queue.add(new Vertex(i, -1));
        visited[i] =true;

        // until the queue is empty
        while(!queue.isEmpty())
        {
            // source node and its parent node
            Vertex temp = queue.poll();
            int value = temp.value;
            int parentValue = temp.parentValue;

            // go to all the adjacent nodes
            for(Integer val: adj.get(value))
            {
                if(!visited[val])
                {
                    queue.add(new Vertex(val, value));
                    visited[val] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if(parentValue != val) return true;
            }
        }

        return false;
    }
}
