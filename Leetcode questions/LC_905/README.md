### 905 - ort array by parity

**Question link** - [Link](https://leetcode.com/problems/sort-array-by-parity/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -
Here as per the requirement we have to fill the array from both the direction i.e. in case of even number we have to add it 
at the start of the array while in case of odd number we have to add it at the end. Instead of adding the elements in a separate 
empty array we can modify the same array and swap the elements, i.e. in case of odd element we can swap it with the element 
from the end while in case of even element we can keep it there itself so that after iterating all even numbers will be at the 
start and all odd numbers will be at the end.
