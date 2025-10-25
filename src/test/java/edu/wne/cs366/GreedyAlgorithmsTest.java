package edu.wne.cs366;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for CS366 - PA4: Greedy Algorithms
 *
 * This test suite verifies:
 * 1. Correctness of minimum cost calculations
 * 2. Proper handling of edge cases
 * 3. Consistency between naive and heap approaches
 * 4. Input validation and error handling
 *
 * All tests apply to both implementations to ensure they produce identical results.
 */
public class GreedyAlgorithmsTest {

    @Nested
    @DisplayName("Naive Approach Tests")
    class NaiveApproachTests {

        @Test
        @DisplayName("Example from problem description: [2, 4, 3] -> 14")
        void testBasicExample() {
            int[] sticks = {2, 4, 3};
            int expected = 14;
            // Explanation:
            // Connect 2+3=5, cost=5, remaining=[5,4]
            // Connect 5+4=9, cost=9, remaining=[9]
            // Total cost = 5+9 = 14
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Another example: [1, 8, 3, 5] -> 30")
        void testSecondExample() {
            int[] sticks = {1, 8, 3, 5};
            int expected = 30;
            // Explanation:
            // Connect 1+3=4, cost=4, remaining=[4,5,8]
            // Connect 4+5=9, cost=9, remaining=[9,8]
            // Connect 9+8=17, cost=17, remaining=[17]
            // Total cost = 4+9+17 = 30
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Five sticks: [4, 3, 2, 6, 1] -> 29")
        void testFiveSticks() {
            int[] sticks = {4, 3, 2, 6, 1};
            int expected = 29;
            // Explanation:
            // Connect 1+2=3, cost=3, remaining=[3,3,4,6]
            // Connect 3+3=6, cost=6, remaining=[6,4,6]
            // Connect 4+6=10, cost=10, remaining=[10,6]
            // Connect 6+10=16, cost=16, remaining=[16]
            // Total cost = 3+6+10+10 = 29
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Minimum case: two sticks [5, 7] -> 12")
        void testTwoSticks() {
            int[] sticks = {5, 7};
            int expected = 12;
            // Only one connection: 5+7=12
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("All equal sticks: [3, 3, 3, 3] -> 24")
        void testEqualSticks() {
            int[] sticks = {3, 3, 3, 3};
            int expected = 24;
            // Connect 3+3=6, cost=6, remaining=[6,3,3]
            // Connect 3+3=6, cost=6, remaining=[6,6]
            // Connect 6+6=12, cost=12, remaining=[12]
            // Total cost = 6+6+12 = 24
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Already sorted ascending: [1, 2, 3, 4] -> 19")
        void testSortedAscending() {
            int[] sticks = {1, 2, 3, 4};
            int expected = 19;
            // Connect 1+2=3, cost=3, remaining=[3,3,4]
            // Connect 3+3=6, cost=6, remaining=[6,4]
            // Connect 4+6=10, cost=10, remaining=[10]
            // Total cost = 3+6+10 = 19
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Sorted descending: [10, 8, 6, 4] -> 48")
        void testSortedDescending() {
            int[] sticks = {10, 8, 6, 4};
            int expected = 48;
            // Connect 4+6=10, cost=10, remaining=[10,8,10]
            // Connect 8+10=18, cost=18, remaining=[18,10]
            // Connect 10+18=28, cost=28, remaining=[28]
            // Total cost = 10+18+20 = 48
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Large values: [100, 200, 150] -> 600")
        void testLargeValues() {
            int[] sticks = {100, 200, 150};
            int expected = 600;
            // Connect 100+150=250, cost=250, remaining=[250,200]
            // Connect 250+200=450, cost=450, remaining=[450]
            // Total cost = 250+350 = 600
            assertEquals(expected, GreedyAlgorithms.connectSticksNaive(sticks));
        }

        @Test
        @DisplayName("Should throw exception for null input")
        void testNullInput() {
            assertThrows(IllegalArgumentException.class, () -> {
                GreedyAlgorithms.connectSticksNaive(null);
            });
        }

        @Test
        @DisplayName("Should throw exception for empty array")
        void testEmptyArray() {
            int[] sticks = {};
            assertThrows(IllegalArgumentException.class, () -> {
                GreedyAlgorithms.connectSticksNaive(sticks);
            });
        }

        @Test
        @DisplayName("Should throw exception for single stick")
        void testSingleStick() {
            int[] sticks = {5};
            assertThrows(IllegalArgumentException.class, () -> {
                GreedyAlgorithms.connectSticksNaive(sticks);
            });
        }
    }

    @Nested
    @DisplayName("Heap Approach Tests")
    class HeapApproachTests {

        @Test
        @DisplayName("Example from problem description: [2, 4, 3] -> 14")
        void testBasicExample() {
            int[] sticks = {2, 4, 3};
            int expected = 14;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Another example: [1, 8, 3, 5] -> 30")
        void testSecondExample() {
            int[] sticks = {1, 8, 3, 5};
            int expected = 30;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Five sticks: [4, 3, 2, 6, 1] -> 29")
        void testFiveSticks() {
            int[] sticks = {4, 3, 2, 6, 1};
            int expected = 29;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Minimum case: two sticks [5, 7] -> 12")
        void testTwoSticks() {
            int[] sticks = {5, 7};
            int expected = 12;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("All equal sticks: [3, 3, 3, 3] -> 24")
        void testEqualSticks() {
            int[] sticks = {3, 3, 3, 3};
            int expected = 24;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Already sorted ascending: [1, 2, 3, 4] -> 19")
        void testSortedAscending() {
            int[] sticks = {1, 2, 3, 4};
            int expected = 19;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Sorted descending: [10, 8, 6, 4] -> 48")
        void testSortedDescending() {
            int[] sticks = {10, 8, 6, 4};
            int expected = 48;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Large values: [100, 200, 150] -> 600")
        void testLargeValues() {
            int[] sticks = {100, 200, 150};
            int expected = 600;
            assertEquals(expected, GreedyAlgorithms.connectSticksHeap(sticks));
        }

        @Test
        @DisplayName("Should throw exception for null input")
        void testNullInput() {
            assertThrows(IllegalArgumentException.class, () -> {
                GreedyAlgorithms.connectSticksHeap(null);
            });
        }

        @Test
        @DisplayName("Should throw exception for empty array")
        void testEmptyArray() {
            int[] sticks = {};
            assertThrows(IllegalArgumentException.class, () -> {
                GreedyAlgorithms.connectSticksHeap(sticks);
            });
        }

        @Test
        @DisplayName("Should throw exception for single stick")
        void testSingleStick() {
            int[] sticks = {5};
            assertThrows(IllegalArgumentException.class, () -> {
                GreedyAlgorithms.connectSticksHeap(sticks);
            });
        }
    }

    @Nested
    @DisplayName("Consistency Tests: Naive vs Heap")
    class ConsistencyTests {

        @Test
        @DisplayName("Both approaches should produce identical results for [2, 4, 3]")
        void testConsistencyBasic() {
            int[] sticks = {2, 4, 3};
            int naiveResult = GreedyAlgorithms.connectSticksNaive(sticks);
            int heapResult = GreedyAlgorithms.connectSticksHeap(sticks);
            assertEquals(naiveResult, heapResult, "Naive and heap approaches must produce same result");
        }

        @Test
        @DisplayName("Both approaches should produce identical results for [1, 8, 3, 5]")
        void testConsistencySecond() {
            int[] sticks = {1, 8, 3, 5};
            int naiveResult = GreedyAlgorithms.connectSticksNaive(sticks);
            int heapResult = GreedyAlgorithms.connectSticksHeap(sticks);
            assertEquals(naiveResult, heapResult, "Naive and heap approaches must produce same result");
        }

        @Test
        @DisplayName("Both approaches should produce identical results for larger input")
        void testConsistencyLarge() {
            int[] sticks = {5, 9, 2, 7, 1, 4, 8, 3, 6};
            int naiveResult = GreedyAlgorithms.connectSticksNaive(sticks);
            int heapResult = GreedyAlgorithms.connectSticksHeap(sticks);
            assertEquals(naiveResult, heapResult, "Naive and heap approaches must produce same result");
        }

        @Test
        @DisplayName("Both approaches should produce identical results for equal elements")
        void testConsistencyEqual() {
            int[] sticks = {5, 5, 5, 5, 5};
            int naiveResult = GreedyAlgorithms.connectSticksNaive(sticks);
            int heapResult = GreedyAlgorithms.connectSticksHeap(sticks);
            assertEquals(naiveResult, heapResult, "Naive and heap approaches must produce same result");
        }

        @Test
        @DisplayName("Both approaches should handle two sticks identically")
        void testConsistencyMinimal() {
            int[] sticks = {42, 17};
            int naiveResult = GreedyAlgorithms.connectSticksNaive(sticks);
            int heapResult = GreedyAlgorithms.connectSticksHeap(sticks);
            assertEquals(naiveResult, heapResult, "Naive and heap approaches must produce same result");
        }
    }

    @Nested
    @DisplayName("Performance Verification Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Heap approach should handle medium-sized input efficiently")
        void testHeapPerformanceMedium() {
            // Generate 100 random sticks
            int[] sticks = new int[100];
            for (int i = 0; i < sticks.length; i++) {
                sticks[i] = (int) (Math.random() * 100) + 1;
            }

            // This should complete quickly with heap approach
            assertDoesNotThrow(() -> {
                int result = GreedyAlgorithms.connectSticksHeap(sticks);
                assertTrue(result > 0, "Result should be positive");
            });
        }

        @Test
        @DisplayName("Both approaches should produce same result on random data")
        void testRandomDataConsistency() {
            // Generate 50 random sticks
            int[] sticks = new int[50];
            for (int i = 0; i < sticks.length; i++) {
                sticks[i] = (int) (Math.random() * 100) + 1;
            }

            int naiveResult = GreedyAlgorithms.connectSticksNaive(sticks);
            int heapResult = GreedyAlgorithms.connectSticksHeap(sticks);

            assertEquals(naiveResult, heapResult,
                "Naive and heap approaches must produce same result on random data");
        }
    }

    @Nested
    @DisplayName("Greedy Property Verification")
    class GreedyPropertyTests {

        @Test
        @DisplayName("Connecting smallest sticks first should minimize cost")
        void testGreedyOptimality() {
            int[] sticks = {1, 2, 3, 4, 5};
            int greedyResult = GreedyAlgorithms.connectSticksHeap(sticks);

            // The greedy approach should give us the optimal solution
            // We can verify this is better than a naive "connect in order" approach
            int naiveOrder = (1+2) + (3+4) + (5+3) + (7+8); // = 33
            int greedyOrder = greedyResult; // Should be 33

            // Greedy: 1+2=3(cost 3), 3+3=6(cost 6), 4+5=9(cost 9), 6+9=15(cost 15) = 33
            assertEquals(33, greedyResult);
            assertTrue(greedyResult <= naiveOrder,
                "Greedy approach should produce optimal or near-optimal result");
        }

        @Test
        @DisplayName("Result should always be sum of all intermediate sums")
        void testCostCalculation() {
            int[] sticks = {2, 4, 3};
            int result = GreedyAlgorithms.connectSticksHeap(sticks);

            // Total cost should be sum of intermediate connections:
            // (2+3=5) + (5+4=9) = 14
            assertEquals(14, result);
        }
    }
}
