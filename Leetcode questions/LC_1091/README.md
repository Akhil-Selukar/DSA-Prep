### 1091 - Shortest path in binary matrix

**Question link** - [Link](https://leetcode.com/problems/shortest-path-in-binary-matrix/description/)

**Topics** - Graph, Shortest path, Dijkstra's algorithm

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. Here it is given that we can go in all 8 directions, but if not given it is important to ask if we can go to all 8 directions
or just 4. 

**Intuition** - <br>
Here we are given a maze/matrix and asked for the shortest distance so first thing that we must think of is Dijkstra's 
algorithm. The problem is here we are not given any adjacency list or anything about edges, but the important thing given
here is we can go to all 8 directions from any node. So if we are standing at a node then it will have edges to all surrounding 
nodes and as edge weights are not given so we can consider it as 1. So all nodes will be at a distance of 1 unit.

![LC-1091 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1091/src/main/resources/images/LC-1091%20image-1.jpg)

Another thing we need in Dijkstra's algorithm is distance array to store minimum distance of each node from starting node.
So here we can consider a 2D array of same dimensions as that if given grid and store distance in it. We also need a priority
queue. (Here it will be beneficial to use normal queue, we will understand teh reason below.)

Consider a problem and let's do a dry run to understand the approach which we can take here.

![LC-1091 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1091/src/main/resources/images/LC-1091%20image-2.jpg)

Now As per dijkstra's algorithm we will take out element from queue and check for all adjacent elements (here all 8 connected nodes)
if the node value is 0 and distance is less than the distance stored in dist array then we will consider that node and add it in
the queue (distance, x-coordinate, y-coordinate) and also mark the distance in dist array. At the end we want to reach till 
x and y coordinates equals to N-1 and the value must be 0.

**Iteration 1** - We will take out the element present in queue i.e. {0, 0, 0} and calculate distance of all adjacent nodes.
Based on the calculated distance and if the node is valid we will update the distance array. (conditions for valid node 
will be, it must not be outside the matrix, it must have value as 0, it's calculated distance must be less that the current 
minimum distance stored in dist array).

![LC-1091 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1091/src/main/resources/images/LC-1091%20image-3.jpg)

Here only one valid place is present i.e. (0, 1) because is it inside the grid boundaries, it's value is 0, and it is at minimum
distance. Hence we marked the distance in dist array and added the element in queue.

**Iteration 2** - Now we will get element {1, 0, 1} (distance 1, x-0, y-1). Hence we will have two valid places to go (0, 2) and (1, 2)
the distance from start node will be 2 which is less that infinity. So we will update the dist array and add the elements in 
queue.

![LC-1091 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1091/src/main/resources/images/LC-1091%20image-4.jpg)

**Iteration 3** - Now we will poll {2, 0, 2} from the queue and will repeat the same step.

![LC-1091 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1091/src/main/resources/images/LC-1091%20image-5.jpg)

In this iteration none of the element will be added in queue. One more thing we can notice here is that in queue already elements
are getting inserted in sorted order and hence the criteria of priority queue is getting fulfilled automatically and hence
we can omit the priority queue and save the time complexity of log(N) which is required for priority queue operations. Normal
queue will also work perfectly fine here.

**Iteration 4** - we will iterate with node {2, 1, 2} now. 

![LC-1091 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1091/src/main/resources/images/LC-1091%20image-6.jpg)

Here in this iteration we will reach the destination coordinates and it took us 3 shifts (i.e. 3 edges) to reach the destination.
As the answer required is in the form of nodes so we will have to add 1 in number of edges. And we will get the answer.

The negative condition here is if we are not able to reach till the destination coordinates and queue became empty then
we can say that there is no way possible to reach till destination point and we can return -1.


> Do check the improved solution as normal solution will give TLE error on leetcode.
> In improved solution we are modifying the original grid and marking already visited cells as 1 so while doing traversal 
> in each iteration calls for already visited cells will be reduced which will reduce the time drastically.