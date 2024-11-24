### 129 - Sum root to leaf numbers

**Question link** - [Link](https://leetcode.com/problems/sum-root-to-leaf-numbers/description/)

**Topics** - Tree, DFS, preorder traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this question we have to find sum of numbers created by traversing from root to leaf in each path. So DFS is clear here.
Next is while creating the number value of node is considered first and then child, so preorder traversal is also clear.
