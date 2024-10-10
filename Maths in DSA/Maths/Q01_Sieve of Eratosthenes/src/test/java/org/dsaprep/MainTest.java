package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSieveOfEratosthenes_Test1(){
        int n = 20;
        boolean[] arr = new boolean[n+1];

        Main.sieveOfEratosthenes(arr, n);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            if(!arr[i]){
                sb.append(i+" ");
            }
        }
        String ans = sb.toString();

        assertEquals("2 3 5 7 11 13 17 19 ", ans);
    }

    @Test
    public void testSieveOfEratosthenes_Test2(){
        int n = 10;
        boolean[] arr = new boolean[n+1];

        Main.sieveOfEratosthenes(arr, n);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            if(!arr[i]){
                sb.append(i+" ");
            }
        }
        String ans = sb.toString();

        assertEquals("2 3 5 7 ", ans);
    }

    @Test
    public void testSieveOfEratosthenes_Test3(){
        int n = 13;
        boolean[] arr = new boolean[n+1];

        Main.sieveOfEratosthenes(arr, n);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            if(!arr[i]){
                sb.append(i+" ");
            }
        }
        String ans = sb.toString();

        assertEquals("2 3 5 7 11 13 ", ans);
    }

    @Test
    public void testSieveOfEratosthenes_Test4(){
        int n = 40;
        boolean[] arr = new boolean[n+1];

        Main.sieveOfEratosthenes(arr, n);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            if(!arr[i]){
                sb.append(i+" ");
            }
        }
        String ans = sb.toString();

        assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 ", ans);
    }
}