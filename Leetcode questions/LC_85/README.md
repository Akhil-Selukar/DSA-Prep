### 85 - Maximal rectangle

**Question link** - [Link](https://leetcode.com/problems/maximal-rectangle/description/)

**Topics** - Arrays, Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This question is an extension of [LC-84 Largest rectangle in histogram](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_84).

Here consider the first row of give matrix is `[1, 0, 1, 0, 0]` then we can consider this as a histogram of heights 1,0,1,0,0 respectively.
If we consider second row as `[1, 1, 0, 1, 0]` then for first column we can say the new histogram is of height 2, second 
histogram will be of size 1 this histogram will be of size 0, and so on. Now if we calculate areas of largest rectangle of all
such histograms, then we can simply take maximum of all the areas and that will be our answer.
