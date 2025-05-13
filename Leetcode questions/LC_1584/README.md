### 1584 - Min Cost to Connect All Points

**Question link** - [Link](https://leetcode.com/problems/min-cost-to-connect-all-points/description/)

**Topics** - Graph, Prim's algorithm, MST

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we need to calculate nothing but the weight of MST. (where weight of each node between 2 points is the distance 
between two points). Now first thing which will come to the mind is that we are not given with edges. Ofcourse we can create 
edges between all points but that will not be good approach as we can go to each and every point from each and every point 
hence to create edge we will have to create it between all points which will roughly take O(N^2). So better we can do is, 
calculate the distance of all points from our currently visited point and keep track of minimum distance.
