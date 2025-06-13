### 357 - Count Numbers with Unique Digits

**Question link** - [Link](https://leetcode.com/problems/count-numbers-with-unique-digits/description/)

**Topics** - Maths

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
If `n = 0` then only 1 number is possible which is 0 itself.<br>
In case of `n = 1` we are looking for single digit numbers so there is no chance of repeating digit hence all 10 numbers (0-9) will be considered in ans.<br>
Now in case of `n = 2` we are checking numbers from 0 to 99 as we know that from 0 to 9 we have 10 unique digit numbers. 
So we have to check only 2 digit numbers. In case of 2 digit numbers 1st digit can be from 1 to 9 (i.e. 9 options) and 
second digit can be from 0 to 9 (i.e. 10 options), but as we dont want repeating digits hence options at second digit reduced 
to 9 (10-1 (the digit at first place)). 

![LC-357 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_357/src/main/resources/images/lc-357%20image-1.jpg)

In case of 3 digit numbers third digit will have options from 0 to 9 except the 2 digits at first and second place (i.e. total 8 choices)
and so on..
so every time choice of digit will reduce by 1 and from 10 digit numbers it will be impossible to form any number without repeating and digit.



