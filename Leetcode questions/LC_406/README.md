### 406 - Queue Reconstruction by Height

**Question link** - [Link](https://leetcode.com/problems/queue-reconstruction-by-height/description/)

**Topics** - Arrays, Sorting

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
1. Sort people by 'hi' in descending order so that we will get the tallest person first.
2. <u>If height is same for two people</u>, sort them by 'ki' in ascending order as person with height 'x' and ki=0 need to be present first than person with same height 'x' but ki=1.
3. Post sorting if we try to arrange as per given condition in question we can observe we need to place each pair at index pair[1].<br>

For detailed explanation check [this solution](https://leetcode.com/problems/queue-reconstruction-by-height/solutions/2211641/visual-explanation-java-greedy)
