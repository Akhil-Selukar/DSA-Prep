package org.akhil;

import java.util.Arrays;

public class Solution {
    // Time complexity O(E * alpha(V)) ~O(E*V)
    // space complexity O(V)
    // Where V is number of vertices and E is number fo edges
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[edges.length+1];
        Arrays.fill(inDegree, -1);

        int potentialAns1 = -1;
        int potentialAns2 = -1;

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(inDegree[v] == -1){      // no previous in degree was there for node v.
                inDegree[v] = i;        // i because ith row edge is the one which is contributing to in degree for node V. In case of potential answers this will be our first potential answer.
            } else {
                potentialAns1 = inDegree[v];    // the earlier edge contributing to in degree
                potentialAns2 = i;              // ith edge which is making the in degree > 1
                break;                          // there is only 1 extra node hence it is safe to terminate here as soon as we got potential answers.
            }
        }

        if(potentialAns2 == -1){        // no node with in degree > 1   (case 2)
            // edge contributing to cycle will be the answer
            DisjointSet ds = new DisjointSet(edges.length + 1);

            for(int i=0; i<edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];

                if(!ds.unionBySize(u, v)){      // we are not able to perform union which means nodes are already connected.
                    return edges[i];
                }
            }
        } else {        // case 2 or case 3
            int[] edge1 = edges[potentialAns1];
            int[] edge2 = edges[potentialAns2];

            // remove edge 1 and try to find cycle
            DisjointSet ds = new DisjointSet(edges.length + 1);
            for(int i=0; i<edges.length; i++){
                if(i == potentialAns2){         // skipping edge2 (potential answer 2)
                    continue;
                }
                int u = edges[i][0];
                int v = edges[i][1];

                if(!ds.unionBySize(u, v)){
                    return edge1;           // case 3 - even after removing edge2 i.e. potential answer 2, if we are able to find the cycle then that means we are not able to make perfect tree by removing edge 2 hence edge2 was not the answer so only possible answer remaining is edge1.
                }
            }

            // case 1 - above loop completely executed, and we didn't get any cycle that means it's case 1. Hence we can remove any edge. but as it is mentioned that in case of multiple answer we need to return the one which comes last in edges matrix hence return edge2 as that will be the edge coming later.
            return edge2;
        }

        return null;    // unreachable code;
    }
}
