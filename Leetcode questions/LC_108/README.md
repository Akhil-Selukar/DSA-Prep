### 108 - Convert sorted array to binary search tree

**Question link** - [Link](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/)

**Topics** - Tree, AVL tree

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
As it is given that the array is sorted, so if we create a binary search tree normally it will be a skewed tree. But
in question it is asked to create height balanced binary tree. Hence we have to balance the tree as and when we insert elements.
So this is nothing but the AVL tree i.e. self-balancing binary tree.

But here the better approach will be, as we are given that the array is sorted so if we create base node with middle element 
of array and add first half of array to left of the node and second half of the array to right side of root, then also our
problem will be solved.