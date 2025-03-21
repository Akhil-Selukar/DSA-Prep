package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution - 1 O(N^2)/O(Nlog(N))
//    List<String> ans = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        helper(root, "");
//        return ans;
//    }
//
//    private void helper(TreeNode root, String str){
//        if(root.left == null && root.right == null){
//            ans.add(str+root.val);
//            return;
//        }
//        if(root.left != null){
//            helper(root.left, str + root.val + "->");
//        }
//        if(root.right != null){
//            helper(root.right, str + root.val + "->");
//        }
//    }


    // Solution - 2 O(N^2)/O(Nlog(N)) (even though complexities are same still this one is the best solution as stringBuffer
    // is faster than normal String manipulation.
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new StringBuilder());
        return ans;
    }

    private void helper(TreeNode root, StringBuilder sb){
        if (root == null){
            return;
        }

        int len = sb.length();

        if (len > 0) {
            sb.append("->");
        }
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }

        helper(root.left, sb);
        helper(root.right, sb);

        sb.setLength(len);
    }
}
