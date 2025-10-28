package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Nested
    @DisplayName("Tests for Greatest Common Divisor (GCD)")
    class GcdTests {

        // --- Tests for int version of GCD ---

        @Test
        @DisplayName("GCD of two positive integers (int)")
        void testGcdPositiveIntegersInt() {
            assertEquals(6, solution.gcd(48, 18));
            assertEquals(1, solution.gcd(17, 23)); // Co-prime numbers
            assertEquals(5, solution.gcd(10, 5));
            assertEquals(27, solution.gcd(27, 81)); // One is a multiple of the other
        }

        @Test
        @DisplayName("GCD with zero (int): GCD(a, 0) = |a|")
        void testGcdWithZeroInt() {
            assertEquals(7, solution.gcd(7, 0));
            assertEquals(7, solution.gcd(0, 7));
            assertEquals(0, solution.gcd(0, 0)); // Conventionally 0
        }

        @Test
        @DisplayName("GCD with one negative integer (int)")
        void testGcdOneNegativeIntegerInt() {
            assertEquals(6, solution.gcd(-48, 18));
            assertEquals(6, solution.gcd(48, -18));
            assertEquals(7, solution.gcd(-7, 0));
            assertEquals(7, solution.gcd(0, -7));
        }

        @Test
        @DisplayName("GCD with both negative integers (int)")
        void testGcdBothNegativeIntegersInt() {
            assertEquals(6, solution.gcd(-48, -18));
            assertEquals(1, solution.gcd(-17, -23));
        }


        // --- Tests for long version of GCD ---

        @Test
        @DisplayName("GCD of two large positive long integers")
        void testGcdLargePositiveLongs() {
            long num1 = 123456789012345L;
            long num2 = 987654321098765L;
            // GCD of these two numbers (found using an external calculator)
            assertEquals(5L, solution.gcd(num1, num2));
            assertEquals(1L, solution.gcd(Long.MAX_VALUE, Long.MAX_VALUE - 1));
        }

        @Test
        @DisplayName("GCD of long with one negative value")
        void testGcdLongOneNegative() {
            assertEquals(5L, solution.gcd(-123456789012345L, 987654321098765L));
        }

        @Test
        @DisplayName("GCD of long with both negative values")
        void testGcdLongBothNegative() {
            assertEquals(5L, solution.gcd(-123456789012345L, -987654321098765L));
        }

        @Test
        @DisplayName("GCD with Long.MIN_VALUE (long)")
        void testGcdLongMinValue() {
            // Math.abs(Long.MIN_VALUE) is still Long.MIN_VALUE due to overflow.
            // The algorithm handles it correctly internally by processing the magnitude.
            assertEquals(4L, solution.gcd(Long.MIN_VALUE, 4L)); // GCD(2^63, 4) = 4
            assertEquals(1L, solution.gcd(Long.MIN_VALUE, 3L)); // GCD(2^63, 3) = 1
            assertEquals(1L, solution.gcd(Long.MIN_VALUE, Long.MAX_VALUE)); // GCD(2^63, 2^63 - 1) = 1
            assertEquals(Math.abs(Long.MIN_VALUE), solution.gcd(Long.MIN_VALUE, 0L)); // Should return 2^63
        }
    }

    @Nested
    @DisplayName("Tests for Least Common Multiple (LCM)")
    class LcmTests {

        // --- Tests for int version of LCM (returns long) ---

        @Test
        @DisplayName("LCM of two positive integers (int inputs, long return)")
        void testLcmPositiveIntegersInt() {
            assertEquals(60L, solution.lcm(12, 10)); // LCM(12, 10) = 60
            assertEquals(21L, solution.lcm(7, 3));   // Coprime
            assertEquals(10L, solution.lcm(5, 10));  // One is a multiple of the other
            assertEquals(1L, solution.lcm(1, 1));
        }

        @Test
        @DisplayName("LCM with zero (int inputs): LCM(a, 0) = 0")
        void testLcmWithZeroInt() {
            assertEquals(0L, solution.lcm(5, 0));
            assertEquals(0L, solution.lcm(0, 5));
            assertEquals(0L, solution.lcm(0, 0));
        }

        @Test
        @DisplayName("LCM with one negative integer (int inputs)")
        void testLcmOneNegativeIntegerInt() {
            assertEquals(60L, solution.lcm(-12, 10));
            assertEquals(60L, solution.lcm(12, -10));
            assertEquals(21L, solution.lcm(-7, 3));
        }

        @Test
        @DisplayName("LCM with both negative integers (int inputs)")
        void testLcmBothNegativeIntegersInt() {
            assertEquals(60L, solution.lcm(-12, -10));
            assertEquals(21L, solution.lcm(-7, -3));
        }

        @Test
        @DisplayName("LCM resulting in a large value (int inputs, long return)")
        void testLcmLargeResultInt() {
            // LCM(200000, 300000) = 600000
            assertEquals(600000L, solution.lcm(200000, 300000));
            // Numbers close to Integer.MAX_VALUE
            // LCM(Integer.MAX_VALUE - 1, Integer.MAX_VALUE) = (Integer.MAX_VALUE - 1) * Integer.MAX_VALUE
            // This result will exceed Integer.MAX_VALUE but fit in long.
            long expectedLcm = (long)(Integer.MAX_VALUE - 1) * Integer.MAX_VALUE;
            assertEquals(expectedLcm, solution.lcm(Integer.MAX_VALUE - 1, Integer.MAX_VALUE));
        }

        // --- Tests for long version of LCM ---

        @Test
        @DisplayName("LCM of two positive long integers")
        void testLcmPositiveLongs() {
            assertEquals(120L, solution.lcm(15L, 24L));
            long num1 = 1_000_000_000L; // 10^9
            long num2 = 1_000_000_001L; // 10^9 + 1 (coprime)
            assertEquals(num1 * num2, solution.lcm(num1, num2)); // Result is 10^18 + 10^9, fits in long
        }

        @Test
        @DisplayName("LCM with zero (long inputs)")
        void testLcmWithZeroLong() {
            assertEquals(0L, solution.lcm(100L, 0L));
            assertEquals(0L, solution.lcm(0L, 100L));
            assertEquals(0L, solution.lcm(0L, 0L));
        }

        @Test
        @DisplayName("LCM with negative long integers")
        void testLcmNegativeLongs() {
            assertEquals(120L, solution.lcm(-15L, 24L));
            assertEquals(120L, solution.lcm(15L, -24L));
            assertEquals(120L, solution.lcm(-15L, -24L));
        }
    }

}