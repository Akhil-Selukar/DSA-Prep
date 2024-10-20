package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElement(1);
        cll.addElement(2);
        cll.addElement(4);
        cll.addElement(5);
        cll.addElement(8);
        cll.addElement(8);

        CustomLinkedList cll1 = new CustomLinkedList();
        cll1.addElement(3);
        cll1.addElement(3);
        cll1.addElement(6);
        cll1.addElement(7);

        cll.display();
        System.out.println();
        cll1.display();

        CustomLinkedList ans = CustomLinkedList.merge(cll, cll1);
        ans.display();
    }
}