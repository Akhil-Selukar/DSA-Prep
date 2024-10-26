### 234- Palindrome LinkedList

**Question link** - [Link](https://leetcode.com/problems/palindrome-linked-list/description/)

**Topics** - LinkedList, LinkedList reversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here as it is said in question that we have to solve the problem in Space complexity O(1) and Time complexity O(N) so we
can not just reverse the list store it somewhere and then compare the original list with reversed list. So what can we do?

Next thing we can think of is we can start first pointer from start i.e. head and second pointer from end i.e. tail and 
then move first pointer forward and second pointer backward one node at a time and compare the nodes. Here as well we have a 
problem, we can't really move backward as it is said that the LinkedList is a singly LinkedList.

So till now we know below things 
1. We can't move backward
2. We have to check the palindrome list (i.e. the list forward and backward must be same).

Now if we observe all palindrome numbers or lists or words, we will see that the elements after the middle element is just 
the reverse of elements from start till end. (for example in number 123321, numbers after middle i.e. 321 is reverse of 
number from start till middle i.e. 123).

So what we can do here is we can first find the middle of the LinkedList. Then we can reverse the linkedList starting from 
middle node till end. And then we can take two pointers, first from start i.e. head and second from the middle point. Now 
we can go forward with both the pointers and check the elements (Here even though we are moving forward from middle node
but still we are kind of traversing backward from last node as the List is reversed from middle and actual last will be now middle
and actual second last will be now middle+1). If all elements are same then the given List is palindrome.  
