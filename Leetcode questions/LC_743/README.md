### 743 - Network Delay Time

**Question link** - [Link](https://leetcode.com/problems/network-delay-time/description/)

**Topics** - Graph, bellman ford or dijkstra's (both will work)

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are asked to find the minimum time required to for the signal to reach each node. 
If we consider there is 1 last node to which the signal is reaching at last then that means our answer will be time taken 
by signal to reach that node. Now it is asked in question to minimize that time (i.e.e minimum time is asked) hence we need 
to find the path using which we can reach to that last node in shortest possible time.<br>

Now if we see bellman ford or dijkstra's algorithm these algorithms find the shortest path of all nodes in graph from a given 
starting node. In question we are given with the starting node. So we can use these algorithms and find the shortest path
(here the path weight will be time as edge weight is giving us time). Now out of these shortest times which ever time is 
maximum that will be the time shortest time taken by signal to reach the last node. Hence that will be the answer.
