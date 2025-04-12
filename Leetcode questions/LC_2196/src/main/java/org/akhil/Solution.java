package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // O(N)/O(N)
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] arr:descriptions){
            int parentVal = arr[0];
            int nodeVal = arr[1];
            int direction = arr[2];

            TreeNode parentNode = map.containsKey(parentVal)? map.get(parentVal) : new TreeNode(parentVal);
            TreeNode node = map.containsKey(nodeVal)? map.get(nodeVal) : new TreeNode(nodeVal);

            if(direction == 1){
                parentNode.left = node;
            } else {
                parentNode.right = node;
            }

            map.put(parentVal, parentNode);
            map.put(nodeVal, node);
            children.add(nodeVal);
        }

        for(int parentVal:map.keySet()){
            if(!children.contains(parentVal)){
                return map.get(parentVal);
            }
        }

        return null;    // for valid description this point will never be reached.
    }
}
