### 2843 - Count Symmetric Integers

**Question link** - [Link](https://leetcode.com/problems/count-symmetric-integers/description/)

**Topics** - Maths, logic

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

<strong>Time complexity</strong> - O(high-low)
<br><strong>Space complexity</strong> - O(1)<br>

Here if we actually see the Time complexity (or even on leetcode) the time complexity will be 'O((N+M)∗Log(M))' but below is 
the explanation we can give for O(high-low).

Here the actual time complexity is 'O((N+M)∗Log(M))' but the dominant term is O(high-low). 
Let's clarify why the dominant term remains O(high - low) in this specific context and why we can often treat the digit-related operations as constant.

<u>**Why O(high - low) Dominates:**</u>

**Loop Range**: <br>The most significant factor is the inner for loop in countSymmetricIntegers. It iterates from low to high, 
directly proportional to high - low. Any other operations performed within this loop are executed a number of times bounded by this range.

**Digit-Based Operations**:
- getTotalDigits, getSum, and the digit extraction in isSymmetric all depend on the number of digits in the input integer.
- For standard integer types (like 32-bit or 64-bit integers), the number of digits is inherently bounded by a small constant (e.g., 10 for 32-bit integers).
- Therefore, these operations are considered to take constant time, independent of the size of high - low.

**Math.pow(10, n/2):**<br>
- While Math.pow can have a logarithmic time complexity in general, the exponent n/2 is also bounded by a small constant (due to the limited number of digits).
- In practice, compilers and hardware often optimize power calculations with small constant exponents into very efficient operations.
- For this reason, we can treat Math.pow(10, n/2) as a constant-time operation in this particular problem.

**Where Logarithmic Complexity Could Arise (But Doesn't Dominate Here)**:<br>
- If the input integers could have an arbitrarily large number of digits (e.g., using BigInteger), then the digit-based operations and Math.pow would indeed have logarithmic time complexities relative to the number of digits.
- However, the problem constraints typically restrict the integers to standard integer types.

**Why your suggestion is good to consider**:<br>
It is good to consider the log(M) factor, where M is the maximum number of digits, but in this case, M is a constant. So log(M) is also a constant. Therefore it does not change the overall time complexity.

**In Conclusion**:<br>
While a very precise analysis might consider logarithmic factors for digit-based operations, the dominant term in this code is still O(high - low) because:

- The loop iterates directly proportional to high - low. 
- The number of digits is bounded by a constant.
- Math.pow with small constant exponents is often optimized.
- Therefore, the overall time complexity remains O(high - low).
