### 112 - Path sum

**Question link** - [Link](https://leetcode.com/problems/path-sum/description/)

**Topics** - Tree, DFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we want to check for the path with all elements sum equal to given sum. As we need to check the path it is clear that 
we need to use DFS. Next thing is we will start from root if the root value is less than target sum we will take root node
and subtract the root node value from target sum so now remaining target sum we need from either left side of the tree or 
right side of the tree. Same we will keep on repeating. If left/right of any node is null or node value > r=target sum we 
can return false (means this path is not a valid path). If we get the target sum then we can return true.  
