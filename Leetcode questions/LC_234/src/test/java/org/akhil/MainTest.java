package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void test_PalindromeLinkedList_Test1(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);

        assertTrue(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test2(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(1);

        assertTrue(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test3(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(1);

        assertTrue(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test4(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(1);

        assertTrue(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test5(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(1);

        assertFalse(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test6(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(1);

        assertTrue(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test7(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(1);

        assertFalse(cll.isPalindrome());
    }

    @Test
    public void test_PalindromeLinkedList_Test8(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);

        assertFalse(cll.isPalindrome());
    }
}