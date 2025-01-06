### 5 - Longest palindromic substring 

**Question link** - [Link](https://leetcode.com/problems/longest-palindromic-substring/description/)

**Topics** - String, Two pointer

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
Here we are given a string and asked to find the longest palindromic substring in it.<br>
The first point is we need substring means consecutive elements (no skipping).

Here the given string is "babad" so as a bruteforce approach we can start from index 0 and end at index 0 only. So the string 
we will get is "b", which is obviously palindrome. Then we can move end index to 1 hence string to check will be "ba" which 
is not palindrome hence we will skip this string. Next we will move end index to 2 hence string to check will be "bab"
which is palindrome hence we will update the longest palindrome to this string and move end by one and so on. So here we
are checking all end index for 1 start index. Then we will have to move start index by 1 and again check all end index against 
updated start index and so on till start index reaches to end. This is not a good solution.

Rather here palindrome means we know that around center of the palindromic string all left and right elements will be same.
Hence we can consider index i as middle point and shift one place to both the sides and compare the elements, until the elements
are same and we are not out of range in any direction we are getting the palindrome string.

![LC-5 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_5/src/main/resources/image/LC-5%20image-1.jpg)

But here there is an edge case, if we observe carefully all the palindromes we are able to find here are of odd length 
because we are starting with 1 character and adding two characters in each iteration. But what if the longest palindrome 
is of some even length. In that case we will have to start with two index and add 2 characters in each iteration.

![LC-5 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_5/src/main/resources/image/LC-5%20image-2.jpg)