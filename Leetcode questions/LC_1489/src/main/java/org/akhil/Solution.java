package org.akhil;

import java.util.*;

public class Solution {

    // Time Complexity: O(E log E + E * (N + E)), where N is the number of nodes and E is the number of edges.
    // Space Complexity: O(N + E), for the adjacency list (implicitly used in DisjointSet), map, and result lists.
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        Map<int[], Integer> map = new HashMap<>();

        for(int i =0;i<edges.length;i++){
            map.put(edges[i], i);           // edge and index of the edge
        }

        Arrays.sort(edges, (e1, e2)->Integer.compare(e1[2], e2[2]));     //O(E log E)

        // construct the MST
        int minCost = buildMST(n, edges, null, null);       // (O(E * N) in worst case)

        for(int i =0;i<edges.length;i++){           // O(E)
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithout = buildMST(n, edges, null, edge);       // (O(E * N) in worst case) check by skipping each edge if by skipping the edge we are not able to get MST (i.e. actual MST weight is not achieved again) then the edge is critical edge.
            if(costWithout > minCost){
                critical.add(index);
            }else{
                int costWith = buildMST(n, edges, edge, null);      // (O(E * N) in worst case) irrespective of what edge we skip we are ensuring the edge (pick) is always part of current MST (i.e. we are making chosen edge as fixed edge) in this case if we are able to create MST again then that means this is a pseudo edge.
                if(costWith == minCost){
                    pseudoCritical.add(index);
                }
            }

        }

        return Arrays.asList(critical, pseudoCritical);
    }


    // Time Complexity: O(E * N) in the worst case, where E is the number of edges and N is the number of nodes
    //                  because findParent can take O(N) in the worst case without path compression (though it's used here).
    //                  With path compression and union by size, it's closer to O(E * alpha(N)), where alpha is the inverse Ackermann function, which is almost constant.
    // Space Complexity: O(N), for the DisjointSet data structure.
    private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        DisjointSet ds = new DisjointSet(n);
        int cost = 0;               // weight of MST
        if(pick != null){
            ds.unionBySize(pick[0], pick[1]);
            cost += pick[2];
        }

        for(int[] edge : edges){
            if(edge != skip && ds.unionBySize(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        return ds.count == 1 ? cost : Integer.MAX_VALUE;
    }
}
