### Shortest path in undirected graph

**Question link** - [Link](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1)

**Topics** - Graph, Undirected graph, BFS

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here given is the undirected graph with unit weight (i.e. each edge has weight 1). Now here we can use BFS and start from
given starting node and visit each node one by one.<br> 
Why we are using BFS?. Because it is obvious that distance of starting node from itself will be 0 now we want the shortest 
distance. So all the nodes to which starting node is connected will be at a distance of 1 (unit weight) then all nodes below 
that will be at distance 2 and so on. Hence, we want to go level by level which is nothing but the BFS. 

Consider below graph.

![GFG-13 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-1.jpg)

Now here consider starting node as 0. Then we will define a queue and we will store a pair in the queue (pair of node value 
and distance of that node from starting node). Along with that instead of visited array we will keep distance array same as 
that of [GFG-12 shortest distance in directed acyclic graph](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/GFG%20questions/GFG-12)<br>
As a starting point we will add starting node in queue with distance as 0. (because shortest distance of starting node from 
itself will be 0).

![GFG-13 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-2.jpg)

From this initial condition we will start taking out element from queue one by one and will check all adjacent nodes for the
one which was taken out from queue and update the distance for adjacent nodes in distance array.<br>
Here the element which we will get from queue is (0, 0) where 0 is the node value and 0 is the shortest distance of that node 
from start point. Now from adjacency list we can check all adjacent elements of 0 and as those elements are directly adjacent
to 0 so the minimum distance of those nodes from start will be `minimum distance of 0 from start + 1` (+1 because this is a
unit weight graph). So we will get the smallest distance of adjacent nodes (node 1 and 3) from starting node 0. This distance 
is smaller than what we have against the node index in distance array (i.e. infinity). So we will update the distance array.

![GFG-13 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-3.jpg)

Now next element to be popped out from queue is (1, 1) which is node 1 with shortest distance 1. From adjacency list we 
can see the adjacent nodes for node 1 are node 2 and 3. Now again we will calculate distance for node 2 and 3 using above-mentioned 
formula. Now here the distance for 3 will be 2 via this path (0->1->3), but the distance stored in distance array is 1 which 
is smaller than 3 so shortest distance is already present in distance array. Hence we will not update the distance array for 
node 3. But we will update it for node 2 and also add node 2 in queue.

![GFG-13 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-4.jpg)

Next to pop out is element (3, 1) i.e. node 3 with distance 1. Node 3 is connected to node 0, 1 and 4 so we will calculate 
distance of 0, 1 and 4 using the formula and update it based on if it is smaller than the existing distance is distance array.

![GFG-13 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-5.jpg)

If we just repeat this step till the queue is empty we will get below iterations.

![GFG-13 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-6.jpg)

![GFG-13 image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-7.jpg)

![GFG-13 image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-8.jpg)

![GFG-13 image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-9.jpg)

![GFG-13 image-10](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-10.jpg)

![GFG-13 image-11](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-13/src/main/resources/images/GFG-13%20image-11.jpg)
