package org.akhil;


import java.util.*;

public class Solution {

    // Solution - more intuitive approach
    // Here if we think then all immediate child of target node and its parent is at level 1 (considering the given tree as a
    // undirected graph). Then all children of child and grand-parent of target is at level 2 and so on.
    // So this simply looks like a BFS in graph just run BFS till the depth is less than K and as soon as depth is K, whatever is present
    // At that level is the answer.
    // But the problem here is that the given structure is not graph, it is binary tree and hence we are not allowed to go to parent from
    // target. (If we just think in prespective of graph then tree is nothing but a directed graph where all directions is just downward)
    // So we can simply add a new relation from child to its parent and by that we will be able to perform BFS on graph easily.

    // O(N)/O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();     // to store information/relation detail from child to parent

        // populate the map (i.e. create relationship between child to parent)
        // Can be done by simple DFS
        dfs(root, parentMap);

        // Now the tree has became an undirected graph so simply run a BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        int level = 0;

        while(!queue.isEmpty() && level < k){
            int size = queue.size();
            level++;

            while(size > 0){
                TreeNode polled = queue.poll();
                visited.add(polled);
                size--;

                if(polled.left != null && !visited.contains(polled.left)){      // visited check because we might be came from left node to parent and if we do not check visited condition we might add left child (from where we came) back again.
                    queue.offer(polled.left);
                }

                if(polled.right != null && !visited.contains(polled.right)){
                    queue.offer(polled.right);
                }

                if(parentMap.containsKey(polled.val) && !visited.contains(parentMap.get(polled.val))){
                    queue.offer(parentMap.get(polled.val));         // this is traversing from target to it's parent (i.e. above)
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }

        return result;
    }

    private void dfs(TreeNode root, Map<Integer, TreeNode> parentMap){
        if(root == null){
            return;
        }

        if(root.left != null){
            parentMap.put(root.left.val, root);
        }
        dfs(root.left, parentMap);

        if(root.right != null){
            parentMap.put(root.right.val, root);
        }
        dfs(root.right, parentMap);
    }

    // --------------------------------------
//    List<Integer> ans = new ArrayList<>();
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        if(k == 0){
//            ans.add(target.val);
//            return ans;
//        }
//        dfsHelper(root, target, k, 0);
//        return ans;
//    }
//
//    private int dfsHelper(TreeNode root, TreeNode target, int k, int depth){
//        if(root == null){
//            return 0;
//        }
//
//        // element found at given the depth
//        if(depth == k){
//            ans.add(root.val);
//            return 0;
//        }
//
//        if(target == root || depth > 0){            // add nodes from subtree of target
//            dfsHelper(root.left, target, k, depth+1);
//            dfsHelper(root.right, target, k, depth+1);
//        } else {
//            // add node from remaining tree
//            int left = dfsHelper(root.left, target, k, depth);
//            int right = dfsHelper(root.right, target, k, depth);
//
//            if(left == k || right == k){
//                ans.add(root.val);
//                return 0;
//            } else if(left > 0){        // need to traverse right tree
//                dfsHelper(root.right, target, k, left + 1);
//                return left + 1;
//            } else if(right > 0){       // need to traverse left tree
//                dfsHelper(root.left, target, k, right + 1);
//                return right + 1;
//            }
//        }
//
//        if(target == root){
//            return 1;
//        }
//
//        return 0;
//    }
}
