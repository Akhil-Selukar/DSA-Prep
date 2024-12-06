### 2000 - Number of islands

**Question link** - [Link](https://leetcode.com/problems/number-of-islands/description/)

**Topics** - Graph, Graph-traversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In simple words here we are given a 2D matrix in which each cell has either 0 or 1, and we are asked to find number of such
groups where 1's are connected somehow.

![LC-200 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_200/src/main/resources/images/lc-200%20image-1.jpg)

Here in above given 2D matrix we can see that there are 3 such groups of 1's where all the 1's are connected to each other
(either vertically, horizontally or diagonally). 

Now to identify these groups we need to check if adjacent elements in given matrix are 1 or not, and keep on traversing like 
this. We know that in case of graph if we start from any of the vertex of given graph and traverse the graph using either 
BFS or DFS, we can visit all the connected vertices. Hence we can use this concept here and consider the given matrix as a 
graph and apply graph traversal. Number of traversals we need to do in order to visit all 1's will be the number of islands
(i.e. required answer). 

In case of graph we usually have adjacency list/matrix but here we do not have it instead we have actual 2D matrix. So
here we instead of storing vertex value in the queue while doing BFS we can store pair (i,j) i.e. row and column index. 
Now next thing is we need to mark the visited element as visited as well. and for that in normal BSF we use visited array
but as we don't have vertex value here so to mark places visited we will need another 2D array.<br>
Also to check the adjacent vertex as we don't have adjacency list/matrix hence we need to check all places which are horizontal,
vertical and diagonal to current place. (i.e. all 8 directions.)

![LC-200 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_200/src/main/resources/images/lc-200%20image-2.jpg)

If any of the neighbouring place is 1 and it is not marked as visited in the visited array then we can add it in the queue 
for traversal and mark it visited. Once the queue is empty we can check for next such element which is not visited and marked as 
1 in given matrix.