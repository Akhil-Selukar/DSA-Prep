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

#### Approach 1
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


#### Approach 2
Here we can solve this problem using Kahn's algorithm as well.<br>
If we observe the given problem statement and below graph, we can clearly see that node 5 and node 6 are the terminal nodes
(because no outgoing edges). As there are no outgoing nodes hence they are safe nodes. 

![LC-802 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-4.jpg)

Now as per the definition of safe node we can say that all nodes which are directly connected to and pointing to terminal nodes
are safe node. So indirectly the nodes which are contributing to the in-degree of terminal node are potential safe nodes 
(Potential because there can be more outgoing edges from those nodes which might lead to a cycle and lands on itself.)<br>
Now to confirm that the node is actually a safe node or not we need to ensure that the node for which we are checking should 
not have any outgoing edge (or should not land on) any unsafe node.

A node can be unsafe if it is not eventually landing on terminal node by all possible paths. For example in below graph node 
0 is not safe node because even though it is landing on terminal node 5 via path `0->2->5`, but there exist another path 
`0->1->3->0` which lands on itself. In case of node 7 even though node 7 has only one outgoing edge and nothing lands on 
itself, but there exist a path `7->1->3->0->1` which forms a cycle hence 7 is also a not safe node.<br>
So in general all nodes which are part of a cycle or somehow connected to cycle directly they can not be a safe node.

![LC-802 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-5.jpg)

Here after all above analysis the problem boils down to identify terminal node first. Then start from terminal node and 
check all nodes which are landing on terminal nodes and ensure that they are not forming any cycle. If they satisfy this condition
(not forming cycle and connected to terminal node) then they are safe node. Now from those safe node again check for other 
nodes connected to the recently identified safe nodes and check the same thing, they must land on safe node (as per definition
of safe node) and they should not form any cycle while traversing to safe/terminal node.

Now cycle detection in directed graph can be easily identified using Kahn's algorithm. But the problem is we have to start 
from terminal node and then identify safe nodes one by one. In Kahn's algorithm we start from the node whose inDegree is 0.
But condition of terminal node given in question is that it's outDegree should be zero, and it can have any inDegree. Hence, 
to apply Kahn's algorithm we need to revert the edges in given graph. So the modified graph will look like.

![LC-802 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-6.jpg)

Now to apply Kahn's algorithm here we first calculate inDegree of all nodes.

![LC-802 image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-7.jpg)

Now next thing is we need to add all nodes with inDegree 0 in a queue and those will be for sure our answers. (Here as we 
have reversed the degree hence all the noes with inDegree 0 are now representing the terminal nodes, hence will be in answer.)

![LC-802 image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-8.jpg)

Now as per Kahn's algorithm next step is to take out elements from queue one by one and reduce the inDegree of connected 
elements by 1. So first we will remove 5. Here 5 is connected to 2 and 4, so we will reduce the inDegree of 2 and 4 by 1.

![LC-802 image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-9.jpg)

Here inDegree of 4 and 2 became 0 so we have to add them in queue. Next element to be removed from queue is 6. As 6 is not 
connected to any other node hence we will not do anything with inDegree and just add 6 to the answer. Same with 4 as well, 
and when we remove 2 from queue, now 2 is connected with 0 and 1 so we will reduce the inDegree of 0 and 1 and then check 
them if the inDegree of any element became 0 or not. Here none of the element is with inDegree 0 now hence no addition in 
queue.

![LC-802 image-10](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_802/src/main/resources/images/LC_802%20image-10.jpg)

Now as queue is empty so we will stop and we got our answer, all other nodes which are remaining will be somehow connected 
to a cycle or itself is a part of a cycle.
(Here if we want sorted order in answer we can sort it.)