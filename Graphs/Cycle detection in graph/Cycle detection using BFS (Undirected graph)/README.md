### Cycle detection in graph using BFS.

> This is for undirected graph

We already know what cycle means in graph. If we start from one vertex and while traversing through the graph reaches back 
to the same starting vertex, that means cycle is present in the given graph. For example consider below graph.

![Cycle detection bfs image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/cycle%20detection%20bfs%20image-1.jpg)

In graph given in above image we can see that a cycle is present (1 > 2 > 6 > 7 > 5 > 3 > 1). We can start from a vertex and 
while traversing we can return to the same vertex. But how to identify this cycle.<br>
For that we can use BFS traversal. Consider we are starting BFS from vertex 1 then as per BFS we can visit all vertices which 
are at a distance of 1 edge. So we will visit vertex 2 and vertex 3.

![Cycle detection bfs image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/cycle%20detection%20bfs%20image-2.jpg)

Now in next iteration we will go to vertex 6 from vertex 2, vertex 4 and 5 from vertex 3. 
After that from 4 we can not go any further.

![Cycle detection bfs image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/cycle%20detection%20bfs%20image-3.jpg)

Now from this state during next iteration we will visit vertex 7 from vertex 6 and mark 7 as visited. And at the same time 
we will try to visit vertex 7 from vertex 5 as well. Which means from two different path we are able to visit same vertex, 
that means there exist a cycle (as this is undirected graph)
