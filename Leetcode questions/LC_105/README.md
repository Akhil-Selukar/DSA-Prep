### 105 - Construct a binary tree using preorder and inorder traversals

**Question link** - [Link](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)

**Topics** - Tree, preorder, inorder

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in the question we are given with two arrays preorder and inorder traversals, using these two arrays we can find the 
root node (first element in preorder array will be the root node). Now we need the left hand side elements of the root node.
If we check the preorder gain then we can't get the exact elements because starting we will be sure that second element in 
preorder array is the starting point of left side nodes but how many nodes post that belongs to left hand side?
To solve this we can use inorder traversal. In order traversal travers in the order left->node->right, and we already have 
node. So from the start of the array till node-1 will be the left side nodes and from node+1 till end of the inorder array 
will be the right hand side.<br>
Now we have all the required details, so we can create a node using root node and then do the recursion calls for both sides.

![LC_105 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_105/src/main/resources/images/LC_105%20image-1.jpg)
