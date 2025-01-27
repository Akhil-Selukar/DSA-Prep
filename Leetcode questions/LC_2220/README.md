### 2220 - Minimum bit flips to convert the number

**Question link** - [Link](https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/)

**Topics** - Bit manipulation

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

Here we need to identify number of bits need to flip to make both numbers equal. Which means number of different bits. 
So somehow if we are able to count number of different bits we will get the answer. We know that if two bits are different 
then only XOR gives 1. Hence if we perform XOR operation of two numbers then the resultant number will 1 at the places where 
original two numbers differ. Then we can simply count the number of 1's in XOR result and return as answer.
