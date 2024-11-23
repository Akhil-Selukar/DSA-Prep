### 543 - Diameter of binary tree

**Question link** - [Link](https://leetcode.com/problems/diameter-of-binary-tree/description/)

**Topics** - Tree, DFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in this question we are asked to find the diameter which is the longest path between two nodes. As we need to find the 
longest path, we need to go till the leaf node on both the side of each node then only we will be able to get the diameter 
at that node by adding left and right side height. So this is the clue for DFS here.
