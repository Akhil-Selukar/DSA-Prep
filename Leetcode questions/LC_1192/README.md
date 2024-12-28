### 1192 - Critical connections in a network

**Question link** - [Link](https://leetcode.com/problems/critical-connections-in-a-network/description/)

**Topics** - Graph, DFS traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the intuition is very simple, an edge (connection) must break the graph in two components to be a critical connection.
Now if removing an edge is breaking the graph in two different components then there must not be any alternative path from
first node to the second node. This is what we will be finding.

For detailed explanation check out video [LC-1192](https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=55)
