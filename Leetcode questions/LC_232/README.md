### 232 - Implement queue using stacks

**Question link** - [Link](https://leetcode.com/problems/implement-queue-using-stacks/description/)

**Topics** - Stack and Queue

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we have asked to implement queue which is FIFO using stacks which is FILO. Another thing given here is we can use 2
stacks, and we have to implement push, pop, peek and empty functionalities of queue. 

If we think about the push part, then in queue we add/push the new element at the end of queue. Similarly, in stack as well 
we add the element at the end only. So overall push functionality is same. We just have to add the element on top of stack 
same will act as queue as well.

If we think about pop functionality, here we have an issue because in stack the pop return last added element or element on 
top of the stack. But in queue, pop returns the first element which was added in the queue first. So this is the place where
we need the second stack as a helper.<br>
Here to pop out the first inserted element from stack we somehow need to reverse the entire stack so that the first added 
element will be on top of the stack. This we can achieve by popping all the elements from first stack and adding them into 
second stack till first stack is empty. By doing this we will reverse the entire stack. Now from this reversed stack we can 
pop out the top element and then again return all the elements in first stack to restore the order.
Have a look at below image for better understanding.

![LC-232 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_232/src/images/LC-232%20image-1.jpg)

Same approach we can use for peek as well, instead of removing the element from top of second/helper stack we will peek the 
element.

Empty functionality is simple we can just check if the main stack i.e. first stack is empty or not if it is empty then that 
means the queue is also empty.

> Very important thing to note here is the insertion of element or add() will have constant time complexity i.e. O(1) but if 
> we check for pop() the time complexity will be O(N), as we have to traverse through all the elements and move them between 
> stacks.
> 
> In interview, interviewer may ask you to make pop() operation efficient. So in that case push will take O(N) time complexity
> as in this question only one operation can be time efficient because for another operation we will have to reverse the stack.
> 
> So queue implemented using stack can either be push efficient or pop efficient but not both.

In case of pop efficient implementation. While inserting the element in stack instead of inserting the element at the end 
insert the element at the bottom. This can be achieved by first shifting all the element to helper stack, then adding the 
required element in first stack and then again moving back the element from helper stack to first stack.