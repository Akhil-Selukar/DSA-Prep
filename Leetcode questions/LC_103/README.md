### 103 - Binary tree zigzag order traversal

**Question link** - [Link](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/)

**Topics** - Tree, BFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In question itself it is mentioned that level order traversal means level wise traversal hence we will use BFS here. Now 
here different thing than normal BFS is we have to remove elements in normal order for one level and reverse order for next 
level hence we will need Deque here (as we have to fetch nodes from front first and from back next.)
