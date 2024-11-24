### 98 - Validate binary search tree

**Question link** - [Link](https://leetcode.com/problems/validate-binary-search-tree/description/)

**Topics** - Tree

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here to validate if given tree is a binary search tree or not we need to ensure that for any node N all left hand side tree 
nodes are having strictly lesser value nodes and all right hand tree nodes are having strictly greater values. To check 
this we need to ge node by node and compare the left and right of that node with lower and upper limit at that level. 
(Note that there will be lower and upper limit and not just the node value.) Have a look at below image to understand this 
statement better.

![LC-98 image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_98/src/main/resources/images/LC-98.jpg)

Consider above tree is not created and we have an empty canvas so the first node which will be added will be the root node.
For first node there is no restriction. It can have value as low as some negative number and value as high as some thousands
or more. So lower as well as upper limit is null (Here we cant take 0 as limit value because 0 itself is a number and value 
can go below zero as well, hence we will use wrapper class instead of primitive datatype here for limits). <br>
So let's say we added node 8 as root node. Now all the values to the left of root node must be less than 8 and all the values 
to the right of root node must be above 8. Hence for next leve below root node the upper limit becomes 8 and lowe limit can 
be anything (i.e. value can go till any negative number). Similarly, for right hand side of root node lowe limit will become 
8 as all values must be greater than 8 and upper limit can be any positive number. So lets say we added 5 to the left hand 
side of root node (5 is less than the upper limit and within the lower limit)<br>
Now for next level below node 5 if we want to go right, then the value must be greater than 5 (because it is a binary search
tree) and value must also be less than 8 because of it is greater than 8 it will go to right hand side of root node. Hence,
the lower and upper limit for right side tree to node 5 will be (5, 8). Similarly, to the left hand side of node 5 nodes with 
value less than 5 can only go and it can go till any negative number. (all values greater than 5 will go to right hand side
of node 5), so the lower and upper limit for left hand side for node 5 will be (null, 5).<br>
Same thing will follow for all the node on both sides. Hence, we need to check each node against its respective boundaries.  
