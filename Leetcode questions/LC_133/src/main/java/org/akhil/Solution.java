package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution 1 - O(V+E)/O(V+E)   where V is number of vertices and E is the number of edges.
//    public Node cloneGraph(Node node) {
//        if(node == null){
//            return null;
//        }
//
//        Node clone = new Node(node.val);
//        Node[] visited = new Node[101];           // 101 because nodes in graph are in the range of 0 to 100 (given)
//
//        dfs(node, clone, visited);
//        return clone;
//    }
//
//    private void dfs(Node node, Node clone, Node[] visited){
//        if(visited[clone.val] == null){
//            visited[clone.val] = clone;
//
//            for(Node adjNode:node.neighbors){
//                if(visited[adjNode.val] == null){
//                    Node tempNode = new Node(adjNode.val);
//                    clone.neighbors.add(tempNode);
//                    dfs(adjNode, tempNode, visited);
//                } else {
//                    clone.neighbors.add(visited[adjNode.val]);
//                }
//            }
//        }
//    }

    // Solution 2 - using hashMap, Same time and space complexity but this one is better as we are not reserving size in advance.
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Node clone = new Node(node.val);
        Map<Integer, Node> visited = new HashMap<>();

        dfs(node, clone, visited);
        return clone;
    }

    private void dfs(Node node, Node clone, Map<Integer, Node> visited){
        if(!visited.containsKey(clone.val)){
            visited.put(clone.val, clone);

            for(Node adjNode:node.neighbors){
                if(!visited.containsKey(adjNode.val)){
                    Node tempNode = new Node(adjNode.val);
                    clone.neighbors.add(tempNode);
                    dfs(adjNode, tempNode, visited);
                } else {
                    clone.neighbors.add(visited.get(adjNode.val));
                }
            }
        }
    }
}
