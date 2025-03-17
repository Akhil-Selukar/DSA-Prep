### 110 - Balanced Binary Tree

**Question link** - [Link](https://leetcode.com/problems/balanced-binary-tree/description/)

**Topics** - Tree, Binary tree

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Important point here is to visualize this problem in bottoms up way. Start from the leaf node, if any of the node is not balanced,
then that imbalance will be carried to the entire tree i.e. to the root node. Hence, from root node go to the left bottom
(i.e. left most leaf node) and from there start going back to root node while exiting the recursive calls check if the node 
is imbalanced or not, if any node is imbalanced then straightway return -1 indicating that there is a imbalance present and 
return false from main function.
