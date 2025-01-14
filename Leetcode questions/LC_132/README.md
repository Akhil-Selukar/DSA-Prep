### 132 - Palindrome partitioning II

**Question link** - [Link](https://leetcode.com/problems/palindrome-partitioning-ii/description/)

**Topics** - String, Recursion

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here after reading the question first thing that can popup in our mind is to run a for loop and check if the string from 
0<sup>th</sup> index till i<sup>th</sup> index is palindromic or not if it is palindromic then move ahead or something like this.
But what if the string is something like `abcba` here in first iteration we will check `ab` which is not palindromic hence 
we might add a cut after `a` which is wrong. Because entire string is palindromic. <br>

Hence to solve this kind of problems we need to use front partitioning. First add a partition after first character. As
it is a single character hence it will be palindrome, for remaining string again do front partitioning. In second iteration 
add a cut after second character, now here is the important part. Before moving ahead and checking for remaining string. 
We need to check if this partition is valid or not. Meaning if the left side string of this partition is palindromic or not
if it is then only we can check for remaining string considering this as a valid partition. Otherwise, we can skip checking
for remaining string and move to next partition (i.e. partition after first 3 characters.)

![LC_132 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_132/src/main/resources/images/LC_132%20image-1.jpg)
