### 1334 - Find the city with the smallest number of neighbours at a threshold distance

**Question link** - [Link](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/)

**Topics** - Graph, Floyd warshall algorithm, Dijkstra's algorithm

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are asked to find the city with smallest number of neighbours withing the threshold distance. For this to identify 
we need to check distance of each city from every other city. This is what Floyd warshall algorithm helps us with. Hence 
we will use floyd warshall algorithm here.

This problem can be solved in less time complexity using Dijkstra's algorithm. Instead of just 1 source apply dijkstra's algorithm
for every city as a source city.
