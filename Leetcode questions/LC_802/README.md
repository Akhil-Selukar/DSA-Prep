### 802 - Find eventual safe state

**Question link** - [Link](https://leetcode.com/problems/find-eventual-safe-states/description/)

**Topics** - Graph, Directed graph traversal, Cycle detection in directed graph 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Important parts of this question are the definition of terminal and safe nodes.
1. Terminal node - A node is a terminal node if there are <u>**no outgoing edges**</u>. (which means out-degree of the node
must be 0. No matter what in-degree is.)
2. Safe node - A node is a safe node if every possible path starting from that node <u>**leads to a terminal node** (**or another safe node**</u>).

Now have a look at below graph.

![LC-802 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-1.jpg)

Here as per definition node 5 and 6 will become terminal nodes.<br>
Now as pwe the definition of safe node, the outgoing path from a safe node must end on either terminal node or another safe 
node (not on any other node).<br>

Now think about cycles in a graph. If a cycle is present in a graph then if we start from a node and traverse forward we will
be able to reach to the same node. That mean each node in a cycle will have both incoming and outgoing edges. By the definition
of Terminal node, terminal node must not have any outgoing edge hence none of the node in a cycle will be a terminal node.
Also, all nodes in a cycle will have an outgoing node to another node in same cycle which can't be a terminal node. Hence
none of the node in a cycle can be a safe node (even though a node whose outgoing node is landing on another safe node can 
also be considered as safe, but here to be first safe node there must exist a terminal node. Without any terminal node there 
can't be any safe node). Hence, in conclusion none of the node in cycle can be a safe node.<br>

Now as none of the node in a cycle can be a safe or terminal node, so any node which is incoming to any of the cycle node 
won't be a safe node. 

All nodes other than above will be safe nodes. 

Let's test this theory in above graph.
In above graph nodes `0 > 1 > 3` form a cycle hence none of these nodes will be terminal node or a safe node. <br>
Node 6 does not have any outgoing edge (i.e. out-degree) hence it is a terminal node (all terminal node are safe node itself).<br>
Node 7 is connected to node 1 which is in cycle hence node 7 can't be a safe node.<br>

![LC-802 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-2.jpg)

Now if we check remaining nodes (node 2, 5 and 4)<br>
Node 5 is a terminal node hence it will be safe node.<br>
Node 2 has only 1 outgoing edge which lands on node 5 which is a terminal node hence node 2 is a safe node.<br>
Node 4 also has only 1 out-degree which land on node 5 which is a terminal node hence node 4 is also a safe node.<br>

Hence, all the nodes apart from nodes forming a cycle and nodes which has outgoing edge to any cycle node, will be safe nodes. 

![LC-802 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-3.jpg)