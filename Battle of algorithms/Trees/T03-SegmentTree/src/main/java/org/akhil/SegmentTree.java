package org.akhil;

public class SegmentTree {
    // Implement below methods
    // construct to initialize and populate the segment tree from given array
    // query(startIndex, endIndex) to fetch the sum of elements from start to end index
    // update(index, value) to update the value at given index with given value.

    // Write your code below this line

    private class Node{
        int data;
        int leftBoundary;
        int rightBoundary;
        Node left;
        Node right;

        public Node(int leftBoundary, int rightBoundary){
            this.leftBoundary = leftBoundary;
            this.rightBoundary = rightBoundary;
        }
    }


    private Node root;

    public SegmentTree(int[] nums){
        root = constructHelper(nums, 0, nums.length-1);
    }

    private Node constructHelper(int[] nums, int start, int end) {
        if(start == end){
            Node leaf = new Node(start, end);
            leaf.data = nums[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = start + (end - start)/2;

        node.left = constructHelper(nums, start, mid);
        node.right = constructHelper(nums, mid+1, end);

        node.data = node.left.data + node.right.data;

        return node;
    }

    public int query(int startIndex, int endIndex){
        if(startIndex < root.leftBoundary || endIndex > root.rightBoundary){
            throw new IllegalArgumentException("Not allowed");
        }

        return queryHelper(root, startIndex, endIndex);
    }

    private int queryHelper(Node root, int startIndex, int endIndex) {
        if(root.leftBoundary >= startIndex && root.rightBoundary <= endIndex){
            return root.data;
        } else if(root.leftBoundary > endIndex || root.rightBoundary < startIndex){
            return 0;
        } else {
            return queryHelper(root.left, startIndex, endIndex) + queryHelper(root.right, startIndex, endIndex);
        }
    }

    public void update(int index, int value){
        if(index < root.leftBoundary || index > root.rightBoundary){
            throw new IllegalArgumentException("Illegal argument");
        }

        updateHelper(root, index, value);
    }

    private int updateHelper(Node root, int index, int value) {
        if(index >= root.leftBoundary && index <= root.rightBoundary){
            if(index == root.leftBoundary && index == root.rightBoundary){
                root.data = value;
                return root.data;
            } else {
                int leftValue = updateHelper(root.left, index, value);
                int rightValue = updateHelper(root.right, index, value);

                root.data = rightValue + leftValue;
                return root.data;
            }
        }
        return root.data;
    }
}
