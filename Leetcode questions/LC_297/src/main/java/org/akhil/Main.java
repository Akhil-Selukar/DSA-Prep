package org.akhil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // To test the solution locally we will need a lot of supporting code and hence only the actual solution is given below.
    // To test the solution against testcases, run it on leetcode.

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }

        sb.append(Integer.toString(node.val)+",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList(Arrays.asList(data.split(",")));
        list.remove(list.size()); // removing last unwanted element
        Collections.reverse(list);      // while serializing root was the first now as well we need root first.
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list) {
        if(list.size()==0){
            return null;
        }

        String value = list.remove(list.size()-1);

        if(value.charAt(0) == 'n'){
            return null;
        }

        int intVal = Integer.parseInt(value);
        TreeNode root = new TreeNode(intVal);

        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);

        return root;
    }
}