### 2290 - Minimum Obstacle Removal to Reach Corner

**Question link** - [Link](https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/)

**Topics** - Arrays (2D), Priority queue or deque

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we can use greedy algorithm and start from (0,0) and check for its neighbours. count the obstacles we encounter to reach all neighbours
and add them to queue. Now here is the important point as we need the minimum obstacles path and we are using greedy approach here
so we will have to poll the neighbour or coordinate which has minimum obstacles till now. Hence we will need priority queue or 
minHeap, so each time it will give us the coordinate where we can reach with minimum obstacles. Eventually at some point we will
reach to the last coordinate which we need and first time when it will be polled from the queue will have the minimum obstacles.

Optimization: As we are eventually going to reach to the destination and every time we need to poll value from queue which has minimum 
obstacles so here we can use deque as well and every time we will add smaller neighbour (i.e. neighbour with lesser obstacle to the 
left of deque and coordinate with higher obstacle to the right) Now as all smaller options are being added to left hence we will
poll elements from left only. So eventually at one point we will fetch the desired location and it will have minimum obstacles.

Video explanation [here](https://www.youtube.com/watch?v=VxeH7_QL-28)
