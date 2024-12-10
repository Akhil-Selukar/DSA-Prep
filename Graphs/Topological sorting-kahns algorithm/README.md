### Topological sort using BFS (Kahn's Algorithm)

In [Topological sorting](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Graphs/Topological%20sorting) using DFS we 
saw what topological sorting means. To summarize **topological sorting stats that, topological sorted ordering is any linear 
ordering of vertices such that if there is an edge present from U to V, then U must appear before V in the ordering.** Topological
sorted ordering is only possible in DAG's (i.e. Directed Acyclic Graphs) and for a single graph there can be multiple topological
sorted orders.

Now to generate topological sorted order using BFS (Kahn's algorithm), we need do tweak the BFS algorithm a bit. This small
modification in BFS algorithm to find the topological sort is called Kahn's algorithm.

Here in kahn's algorithm along with normal queue in BFS we use an array called 'inDegree' it is just like visited array but 
this has integer values which represent the inDegree of every vertex in graph.

Have a look at below example.

![Kahn's Algorithm image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-1.jpg)

In above image we have inDegree array where we have filled inDegree of each vertex.
Foe example vertex 0 has inDegree of 2 hence for 0th index of inDegree array we have 2 and so on.<br>
Now it is important to note that any acyclic directed graph will always have at least 1 node wth inDegree 0. So we will start 
with that node because as the inDegree is 0 so no other vertex has edge directed to that node. In our example vertex 4 and
5 has inDegree 0 because none of the other node has edge directed to either 4 or 5, so there is no restriction on these vertices
to have some other vertex before them in topological sort. So as initial condition add all such vertices which has inDegree
0 in the queue. we can add in any order. (here we added vertex 5 first and then vertex 4)

![Kahn's Algorithm image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-2.jpg)

Now, take elements one by one from queue. As queue is a FIFO, so we will have 5 first. Check from adjacency list that vertex
5 is pointing to which other nodes, here we have 0 and 2. So reduce the inDegree for 0 and 2 by 1. Then if any of the other 
inDegree becomes 0 then add it in the queue. Here inDegree of 0 will be updated to 1 and inDegree of 2 will be updated to 0. 
Hence, we will add 2 in the queue.

![Kahn's Algorithm image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-3.jpg)

Next we will take out 4 from the queue and repeat the same process. For 4 adjacent vertices are 0 and 1. Hence, we will reduce 
the inDegree for 0 and 1. The updated inDegree for 0 will be 0 and 1 will be 1. Here inDegree for 0 became 0 so we will add
0 in the queue.

![Kahn's Algorithm image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-4.jpg)

Next element to be taken out from queue will be 2. Vertex 2 is connected to 3 hence we will reduce inDegree of 3 by 1.
The updated inDegree of 3 will be 0 hence we will add 3 in the queue.

![Kahn's Algorithm image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-5.jpg)

Next will 0, which is not connected to any of the vertices hence no need to reduce any inDegree.

![Kahn's Algorithm image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-6.jpg)

Next element removed from queue will be 3, now 3 is connected to 1 hence we will reduce inDegree of 1 which will become 0 
after reduction. So we will add 1 into the queue as well.

![Kahn's Algorithm image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-7.jpg)

Now next to remove will be 1. 1 is not connected to anyone hence no need to reduce inDegree or add any element in queue.

![Kahn's Algorithm image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Kahn's%20algorithm%20image-8.jpg)

Now after 1 there is nothing to remove from the queue and queue is empty, hence the answer we got by removing elements from 
queue will be one of the topological sort order for given graph. `5,4,2,0,3,1` in this case.
