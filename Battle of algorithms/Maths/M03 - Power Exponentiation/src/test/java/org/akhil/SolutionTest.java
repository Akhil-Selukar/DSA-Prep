package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test with exponent 0 (x^0 = 1)")
    void testPowerExponentZero() {
        assertEquals(1L, solution.power(5, 0));
        assertEquals(1L, solution.power(1, 0));
        assertEquals(1L, solution.power(0, 0)); // Conventionally 0^0 = 1
        assertEquals(1L, solution.power(-1, 0));
    }

    @Test
    @DisplayName("Test with exponent 1 (x^1 = x)")
    void testPowerExponentOne() {
        assertEquals(5L, solution.power(5, 1));
        assertEquals(0L, solution.power(0, 1));
        assertEquals(-1L, solution.power(-1, 1));
        assertEquals(100L, solution.power(100, 1));
    }

    @Test
    @DisplayName("Test with positive base and positive exponent")
    void testPowerPositiveBasePositiveExponent() {
        assertEquals(8L, solution.power(2, 3));   // 2^3
        assertEquals(81L, solution.power(3, 4));  // 3^4
        assertEquals(625L, solution.power(5, 4)); // 5^4
        assertEquals(1024L, solution.power(2, 10)); // 2^10
        assertEquals(1L, solution.power(1, 100)); // 1^100
    }

    @Test
    @DisplayName("Test with negative base and even exponent")
    void testPowerNegativeBaseEvenExponent() {
        assertEquals(16L, solution.power(-2, 4));  // (-2)^4
        assertEquals(81L, solution.power(-3, 4));  // (-3)^4
        assertEquals(1L, solution.power(-1, 100)); // (-1)^100
    }

    @Test
    @DisplayName("Test with negative base and odd exponent")
    void testPowerNegativeBaseOddExponent() {
        assertEquals(-8L, solution.power(-2, 3));  // (-2)^3
        assertEquals(-27L, solution.power(-3, 3)); // (-3)^3
        assertEquals(-1L, solution.power(-1, 101)); // (-1)^101
    }

    @Test
    @DisplayName("Test with base 0 and positive exponent (0^y = 0)")
    void testPowerBaseZeroPositiveExponent() {
        assertEquals(0L, solution.power(0, 5));
        assertEquals(0L, solution.power(0, 100));
    }

    @Test
    @DisplayName("Test with large exponent (to check efficiency implicitly)")
    void testPowerLargeExponent() {
        // 2^30 should fit in long
        assertEquals(1073741824L, solution.power(2, 30));
        // 3^20 should fit in long
        assertEquals(3486784401L, solution.power(3, 20));
    }

    @Test
    @DisplayName("Test with negative exponent")
    void testPowerNegativeExponent() {
        assertEquals((int) Math.pow(2, -3), (int) solution.power(2, -3));
    }

    @Test
    @DisplayName("Test with negative max exponent")
    void testPowerNegativeMaxExponent() {
        assertEquals(Math.pow(2, Integer.MIN_VALUE), solution.power(2, Integer.MIN_VALUE));
    }
}