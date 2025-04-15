package org.akhil;

public class NumArray {
    TreeNode root = null;
    // O(N)/O(N)
    public NumArray(int[] nums) {
        root = buildSegmengTree(nums, 0, nums.length-1);
    }

    // O(log(N)/O(log(N))
    public void update(int index, int val) {
        this.root.data = updateHelper(root, index, val);
    }

    public int sumRange(int left, int right) {
        return sumFinder(root, left, right);
    }

    // O(log(N)/O(log(N))
    private int sumFinder(TreeNode root, int left, int right){
        if(root.startIndex >= left && root.endIndex <= right){
            return root.data;
        }
        if(root.startIndex > right || root.endIndex < left){
            return 0;
        }
        return sumFinder(root.left, left, right) + sumFinder(root.right, left, right);
    }

    private TreeNode buildSegmengTree(int[] nums, int startIndex, int endIndex){
        if(startIndex == endIndex){
            TreeNode leaf = new TreeNode(startIndex, endIndex);
            leaf.data = nums[startIndex];
            return leaf;
        }

        TreeNode node = new TreeNode(startIndex, endIndex);
        int midIndex = startIndex + (endIndex - startIndex)/2;

        node.left = buildSegmengTree(nums, startIndex, midIndex);
        node.right = buildSegmengTree(nums, midIndex+1, endIndex);

        node.data = node.left.data + node.right.data;
        return node;
    }

    private int updateHelper(TreeNode root, int index, int val){
        if(index >= root.startIndex && index <= root.endIndex){
            if(root.startIndex == index && root.endIndex == index){
                root.data = val;
            } else {
                int leftAnswer = updateHelper(root.left, index, val);
                int rightAnswer = updateHelper(root.right, index, val);

                root.data = leftAnswer + rightAnswer;
                return root.data;
            }
        }
        return root.data;
    }
}
