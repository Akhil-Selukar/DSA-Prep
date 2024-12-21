### 787 - Cheapest flight within K stops

**Question link** - [Link](https://leetcode.com/problems/cheapest-flights-within-k-stops/description/)

**Topics** - Graph, Dijkstra's algorithm

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here as we are given with a graph and asked to find the best path so first thing that we will think of is Dijkstra's algorithm.
Dijkstra's algorithm is a correct thinking but the important thing to note here is that we are asked to find cheapest flight 
**withing K stops** that means we can have at max K stops. So in the graph there can be some other path with much cheaper 
flight (i.e. edge weight), but that path may have more than K stops so we can not consider that path. Hence here the condition
we have to check is against the stop. Hence we will use dijkstra's algorithm, we will have the dist array (which will represent
cost here), but the condition that we will apply will be on number of stops. Hence this will be a slight modification in 
normal Dijkstra's. <br>
In queue we will store elements based on number of stops and the elements in queue will be {No of stops, destination, dist/cost}
Here another thing to node is as we keep on adding elements in queue, we are adding based on number of stops and with each
iteration number of stop is going to increase by 1 hence automatically the queue will be sorted and hence we no need to use
the priority queue which will save the log(N) time complexity of priority queue.
