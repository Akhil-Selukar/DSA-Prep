### 876 - Middle of the linkedlist

**Question link** - [Link](https://leetcode.com/problems/middle-of-the-linked-list/description/)

**Topics** - LinkedList, fast and slow pointer

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here it is given that the LinkedList is singly LinkedList so there will not be any cycle in it.<br>
Now to find the middle we can simply traverse through the LinkedList till the end (i.e. node.next == null) and then as we know
the length we can get middle node by using length/2 (traverse again from start till length/2). But the problem with this 
approach is that we are traversing through the LinkedList two times. What if we can find the middle node just by traversing
only once?<br>
This is also possible, as we already know that in fast and slow pointer method fast pointer move 2 nodes at a time while 
slow pointer move 1 node at a time (i.e. fast pointer is twice as fast as slow pointer). So when fast pointer is at the end
of the LinkedList the slow pointer must be at the middle. Hence, we can use fast and slow pointer and traverse through the 
LinkedList only once till fast pointer reaches the end and when it does we can return the node at which slow pointer is. 

Note: It requires a lot of boilerplate code to simulate this question on local hence below is the solution, you can try 
leetcode.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
```