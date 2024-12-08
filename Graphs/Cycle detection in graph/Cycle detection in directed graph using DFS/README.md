### Cycle detection in directed graph using DFS

We have already seen the cycle detection in undirected graph using DFS. The same algorithm will not work here as there can
be some circular structure but the direction of edges in that circular structure does not allow returning to the same vertex 
without changing the path. (Check below image for reference).

![Cycle detection in directed graph image-1]()

In graph 1 of above image vertices `3, 4, 5, 6` looks like forming a cycle, but if we start from vertex 3 then we can traverse 
till vertex 5. But there is no way we can traverse from vertex 5 to vertex 3 without going back. So this is not a cycle.<br>
Whereas if we observe graph 2, then we can see vertices `8, 9, 10` are making a perfect cycle.

In case of algorithm which we used for cycle detection in undirected graph, graph 1 will also be considered as cyclic graph.
Because in that algorithm we are not checking for the paths. Meaning did we reach back to starting node while traversing 
same path or while traversing different one. Here in directed graph along with visited nodes we will have to check for the
currently traversed path. 

Hence, we will have two arrays, one for visited elements and another isInPath to keep track of vertices which are visited 
in currently traversed path.

