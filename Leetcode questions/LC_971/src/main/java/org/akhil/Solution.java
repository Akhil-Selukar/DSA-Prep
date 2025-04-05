package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(N)/O(N)
    List<Integer> answer = new ArrayList<>();
    int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        boolean matching = dfs(root, voyage);

        if(matching){
            return answer;
        } else {
            return List.of(-1);
        }
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if(root == null){
            return true;
        }
        if(root.val != voyage[index]){
            return false;
        }
        index++;            // next index in preOrder will be left node.
        // hence match left node. if left node is not matching then check for flip.
        if(root.left != null && root.left.val != voyage[index]){
            // as we are flipping hence need to add root to the answer.
            answer.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        } else {
            return dfs(root.left, voyage) && dfs(root.right, voyage);
        }
    }
}
