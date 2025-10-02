### 3125 - Maximum Number That Makes Result of Bitwise AND Zero 🔒

**Question link** - [Link](https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/description/)

**Topics** - Bitwise operator

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -

<hr>

**Question :**

<u>Description</u> :<br>
Given an integer n, return the maximum integer x such that x <= n, and the bitwise AND of all the numbers in the range [x, n] is 0.

Example 1:<br>

```markdown
Input: n = 7

Output: 3

Explanation:
The bitwise AND of [6, 7] is 6.
The bitwise AND of [5, 6, 7] is 4.
The bitwise AND of [4, 5, 6, 7] is 4.
The bitwise AND of [3, 4, 5, 6, 7] is 0.
```

Example 2:<br>

```markdown
Input: n = 9

Output: 7

Explanation:
The bitwise AND of [7, 8, 9] is 0.
```

Example 3:<br>

```markdown
Input: n = 17

Output: 15

Explanation:
The bitwise AND of [15, 16, 17] is 0.
```

Constraints :<br>
* `1 <= n <= 1015`