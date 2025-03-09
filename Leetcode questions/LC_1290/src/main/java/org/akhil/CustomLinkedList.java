package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtEnd(int value){
        ListNode node = new ListNode(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    // Solution 1 - O(N)/O(1)
    public int getDecimalValue() {
        reverseList();
        ListNode temp = this.head;
        int decimalValue = 0;
        int power = 0;
        while(temp != null){
            decimalValue = (int) (decimalValue + temp.value*Math.pow(2,power++));
            temp = temp.next;
        }
        return decimalValue;
    }

    private void reverseList() {
        ListNode previousNode = null;
        ListNode currentNode = this.head;
        ListNode nextNode = this.head.next;

        while(currentNode != null){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        this.head = previousNode;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}

// Solution 1 - Using stack O(N)/O(N) - Not that fast.
//public int getDecimalValue(ListNode head) {
//    Stack<Integer> stack = new Stack<>();
//
//    while(head != null){
//        stack.push(head.val);
//        head = head.next;
//    }
//
//    int power = 0;
//    int ans = 0;
//    while(!stack.isEmpty()){
//        ans = ans + (int)(stack.pop()*Math.pow(2, power));
//        power++;
//    }
//
//    return ans;
//}
