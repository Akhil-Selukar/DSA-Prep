### Maze with obstacles

Consider you are given with a maze where you can not go on some blocks. In such maze you have to travel from (0,0) to (n,n).
Write a program to print all the possible paths. You are allowed to go either one step right or one step down (No diagonal or backward 
movement).

Example:
Below is a 3X3 matrix with block (1,1) is a obstacle. So the only possible ways are "DDRR" or "RRDD"

![Maze image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Maze%20questions/Maze%20with%20obstacles/src/main/resources/images/Maze-3.jpg)

In above image we can see that the middle block i.e. (1,1) has an obstacle hence only two ways are possible to travel from
(0,0) to (2,2).

Input : maze = <br>{{true, true, true},<br>{true, false, true},<br>{true, true, true}};

output : [DDRR, RRDD]