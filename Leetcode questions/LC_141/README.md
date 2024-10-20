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
<hr>

### Find length of the cycle
The followup question to cycle detection can be to find the length of the cycle. For example consider below LinkedList 
which has cycle in it.

![Cycle detection-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Custom%20linkedlist/images/Cycle%20detection-1.jpg)

In above image we can see that the cycle starts from 3rd element (i.e. 9) and it has total 5 elements in it.
Hence, if we use above slow-fast pointer method, at some element in cycle both slow and fast pointer will meet and it will 
confirm us the presence of cycle.<br>
Let's assume that two pointer meet at element 4 as show in below image.

![Cycle detection-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Custom%20linkedlist/images/Cycle%20detection-2.jpg)

Now our task is to calculate the length of the cycle.<br>
As we already know that the pointers will now keep on looping in the cycle as there is no tail with null value for this LinkedList.
So we can keep fast pointer at the same place and move slow pointer till it reaches back to the fast pointer. At that instance 
slow pointer must have visited all the elements in the cycle hence if we calculate the number of iterations slow pointer took
to reach back to halted fast pointer, that number of iterations will be the count of nodes present in the cycle (i.e. length of cycle)

![Cycle detection-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Custom%20linkedlist/images/Cycle%20detection-3.jpg)

Below code will return the length of cycle.

```java
public int lengthOfCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(fastPointer == slowPointer){
                // cycle present hence calculate the length here
                int length = 0;
                do{
                    slowPointer = slowPointer.next;
                    length++;
                } while(slowPointer != fastPointer);
                return length;
            }
        }

        return 0;  // cycle not present hence length of cycle is 0
    }
```