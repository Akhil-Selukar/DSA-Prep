package org.akhil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null){
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private TreeNode deserializeHelper(Queue<String> queue, int minValue, int maxValue) {
        if(queue.isEmpty()){
            return null;
        }
        String temp = queue.peek();
        int val = Integer.parseInt(temp);
        if(val < minValue || val > maxValue){
            return null;
        }
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue, minValue, val);
        node.right = deserializeHelper(queue, val, maxValue);
        return node;
    }
}
