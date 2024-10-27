### 138 - Copy list with random pointer (Deep copy of list)

**Question link** - [Link](https://leetcode.com/problems/copy-list-with-random-pointer/description/)

**Topics** - LinkedList, deep-copy

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here copying the nodes in given list is very simple we can simply create new node with value in original node. But the tricky 
part is to copy all the relations (i.e. values in next and random pointers). Because if we go node by node then it is not
necessary that the copy of random node which we want to refer from current (copied) node is available. 

Hence, to solve this problem we can first create copy of each node in front of itself in same list. Once all copies are 
created we can assign the random relationships and after that we can separate the copied nodes from original list.

For example have a look at below image.
![LC-138](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_138/src/main/resources/images/LC-138.jpg)
