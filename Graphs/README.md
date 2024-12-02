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

**How graph is stored**<br>
Before understanding how to store a graph data structure we must understand what all are the things which are given while
storing a graph. Given things are.<br>
Number of nodes = N<br>
Number of edges = M<br>
M lines (each line represent two nodes connected by an edge)

For example for graph shown in below image observe the inputs.

![Graph image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Graph%20image-2.jpg)

Now to represent this graph we have two types of representation.
1. Adjacency matrix
2. Adjacency list 

**Adjacency Matrix** - In this way we create a matrix of size 'N+1' and for each pair (for example pair 1 2) we mark cell 
with row 1 and column 2 as 1 (this 1 is the default weight, in case of weighted graph we actually put weight here). Now 
as we are dealing with undirected graph here so pair 1 2 indirectly mean 2 1 as well hence we mark cell with row 2 and column
1 as well with 1. And we do this for all the pairs.

![Graph image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Graph%20image-3.jpg)

```java
int[][] adj = new int[n+1][n+1];

// for pair 1 2
adj[1][2] = 1;
adj[2][1] = 1;

// so for pair i j and weight w
adj[i][j] = w;
adj[j][i] = w;
```

In case of directional graph we don't consider 1 2 implicitly means 2 1.

> in case of adjacency matrix we need matrix to store the values and the size of matrix is 'N+1' rows by 'N+1' columns
> So the space complexity will be O(N<sup>2</sup>) which is not a good complexity.

**Adjacency List** - In this way instead of storing the data in matrix form we store it in list of list. We create a list 
of list having size 'N+1' for each pair we add elements in the list. For example consider the pair 1 2, in that case for 
list at index 1 we will add 2 and as we are dealing with undirected graph se we will add 1 in the list at index 2 as well.

![Graoh image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Graph%20image-4.jpg)

Now in case of directed graph here as well the change is simple we don't consider 1 2 implicitly means 2 1.

Also in case of weighted graph instead of storing just the value we also store weight in the form of pair. So the list
becomes `List<List<pair>> adj` where pair has two data members value and weight.

![Graph image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Graph%20image-5.jpg)

```java
List<List<Integer>> adj = new ArrayList<>();

// for pair 1 2
adj.get(1).add(2);
adj.get(2).add(1);

// for pair i j
adj.get(i).add(j);
adj.get(j).add(i);
```

In case of weighted graph

```java
class Pair{
    int value;
    int weight;
    
    public pair(value, weight){
        this.value = value;
        this.weight = weight;
    }
}

class Main{
    List<List<Integer>> adj = new ArrayList<>();

    // for pair 1 2
    adj.get(1).add(new pair(2, 2));
    adj.get(2).add(new pair(1, 2));

    // for pair i j and weight w
    adj.get(i).add(new pair(j, w));
    adj.get(j).add(new pair(i, w));
}
```