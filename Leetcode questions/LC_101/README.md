### 101 - Symmetric tree

**Question link** - [Link](https://leetcode.com/problems/symmetric-tree/description/)

**Topics** - Tree, BFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we have to compare the mirror node of a tree, mirror nodes will be present in same level, right? So it is the clue to 
use BFS here. Now to check mirror elements we need to populate the queue in such a way that adjacent elements in the queue
are the mirror nodes in actual tree (because we can not get element from middle of the queue so if we add normally then to 
check mirror position we will have to fetch element from somewhere middle in the queue.) Hence the queue population logic 
will be different here.

