### 141 - Linked list cycle

**Question link** - [Link](https://leetcode.com/problems/linked-list-cycle/)

**Topics** - LinkedList, Cycle detection, fastPointer-slowPointer

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this question we are given with a LinkedList and we are asked to identify if there is a cycle present in given LinkedList 
or not. This question can be solved by using fastPointer-slowPointer approach, it is very important and very useful approach 
and helps in many problems where we have to work with cycle in LinkedList.<br>

If there is a cycle present in given LinkedList then the tail of that LinkedList list will not be null and hence if we keep 
on traversing each element with just one single pointer then it will keep on looping over the cycle. This is what we can 
use to identify the cycle.

In fastPointer-slowPointer method we take two pointers and start both of them from head. Then we increment one pointer by 
two places in each iteration (i.e. fastPointer) and another pointer by 1 place (slow pointer). Obviously the fast pointer 
will be ahead of the slow one. So if fast pointer encounter null value then that means there is an end to the given LinkedList
and hence there is no cycle present. But if there is a cycle present then in that case when slow pointer enters the cycle,
fast pointer will eventually catch it during one of the iteration and that will be our concluding condition (i.e. if slowPointer
and fastPointer meet at some point, that means the cycle is present)


As simulation the cycle in LinkedList is difficult and this question was just to introduce the slow-fast pointer method 
below is the code and actual code is not written. (You can run below code in leetcode and check the working.)

```java
public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(fastPointer == slowPointer){
                return true;
            }
        }

        return false;
    }
```