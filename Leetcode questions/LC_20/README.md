### 20 - Valid parentheses

**Question link** - [Link](https://leetcode.com/problems/valid-parentheses/description/)

**Topics** - String, Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

Approach 1: (brute force)<br>
As it is mentioned that the closing must happen in same order as that of opening of brackets, then only it is valid.
Hence, for a string to be valid, at the middle of given string for opening bracket (of any type) immediate next there must 
be a closing bracket of the same type. So we can go ahead and remove these pairs and if there is no pair left to remove and 
the string is not empty that means the string is not valid. For example.

given string = {[()]}<br>
at first iteration () will be removed and remaining string will be {[]}<br>
Now in second iteration [] will be removed and the remaining string will be {}<br>
At third iteration {} will be removed and string will be empty. So in next iteration nothing will be removed and as string is 
empty so we can say that the string is valid.

Where-as if given string is {[)()]}<br>
Here in first iteration () will be removed and the string will become {[)]}<br>
In next iteration nothing will be removed and as the string is not empty so we will return false.

<hr>
Approach 1: (Optimized approach)<br>
Here we clearly know that the closing parenthesis will start after the middle character in given string. So to check if all
opening parenthesis are getting closed or not we need to keep track of all opening parenthesis unless we traverse till middle 
character. After that we will start cancelling out each parenthesis. So this is classic use of stack (store the previous elements
and first retrieval will be of most recent element so that we can cancel it out).<br>
We can keep on adding characters in stack till we encounter first closing parenthesis and as soon as we encounter one, we can 
check if its topmost element in stack is the corresponding closing parenthesis or not. If not then we can directly return false
else if stack is empty and everything is cancelled out then we can return true.
