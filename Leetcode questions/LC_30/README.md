### 30 - Substring with Concatenation of All Words

**Question link** - [Link](https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/)

**Topics** - String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here important point to focus are -
1. All words in `words` array are of same length. (This is the hint for sliding window type of pattern)
2. From example 2 we can see that words array can have same word multiple times (This is the hint to use HashMap and count of words).


From first point we can conclude that if length of words array is `n` and length of the word in it is `m`. Then substring which 
we are looking for in `s` will be of length `n*m`. So we can use a window of `n*m` length in string `s` and check for all words of 
length m in it. if all the words from given array are present in that substring then starting index of the substring will be added 
in result.