### Kosaraju's Algorithm

Kosaraju's algorithm is used to find the strongly connected components. By using this algorithm we can find both number of 
strongly connected components and nodes forming strongly connected components.

Before actually understanding the algorithm we must know what exactly strongly connected components are. Consider below 
graph. (Note that strongly connected components can only be present in Directed Graphs.)

![Kosaraju's algorithm image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Kosaraju's%20algorithm%20(Strongly%20connected%20components)/images/Kosaraju's%20algorithm%20image-1.jpg)

Here if we consider node 0 and node 1, then we can travel from node 0 to node one directly and also we can travel from node
1 to node 0 via node 2. That means both way traversal is possible by some way hence this is a strongly connected component 
in given graph (SCC).

Also if we consider node 3 then no such scenario is possible and node 3 is an individual node hence we can say that node 3 
is an individual strongly connected component (single node SCC).

By above explaination we can see that in given graph there are 4 strongly connected components.

![Kosaraju's algorithm image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Kosaraju's%20algorithm%20(Strongly%20connected%20components)/images/Kosaraju's%20algorithm%20image-2.jpg)


Now to identify the SCC using kosaraju's algorithm below are the steps.
**Step 1** - Sort all the nodes according to finishing time. (Finishing time means if we perform DFS on the graph then the 
first element which will have no child to go to is finished first and the element from where we start will be the last one 
to exit from call stack hence it will be finished last.)

**Step 2** - Reverse the graph (i.e. reverse all the edges)

**Step 3** - Do a DFS again.

