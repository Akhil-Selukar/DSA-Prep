### 621 - Task Scheduler

**Question link** - [Link](https://leetcode.com/problems/task-scheduler/description/)

**Topics** - Arrays

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
Schedule task with highest frequency first, then second highest, then third and so on. (for this we can use priority queue)<br>
once a task is schedule we can remove it from priority queue temporarily.
