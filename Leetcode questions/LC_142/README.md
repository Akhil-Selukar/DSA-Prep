### 142 - Linked list cycle - 2

**Question link** - [Link](https://leetcode.com/problems/linked-list-cycle-ii/description/)

**Topics** - LinkedList, Cycle detection, fastPointer-slowPointer

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In question [LC_141](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_141) we saw how we can 
identify if there is a cycle present in given LinkedList or not. We also saw how to find the length of the cycle. Both the 
things can be identified by using fast and slow pointer method. In this method fast pointer and slow pointer meets at some point 
in the cycle if cycle is present (It is not necessary that the point they meet is the starting point of the cycle).<br>
In this question we have to find the starting point of the cycle. So we have to ensure that both the point should meet at 
the start of cycle. To do that we can follow below steps.

1. Identify if there is a cycle present or not.
2. If present, then identify the length of cycle. (let's say L)
3. Start two pointers from head (i.e. start) and move one pointer 'L' time ahead. (Keep another pointer at starting position only.)
4. Now from this position move both the pointers one step at a time.
5. The node at which both pointers meet will be the starting point of cycle.

Now Let's see the proof of above steps and how exactly it is working.

Consider you have below LinkedList in which there is a cycle present and the length of cycle (L) is 6.

![LinkedList_cycle_1.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_142/src/main/resources/images/LinkedList_cycle_1.jpg)

Now take two pointers (P1 and P2) and put them both at the start (i.e. head). Consider the number of steps first pointer P1 
need to take to reach the starting point of cycle is 'X' steps. (in this example 4 steps).

![LinkedList_cycle_2.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_142/src/main/resources/images/LinkedList_cycle_2.jpg)

Now we have to put second pointer P2 some steps from the head such that from that position the forward distance of starting 
point of cycle must be 'X' steps (Then only both pointers will meet exactly at the starting point on moving one step at a time.)<br>
So we have to identify that exact number of steps from head where we should place second pointer so that above scenario 
will be true. Let's consider that steps equal to length of cycle (i.e. L).

![LinkedList_cycle_3.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_142/src/main/resources/images/LinkedList_cycle_3.jpg)

As we already know that once a pointer enter the cycle it will keep on looping over and over in the cycle. The second 
pointer P2 is already in the cycle, so there is no way it can traverse through non-cyclic nodes.<br>
Now if we calculate how many steps P2 had already covered from the start of the cycle. It will be very easy. we can simply 
subtract L from X.

![LinkedList_cycle_4.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_142/src/main/resources/images/LinkedList_cycle_4.jpg)

So pointer P2 already covered (L-X) steps in the cycle from starting point. So the remaining steps P2 has to cover to 
complete the cycle is 'Total length of cycle - already covered length'.<br>
We have already calculated the total length of cycle which was L, and just now in above step we have calculated the already 
covered length which is (L-X). So remaining is,<br>

`L-(L-X)` here L is cancelled out and remaining is `X` which is nothing but the distance of first pointer P1 (or head) from 
the starting point of cycle. Hence, now from this position if we move both the pointers one step at a time, they will meet 
at the starting point of the cycle (as both are X steps away from the starting point of cycle).

![LinkedList_cycle_5.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_142/src/main/resources/images/LinkedList_cycle_5.jpg)


Below is the actual code for this question.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // step-1 check if cycle is present or not
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        int length = 0;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                // cycle is present. Now find the length.
                do{
                    slowPointer = slowPointer.next;
                    length++;
                }while(slowPointer != fastPointer);
                break;
            }
        }

        if(length == 0){        // No cycle is present
            return null;
        }

        // Find the starting point of cycle.
        ListNode p1 = head;
        ListNode p2 = head;

        while(length > 0){
            p2 = p2.next;
            length--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
```