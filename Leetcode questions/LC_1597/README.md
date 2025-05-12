### 1597 - Remove Max Number of Edges to Keep Graph Fully Traversable

**Question link** - [Link](https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/)

**Topics** - Graph, Disjoint set

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
Here the ultimate goal is to reach all nodes by both Alice and Bob. After reaching all the nodes with traversing minimum paths
whatever extra nodes we have we need to return count of those extra nodes.
This we can achieve by using disjoint set we can create union for each edge and if for any edge union is not possible means that 
edge is an extra edge.

Now next important thing here is we have three types of edges, and we want both to traverse all nodes. So here the sequence of 
considering edges becomes important. First we will have to consider all edges which both can traverse and then we can consider 
all individual edges.
