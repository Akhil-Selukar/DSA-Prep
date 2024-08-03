package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFineTarget_TargetAtStart(){
        int[] arr = {1,3,4,6,8,9,12,16,19,23,25};
        int target = 1;

        assertEquals(0, Main.fineTarget(arr, target));
    }

    @Test
    public void testFineTarget_TargetInTheMiddle(){
        int[] arr = {1,3,4,6,8,9,12,16,19,23,25};
        int target = 12;

        assertEquals(6, Main.fineTarget(arr, target));
    }

    @Test
    public void testFineTarget_TargetDoesNotExists(){
        int[] arr = {1,3,4,6,8,9,12,16,19,23,25};
        int target = 5;

        assertEquals(-1, Main.fineTarget(arr, target));
    }
}