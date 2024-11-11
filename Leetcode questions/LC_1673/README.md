### 1673 - Find the most competitive subsequence

**Question link** - [Link](https://leetcode.com/problems/find-the-most-competitive-subsequence/description/)

**Topics** - String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here to get the solution we need to find the smallest element first then after that we need next smallest adjacent to the
previous and so on till K elements. So to store the smallest then second smallest and so on we need a stack (in stack we will
keep the smallest element at the bottom, second smallest on top of it and third smallest on top of second and so on). Then 
at the end we will fetch the elements in reverse order and add them in an array of length K.<br>
While storing the elements in stack we need to ensure that at any point in time there must not be more tha K elements in 
the stack.

In above approach there can be an edge case where last element in given array is the smallest one, in that case it will
empty the entire stack, and we will not have K elements in the stack. (At the end we need to ensure that the stack must have 
K elements not more not less).<br>
So here one solution which one can think of is to not pop out elements from stack if value of i is greater than or equal to
total number of elements yet to check. But in this case there can be such scenario where K is 3, and we have 3 elements in
stack but the actual 3rd minimum is at last or second last index. In that case even though that should have been the 3rd 
element in answer but as we are not popping the element and adding the new min in stack (in short not checking for last K-1 elements)
our answer will be wrong.<br>

So the correct thinking here is we will keep popping till `number of elements yet to check > available spaces in stack`
<br>

Number of elements yet to check = nums.length-i<br>

Available spaces in stack = k-stack.size()<br>

Hence, our condition will be `nums.length - i > k-stack.size();` 


