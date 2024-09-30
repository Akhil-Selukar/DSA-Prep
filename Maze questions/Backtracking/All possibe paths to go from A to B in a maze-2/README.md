### All possible paths to go from point A to point B in a maze.

You are given a (N x N) matrix/maze, and you are standing in the top left corner of the matrix/maze (Point A). You can go one
block up, down, left or right, there is no way to go diagonally, and you can not visit same block twice in a path.
Your task is to reach to the bottom right corner (Point B). Write a code to print all unique paths possible to reach from point A to point B.
Also print the maze with steps in it.

Example:
In a maze of 3 X 3 number of ways are 12.<br>

Intuition: Here as we can go in all 4 directions hence there is a possibility that we can visit same block again and again, this can 
result in reaching the starting point after few recursions and same loop goes on. Hence to prevent that we have to mask 
every visited cell so that it can not be visited again. But this can lead to another problem which is, if we visit a cell 
in one path and mask that as visited (false) then in second path which might be completely different but include the previously false
masked cell, this path we will miss. Hence to deal with this we have to restore the original state of matrix after every path is 
traversed. i.e. we have to restore the maze to its original state during traversing back from a path. This is called backtracking.


>Backtracking: process of reverting the changes made during a recursion call while returning from that recursion call is called backtracking.

