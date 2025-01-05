### 1143 - Longest common subsequence

**Question link** - [Link](https://leetcode.com/problems/longest-common-subsequence/description/)

**Topics** - Recursion, Dp on strings

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in this problem 1 thing to note is we are asked **subsequences** (i.e. if we consider string "abcd" then 'abd' is one 
of the subsequence of given string even though the elements in 'abd' are not consecutive in original string but all elements 
from 'abd' are present in original string and are in same order hence we can say that 'abd' is a subsequence of "abcd").

Now in the question we are given two strings and asked to find the length of longest subsequence which is common for both 
the strings. So here as per bruit force approach we can first find all subsequences of first string, then find all subsequences
of second string and then compare each subsequence of first string with all subsequences of second string and then find the 
longest one and then return the length of it. Which will work but a very long and complex approach. <br>
As we are comparing all possible subsequences of both the strings hence we can use recursion here and find the longest common
in runtime while finding the subsequences only.

Consider given strings are `abc` and `bec`. Then first thing we can do is start from the last index of both the strings and 
compare if they are equal or not. 

![LC-1143 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1143/src/main/resources/images/LC-1143%20image-1.jpg)

If they are equal then that means we have found common subsequence and the length of it 
is 1. Next as in both the string last indexed character is matching and we have considered its length hence we can move 1
index left for both the strings. 

![LC-1143 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1143/src/main/resources/images/LC-1143%20image-2.jpg)

Now the char at P1 (i.e. index 1) of string is not matching with char at P2 (i.e. index 1 of string 2). Hence we can have 
two possibilities here. The char at P1 can be present anywhere left to the P2 in string 2. Also char at P2 in string 2 can 
be present anywhere to the left of P1 in string 1. Hence we will consider both the possibilities and write the recursion 
calls with considering first case and second case. And as we need the longest (i.e. maximum hence we will take the max 
value from the recursive calls.)

![LC-1143 image3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_1143/src/main/resources/images/LC-1143%20image-3.jpg)

Here, in first recursion call to the left where P1 = 0 and P2 = 1. The char `a` is not matching with `e` hence further recursion
will be called but in right side recursion call where P1 = 1 and P2 = 0. We again got the matching char i.e. `b` hence 
we will add 1 to the common subsequence and reduce both P1 ad P2 and then again check for recursion calls.
