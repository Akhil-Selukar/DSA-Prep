package org.akhil;

public class Solution {

    // Solution 1 - using string.
//    String result = "";
//    public String smallestFromLeaf(TreeNode root) {
//        dfsHelper(root, "");
//        return result;
//    }
//
//    private void dfsHelper(TreeNode root, String currentStr) {
//        if(root == null){
//            return;
//        }
//
//        currentStr = ((char)(root.val+'a')) + currentStr;
//
//        if(root.left == null && root.right == null){
//            if(result.equals("")){
//                result = currentStr;
//            } else {
//                if(result.compareTo(currentStr) > 0){
//                    result = currentStr;
//                }
//            }
//            return;
//        }
//
//        dfsHelper(root.left, currentStr);
//        dfsHelper(root.right, currentStr);
//    }


    // Solution 2 - using stringBuilder
    String result = "~"; // Initialize with a value lexicographically larger than any possible result

    public String smallestFromLeaf(TreeNode root) {
        dfsHelper(root, new StringBuilder());
        return result;
    }

    private void dfsHelper(TreeNode root, StringBuilder currentStr) {
        if (root == null) {
            return;
        }

        currentStr.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) {
            String reversedStr = currentStr.reverse().toString();
            if (result.equals("~") || result.compareTo(reversedStr) > 0) {
                result = reversedStr;
            }
            currentStr.reverse(); // Backtrack: reverse to restore for other paths
        } else {
            dfsHelper(root.left, new StringBuilder(currentStr)); // Pass a copy
            dfsHelper(root.right, new StringBuilder(currentStr)); // Pass a copy
        }

        currentStr.deleteCharAt(currentStr.length() - 1); // Backtrack: remove the current character
    }
}
