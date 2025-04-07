package org.akhil;

import java.util.*;

public class Solution {

    // O(N+D)/O(N+D) where D is nodes to delete. As we know that nodes to delete can be at max N hence we can simplify the
    // time and space complexities to O(N)/O(N)
    Set<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        if(to_delete.length == 0){
            list.add(root);
            return list;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode temp = helper(queue.poll());
            if(temp != null){
                list.add(temp);
            }
        }
        return list;
    }

    private TreeNode helper(TreeNode root) {
        if(root == null){
            return null;
        }

        if(set.contains(root.val)){
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
            return null;
        }

        root.left = helper(root.left);
        root.right = helper(root.right);

        return root;
    }
}
