### 114 - Flatten binary tree to linkedList

**Question link** - [Link](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/)

**Topics** - Tree, Pre-order traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here it is mentioned in the question that follow pre-order traversal (i.e Node -> Left -> Right).<br>
Next thing we can observe from the examples is all the node.left are null. And everything we have to put on node.right.<br>
As it is pre-order traversal so for each node we can take node.left and attach it to node.right, but then the question is 
where will existing node.right elements go. As we are following pre-order traversal so for sure node.right will be after 
node.left and we are attaching node.left to the right of node. So before adding node.left to the right of node what we can do 
is whatever tree we have in right side of tree that we can attach to the rightmost node in the node.left tree. (Have a look 
at below image to understand it better.)

![LC-114 image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_114/src/main/resources/images/lc-114.jpg)

