### 1277 - Count square sub-matrix with all 1's

**Question link** - [Link](https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/)

**Topics** - DP, Matrix, 2D-Array

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given with a binary matrix and asked to find the maximum number of **Squares** we can make using cells containing 
1's. First thing is a single 1 can be considered as a square with all sides as 1. Then 4 1's combined (2 in one row and 
2 just below them) can create a square of side 2, and so on. Have a look at below example.

![LC-1277 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1277/src/main/resources/images/LC-1277%20image-1.jpg)

Here we have total 19 squares. 

Now to solve this problem one approach which we can think of is normal brute force approach which is nothing but the recursion.
We can start from top left corner, if the value at that place is 1 then we can consider that as 1 square, then we can check 
all 3 directions (i.e. right, down and diagonal) if all of them are 1 then we can again add 1 to the number of squared,
we can again extend the inspection zone and check for square of size 3 from top left corner. Once we reach at a point where 
no square is possible then we can shift to next place i.e. (0, 1) and repeat the same process till last cell.

![LC-1277 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1277/src/main/resources/images/LC-1277%20image-2.jpg)

Here as we keep on moving away from the starting cell we are getting more and more cells to check and this can get much 
more complicated. Hence this approach will work but will not be the efficient once.

Hence in such problems we can directly go with tabulation method. The first thing we can do is create a 2D array of same 
dimension. In this 2D array at each cell we will store the number of squares ending at that particular dell (i.e. squares
bottom right corner). Now if we carefully observe all teh cells at 1st row and 1st column will not have any other cell before
them. Hence the number of squares ending at those cells will depend on the cell value only (i.e. if cell value is 1 then 
we can say there is 1 square of side 1 unit, and if the cell value is 0 then obviously there can't be any square at that cell).
Hence in our DP array we can replicate 1st row and 1st column as it is.

![LC-1277 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1277/src/main/resources/images/LC-1277%20image-3.jpg)

Now if we consider cell (1, 1) then if the value at that cell is 0 then for sure there can't be any square ending at that 
cell (as squares can only be formed using 1's), but if the value at cell (1, 1) is 1, then there can be a square ending at 
that cell. Now for any square to end at cell (1, 1), all the cells before (1, 1) must be a part of some square. In our 
example cells (0, 0) and (0, 1) are part of some squares but cell (2, 0) is not part of any square hence we can not form any
square with previous cells and ending at cell (1, 1). But cell (1, 1) can be a square in itself hence there will be only 1 
possible square at cell (1, 1). 

![LC-1277 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1277/src/main/resources/images/LC-1277%20image-4.jpg)

Now for cell (1, 2), all previous cells (i.e (0,1), (0,2), (1,1)) are part of some square that means they will have 1 as value
now if the value at cell (1, 2) is 1 then that means it can form a square with side 2 using all previous cells. hence the 
total squares ending at cell (1, 2) will be 2 (one of side 2 and another of side 1 i.e. cell itself).

![LC-1277 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1277/src/main/resources/images/LC-1277%20image-5.jpg)

Now at cell (1, 3). even though there are two squares ending at cell (1, 2), but for other cells (i.e. (0,2) and (0,3))
we have only 1 square. hence we for cell (1, 3) we can say there will be 2 square ending at that cell. (i.e. nothing but 
the minimum value of all 3 adjacent cells plus 1 for itself i.e. square with side 1).

Now if in this way we keep on filling the dp array we will get below array.

![LC-1277 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1277/src/main/resources/images/LC-1277%20image-6.jpg)

> Here cell (3, 1) will be 0 because the value at the cell itself is 0 hence no square can include that cell.

Now after populating the table if we sum up all values in all the cells we will get the total number of squares possibles.

In our case it will be `1 + 1 + 1 + 1 + 0 + 1 + 2 + 2 + 1 + 1 + 2 + 3 + 0 + 0 + 1 + 2 = 19`