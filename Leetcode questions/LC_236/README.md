### 236 - The Lowest common ancestor of a binary tree 

**Question link** - [Link](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)

**Topics** - Tree, DFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this question we are given with two nodes and we want to find the lowest common ancestor for those nodes. So here if we 
think this question in reverse way, we can say that we need to check the node on which we are currently at is having 
both given nodes as children or not? and then we need to ensure that the node is the lowest one.
Here as it is mentioned in the question that the node can be considered as its own ancestor, so there can be three cases. 

**Case 1** : Both given node lies on opposite side of current node.

![LC-236 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_236/src/main/resources/images/LC-236%20image-1.jpg)

In this case `p = 5` and `q = 0` are on the opposite side of node 3. So if we start traversing on both the sides till we 
find any of the node (p or q) we will get p from left hand side traversal and 1 from the right hand side traversal. So 
the node at which we are currently at is the lowest common ancestor. Here we will return the node as soon as we find it so 
as we find node 5 we will not go below the tree and hence we will not have to trace entire tree once the node is found. 

**Case 2** : Both the given nodes lies on left hand side of the current node.

![LC-236 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_236/src/main/resources/images/LC-236%20image-2.jpg)

In this case `p = 5` and `q = 4` both are on the left hand side of node 3. Here as well we will start from node 3 and check
on both the sides. Now from left hand side 5 will be reached first and hence it will return 5 and will not traverse further 
below. But form right hand side it will traverse entire tree and still none of the node will match to p or q hence null 
will be returned. As entire right hand side tree is traversed and none of the element was found, also till node 5 we have 
not found node 4. So the only possibility of 4 to exist is in the tree where we have not traversed i.e. tree below node 5.
As this is the only possibility, we can safely say that the node 4 will be somewhere below 5 which makes 5 the lowest common
ancestor. (as node can be considered as its own ancestor).

**Case 3** : Both the given node lies on the right hand side of current node.

![LC-236 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_236/src/main/resources/images/LC-236%20image-3.jpg)

This case is exactly same as that of case 2 just that the sides are changed hence same logic will work here as well.
