package org.akhil;

import java.util.ArrayList;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtEnd(int value){
        ListNode node = new ListNode(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
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
        System.out.println();
    }

    public int[] nextLargerNodes() {
        ListNode temp = this.head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int[] ansArray = new int[count];
        count = 0;
        ListNode headNode = this.head;
        while(headNode != null){
            temp = headNode.next;
            while(temp != null){
                if(temp.value > headNode.value){
                    ansArray[count] = temp.value;
                    break;
                }
                temp = temp.next;
            }
            count++;
            headNode = headNode.next;
        }
        return ansArray;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
