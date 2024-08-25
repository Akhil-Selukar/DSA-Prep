### 1200 - Minimum absolute difference

**Question link** - [Link](https://leetcode.com/problems/minimum-absolute-difference/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.


**Intuition** -
The difference between two elements of given array will be minimum when the elements are sorted in the array (i.e. the closest 
element will have minimum absolute difference). So the first step here will be to sort the given array and then we can simply 
loop over the sorted array and check the absolute difference between i+1<sup>th</sup> element and i<sup>th</sup> element is 
minimum or not, if yes the add that pair in result.