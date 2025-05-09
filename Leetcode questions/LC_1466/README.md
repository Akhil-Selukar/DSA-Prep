### 1466 - Reorder Routes to Make All Paths Lead to the City Zero

**Question link** - [Link](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/)

**Topics** - Graph, BFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
we are starting from 0 so we can check all the neighbors of 0 then out of those neighbors we can check which ones has direction
towards 0, if both of them has then no need to add any thing to counter (i.e. final answer). Next we will shift to next level
i.e. child of child of 0, so if the can reach till child of 0 then eventually they will reach to 0. So here we are going level 
by level hence BFS.
