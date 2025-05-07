### 1377 - Frog Position After T Seconds

**Question link** - [Link](https://leetcode.com/problems/frog-position-after-t-seconds/description/)

**Topics** - Graph/Tree, BFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. A very important scenario is not mentioned in question is what if frog reaches the target node/vertex before time and 
there are nodes/vertices available below and frog can go ahead. (It is obvious that frog can go ahead, but it is better to ask.)
2. If frog is going ahead then that means frog can not reach the target node/vertex at time t. (it will cross the node) and hence probability becomes zero.

**Intuition** -
