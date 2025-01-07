### 1312 - Minimum insertion steps to make a string palindrome

**Question link** - [Link](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/)

**Topics** - String, Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here one thing to note is that we can insert characters at any place (i.e. it need not be continuous insertions only) and 
by doing that we have to make the string as palindrome. So if we take an example of "mbadm", then in this word if we consider 
longest possible palindromic **subsequence** then it will be 'mam'. Now as this is already palindromic hence we only need 
to add some elements to make non-palindromic characters palindromic.

![LC-1312 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1312/src/main/resources/images/LC-1312%20image-1.jpg)

Now here if we want to add corresponding character to make 'b' at index 1 palindromic then we need to add another 'b' at 
last but one place. And similarly we will have to add 1 more character for "d". That means total 2 characters.

![LC-1312 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1312/src/main/resources/images/LC-1312%20image-2.jpg)

Similarly, if we take another example of "bcebacb", the minimum insertions required are 2 only. (No matter what initial 
longest palindromic subsequence we choose).

![LC-1312 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1312/src/main/resources/images/LC-1312%20image-3.jpg)

Here if we carefully observe then we are finding the longest possible palindromic subsequence and then for remaining 
elements we are adding their corresponding elements. Hence in other words the number of insertions are always equal to 
non-palindromic elements present in string. Hence if we find the length of longest palindromic subsequence and subtract it 
from the length of string we will get the required answer. 
