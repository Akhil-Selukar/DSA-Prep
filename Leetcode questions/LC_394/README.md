### 394 - Decode string

**Question link** - [Link](https://leetcode.com/problems/decode-string/description/)

**Topics** - String,Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the important test case is the second one, by this test case we are clear that if there are nested brackets then we 
have to resolve the inner bracket and then do the repetition for outer bracket. This will repeat the inner repetition outer times.<br>
So here it is clear that we have to check for nested brackets as well and then only start the repetition, for this we will
need to traverse through the entire string. So unless we traverse through the entire string we need to hold the digits and 
brackets somewhere and hence we can think of stack here.<br>
Now we need to store the number of times we want to repeat and the string after which we want to append the inner repetition.
Hence, we will need two stacks here. We can traverse and keep on adding the number and string in stacks till we get any closing ']'
once we get the closing bracket then we can repeat the string inside the closing ']' and last opening '[' bracket. Number of
repetitions can be decided by the number we have stored in stack.
