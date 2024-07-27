package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSumZero_Test1(){
        int n = 5;
        int[] ans = Main.sumZero(n);
        int size = ans.length;
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += ans[i];
        }

        assertEquals(n, size);
        assertEquals(0, sum);
    }

    @Test
    public void testSumZero_Test2(){
        int n = 1;
        int[] ans = Main.sumZero(n);
        int size = ans.length;
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += ans[i];
        }

        assertEquals(n, size);
        assertEquals(0, sum);
    }

    @Test
    public void testSumZero_Test3(){
        int n = 6;
        int[] ans = Main.sumZero(n);
        int size = ans.length;
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += ans[i];
        }

        assertEquals(n, size);
        assertEquals(0, sum);
    }
}