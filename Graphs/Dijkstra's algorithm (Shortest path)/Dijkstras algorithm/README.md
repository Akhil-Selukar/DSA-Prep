### Dijkstra's algorithm

Dijkstra's algorithm is one of the most important algorithm when it comes to find the shortest path between the nodes.
It is important to note that it works on graphs with non-negative edge weights. This algorithm can be implemented in two 
ways one is using priority queue and another is using set. (prefer set over priority queue as it is faster)

The algorithm is similar to that of BFS in graph the difference is we use priority queue in place of normal queue. <br>
Have a look at below problem to understand the algorithm

![Dijkstra's algorithm image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-1.jpg)

**Step 1** - initialize priority queue with a pair of starting node and 0 (distance of starting node with itself.)

![Dijkstra's algorithm image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-2.jpg)

**Step 2** - now we will start polling out elements from queue till queue becomes empty. This is a priority queue but as
of now it has only one element hence that element will be the one to be polled out of the queue (i.e. {0, 0}). Here from 
adjacency list we can get the adjacent nodes of node 0 and we can calculate their distance from root node. Then we can compare
the distance with the one stored in distance array. If calculated distance is less than the one in distance array, we will
update the distance array as we got new shortest distance. As we got new shortest distance hence all other nodes connected 
to that node can also be reached using this shortest distance so we need to check for them as well. Hence, we will add this 
node to the queue.

![Dijkstra's algorithm image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-3.jpg)

**Step3** - now in next iteration as we are working with priority queue it will check the smallest distance first but in 
our case both nodes in queue has equal distance of 4, hence it will check for the node value. Here node value 1 is less than 
2 hence the next element to be removed will be {4, 1}. We will repeat same step again.

![Dijkstra's algorithm image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-4.jpg)

Here for both the adjacent nodes calculated distance is greater that what we have in distance array hence we will skip this nodes
and will not add in queue.

Now just repeat step 2 and 3 till we get empty queue.

In next step we will remove the only element present in queue which is {4, 2} and calculate the distance of adjacent node.

![Dijkstra's algorithm image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-5.jpg)

Now next element to remove will be {5, 4} because 5 is the smallest distance available in queue. So next iteration will 
look like

![Dijkstra's algorithm image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-6.jpg)

Here we can see that we found out a new path which can get us to node 5 in just 8 distance which is less than earlier i.e. 10
Hence we will consider this new path and as we got the new path hence we will add this node with new smallest distance in queue
(even though node 5 is already present in queue with distance 10).

In next iteration element to be polled out from priority queue is {7, 3} as 7 is the smallest distance available in queue.

![Dijkstra's algorithm image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-7.jpg)

Here none of the calculated distance is less that the distance in dist array hence we will not consider any of the new distance
and hence we will not add any new entry in queue.

Next element from queue will be {8, 5} as 8 is less than 10. So the iteration will look like.

![Dijkstra's algorithm image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-8.jpg)

Next element to polled out will be the remaining one {10, 5}. For this the iteration will be like below.

![Dijkstra's algorithm image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Dijkstra's%20algorithm%20(Shortest%20path)/Dijkstras%20algorithm/src/main/resources/images/Dijkstras%20algorithm%20image-9.jpg)

Now no element is left in queue and queue is empty hence we can say that the distance array that we have is the required 
answer which will have minimum distance of respective nodes from starting node.