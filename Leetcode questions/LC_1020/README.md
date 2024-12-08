### 1020 - Number of enclaves

**Question link** - [Link](https://leetcode.com/problems/number-of-enclaves/description/)

**Topics** - Graph, Graph traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we want to find all such lands (i.e. 1's) from where we can not go outside the boundary of grid. If we think in other 
way, we can say to escape from the boundary land must be connected to the boundary. So all land cells which are at the boundary 
will not be the part of our answer. Now for inner land cells, if that cell is connected either horizontally or vertically 
to any or the land cell at boundary then we can hop onto the connected land cell and escape out of the boundary. Hence, all 
land cells which are connected to the boundary land cell will also not be the part of answer.

![LC-1020 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1020/src/main/resources/images/LC_1020%20image-1.jpg)

So the approach will be simple, we will check all the boundaries of the grid and if we find any land cell then by using 
either bfs or dfs we can traverse to all the connected land cells. While traversing, we will be marking the cells as visited
and at the end all land cells which are not yet marked as visited will be the answer. (As we are not able to reach from boundary 
to that cell means we can not reach from that cell to boundary and hence we can't escape)
