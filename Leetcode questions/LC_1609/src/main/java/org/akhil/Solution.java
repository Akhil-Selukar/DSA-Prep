package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Solution 1 - Using BFS (O(N)/O(N))
//    public boolean isEvenOddTree(TreeNode root) {
//        if(root.val % 2 == 0){
//            return false;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int level = 0;
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            int prevVal = ((level % 2)==1) ? Integer.MAX_VALUE : 0;
//
//            for(int i=0; i<size; i++){
//                TreeNode polled = queue.poll();
//
//                if((level % 2) == 1){
//                    if((polled.val % 2) == 1 || (prevVal - polled.val) <= 0){
//                        return false;
//                    }
//                } else {
//                    if((polled.val % 2) == 0 || (polled.val - prevVal) <= 0){
//                        return false;
//                    }
//                }
//                prevVal = polled.val;
//
//                if(polled.left != null){
//                    queue.offer(polled.left);
//                }
//                if(polled.right != null){
//                    queue.offer(polled.right);
//                }
//            }
//            System.out.println();
//            level++;
//        }
//
//        return true;
//    }


    //  Same solution as that of above just changed the logic of level tracking and improved the time significantly.
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 == 0){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean evenLevel = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            int prevVal = evenLevel ? 0 : Integer.MAX_VALUE;

            for(int i=0; i<size; i++){
                TreeNode polled = queue.poll();
                int currVal = polled.val;

                if(!evenLevel){
                    if((currVal % 2) == 1 || (prevVal - currVal) <= 0){
                        return false;
                    }
                } else {
                    if((currVal % 2) == 0 || (currVal - prevVal) <= 0){
                        return false;
                    }
                }
                prevVal = currVal;

                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}
