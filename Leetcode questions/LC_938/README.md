### 938 - Range Sum of BST

**Question link** - [Link](https://leetcode.com/problems/range-sum-of-bst/description/)

**Topics** - Tree, DFS, BST

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we will not use segment tree as it will overkill the problem and we will have extra overhead of creating and maintaining 
segment tree. As it is not given that the tree is dynamic or growing and we need to query the tree at any instance so work 
with DFS and BST properties only.
