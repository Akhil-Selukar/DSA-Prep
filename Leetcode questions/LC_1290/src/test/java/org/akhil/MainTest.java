package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testGetDecimalValue_Test1(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(0);

        assertEquals(2, cll.getDecimalValue());
    }

    @Test
    public void testGetDecimalValue_Test2(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(1);

        assertEquals(3, cll.getDecimalValue());
    }

    @Test
    public void testGetDecimalValue_Test3(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(0);
        cll.addElementAtEnd(0);

        assertEquals(4, cll.getDecimalValue());
    }

    @Test
    public void testGetDecimalValue_Test4(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(0);

        assertEquals(6, cll.getDecimalValue());
    }

    @Test
    public void testGetDecimalValue_Test5(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(1);

        assertEquals(7, cll.getDecimalValue());
    }

    @Test
    public void testGetDecimalValue_Test6(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(0);
        cll.addElementAtEnd(1);

        assertEquals(5, cll.getDecimalValue());
    }

    @Test
    public void testGetDecimalValue_Test7(){
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(0);
        cll.addElementAtEnd(0);
        cll.addElementAtEnd(0);

        assertEquals(8, cll.getDecimalValue());
    }
}