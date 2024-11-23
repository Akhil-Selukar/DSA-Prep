package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};

        Node root = sortedArrayToBST(arr);
        System.out.println(root.val);
    }

    public static Node sortedArrayToBST(int[] nums) {
        return insertHelper(nums, 0, nums.length-1);
    }

    private static Node insertHelper(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        Node root = new Node(nums[mid]);
        root.left = insertHelper(nums, start, mid-1);
        root.right = insertHelper(nums, mid+1, end);
        return root;
    }
}