### 1319 - Number of operations to make network connected

**Question link** - [Link](https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/)

**Topics** - Graph, Disjoint set

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given adjacency matrix `{{0,1},{0,2},{0,3},{1,2},{1,3}}` and number of nodes are 6 (i.e. nodes from 0 to 5).
The graph will look like below.

![LC_1319 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1319/src/main/resources/images/LC_1319%20image-1.jpg)

Here we can clearly see that the node 4 and node 5 are not connected to the main component (hence graph has three components)
We need to make sure that the graph has only 1 component (i.e. all nodes are connected in the graph). From normal observation
we can say that if we have 3 components, and we want to make sure that all nodes are connected so that we will have only 
1 component then we will have to connect node 4 to the main node and node 5 to the main node as well. So we will need 2 additional
edges. In general for a graph of N component we will need `N-1` additional edges to make the graph connected. So we can 
calculate the number of components and then subtract 1 from it to get the answer.<br>
But the important thing in question is 'we can not create new edges, if we want to connect two components, then we must 
remove one edge from any of the component and use that edge only.' So we must have at least N-1 extra edges in overall 
graph where removing those edges will not impact the connectivity of the graph. These extra edges we can use to connect to
other components. In above example we have extra edges between 0-3 and 1-2. These two edges we can remove and attach to 
connect 4 and 5 to the main component. Hence answer here will be 2.

By using Disjoint set we can easily identify the number of components in the given graph. If we get number of components 
N then we can compare N-1 with extra edges and extra edged must be equal to or greater than N-1.<br> To get extra edges 
we can use any of the kruskal's or Prim's algorithm to find MST. (because edges which are not contributing to MST are the
extra edges) 
