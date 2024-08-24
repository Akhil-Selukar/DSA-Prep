### 976 - Largest perimeter triangle

**Question link** - [Link](https://leetcode.com/problems/largest-perimeter-triangle/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. Can there be any such array where less than 3 values are present? (if yes then we need to check this condition and return 0).

**Intuition** -
Without loss of generality, say the sidelengths of the triangle are a≤b≤c. The necessary and sufficient condition for these 
lengths to form a triangle of non-zero area is a+b>c.
Say we knew c already. There is no reason not to choose the largest possible a and b from the array. If a+b>c, then it forms a triangle, otherwise it doesn't.

So here we can sort the array first then we can find the largest values for a,b and c which satisfy the above condition (i.e. a+b>c)
if any such values are present then the perimeter will be nothing but the sum of a,b and c.