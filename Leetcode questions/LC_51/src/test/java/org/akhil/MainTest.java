package org.akhil;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSolveNQueens_Test1(){
        int n=1;

        List<List<String>> ans = Main.solveNQueens(n);

        assertEquals(1, ans.size());
        assertEquals("Q", ans.get(0).get(0));
    }

    @Test
    public void testSolveNQueens_Test2(){
        int n=2;

        List<List<String>> ans = Main.solveNQueens(n);

        assertEquals(0, ans.size());
    }

    @Test
    public void testSolveNQueens_Test3(){
        int n=3;

        List<List<String>> ans = Main.solveNQueens(n);

        assertEquals(0, ans.size());
    }

    @Test
    public void testSolveNQueens_Test4(){
        int n=4;

        List<List<String>> ans = Main.solveNQueens(n);

        assertEquals(2, ans.size());
        assertEquals(".Q..", ans.get(0).get(0));
        assertEquals("...Q", ans.get(0).get(1));
        assertEquals("Q...", ans.get(0).get(2));
        assertEquals("..Q.", ans.get(0).get(3));
        assertEquals("..Q.", ans.get(1).get(0));
        assertEquals("Q...", ans.get(1).get(1));
        assertEquals("...Q", ans.get(1).get(2));
        assertEquals(".Q..", ans.get(1).get(3));
    }

    @Test
    public void testSolveNQueens_Test5(){
        int n=5;

        List<List<String>> ans = Main.solveNQueens(n);

        assertEquals(10, ans.size());
        assertEquals("Q....", ans.get(0).get(0));
        assertEquals("..Q..", ans.get(0).get(1));
        assertEquals("....Q", ans.get(0).get(2));
        assertEquals(".Q...", ans.get(0).get(3));
        assertEquals("...Q.", ans.get(0).get(4));
        assertEquals("Q....", ans.get(1).get(0));
        assertEquals("...Q.", ans.get(1).get(1));
        assertEquals(".Q...", ans.get(1).get(2));
        assertEquals("....Q", ans.get(1).get(3));
        assertEquals("..Q..", ans.get(1).get(4));
        assertEquals(".Q...", ans.get(2).get(0));
        assertEquals("...Q.", ans.get(2).get(1));
        assertEquals("Q....", ans.get(2).get(2));
        assertEquals("..Q..", ans.get(2).get(3));
        assertEquals("....Q", ans.get(2).get(4));
        assertEquals(".Q...", ans.get(3).get(0));
        assertEquals("....Q", ans.get(3).get(1));
        assertEquals("..Q..", ans.get(3).get(2));
        assertEquals("Q....", ans.get(3).get(3));
        assertEquals("...Q.", ans.get(3).get(4));
        assertEquals("..Q..", ans.get(4).get(0));
        assertEquals("Q....", ans.get(4).get(1));
        assertEquals("...Q.", ans.get(4).get(2));
        assertEquals(".Q...", ans.get(4).get(3));
        assertEquals("....Q", ans.get(4).get(4));
        assertEquals("..Q..", ans.get(5).get(0));
        assertEquals("....Q", ans.get(5).get(1));
        assertEquals(".Q...", ans.get(5).get(2));
        assertEquals("...Q.", ans.get(5).get(3));
        assertEquals("Q....", ans.get(5).get(4));
        assertEquals("...Q.", ans.get(6).get(0));
        assertEquals("Q....", ans.get(6).get(1));
        assertEquals("..Q..", ans.get(6).get(2));
        assertEquals("....Q", ans.get(6).get(3));
        assertEquals(".Q...", ans.get(6).get(4));
        assertEquals("...Q.", ans.get(7).get(0));
        assertEquals(".Q...", ans.get(7).get(1));
        assertEquals("....Q", ans.get(7).get(2));
        assertEquals("..Q..", ans.get(7).get(3));
        assertEquals("Q....", ans.get(7).get(4));
        assertEquals("....Q", ans.get(8).get(0));
        assertEquals(".Q...", ans.get(8).get(1));
        assertEquals("...Q.", ans.get(8).get(2));
        assertEquals("Q....", ans.get(8).get(3));
        assertEquals("..Q..", ans.get(8).get(4));
        assertEquals("....Q", ans.get(9).get(0));
        assertEquals("..Q..", ans.get(9).get(1));
        assertEquals("Q....", ans.get(9).get(2));
        assertEquals("...Q.", ans.get(9).get(3));
        assertEquals(".Q...", ans.get(9).get(4));

    }
}