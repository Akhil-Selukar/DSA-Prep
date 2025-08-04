package org.akhil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testBasicMatch() {
        String text = "ababa";
        String pattern = "aba";
        assertEquals(0, solution.search(text, pattern));
    }

    @Test
    void testNoMatch() {
        String text = "hello";
        String pattern = "world";
        assertEquals(-1, solution.search(text, pattern));
    }

    @Test
    void testMatchAtBeginning() {
        String text = "abcde";
        String pattern = "abc";
        assertEquals(0, solution.search(text, pattern));
    }

    @Test
    void testMatchAtEnd() {
        String text = "abcde";
        String pattern = "cde";
        assertEquals(2, solution.search(text, pattern));
    }

    @Test
    void testPatternEqualsText() {
        String text = "pattern";
        String pattern = "pattern";
        assertEquals(0, solution.search(text, pattern));
    }

    @Test
    void testPatternLongerThanText() {
        String text = "abc";
        String pattern = "abcd";
        assertEquals(-1, solution.search(text, pattern));
    }

    @Test
    void testSingleCharacterMatch() {
        String text = "a";
        String pattern = "a";
        assertEquals(0, solution.search(text, pattern));
    }

    @Test
    void testSingleCharacterNoMatch() {
        String text = "a";
        String pattern = "b";
        assertEquals(-1, solution.search(text, pattern));
    }

    @Test
    void testMultipleOccurrencesReturnsFirst() {
        String text = "abababa";
        String pattern = "aba";
        assertEquals(0, solution.search(text, pattern));
    }

    @Test
    void testNoMatchWithSimilarCharacters() {
        String text = "aaaa";
        String pattern = "aaab";
        assertEquals(-1, solution.search(text, pattern));
    }

    @Test
    void testWithDifferentCharacterSet() {
        String text = "The quick brown fox jumps over the lazy dog";
        String pattern = "quick";
        assertEquals(4, solution.search(text, pattern));
    }

    @Test
    void testWithEmptyPattern() {
        String text = "abcde";
        String pattern = "";
        // Depending on implementation, an empty pattern may return 0 or throw an exception.
        // Assuming it's a valid match at index 0.
        assertEquals(0, solution.search(text, pattern));
    }

    @Test
    void testWithEmptyText() {
        String text = "";
        String pattern = "a";
        assertEquals(-1, solution.search(text, pattern));
    }

    @Test
    void testWithEmptyTextAndPattern() {
        String text = "";
        String pattern = "";
        // A common convention is that an empty string is a substring of an empty string at index 0.
        assertEquals(0, solution.search(text, pattern));
    }
}