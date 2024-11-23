### 199 - Binary tree right side view

**Question link** - [Link](https://leetcode.com/problems/binary-tree-right-side-view/description/)

**Topics** - Tree, BFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the first thought you might have is to just start from root node and add all `node.right` in an array and then return 
the array. This will pass some test cases but the question does not specify it is a perfect tree, that means we can have 
tree like below.

![LC-199 image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_199/src/main/resources/image/LC_199%20image.jpg)

Here we can see that the observer standing at the right will see nodes [1, 3, 6, 8]. But here the nodes 6 and 8 are not in
the path `root.right.right....`. <br>
So here our approach will be traverse level by level and just get last element in that level no matter it is at the left 
of any node or at the right. Last node in any level will be the node visible from right side of the tree.