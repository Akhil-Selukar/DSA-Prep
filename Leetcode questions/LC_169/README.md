### 169 - Majority element

**Question link** - [Link](https://leetcode.com/problems/majority-element/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. 

**Intuition** -
Here it is given that there will always be a majority element, and majority element is the element which occurs at-least (n/2) times.
<br>Consider given array is, `[1,5,6,3,5,4,5,5]`.<br>
Now as it is given that there is a majority element present in this array, then if we sort this array then middle of the array 
i.e. (n/2)<sup>th</sup> element will be the majority element. (Because as per definition of majority element it has to be present at
least n/2 times. Hence n/2<sup>th</sup> element will always be majority element after sorting the array.)