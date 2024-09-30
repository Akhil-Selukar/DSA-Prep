### Paths to go from point A to point B in a maze.

You are given a (N x N) matrix/maze, and you are standing in the top left corner of the matrix/maze (Point A). You can go one
block right, one block down or one block diagonally (but not in backward direction.), there is no way to go up or left. 
Your task is to reach to the bottom right corner (Point B). Write a code to print all unique paths possible to reach from point A to point B.

Example:
In a maze of 3 X 3 number of ways are 6.<br>
have a look at below image for all 6 possible ways.

![Maze image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Maze%20questions/Paths%20to%20go%20from%20point%20A%20to%20B%20in%20a%20maze%20-%202/src/main/resources/images/Maze-2.jpg)

In above image only additional path's due to diagonal traversing are shown, but you have to print all possible paths.

>Note: Here maze is nothing but a 2D matrix but the row and column index is taken in reverse order because it is easy for recursion
while solving maze.