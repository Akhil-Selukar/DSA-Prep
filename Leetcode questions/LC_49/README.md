### 49 - Group anagrams

**Question link** - [Link](https://leetcode.com/problems/group-anagrams/description)

**Topics** - Array, String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in all anagrams of a word the characters will be same. Hence if we sort the characters in all anagrams and create a 
sorted string for each anagram then we will have same String for all anagrams. This is what we will use and against that 
same string we will store list of actual words in a map. At the end we will fetch all lists from map against all keys and 
add them together in another list and return as answer.
