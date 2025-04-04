package org.akhil;

public class Solution {
    /**
     * To be flip equivalent we need to check below conditions for all nodes.
     * 1. node1 = node2 = null (i.e. if both the nodes are null then it is directly equivalent.
     * 2. (node1 = null & node2 != null) || (node1 != null & node2 = null) then it cant be equivalent as one of the tree does not have corresponding node at that level.
     * 3. (node1.val = node2.val) both the individual nodes must have same value (either before or after flipping)
     * 4. treeNodes should match without flipping i.e. (node1.left = node2.left) && (node1.right = node2.right)
     * 5. treeNodes should match after flipping i.e. (node1.left = node2.right) && (node1.right = node2.left)
     * Either of 4 and 5 will work.
     */

     public boolean flipEquiv(TreeNode root1, TreeNode root2) {
         return dfsHelper(root1, root2);
     }

     private boolean dfsHelper(TreeNode root1, TreeNode root2){
         if(root1 == null && root2 == null){
             return true;
         }

         if(root1 == null || root2 == null || root1.val != root2.val){
             return false;
         }

         boolean noFlipMatch = dfsHelper(root1.left, root2.left) && dfsHelper(root1.right, root2.right);
         boolean flipMatch = dfsHelper(root1.left, root2.right) && dfsHelper(root1.right, root2.left);

         return flipMatch || noFlipMatch;
     }
}
