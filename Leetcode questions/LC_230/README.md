### 230 - K<sup>th</sup> smallest element in binary search tree

**Question link** - [Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

**Topics** - String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Simple way we can do this question is, as it is mentioned that the given tree is 'binary search tree' so if we do in-order traversal
and store the elements in an array we will get the sorted array. Then from that array we can get i<sup>th</sup> easily.
This will cover the followup question as well as no matter how many insertion and deletion is happening as it is a binary 
search tree every time in-order traversal tree will give us sorted values. 

One optimization we can do is as we are interested in k<sup>th</sup> smallest element only so instead of storing all sorted 
elements in array we can simply keep a counter and increment it on finding elements, as soon as counter = k return the currrent
element. So extra array is eliminated.

