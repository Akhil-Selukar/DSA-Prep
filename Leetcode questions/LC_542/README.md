### 542 - 01 Matrix

**Question link** - [Link](https://leetcode.com/problems/01-matrix/description/)

**Topics** - Graph

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this problem it is given that the matrix is a binary matrix which means it will have only 0 and 1. Now what we have to 
calculate is if a cell has 1 as value then we want to calculate the distance of that cell from nearest 1 (non-diagonal distance).
As the distance is non-diagonal distance hence if we traverse 1 unit in all 4 directions and encounter any 0 at those places
then we can safely say that the nearest 0 is at distance 1. This step by step traversing is nothing but BFS traversing in
Graph hence we will use BFS here.

![LC-542 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_542/src/main/resources/images/LC-542%20image-1.jpg)

Here in above image if we start from cell `(0, 1)` and traverse distance of 1 unit in all 4 directions. Then above will be 
invalid cell, left cell is another 0, right cell is also a 0 and down cell is 1. So we are able to find 1 in below cell 
by traversing a distance of 1 unit down, that means distance between cell with 0 (i.e `(0,1)`) and cell with 1 i.e. `(1,1)` 
is 1 unit which is nothing but the minimum distance or smallest distance of cell `(1,1)` from its nearest 0.
Same thing we can apply for all other 1's as well. (i.e. we can start bfs from 0's and check for 1 after every step).

Also, at initial step when we populate the Queue with all 0's for bfs we can safely say that the distance for those cells 
from nearest 0 is 0 itself as those cell itself has 0.

![LC-542 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_542/src/main/resources/images/LC-542%20image-2.jpg)

