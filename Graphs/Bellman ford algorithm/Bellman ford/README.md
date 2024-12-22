### Bellman ford algorithm

Just like Dijkstra's algorithm, bellman ford is also an algorithm to find the shortest path of all nodes from a source. 
The difference here is, we know that the Dijkstra's algorithm does not work if there is any negative weight in the graph.
Bellman ford works with negative weighted graphs as well. Another thing which bellman ford help us with is to detect negative 
cycle in any graph. (negative cycle means if we have a graph of three nodes forming a cycle and if we add all the edge weights 
then if it is resulting in a negative value then after applying dijkstra's algorithm it will go in an infinite loop, because 
after each iteration the overall path weight will keep on getting in negative and becoming lesser and lesser.)

> Important point to node in case of bellman ford algorithm is that it is applied in "directed graphs" only, hence if we want 
> to apply it in any undirected graph then in that case first we have to create an additional edges which represents reverse 
> direction i.e. if in an undirected graph we have node 1 and node 2 and an undirected edge between them with weight 6, then 
> we need to represent it as an edge from node 1 to node 2 with weight 6 and another edge from node 2 to node 1 with weight 6.
> 
> Second point to remember is the order of edges is not important in bellman ford the only important thing is that all edges 
> must be represented.

**Actual algorithm**<br>
What bellman ford algorithm states that is to find the shortest distance between starting point and all the other nodes, we
need to relax all the edges 'N-1' times sequentially. (where N is the number of nodes)

Relaxing an edge means consider we have a graph in which an edge is going from node U to node V with edge weight of W. We 
also have an dist array which stores the distance required to reach for particular node (just like Dijkstra's algorithm).
Then relaxing an edge means if <br>

dist[U] + W < dist[V]<br>

then update 

dist[V] = dist[U] + W

Repeat this relaxation for N-1 times sequentially (Sequentially means first perform relaxation for all the edges, that will
be our iteration 1). Then again start from first edge and perform same relaxation steps for all nodes which will be our iteration
2, and so on.

**Why exactly N-1 times?**<br>
Consider below graph<br>

![Bellman ford image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Bellman%20ford%20algorithm/images/Bellman%20ford%20image-1.jpg)

Here as shown in above image in each iteration we are getting the minimum distance of 1 node i.e. first we are getting the minimum
distance of node 1 then by using that in next iteration we are calculating the distance for node 2 then in next iteration
by using distance of 2 we are calculating distance of 3. Hence, after 3 (i.e. N-1) iterations we are getting distances for all
the nodes.

**Detection of negative cycle using Bellman ford algorithm.**<br>
In above explanation we saw that at max in worst case we will require N-1 iterations to get the answer. So if we perform 
N<sup>th</sup> iteration and the value of any distance in dist array is still reduced then we can for sure say that the 
negative cycle is present in the graph. Because we know that in case of negative cycle the distance value keep on reducing 
infinitely hence even after N-1 iterations at N<sup>th</sup> iteration the value is reduced.
