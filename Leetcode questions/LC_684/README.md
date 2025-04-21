### 684 - Redundant Connection

**Question link** - [Link](https://leetcode.com/problems/redundant-connection/description/)

**Topics** - Graph, Disjoint set

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
If we start creating unions then the edge for which we get ultimate parent for both U and V as same, that will be the redundant edge
as ultimate parents are same means the nodes are already connected in some way.
