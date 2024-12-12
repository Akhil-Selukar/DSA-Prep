### Shortest path in directed acyclic graph

**Question link** - [Link](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/0)

**Topics** - Graph, Weighted graph, Topological sort.

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given an DAG, so the first thing to look for is topological sort. Now along with the edges we have weight for 
each edge. And shortest path depends on edge. For example consider we have two paths to reach from 'a' to 'c'. One is directly 
from 'a' to 'c' with weight 4 and another one is from 'a' to 'b' with weight 1 and then from 'b' to 'c' with weight 2. So
here if we take direct path the path weight will be 4, while if we take 'a->b->c' path then path weight will be 1+2 i.e. 3.
Hence, the shortest path will be 'a->b->c' as it has minimum weight.

Here consider below graph and starting node is 6.

![GFG-12 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-1.jpg)

Here we will use topological sort using DFS (BFS will also work). So first thing we need is a stack to store nodes which we 
are traversing. And a small modification we need to find the shortest path is a distance array, as and when we reach to any
node we will store the shortest distance of that node from starting node in this array. So at the end of traversal this array
will contain the required answer. 

Now to start we will first we will start from 0 (as per topological sort using DFS). Then adjacent nodes for 0 is node 1
hence we call DFS for 1. Then adjacent nodes for 1 is 3, hence we will call DFS for 3. Now for 3 there are no adjacent nodes
so no further DFS call is possible.

![GFG-12 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-2.jpg)

So we return from the recursive call now. While returning as per Topological sort we will add the node in stack and at the same 
time we will mark the visited array for that node as visited.

![GFG-12 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-3.jpg)

Now in next iteration we will check for node 1, but it is already visited so ignore it and check for node 2. As node 2 is 
not yet visited hence we will call DFS for node 2. The adjacent node for 2 is node 3 which is already visited and no other 
node is available for node 2 so we will end the recursion call there itself and add node 2 in stack. Also mark it as visited.

![GFG-12 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-4.jpg)

Now next iteration will be for 3, which is already visited hence skip it. Next will be for node 4, adjacent nodes for 4 are 
0 and 2. Both are already visited hence no further DFS call is possible for node 4 hence we will mark 4 as visited and will
add it in stack.

![GFG-12 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-5.jpg)

Next iteration will be of node 5, node 5 has only 1 adjacent node 4 which is already visited hence node 5 will be marked as
visited and added in stack without any further recursion call and same for node 6 as well. So final stack will be like below 
which will be nothing but the topological sort order.

![GFG-12 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-6.jpg)

Now as the stack is populated with topological sort order we will start calculating the shortest distance of each node.
And as mentioned earlier to store the shortest distance we will use the distance array. Distance array will be initially 
filled with Integer.MAX_VALUE as we need the shortest distance.<br>
Now one thing we know for sure, if we are starting from a node 'A' then the shortest distance of node 'A' from itself will 
be 0 only. So same we will apply here as well, as we are starting from node 6 hence we will mark shortest distance in distance 
array for node 6 as 0.

![GFG-12 image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-7.jpg)

Now start taking out nodes one by one from stack and calculate teh distance for those node from starting node (this is called 
relaxing the edges.)<br>
Here the first element which will be polled from stack is node 6, We have already marked the shortest distance of node 6 from 
starting node as 0. So next thing is to check adjacent nodes of node 6 from adjacency list. We have node 4 which is 2 weights
apart and node 5 which is 3 weights apart.<br>
Now as we now the shortest distance of node 6 from starting node then the shortest distance of node 4 from starting node 
will be `shortest distance till node 6 + distance of node 4 from node 6`. Same can be applied to 5 as well.

![GFG-12 image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-8.jpg)

Next popped node will be node 5. Now we know the shortest distance of node 5 from starting node is 3. And adjacent node 4 is
placed 1 weight away so the distance of node 4 from starting node (via this path) will be `shortest distance till 5 + distance 
between 5 and 4` (i.e. 3+1 = 4). But the distance of 4 from starting mentioned in distance array is 2 which is less than 
4 hence we will not consider this as shortest distance and will not update the distance array. (If newly calculated distance 
is less than the distance is distance array then update the distance array with smaller distance as we need shortest distance)

![GFG-12 image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-9.jpg)

Next will be 4, now shortest distance of 4 from tarting node is 2. The adjacent nodes for 4 are 2 and 0 which are at a distance of 
1 and 3 respectively so the shortest distance will be updated for 2 and 0 like below.

![GFG-12 image-10](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-10.jpg)

Similarly, subsequent iterations will be like below.

![GFG-12 image-11](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-11.jpg)

![GFG-12 image-12](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-12.jpg)

![GFG-12 image-13](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-13.jpg)

![GFG-12 image-14](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-12/src/main/resources/images/GFG-12%20image-14.jpg)