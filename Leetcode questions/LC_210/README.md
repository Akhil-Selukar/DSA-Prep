### 210 - Course schedule II

**Question link** - [Link](https://leetcode.com/problems/course-schedule-ii/)

**Topics** - Graph, Topological sort, Kahn's Algorithm

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This question is an extension to the question [207 - Course schedule I](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_207)
In question 207 we had to find only if all courses can be completed or not, here we have to find if yes then the order in 
which the courses can be completed. This is nothing but the classic topological sort. We have to have prerequisites completed 
before taking the new course and details of prerequisites are given in the problem. We need to find the order of courses
such that for any course A, it's prerequisite B must be present before A in the order. (which is nothing but topological 
sorted order) 
