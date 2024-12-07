### 130 - Surrounded regions

**Question link** - [Link](https://leetcode.com/problems/surrounded-regions/description/)

**Topics** - Graph, Graph traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this question we have to replace all those O's which are completely surrounded by X's (from all 4 sides and not diagonally).
The above condition can only be invalid if any O from the group of O's is at the edge of the matrix. For example consider 
below images.

![LC-130 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_130/src/main/resources/images/LC-130%20image-1.jpg)

Here in above image we have 2 groups of O's, and we can easily trace all cells in each group by using either of BFS or DFS.
Now if we see in first group O at cell `(1,0)` is at the boundary hence the entire group is not completely enclosed by X's.
Same if we observe for second group of O's we can see that it is also at the boundary and hence not enclosed from two directions.

Whereas if we have a look at below image here none of the O's is touching the boundary hence the entire group of O's is enclosed
with X by all sides.

![LC-130 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_130/src/main/resources/images/LC-130%20image-2.jpg)

From above, we can confidently say that from the group of O's if any of the O lies on the edge/boundary of the matrix then 
DO NOT replace it with X otherwise we can replace all O's with X. Hence the main task for us here is to check the boundaries 
of matrix and check for O's. If we get any O then mark all connected O's as do not convert. And at the end replace all unmarked 
O's with X.

