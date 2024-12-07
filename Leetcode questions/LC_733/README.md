### 733 - Flood fill

**Question link** - [Link](https://leetcode.com/problems/flood-fill/description/)

**Topics** - Graph, Graph traversing

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this problem we are given with a 2D matrix representing an image where each element in the matrix represent pixel value
at that coordinate. We are also given with coordinates of starting pixel and a target color value. We have to check the 
color value at given starting pixel and find out all the connected pixels (non-diagonal) to that starting pixel with same color value and 
replace the color value of only that connected group of pixels with target color value.

Here it is clear that we want to find the adjacent elements with same value in it, which can be easily done by using graph 
traversal. Hence we can consider the given 2D matrix as a graph and do the graph traversal (BFS or DFS both will work) and 
then as we keep on visiting connected vertices we can replace the value.
