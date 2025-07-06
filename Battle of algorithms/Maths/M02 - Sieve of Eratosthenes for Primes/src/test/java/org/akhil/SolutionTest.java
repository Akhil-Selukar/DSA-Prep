package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test algorithm with n=0")
    void testSieveNZero() {
        assertEquals(0, solution.getPrimeList(0).size());
    }

    @Test
    @DisplayName("Test algorithm with n=1")
    void testSieveNOne() {
        assertEquals(0, solution.getPrimeList(1).size());
    }

    @Test
    @DisplayName("Test algorithm with n=2 (first prime)")
    void testSieveNTwo() {
        List<Integer> primes = solution.getPrimeList(2);
        assertEquals(1, primes.size());
        assertTrue(primes.contains(2));
    }

    @Test
    @DisplayName("Test algorithm with n=10")
    void testSieveNTen() {

        List<Integer> primes = solution.getPrimeList(10);
        assertEquals(4, primes.size());
        assertTrue(primes.containsAll(Arrays.asList(2, 3, 5, 7)));
        assertFalse(primes.contains(1));
        assertFalse(primes.contains(4));
        assertFalse(primes.contains(6));
        assertFalse(primes.contains(8));
        assertFalse(primes.contains(9));
        assertFalse(primes.contains(10));
    }

    @Test
    @DisplayName("Test algorithm with n=30")
    void testSieveNThirty() {

        List<Integer> primes = solution.getPrimeList(30);

        // Expected primes up to 30: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 (10 primes)
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        assertEquals(expectedPrimes.size(), primes.size());
        assertTrue(primes.containsAll(expectedPrimes));

        // Check a few non-primes explicitly
        assertFalse(primes.contains(1));
        assertFalse(primes.contains(4));
        assertFalse(primes.contains(6));
        assertFalse(primes.contains(8));
        assertFalse(primes.contains(9));
        assertFalse(primes.contains(15));
        assertFalse(primes.contains(18));
        assertFalse(primes.contains(25));
        assertFalse(primes.contains(26));
        assertFalse(primes.contains(27));
        assertFalse(primes.contains(28));
        assertFalse(primes.contains(30));
    }

    @Test
    @DisplayName("Test algorithm with a larger limit (e.g., n=100)")
    void testSieveNHundred() {

        List<Integer> primes = solution.getPrimeList(100);

        // Number of primes up to 100 is 25
        assertEquals(25, primes.size());

        // Check a few known primes and composites
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(97)); // Largest prime below 100
        assertFalse(primes.contains(1));
        assertFalse(primes.contains(25));
        assertFalse(primes.contains(26));
        assertFalse(primes.contains(27));
        assertFalse(primes.contains(28));
        assertFalse(primes.contains(30));
        assertFalse(primes.contains(49));
        assertFalse(primes.contains(91));
        assertFalse(primes.contains(99));
    }

    @Test
    @DisplayName("Test algorithm with a negative n (expect IllegalArgumentException)")
    void testSieveNegativeN() {
        assertThrows(IllegalArgumentException.class, () -> solution.getPrimeList(-5),
                "Sieve should throw IllegalArgumentException for negative input.");
    }
}