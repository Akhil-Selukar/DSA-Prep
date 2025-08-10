### 869 - Reordered Power of 2

**Question link** - [Link](https://leetcode.com/problems/reordered-power-of-2/description/)

**Topics** - Maths, bit manipulation

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

Important points to observe here are below:
1. If we check decimal place value of each bit from binary system, we get each power of 2 in increasing order from right to left.
2. This we can get by shifting 1 to left each time by 1 place.
3. Now to check the rearrangement of given num. If we somehow sort the given number based on its digits and sort the number obtained from
   left shifting the bit and converting it to decimal. Then both the sorted values will be same.

