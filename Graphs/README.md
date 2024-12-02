### Graph data structure

**Important terminologies in graph**

First have a look at below image to understand the terminologies related to graph.

![Graph image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Graph%20image-1.jpg)

In above image we can see two structures, both are graphs. First one is undirected graph while the second one is directed 
graph. 

**Vertex** - Each node in a graph is called as vertex of the graph.<br>
**Edge** - Line joining two vertex is called edge of the graph. Edge can have direction or it can be without direction.
Edge without direction is called undirected edge. (in case of undirected edge we can traverse from node1 to node2 as well 
as node2 to node1, while in case of directed edges we can only traverse in the given direction.)<br>
**Path** - edges present between two nodes is called the path. (it can have direction if edges are directional.)<br> 
**Cycle** - If in a graph we start from one node and by traversing through some path we are able to reach the starting
node again without traversing any node twice. Then this path represents a cycle.<br>
**Cyclic graph** - If given graph has at least one cycle, then it is a cyclic graph.<br>
**Acyclic graph** - If given graph does not have any cycle, then it is called as acyclic graph.<br>
**Degree of a node** - In case of undirected graph the number of edges attached to any node is called as the degree of that 
node. In above image degree of 5 is 3 while degree of 4 is 2.
**In-degree of a node** - In case of a directed graph, number of incoming edges to a node is called as in-degree of that node.<br>
**Out-degree of a node** - In case of a directed graph, number of outgoing edges to a node is called as out-degree of that node.<br>

> Important property -
> Degree of an N node graph is 2*N.

