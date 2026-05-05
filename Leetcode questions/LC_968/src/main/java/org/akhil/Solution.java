package org.akhil;

public class Solution {
    // we we read the problem carefullt then there can be 3 cases per node
    // 1. node has camera on it
    // 2. node does not have camera but is monitored by immediate child or parent
    // 3. node does not have camera and not being monitored
    // Now if we start from bottom and keep on adding cameras greedily based on the node node state then we can get the minimum number
    // of cameras required

    // if the node has camera we will be returning 1, if node is monitored we will be returning 2 and if the node is not being monitored then we will be returning 3. (this is to distinguish the states of nodes)

    // O(N)/O(H)
    int totalCameras = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 3) {   // if root itself is not monitored then we need to add 1 camera at root
            totalCameras++;
        }
        return totalCameras;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 2;       // consider null node as monitored as we are not dependent on it
        }

        int leftNodeState = dfs(root.left);
        int rightNodeState = dfs(root.right);

        // assign cameras greedily based on state of child
        if(leftNodeState == 3 || rightNodeState == 3){  // if any of the child is not monitored then we has to have a camera on curr node
            totalCameras++;
            return 1;   // as we placed the camera on this node;
        } else if(leftNodeState == 1 || rightNodeState == 1){  // if any of the child has camera then curr will be monitored
            return 2;
        } else {
            return 3;   // this node has no camera and not monitored
        }
    }
}
