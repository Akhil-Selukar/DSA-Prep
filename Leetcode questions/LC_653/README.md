### 653 - Two sum IV - Input is a BST

**Question link** - [Link](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/)

**Topics** - Binary search tree, 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we want to find the sum of two elements in the node and check if it is equal to given integer or not. This means that 
we for sure need to traverse through the tree. Now next thing is the elements whose sum is equal to the given number might 
be present at the opposite side of a node so we must keep track of what all elements we have visited till now. 
So the approach here will be to visit each element and check if the given required sum minus the value of element gives us 
any number which we have already visited. And as and when we visit any element we store that element in a set.
