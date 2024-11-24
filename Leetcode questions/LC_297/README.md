### 297 - Serialize and deserialize binary tree

**Question link** - [Link](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/)

**Topics** - Tree, preorder traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we have to serialize the tree to a string so that we can again deserialize it. Now to deserialize a tree from string or
list we need to identify the root node and the only traversal in which we can for sure get the root node is preorder traversal.
Because in preorder traversal first node i.e. index 0 node will always be the root node.<br>
But getting only the root node is not enough we also need how many nodes are there in left hand side and how many are there 
on the right hand side. So to solve this issue we can store null value as well in the serialized form so that once null 
is encountered while deserializing we can say that the nodes in that subtree are done and switch to next side subtree.
