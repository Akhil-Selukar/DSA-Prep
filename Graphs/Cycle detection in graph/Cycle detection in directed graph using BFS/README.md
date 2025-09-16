### Cycle detection in directed graph using BFS (Topological sort)

In [Kahn's algorithm](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Graphs/Topological%20sorting-kahns%20algorithm)
(i.e. topological sort) we saw that topologically sorted order can only be generated of a DAG (i.e. Directed Acyclic Graph).
Hence if topological sorting order is not generated then there must be a cycle. So what we will do to check cycle in directed
graph is, apply topological sorting (i.e. Kahn's Algorithm) and if we are able to generate the ordering then no cycle is present 
otherwise cycle is present.

Have a look at below example.

![Cycle detection in directed graph using BFS image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Cycle%20detection%20in%20directed%20graph%20using%20BFS%20image-1.jpg)

In above image there is a cycle, Now here if we try to apply Kahn's algorithm. First we will add 1 to the queue.
Then we will remove 1 from the queue and as 2 is the adjacent to 1 so we will reduce the inDegree of 2. Post that the queue 
will be empty as inDegree of none of the element is 0 now. So in topological sort we will only have 1 element, which means 
topological sort ordering is not possible. So we can safely say that cycle is present in given graph.