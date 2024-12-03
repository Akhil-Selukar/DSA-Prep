### BFS in graph

BFS in graph is almost same as that of Trees just the only difference is in trees we start from the root node and go down
(left and right), but in graph we can start from any node and we can go upward as well. Consider below two examples to 
understand the difference. 

![Graph BFS image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/graph%20BFS%20image-1.jpg)

In first case of above image starting vertex is 1. So vertex 1 is at level 0 (or we can say 1st level). The next vertex at 
distance 1 edge are 2 and 3 hence those are at the level 1, and so on.. So the final traversal will be [1, 2, 3, 4, 5, 6, 7, 8, 9]<br>
But if we start traversing from some middle vertex like vertex 3 in second case of above example.
In that case the vertices at 1 edge distance are 1, 6 and 7 only, hence only those vertices will be at level 1. To reach 
vertex 2 from vertex 3 we need to traverse 2 edges (even though they are adjacent) hence the level of vertex 2 with respect
to vertex 3 is second level and so on. So the final traversal will be [3, 1, 6, 7, 2, 9, 4, 5, 8]

Now to actually traverse through the graph we can use similar approach like tree but not the exactly same. From above 
explanation we saw that in case of starting from some middle vertex we can traverse to any node, for example if I start 
from vertex 3 and vertex 5 is at level 3 if we traverse through 3->1->2->5 path but same node can also be traversed via
3->6->9->8->5 (as this is undirected graph) hence in this case level can be 4. Here we have to consider the shortest path.
But to ensure that for a particular vertex a path is already considered, we have to keep track of all visited vertex and 
for that we need an array (boolean, true means visited and false means not visited).<br>
In list we keep on marking vertices which are already visited and if those are not visited then only we consider those 
vertices. Rest logic is similar to that of tree (i.e. by using queue).

In case of graph traversal we will be given with two things, the vertex `v` from where we want to start and the adjacency list `adj`.
In this code we are returning traversed vertices in the form of ArrayList but we can print as well if needed. 