### 226 - Invert binary tree

**Question link** - [Link](https://leetcode.com/problems/invert-binary-tree/description/)

**Topics** - Tree, DFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we need to swap the left and right node of each node to invert a binary tree. Now here before swapping the left and right
we need to ensure that left and right itself are swapped first. That means the swapping operation for actual node we will 
do later but first we will swap left and right of that node. So the order of operation is `Left (swap) -> Right (swap) 
-> Node (swap)` which is nothing but the post-order traversal that means DFS.
