### Kruskal's algorithm (Minimum spanning tree)

Just like Prim's algorithm, Kruskal's algorithm is also used to find the minimum spanning tree. This algorithm is a bit
simpler than the prim's algorithm. It uses [Disjoint set](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Graphs/Disjoint%20set) 
to find the MST.

Consider below example to understand the Kruskal's algorithm.

![Kruskal's algorithm image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Kruskals%20algorithm/src/main/resources/images/Kruskal's%20algorithm%20image-1.jpg)

Here we are given with a graph and the detail of it's edges and weights. 

**Step 1 -** sort the given edges based on their weights. So we will get below sorted order of edges.

![Kruskal's algorithm image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Kruskals%20algorithm/src/main/resources/images/Kruskal's%20algorithm%20image-2.jpg)

**Step 2 -** define a disjoint set. When we define a disjoint set all nodes will be orphan.

**Step 3 -** Take the first element from the sorted edges and check if they belong to same component or not. If not then 
we can consider this edge as a part of MST (from second and third coordinate we can get the nodes creating the edge and first 
coordinate will be the weight contributing the MST)

![Kruskal's algorithm image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Kruskals%20algorithm/src/main/resources/images/Kruskal's%20algorithm%20image-3.jpg)

**Step 4 -** Repeat same process for all the elements in sorted edges. **If nodes are from same component then we will not 
consider them in the MST**