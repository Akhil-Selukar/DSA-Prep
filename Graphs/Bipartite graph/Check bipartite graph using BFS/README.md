### Check for bipartite graph using BFS

We already understood the meaning of [bipartite graph](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Graphs/Bipartite%20graph).
Now to check if given graph is bipartite or not, we can use BFS. While traversing using BFS along with visited array we can 
keep a track of color of each vertex (i.e. 0 or 1/true or false). If by any chance adjacent vertex of vertex being iterated 
has same value of color, then that means the graph is not a bipartite graph. While is we are able to traverse through entire 
graph without violating the condition, that means the graph is bipartite graph.
