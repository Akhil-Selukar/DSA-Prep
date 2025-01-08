### 72 - Edit distance

**Question link** - [Link](https://leetcode.com/problems/edit-distance/description/)

**Topics** - String, Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given with two strings S1 and S2, we want to convert S1 into S2. While converting S1 to S2 we can perform only 
insertion, deletion and replace operation (on single character) at a time. We are asked the minimum number of operations
required to change S1 to S2. 

First thing to notice here is that there will always be a minimum number (i.e. if nothing is matching between S1 and S2 
then at worst case we can simply delete all characters from S1 and insert all characters of S2 in empty S1). Now here we 
are asked the minimum number of operations required hence we need to check all possible ways so that we can get the minimum 
one. Hence, we need recursion here. Now to derive base conditions and recursive steps let's consider below example.

S1 = "horse" and S2 = "ros"

Let's start with end of both the strings so `i = S1.length()-1` and `j = S2.length()-1`

![LC-72 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_72/src/main/resources/images/LC-72%20image-1.jpg)

Now if we compare i<sup>th</sup> and j<sup>th</sup> character then there can be two possibilities, either they can be equal
or they can not be equal. If they are equal then we don't need to do anything because we already got the last character of 
S2 (i.e. our target). But if it is not equal then we have three options (insertion, deletion, replace). So we can try all the 
operations. 

Let's consider insertion<br>
Here 'e' is not equal to 's' hence we are trying insertion, that means we are performing an edit hence we will have to add 1
(1 edit have been performed). And as we are inserting the element we will have to insert 's' at the end of S1 so that end 
portion of S2 will get a match at end of S1. That means as last character is matched in S2 so only required matches are 'ro'
from S2 but as we have added new character in S1 so the ith character (Which we were checking, we have not taken any decision 
on it). So our j<sup>th</sup> index will reduce by 1 but i will remain as it is.

![LC-72 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_72/src/main/resources/images/LC-72%20image-2.jpg)

Now next possibility is to delete. That means if the characters at i<sup>th</sup> index in S1 need to be deleted. In that case
S1 will be shrunk and we will have to find entire 'ros' is updated S1. That means here as well we made an edit in S1 and 
hence we will add 1 and shrink the S1 i.e. (i-1).

![LC-72 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_72/src/main/resources/images/LC-72%20image-3.jpg)

Last option that we have is to replace the element. Now if we got the chance to replace then obviously we will replace 'e'
with 's' only because that is what we need. Hence after replace the last element of S1 and S2 are matching hence we will 
have to search for 'ro' in 'hors' i.e. both the strings are shrunk. (similar to the first matching case) just that here 
we did one edit and then it started matching. Hence we will have to add 1. 

![LC-72 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_72/src/main/resources/images/LC-72%20image-4.jpg)

Now we have explored all the possibilities here and whichever possibility will give the minimum number of edits that's our
answer. Hence we need to take the minimum of all 3 i.e. insertion, deletion, replace.

![LC-72 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_72/src/main/resources/images/LC-72%20image-5.jpg)

Above is the recursive part, but we need to stop the recursion at some point (i.e. we need base conditions as well).
Now here base conditions can be either i will become negative (i.e. S1 exhausted) or j will become negative (i.e. S2 
exhausted). In first case if S1 is exhausted then the only option we have to create S2 is add remaining characters from 
S2. And in second case, if S2 is exhausted then that means we already got the required string and hence all the characters
remaining in S1 need to be deleted. (hence number of operations required in first case will be equal to number of char 
left in S2 while, number of operations required in second case are equal to number of char left in S1.)

![LC-72 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_72/src/main/resources/images/LC-72%20image-6.jpg)

Further we can use DP to improve performance of the code.