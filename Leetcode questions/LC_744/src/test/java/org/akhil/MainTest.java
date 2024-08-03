package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testNextGreatestLetter_WholeArrayIsGreater(){
        char[] letters = {'c','f','j'};
        char target = 'a';

        assertEquals('c', Main.nextGreatestLetter(letters, target));
    }

    @Test
    public void testNextGreatestLetter_WholeArrayIsSmallerThanTarget(){
        char[] letters = {'c','f','j'};
        char target = 'l';

        assertEquals('c', Main.nextGreatestLetter(letters, target));
    }

    @Test
    public void testNextGreatestLetter_TargetIsFirstElement(){
        char[] letters = {'c','f','j'};
        char target = 'c';

        assertEquals('f', Main.nextGreatestLetter(letters, target));
    }

    @Test
    public void testNextGreatestLetter_TargetIsLastElement(){
        char[] letters = {'c','f','j'};
        char target = 'j';

        assertEquals('c', Main.nextGreatestLetter(letters, target));
    }

    @Test
    public void testNextGreatestLetter_TargetIsMiddleElement(){
        char[] letters = {'c','f','j'};
        char target = 'f';

        assertEquals('j', Main.nextGreatestLetter(letters, target));
    }
}