### 1631 - Path with minimum efforts

**Question link** - [Link](https://leetcode.com/problems/path-with-minimum-effort/description/)

**Topics** - Graph, Dijkstra's algorithm

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given with a grid and we have to traverse from top left (i.e {0, 0}) to bottom right (i.e. {N-1, N-1}). So 
question is of grid traversal so first thing that we should think of is Dijkstra's algorithm.<br>
Here instead of distance we need maximum absolute difference of the path we are taking (because at the end we have to compare
absolute difference only and return the minimum one i.e. minimum efforts).

Now to calculate this we will use the basic initial conditions of Dijkstra's algorithm i.e. priority queue and a distance array.
but in distance array instead of distance from starting node we will store the maximum absolute difference (i.e. the 
maximum effort of that path).

Consider below grid.

![LC-1631 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-1.jpg)

Now we will start Dijkstra's algorithm. So first we will take out the element preset in the queue i.e. {0, 0, 0}. As it is 
given in question that we can travel in only 4 directions i.e. up, down, left and right. Hence we will calculate the absolute
distance between the nodes with current node and check that absolute distance against the distance in dist array. If the 
absolute distance is less that the distance present in distance array we will update the distance array and add the new 
distance with x and y coordinates in priority queue.

![LC-1631 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-2.jpg)

Here if we are at (0, 0) then we can go to (0, 1) in that case the absolute distance will be (2 - 1 i.e. 1) which is less that 
infinite. Also this absolute distance is greater than 0 (i.e. max till now in this path 1 -> 2). Hence we will update this
in dist matrix. Next we can go to (1, 0) in that case absolute distance will be 3 - 1 i.e 2, now max efforts in this path
( 1 -> 3) will be 2. Hence we will add 2 in distance array and also in priority queue.

Now in next iteration as the queue is a priority queue hence we will get element {1, 0, 1}.
From this cell we can go to 3 valid cell which are (0, 0), (0, 2) and  (1, 1). This will have absolute distance of 1, 0 and 6
respectively. Out of these absolute distance for (0, 0) we already have better distance present in distance array hence we will
skip this. Next is for (0, 2) here the absolute distance will 2 - 2 i.e. 0. But as we need maximum efforts in a path, here 
our path will become (1 -> 2 -> 2). and in this path we already have maximum efforts till now as 1. Hence here as well 
to reach till second 2 cell i.e. (0, 2) the maximum efforts will be 1 only and not 0. Last place where we can go from (0, 1)
is (1, 1). Here the absolute distance is 6 (i.e. 8-2). Now for this path i.e. 1->2->8 maximum efforts will be maximum of 1 
i.e. max efforts till now and current efforts i.e. 6. Hence here max efforts will be 6. So we will update in distance array
and in priority queue.

![LC-1631 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-3.jpg)

Now in queue the smallest element is {1, 0, 2} because it has the smallest distance 1. So this will be polled out. From 
cell (0, 2) we can go either left or down. If we go left (i.e. at (0, 1)) then teh absolute distance will be (2-2 = 0) and the effort in 
this path (1->2->2->2) will be 1 which is already there in distance array for (0, 1) hence we will skip this and go down 
to cell (1, 2). In this case aswell the absolute distance will be 0 (2-2), but the max efforts in this path (1->2->2->2) 
will be 1 (required to travel from 1 to 2) hence we will update distance array (cell (1, 2)) with 1 and add new entry in 
queue.

![LC-1631 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-4.jpg)

At this stage the smallest element in queue is {1, 1, 2} so we will pull out that element and repeat the above process again.
This time while going down we will reach the destination i.e. (2, 2) and at this step the absolute difference will be 3 (5 - 2).
Hence, the max effort required if we take the path (1->2->2->2->5) will be 3 (i.e. max of 1 (from 1 to 2) and 3 (from 2 to 5)).

Here important thing to note is we are using priority queue and hence we are consuming or iterating over smaller elements 
first and so all additions to the queue will obviously going to be either greater than or equal to the distance which we polled
out of queue. Now after above iteration if we observe the queue we still have an element {2, 1, 0} present in the queue which
is having efforts less that the efforts required in current path. Hence we can not say this is our answer because the other 
path which contains {2, 1, 0} can have max efforts 2. Hence we will keep on checking further even though we reach the destination.
>In code this checking will be ensured because of priority queue as we are using min heap, it will first poll element {2, 1, 0}
> and hence the base condition will not be satisfied. (i.e. x == N-1 && y == N-1).

![LC-1631 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-5.jpg)

Next element to be polled from queue will be {2, 1, 0} and the iteration will be like below.

![LC-1631 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-6.jpg)

After above iteration next element to be polled from queue is {2, 2, 0}. So iteration will be like.

![LC-1631 image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-7.jpg)

Next smallest element in priority queue is {2, 2, 1} hence it will be polled out and iterated.

![LC-1631 image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1631/src/main/resources/images/LC_1631%20image-8.jpg)

Now after this iteration we reach the destination with new path having max efforts as 2 which is less that the earlier path (i.e. 3)
Next we can also see in the priority queue that there is no element which is having distance less that 2, so all the next elements
or iterations that we will do will have distance either 2 or greater than 2 hence we can say that this is one of the path having 
minimum efforts. Hence we can stop the iterations and return the answer as 2.
