### DFS in graph (Depth first search)

DFS in graph is almost same as that of Trees just the only difference is in trees we start from the root node and go down 
in one side till the last node, but in graph we can start from any node and we can go upward as well. 
From code perspective here the logic will be same as that of BFS in graph. That means we will visit each vertex and mark 
it as visited in a visited array.

Consider below graph to understand DFS traversal.

![DFS in graph image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/graph%20DFS%20image-1.jpg)

Here in above example if we start from vertex 1 then we have two choices either to go to vertex 2 or vertex 3. Let's say we 
went to vertex 2. Then after that unlike BFS where we went to node 3, we will instead go below vertex 2. Here as well we 
have two choices, either vertex 5 or 6. If we go to vertex 5 then after that there is no further traversal possible in downward 
direction hence we will return to node 2 and go to the remaining un-traversed vertex (Here when we return to node 2, we 
should not consider that node again as that was already visited earlier.). This same process goes on. So the final answer 
of DFS will be [1, 2, 5, 6, 3, 4, 8, 7].

If we start from vertex 3 then the final answer will be [3, 1, 2, 5, 6, 4, 8, 7].