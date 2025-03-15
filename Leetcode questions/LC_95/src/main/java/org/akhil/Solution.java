package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {          // out of leaf node
            trees.add(null);
            return trees;
        }

        for(int root = start; root <= end; root++){
            List<TreeNode> leftTrees = generateTreesHelper(start, root - 1);
            List<TreeNode> rightTrees = generateTreesHelper(root + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode r = new TreeNode(root);
                    r.left = leftTree;
                    r.right = rightTree;
                    trees.add(r);
                }
            }
        }
        return trees;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
