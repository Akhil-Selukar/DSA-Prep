package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(N^2)/O(N)

    /*
    * Time Complexity: O(N^2 + M log N), where N is the number of nodes and M is the number of initial infected nodes.
        - Building the Disjoint Set takes O(N^2) in the worst case due to iterating through the graph adjacency matrix. However, with path compression and union by size, the subsequent findParent and unionBySize operations take nearly O(1) amortized time.
        - Iterating through the initial array to count malware in components takes O(M) time.
        - Sorting the initial array takes O(M log M) time.
        - The final loop iterating through initial and performing Disjoint Set operations takes O(M log N) in the worst case due to findParent.
        - Overall, the dominant factor is O(N^2) for building the Disjoint Set from the graph.

    * Space Complexity: O(N)
        - The Disjoint Set data structures (parent and size) take O(N) space.
        - The componentMalwareCount array takes O(N) space.
        - The initial array is sorted in-place, so it doesn't contribute extra space.
        - Other variables use constant space.
    * */
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;

        DisjointSet ds = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(graph[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int[] affectedNodeInEachComp = new int[n];

        for(int i:initial){
            affectedNodeInEachComp[ds.findParent(i)]++;
        }

        Arrays.sort(initial);
        int result = initial[0];

        int maxNodesInComp = 0;

        for(int i:initial){
            int componentParent = ds.findParent(i);
            int nodesInThisComp = ds.size.get(componentParent);
            int affectedNodesInThisComp = affectedNodeInEachComp[componentParent];

            if(affectedNodesInThisComp == 1){
                if(nodesInThisComp > maxNodesInComp){
                    result = i;
                    maxNodesInComp = nodesInThisComp;
                }
            }
        }

        return result;
    }
}
