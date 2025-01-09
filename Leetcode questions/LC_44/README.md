### 44 - Wildcard matching

**Question link** - [Link](https://leetcode.com/problems/wildcard-matching/description/)

**Topics** - Recursion, DP, String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. Here in this question if first testcase is not given then you should ask if we want to match entire strings of some part
if of 'p' is matching with 's' will also be fine (like in 1st test case 'a' is a part of 'aa' but still it is not acceptable).
You can ask if it is allowed or not if not given.

**Intuition** -<br>
Here at first glance this question look simple character by character string comparison and whenever we encounter any `?`
then for that index we can simply skip the comparison and move ahead. But in this approach how can we compare `*`, because 
for `*`, there is no specific length. `*` in pattern can be 0 characters, can be 1 character, can be 2 or can be n characters 
in actual string. Hence we are unaware about how many iterations to skip. Hence here normal looping over strings will not 
work. Consider we have a string of length 4 to check and in pattern we encounter a `*` in that case it might happen that 
`*` takes 0 character from string, or 1 character or 2 or 3 or all 4 as well. Hence we have to check all possibilities here.
Hence we need to think for recursion. 

Now consider below testcase. 

`s = "abcdef"`<br>
`p = "a*d?f"`

Here we can take two pointers p1 and p2 which will start from either 0 or s.length()-1 and p.length()-1 respectively.
and the recursive function f(p1,p2) will match s.charAt(p1) with p.charAt(p2).

![LC-44 image-0](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_44/src/main/resources/images/LC-44%20image-0.jpg)

Now here if the characters in s and p for at place p1 and p2 are matching then we can shrink both ths strings. 
Like in this case `s.charAt(p1)` and `p.charAt(p2)` both are f hence we can say that this is matching and shrink the string 
by 1 character.

![LC-44 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_44/src/main/resources/images/LC-44%20image-1.jpg)

Now in next iteration the for pattern we have `?` that means any character can match with it from s. Hence here as well 
we can directly say that 1 character from s is matching with `?` from p, and again shrink both the strings. Hence this is
also just like above condition hence we can modify our condition and add this case as well.

![LC-44 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_44/src/main/resources/images/LC-44%20image-2.jpg)

Now in next iteration character 'd' and 'd' is matching hence it will again shrink both the strings just like first condition 
above. After that when p1 is 2 and p2 is 1, we have a `*` in pattern and here there can be either 0 matching elements in s
or 1 matching element or 2 or 3, etc. Hence here we will apply recursion and the choices will be like either we will consider 
`*` to be equivalent to 0 character in s or `*` is equivalent to 1 character in s. 
then again for 1 character case it will take same two choices and keep on checking till base case.

![LC-44 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_44/src/main/resources/images/LC-44%20image-3.jpg)

So we got the recursive function, but the base cases need to be figured out. We have to stop when both strings match completely 
and nothing is left to match now. Or if p is over i.e. p2<0 and p1 still has some value then that means the string 
and pattern are not properly matching. Another case can be p1<0 which means string is exhausted but p2 still has some value.
That means pattern has something. Now in this case there can be two possibilities. If all that is left is pattern is just 
couple of `*`s then as a star can take 0 character as well hence we can say it is matching, but if there is anything other
than star even just once then that means it is not matching.

![LC-44 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_44/src/main/resources/images/LC-44%20image-4.jpg)

