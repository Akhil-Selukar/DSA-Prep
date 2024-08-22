### 455 - Assign Cookies

**Question link** - [Link](https://leetcode.com/problems/assign-cookies/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.


**Intuition** -
Here we have to compare two arrays and check elements of those arrays against each other so we can take 1 pointer/index which 
will track which element from g array we are checking and another pointer/index which will track which element from s array we
are checking. Then as soon as any cookie is assigned we can exclude that pointer of cookie and that children from further 
checks. For this to work we will have to first sort the array in ascending order and then we can either start from last element or 
start from the first element.