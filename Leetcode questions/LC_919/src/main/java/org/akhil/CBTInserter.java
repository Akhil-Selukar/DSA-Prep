package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {

    // Solution 1 - Bruteforce approach (here insertion will require O(N) time complexity every time.
//    private TreeNode root;
//    public CBTInserter(TreeNode root) {
//        this.root = root;
//    }
//
//    public int insert(int val) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(this.root);
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if(node.left != null){
//                queue.add(node.left);
//            } else {
//                node.left = new TreeNode(val);
//                return node.val;
//            }
//            if(node.right != null){
//                queue.add(node.right);
//            } else {
//                node.right = new TreeNode(val);
//                return node.val;
//            }
//        }
//        return 0;
//    }
//
//    public TreeNode get_root() {
//        return this.root;
//    }


    // Solution 2 - insertion is O(1) time complexity. space complexity is O(N)
    private TreeNode root;
    private Queue<TreeNode> queue = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue.offer(root);
        while(queue.peek().right != null){      // if right is not null that means left will for sure have value as it is a complete tree.
            TreeNode polled = queue.poll();
            queue.offer(polled.left);
            queue.offer(polled.right);
        }
    }

    public int insert(int val) {
        TreeNode peeked = queue.peek();

        if(peeked.left == null){
            peeked.left = new TreeNode(val);
        } else {
            peeked.right = new TreeNode(val);
            queue.offer(peeked.left);
            queue.offer(peeked.right);
            queue.poll();
        }
        return peeked.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
