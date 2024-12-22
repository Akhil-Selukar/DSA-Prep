### Floyd warshall algorithm

Floyd warshall is also an algorithm to find the shortest path between two nodes. This is a multi source shortest path algorithm,
Dijkstra's and Bellman ford are the single source shortest path algorithms (means they identify shortest path to any node from 
a single given source). Floyd warshall find the shortest path from all nodes to all nodes. This algorithm also help us to detect
the negative cycle in given graph. 

As per this algorithm we start from source node and go till destination node via some nodes. So lets say we want to go from 
node I to node J via node K that means 

[I] --> [J]<br>
Via node K<br>
[I] --> [K] + [K] --> [J]

Hence, the common formula or representation of Floyd warshall algorithm is as below.

![Floyd warshall image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-1.jpg)

In this algorithm we will apply above formula for all two nodes via all nodes, and finally we will have a matrix where row
will be starting node (i) and column will be destination node (j) and the value at [i][j] will be the required shortest distance.

To calculate via all nodes we will apply above formula for all values of K and keep on updating the matrix final matrix will 
be our answer.

For example consider below graph and its adjacency matrix.

![Floyd warshall image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-2.jpg)

Now as initial configuration we will create a distance array which is exact replica of adjacency matrix.

![Floyd warshall image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-3.jpg)

In first iteration we will try to reach each node via node 0, hence the value of K will be 0. After entire iteration the 
dist array will look like below.

![Floyd warshall image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-4.jpg)

Now in second iteration we will try to reach each node via node 1, and will use matrix from iteration 1 for calculations.

![Floyd warshall image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-5.jpg)

Next in third iteration we will try to reach every node via node 2 and will use above dist matrix generated from iteration 2.

![Floyd warshall image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-6.jpg)

Next in fourth and final iteration we will try to reach every node via node 3 and we will use dist matrix from iteration 3.

![Floyd warshall image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-7.jpg)

Now above matrix gives us the shortest path between two nodes. For example if we need shortest path between node 3 to node 1,
we can simply get dist[3][1] i.e. 5 which is nothing but the shortest path between node 3 and 1.

![Floyd warshall image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Floyd%20Warshall%20(Shortest%20path)/images/Floyd%20warshall%20image-8.jpg)

If the shortest distance is infinity that means no path exist between two nodes.

**Detection of cycle**<br>
From above iterations we can observe one thing that the shortest distance of any node from itself (i.e. diagonal elements) 
is always 0. So if in any case the diagonal element is less than 0 or negative then that means there is a cycle in given graph. 


> Important point to remember here is the time complexity for this algorithm is O(N^3) which is not that good. Hence, if there
> is no negative edge given in graph and asked for all shortest distance then apply Dijkstra's algorithm for all nodes (i.e.
> considering each node as starting point) In this case as well time complexity of Dijkstra's algorithm will become O(V*(E log(V)))
> where V is number of nodes and E is number of edges. FLoyd warshall is useful only if there is any negative edge weight.  