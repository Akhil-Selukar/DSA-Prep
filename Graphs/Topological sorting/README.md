### Topological sorting

The definition of topological sorting stats that, topological sorted ordering is any linear ordering of vertices such that 
if there is an edge present from U to V, then U must appear before V in the ordering.

> Note that one graph can have multiple topological sorted ordering.<br>
> Topological sorting is present in only Directed Acyclic Graph (i.e. DAG). (Look at below example to understand this better.)

![Topological sort image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-1.jpg)

In above image vertex 5 has outward edge to vertex 2 and vertex 0, so 5 comes before both 0 and 2 in Topologically sorted
order. Also, 4 has outward edges to 0 and 1 hence 4 comes before 0 and 1. 2 has outward edge to 3 hence 2 comes before 3. 
3 has outward edge to 1 hence 3 comes before 1 and so on. Basically all vertices in linear structure are following the above 
definition. This is not possible in case of cyclic graph neither possible in undirected graph.

There can be multiple topologically sorted ordering for a single graph. For example above graph has `5,4,2,3,1,0`, `4,5,2,3,1,0`, 
`5,2,4,0,3,1`, etc. topologically sorted orderings.

Now to get the topological sorted ordering we can use DFS. The algorithm is simple.
We will apply DFS for each vertex and keep a visited array. an as and when there is no more DFS call to make and we are returning 
 from the recursion stack, we add the vertices to another stack. At the end when all the vertices are visited, we can simply
get the elements one by one from stack and the order in which we will receive the elements will be topologically sorted order.

For example in above example lets create a visited array and declare a stack.

![Topological sort image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-2.jpg)

Now let's start from vertex 0. From adjacency list we can see that 0 does not have any adjacent vertex hence no further DFS 
call will be possible. Hence, return from DFS call but before returning add 0 to the stack.

![Topological sort image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-3.jpg)

Now start DFS for vertex 1. For vertex 1 as well we dont have any adjacent vertices so we will return from the DFS call and
while returning will add 1 to stack.

![Topological sort image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-4.jpg)

Next we will start DFS for vertex 2, here for vertex 2 we have 3 as adjacent vertex hence we will call DFS for 3. For 3 we 
have adjacent vertex 1, but 1 is already visited hence we will not call DFS for 1 again. Now as no other vertex is left for
3 hence we will start returning from recursive calls and while returning will add vertex to stack. As we will return from 
DFS call for 3 first hence we will add 3 first in stack and then 2.

![Topological sort image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-5.jpg)

Now same thing we will repeat for node 4 and node 5.

![Topological sort image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-6.jpg)

![Topological sort image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-7.jpg)

Now as all vertices are visited, if we start taking out elements from stack one by one what we will get is one of the topological
sorted order.

![Topological sort image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/images/Topological%20sorting%20image-8.jpg)

