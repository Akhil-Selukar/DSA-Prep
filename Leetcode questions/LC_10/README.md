### 10 - Regular Expression Matching

**Question link** - [Link](https://leetcode.com/problems/regular-expression-matching/description/)

**Topics** - Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here there are three scenarios in pattern.
1. We do not have `*` or `.` in the pattern then its just a simple string matching.
2. If we have a `.` in the pattern then we can just move one index ahead in string and pattern as `.` can match with any character in string (but only 1 character).
3. If we have `*` in the pattern then in this case we have two choices, either we can use the `*` and consider whatever there in pattern before `*`, (in this case we will have again the option to consider or not consider `*` again), or we can decide to not use `*` and move to next thing in pattern.

Here important thing which can confuse is the 3rd testcase where we have pattern as `.*`, this means we can have `.` either 0 or n number of times. It is not like `.` is matched with `a` in string and then we are trying to match `*` (in that case we will not have any element before `*` in pattern).

Have a look at below diagram to understand this problem better.

![LC-10 diagram](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_10/src/main/resources/images/Image-01.jpg)

Here at the end base cases can also be 3.
1. i and j both are out of bounds, which means we found the perfect match (so return true).
2. i is out of bounds and j is still in bounds, means we found the match for string in pattern (return true).
3. j is out of bounds and i is still in bounds, means no pattern left and still we have not found match for entire string (return false).