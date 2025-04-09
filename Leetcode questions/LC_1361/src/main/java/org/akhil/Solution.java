package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Solution using DFS (O(N)/O(N))
    // The basic Idea behind this solution is to be a valid binary tree and return true below conditions must be satisfied
    // 1. There should be only 1 tree i.e. all nodes must be connected.
    // 2. There must not be any cycle
    // We can use a DFS here and start from root and keep track of visited nodes. If at any instance we are visiting already visited node
    // Then that means there is a cycle and we can return false. Also if at the end of DFS we are able to visit all nodes then it denotes that
    // there is only one tree and all nodes are connected.
    // For this first thing we need it to find the root.
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int root = findRoot(n, leftChild, rightChild);

        Set<Integer> visited = new HashSet<>();

        return dfs(root, visited, leftChild, rightChild) && visited.size() == n;    // visited.size() == n because we need to ensure that all nodes are visited. to ensure that there is only one valid tree.
    }

    private boolean dfs(int root, Set<Integer> visited, int[] leftChild, int[] rightChild){
        if(root == -1){     // if we have -1 as root then that means last node does not have this (left/right) child.
            return true;
        }
        if(visited.contains(root)){         // if we encounter already visited node then there is a cycle.
            return false;
        }

        visited.add(root);
        return dfs(leftChild[root], visited, leftChild, rightChild) && dfs(rightChild[root], visited, leftChild, rightChild);

    }

    // in given tree there will be only 1 node which will not have parent that will be our root
    // There can multiple such nodes but in that case the tree will not be connected and we will return false further as we will not be able to
    // visit all the nodes hence in case of multiple root no matter which one we return our answer will be correct.
    private int findRoot(int n, int[] leftChild, int[] rightChild){
        Set<Integer> hasParent = new HashSet<>();
        for(int num:leftChild){
            hasParent.add(num);
        }
        for(int num:rightChild){
            hasParent.add(num);
        }

        for(int i=0; i<n; i++){
            if(!hasParent.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
