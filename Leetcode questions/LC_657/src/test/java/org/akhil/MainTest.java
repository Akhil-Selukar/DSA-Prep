package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {
    @Test
    public void testJudgeCircle_Test1(){
        String moves = "UD";

        assertTrue(Main.judgeCircle(moves));
    }

    @Test
    public void testJudgeCircle_Test2(){
        String moves = "UDLR";

        assertTrue(Main.judgeCircle(moves));
    }

    @Test
    public void testJudgeCircle_Test3(){
        String moves = "UU";

        assertFalse(Main.judgeCircle(moves));
    }

    @Test
    public void testJudgeCircle_Test4(){
        String moves = "LL";

        assertFalse(Main.judgeCircle(moves));
    }

    @Test
    public void testJudgeCircle_Test5(){
        String moves = "UDLLR";

        assertFalse(Main.judgeCircle(moves));
    }

    @Test
    public void testJudgeCircle_Test6(){
        String moves = "UDDDDDDUUUUURRLRLL";

        assertTrue(Main.judgeCircle(moves));
    }

    @Test
    public void testJudgeCircle1_Test1(){
        String moves = "UD";

        assertTrue(Main.judgeCircle1(moves));
    }

    @Test
    public void testJudgeCircle1_Test2(){
        String moves = "UDLR";

        assertTrue(Main.judgeCircle1(moves));
    }

    @Test
    public void testJudgeCircle1_Test3(){
        String moves = "UU";

        assertFalse(Main.judgeCircle1(moves));
    }

    @Test
    public void testJudgeCircle1_Test4(){
        String moves = "LL";

        assertFalse(Main.judgeCircle1(moves));
    }

    @Test
    public void testJudgeCircle1_Test5(){
        String moves = "UDLLR";

        assertFalse(Main.judgeCircle1(moves));
    }

    @Test
    public void testJudgeCircle1_Test6(){
        String moves = "UDDDDDDUUUUURRLRLL";

        assertTrue(Main.judgeCircle1(moves));
    }

    @Test
    public void testJudgeCircle2_Test1(){
        String moves = "UD";

        assertTrue(Main.judgeCircle2(moves));
    }

    @Test
    public void testJudgeCircle2_Test2(){
        String moves = "UDLR";

        assertTrue(Main.judgeCircle2(moves));
    }

    @Test
    public void testJudgeCircle2_Test3(){
        String moves = "UU";

        assertFalse(Main.judgeCircle2(moves));
    }

    @Test
    public void testJudgeCircle2_Test4(){
        String moves = "LL";

        assertFalse(Main.judgeCircle2(moves));
    }

    @Test
    public void testJudgeCircle2_Test5(){
        String moves = "UDLLR";

        assertFalse(Main.judgeCircle2(moves));
    }

    @Test
    public void testJudgeCircle2_Test6(){
        String moves = "UDDDDDDUUUUURRLRLL";

        assertTrue(Main.judgeCircle2(moves));
    }
}