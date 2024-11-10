### Reverse first k numbers from a queue

**Question link** - [Link](https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1)

**Topics** - Queue, stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we want to reverse only first k elements from queue. And as queue works on FIFO principle we know that we can pop out 
first elements from queue. So now the next task is to reverse the numbers. Here we know that stack works on LIFO principle
hence what we insert in queue first will become last while popping out. This is what we can use here. We will pop the first 
element from queue and push it in a stack, repeat this operation K times so first K elements will be in stack. Now while
popping out elements from stack first element to pop out will be the K<sup>th</sum> element in queue, so the first K elements will
be reversed, and we can add this reversed element back to queue. But now the elements will be added at the back of the queue
Hence to correct the order we can pop and push back the remaining (N-K) elements from queue so they will be re inserted in 
the queue at the end with same order.
