### 547 - Number of provinces

**Question link** - [Link](https://leetcode.com/problems/number-of-provinces/description/)

**Topics** - Graph, Traversal (BFS/DFS)

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here all the vertices which are connected to each other are considered to be one single province. So in other words we 
need to identify the number of groups of connected vertices. Now we already know that if we use any of the traversal 
(BFS or DFS) then if we start from one vertex of a connected node it will traverse through all the other vertices which are 
in that group. So if we find number of traversals required to visit all vertices given that will give us the number or 
connected vertices groups (which is nothing but the required answer.)
