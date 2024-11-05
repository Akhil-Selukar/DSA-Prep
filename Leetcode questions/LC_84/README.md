### 84 - Largest rectangle in histogram

**Question link** - [Link](https://leetcode.com/problems/largest-rectangle-in-histogram/description/)

**Topics** - Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in this problem we have to find the area of rectangles that can be formed using given histogram and ten return the maximum
area out of them. 
So first and important part here is we need to one by one create all the possible rectangles using given histogram.

For example consider given histogram heights are [2, 1, 5, 6, 2, 3] so it will look like below.

![Histogram image - 1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_84/src/images/histogram-1.jpg)

Now the approach here is, for every column we can create rectangles with all previous columns only if the height of previous 
columns is greater than the actual column and keep on decreasing or remains same.

For example if we take the column at index 3 where height is 6, then the first rectangle will be the column itself.  
Second rectangle will be with column at index 2 (because the height of previous i.e. indexed 2 column is decreased that of
actual column)

![Histogram image - 2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_84/src/images/histogram-2.jpg)

Height of column at index 1 is also reduced than that of height of column at index 2 hence another rectangle is possible 
here. Here as there is no lesser height available than that of column at index 1 to it's left hence we can start the rectangle 
from left boundary.

![Histogram image - 3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_84/src/images/histogram-3.jpg)

Same goes with column at index 4, only below rectangles will be possible.

![Histogram image - 4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_84/src/images/histogram-4.jpg)

Now we know how we can identify and form the rectangles. For every column we need to store the columns with less height which
are left to the current column, and we need to retrieve the stored columns as well so here we will need a stack. 
In the stack we will store index of all the columns having height less than current column.

Then one by one we will fetch the index from stack and calculate the area of rectangle and compare it with current maximum.
So that at the end we will have overall maximum.


