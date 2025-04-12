package org.akhil;

public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        findNode(root, startValue, start);
        findNode(root, destValue, end);

        int i=0;
        int maxPossibleCommonPath = Math.min(start.length(), end.length());

        while(i<maxPossibleCommonPath && start.charAt(start.length()-1-i) == end.charAt(end.length()-1-i)){
            i++;
        }

        return "U".repeat(start.length()-i) + end.reverse().toString().substring(i);
    }

    private boolean findNode(TreeNode root, int val, StringBuilder path) {
        if(root == null){
            return false;
        }

        if(root.val == val){
            return true;
        }

        if(root.left != null && findNode(root.left, val, path)){
            path.append('L');
        } else if(root.right != null && findNode(root.right, val, path)) {
            path.append('R');
        }

        return path.length() > 0;
    }
}
