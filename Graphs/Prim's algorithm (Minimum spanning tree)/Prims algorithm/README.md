### Prims algorithm (minimum spanning tree)

Before understanding prims algorithm we need to know what exactly spanning trees and minimum spanning tree of a graph means.
Consider below graph.

![Prims algorithm image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-1.jpg)

Now the definition of spanning tree stats that is a graph having N nodes has exactly N-1 edges and all nodes in the graph 
are directly or indirectly connected to each other, then that graph is called a spanning tree.
Below are some spanning trees we can draw for above graph. (there can be many spanning trees for a graph) 

![Prims algorithm image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-2.jpg)


Now if we calculate the overall weight of all spanning trees individually and compare the weights, then the spanning tree 
with the least weight will be called as minimum spanning tree.

![Prims algorithm image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-3.jpg)

In above image spanning tree 1 has minimum weight hence it will the minimum spanning tree (i.e. MST) for above given graph.
None of the other tree has weight less than 17.

Now prims algorithm helps us to find the MST (i.e. weight of the MST or edges as well if required.)

**Algorithm**
Consider below graph where we want to find the MST.

![Prims algorithm image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-4.jpg)

Now as initial configuration of prims algorithm we need a priority queue, a visited array, a mst array to store edges involved in 
MST and a counter weight to hold weight of the MST.

![Prims algorithm image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-5.jpg)

Here we are starting from node 0 but we can start from any node. Just that the node from which we are starting, we need to 
consider the parent of that node as -1. (hence added -1 as parent in the queue). 
> Also another thing to note here is "Do not mark visited while inserting in priority queue" (hence we have not marked the 
> node 0 as visited yet.)

In first iteration we will poll out the only element present in priority queue {0, 0, -1}.
Now the node is 0 so consider that we are standing at node 0 now and hence we can mark node 0 as visited now. 
From node zero we can travel to node 1 and node 2, and both the nodes are not visited hence we will add both this nodes in
queue with respective weights and we are travelling to these nodes from node 0 hence parent for both will be 0. (Again 
important do not mark nodes as visited while inserting into the queue). During this iteration we were having parent as -1
which means no parent hence there was no edge and hence we didn't consider any of the addition in MST.

![Prims algorithm image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-6.jpg)

In next iteration as we are using priority queue hence the element to be polled is {1, 2, 0}. This time we have a parent i.e 0
and an node i.e. 2 hence we will add this edge to the MST and add the edge weight 1 to weight of MST. Now after this we can 
say that node 2 is visited. So from 2 we can go to nodes 0, 1, 4 and 3. But node 0 is already visited hence we will not 
consider it, node 1 is not yet visited hence we will add an entry for node 1 in the queue with parent as 2 and edge weight of 1.
same goes with 4 and 3 as well as those nodes are not visited hence we will add entries in queue for 4 and 3 as well 
with parent as 2.

![Prims algorithm image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-7.jpg)

Now next element to be removed from queue will be {1, 1, 2} (because of priority queue). And the iteration will look like 
below.<br>
Here we will get the node (2, 1) from the polled element and we can add weight 1 to the MST weight. Also we can mark 1 as 
visited now and from 1 we can go to node 0 and 2, but both are already visited hence we can simply skip those node.

![Prims algorithm image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-8.jpg)

Next element to be removed from queue will be {2, 1, 0}. Here the node is 1, but this node is already visited and considered 
in MST hence we will not do anything and skip the iteration for this node.

![Prims algorithm image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-9.jpg)

Next will be {2, 3, 2}, in this iteration we will get edge (2, 3) and weight 2 to consider in MST. From 3 we can go to 2 
and 4, but 2 is already visited hence we will not consider this and will move to 4. Also we have to mark node 3 as visited 
now.

![Prims algorithm image-10](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-10.jpg)

After this we will get {1, 4, 3} from queue and the iteration will be like below.

![Prims algorithm image-11](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-11.jpg)

Now next element to be removed will be {2, 4, 2} but as all the nodes are visited hence we will not do anything and skip 
this iteration. Now the queue is empty hence we are done with all the iterations and the weight we have will be the weight 
of MST and in MST array we will have all the edges which are contributing to the MST.

![Prims algorithm image-12](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Prim's%20algorithm%20(Minimum%20spanning%20tree)/images/Prims%20algorithm%20image-12.jpg)

