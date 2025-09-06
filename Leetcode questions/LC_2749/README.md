### 2749 - Minimum Operations to Make the Integer Zero

**Question link** - [Link](https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/description/)

**Topics** - Maths, Bit count

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
[LC-2749 image-01](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_2749/src/main/resources/images/img.png)

Here the equation `num1 - n*num2 = x` is the important equation.<br>
we know value for `num1` and `num2` we need to find some value for `n` such that x can be represented in at least `n` powers of 2.
So we can try different values for `n` till either we find the answer or the condition goes invalid i.e. we get -ve value.

Now the next challenge is how to identify that x can be represented in at least n powers of 2 or not?
<br> Consider `x = 5` we can write in the form of 2's power as 2<sup>2</sup> + 2<sup>1</sup>, so we 5 can be represented on 2 powers of 2.
Similarly, if we consider x = 11 then it can be represented as 2<sup>3</sup> + 2<sup>1</sup> + 2<sup>0</sup> (i.e. 3 powers of 2).

On some examples it is very obvious that we are converting x to binary. And number of powers of 2 are nothing but the number of
set bits in binary form of x.
