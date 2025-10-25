package edu.wne.cs366;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * CS366 - PA4: Greedy Algorithms - Minimum Cost to Connect Sticks
 *
 * This assignment explores the greedy algorithm paradigm through the "Minimum Cost to Connect Sticks" problem.
 * Students will implement both a naive O(n²) approach and an optimized O(n log n) heap-based approach,
 * demonstrating how proper data structure selection dramatically improves algorithmic efficiency.
 *
 * Problem: You have n sticks of varying lengths. The cost to connect two sticks is the sum of their lengths.
 * Connect all sticks into one stick with minimum total cost.
 *
 * Example: sticks = [2, 4, 3]
 * - Connect 2 and 3 → cost = 5, remaining = [5, 4]
 * - Connect 5 and 4 → cost = 9, remaining = [9]
 * - Total cost = 5 + 9 = 14
 *
 * @author [Student Name]
 * @date Due: November 6, 2025
 */
public class GreedyAlgorithms {

    /**
     * Calculate minimum cost to connect all sticks using a NAIVE approach with unsorted list.
     *
     * Greedy Strategy: Always combine the two smallest sticks first.
     *
     * Implementation Approach:
     * - Store sticks in an ArrayList (unsorted)
     * - Each iteration: find two minimum elements (O(n))
     * - Remove them, add their sum back to list
     * - Repeat until one stick remains
     *
     * Time Complexity: O(n²)
     * - n-1 iterations (combining n sticks into 1)
     * - Each iteration: O(n) to find two minimums + O(n) to remove elements
     * - Total: O(n) × O(n) = O(n²)
     *
     * Space Complexity: O(n) for the list
     *
     * @param sticks array of stick lengths
     * @return minimum total cost to connect all sticks
     * @throws IllegalArgumentException if sticks array is null or has less than 2 elements
     */
    public static int connectSticksNaive(int[] sticks) {
        // 1. Validate input
        if (sticks == null) {
            throw new IllegalArgumentException("Sticks array cannot be null");
        }
        if (sticks.length < 2) {
            throw new IllegalArgumentException("Need at least 2 sticks to connect");
        }

        // 2. Copy sticks to ArrayList for dynamic removal
        List<Integer> stickList = new ArrayList<>();
        for (int stick : sticks) {
            stickList.add(stick);
        }

        int totalCost = 0;

        // 3. Loop while more than 1 stick remains
        while (stickList.size() > 1) {
            // a. Find index of first minimum
            int firstMinIdx = 0;
            for (int i = 1; i < stickList.size(); i++) {
                if (stickList.get(i) < stickList.get(firstMinIdx)) {
                    firstMinIdx = i;
                }
            }

            // b. Find index of second minimum (excluding first)
            int secondMinIdx = (firstMinIdx == 0) ? 1 : 0;
            for (int i = 0; i < stickList.size(); i++) {
                if (i != firstMinIdx) {
                    if (stickList.get(i) < stickList.get(secondMinIdx)) {
                        secondMinIdx = i;
                    }
                }
            }

            // c. Calculate cost (sum of two minimums)
            int firstMin = stickList.get(firstMinIdx);
            int secondMin = stickList.get(secondMinIdx);
            int cost = firstMin + secondMin;

            // d. Remove the two sticks (remove larger index first to avoid index shifting issues!)
            int largerIdx = Math.max(firstMinIdx, secondMinIdx);
            int smallerIdx = Math.min(firstMinIdx, secondMinIdx);
            stickList.remove(largerIdx);
            stickList.remove(smallerIdx);

            // e. Add their sum back to the list
            stickList.add(cost);

            // f. Add cost to total
            totalCost += cost;
        }

        // 4. Return total cost
        return totalCost;
    }

    /**
     * Calculate minimum cost to connect all sticks using HEAP-OPTIMIZED approach.
     *
     * Greedy Strategy: Always combine the two smallest sticks first.
     *
     * Implementation Approach:
     * - Use Java's PriorityQueue (min-heap) to efficiently maintain smallest elements
     * - Build heap from input: O(n)
     * - Each iteration: 2 extractions + 1 insertion = O(log n)
     * - Repeat until one stick remains
     *
     * Time Complexity: O(n log n)
     * - Build heap: O(n)
     * - n-1 iterations (combining n sticks into 1)
     * - Each iteration: O(log n) for heap operations
     * - Total: O(n) + O(n log n) = O(n log n)
     *
     * Space Complexity: O(n) for the heap
     *
     * Why is heap faster than naive?
     * - Naive: Finding minimum in unsorted list = O(n), done n times = O(n²)
     * - Heap: Extracting minimum from heap = O(log n), done n times = O(n log n)
     * - The "extra work" of maintaining heap invariants (O(log n) per operation)
     *   is MUCH less than scanning entire unsorted list (O(n) per operation)
     * - This is the same principle as Dijkstra's with heap vs without!
     *
     * Why not just sort once (also O(n log n))?
     * - After combining sticks, result must be reinserted into sorted order
     * - Inserting into sorted array (ArrayList) requires O(n) shift operations
     * - Total: O(n log n) sort + n × O(n) insertions = O(n²) - no better than naive!
     * - Heap maintains "partial order" - just enough structure to find minimums efficiently
     * - We don't need full sorted order, just access to smallest elements
     *
     * @param sticks array of stick lengths
     * @return minimum total cost to connect all sticks
     * @throws IllegalArgumentException if sticks array is null or has less than 2 elements
     */
    public static int connectSticksHeap(int[] sticks) {
        // 1. Validate input
        if (sticks == null) {
            throw new IllegalArgumentException("Sticks array cannot be null");
        }
        if (sticks.length < 2) {
            throw new IllegalArgumentException("Need at least 2 sticks to connect");
        }

        // 2. Create PriorityQueue<Integer> (min-heap by default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 3. Add all sticks to the heap
        for (int stick : sticks) {
            minHeap.offer(stick);
        }

        int totalCost = 0;

        // 4. Loop while heap size > 1
        while (minHeap.size() > 1) {
            // a. Extract first minimum (poll())
            int firstMin = minHeap.poll();

            // b. Extract second minimum (poll())
            int secondMin = minHeap.poll();

            // c. Calculate cost (sum of two minimums)
            int cost = firstMin + secondMin;

            // d. Add their sum back to heap (offer())
            minHeap.offer(cost);

            // e. Add cost to total
            totalCost += cost;
        }

        // 5. Return total cost
        return totalCost;
    }

    /**
     * Compare the performance of naive vs heap approaches empirically.
     *
     * This method runs both implementations on the same input and measures their execution times,
     * demonstrating the practical difference between O(n²) and O(n log n) complexity.
     *
     * @param sticks array of stick lengths
     */
    public static void compareApproaches(int[] sticks) {
        System.out.println("Comparing Naive vs Heap Approaches");
        System.out.println("==================================");
        System.out.printf("Input size: %d sticks%n%n", sticks.length);

        // Test naive approach
        long startTime = System.nanoTime();
        int naiveCost = connectSticksNaive(sticks);
        long naiveTime = System.nanoTime() - startTime;

        // Test heap approach
        startTime = System.nanoTime();
        int heapCost = connectSticksHeap(sticks);
        long heapTime = System.nanoTime() - startTime;

        // Display results
        System.out.printf("Naive Approach (O(n^2)):%n");
        System.out.printf("  Cost: %d%n", naiveCost);
        System.out.printf("  Time: %d nanoseconds (%.3f ms)%n%n", naiveTime, naiveTime / 1_000_000.0);

        System.out.printf("Heap Approach (O(n log n)):%n");
        System.out.printf("  Cost: %d%n", heapCost);
        System.out.printf("  Time: %d nanoseconds (%.3f ms)%n%n", heapTime, heapTime / 1_000_000.0);

        System.out.printf("Speedup: %.2fx%n", (double) naiveTime / heapTime);
        System.out.printf("Results match: %s%n", naiveCost == heapCost);
    }

    /**
     * Main method for testing and demonstration.
     *
     * Runs example test cases and performance comparisons to help students
     * understand the algorithm and observe the efficiency differences.
     */
    public static void main(String[] args) {
        System.out.println("CS366 - PA4: Greedy Algorithms - Minimum Cost to Connect Sticks");
        System.out.println("===============================================================\n");

        // Example test cases
        int[][] testCases = {
            {2, 4, 3},           // Small example from problem description
            {1, 8, 3, 5},        // Another small example
            {4, 3, 2, 6, 1},     // Medium example
        };

        System.out.println("Testing with small examples:");
        System.out.println("----------------------------\n");

        for (int i = 0; i < testCases.length; i++) {
            int[] sticks = testCases[i];
            System.out.printf("Test Case %d: ", i + 1);
            printArray(sticks);

            int naiveCost = connectSticksNaive(sticks);
            int heapCost = connectSticksHeap(sticks);

            System.out.printf("  Naive approach cost: %d%n", naiveCost);
            System.out.printf("  Heap approach cost:  %d%n", heapCost);
            System.out.printf("  Results match: %s%n%n", naiveCost == heapCost);
        }

        // Performance comparison with larger input
        System.out.println("\nPerformance Comparison with Larger Input:");
        System.out.println("==========================================\n");

        // Generate larger test case
        int[] largeTest = generateRandomSticks(1000, 1, 100);
        System.out.printf("Testing with %d random sticks...%n%n", largeTest.length);

        compareApproaches(largeTest);

        System.out.println("\n===============================================================");
        System.out.println("Complete the theoretical analysis in ANALYSIS.md");
        System.out.println("Run tests with: ./gradlew test");
    }

    /**
     * Helper method to generate random stick lengths for testing.
     *
     * @param count number of sticks to generate
     * @param minLength minimum stick length
     * @param maxLength maximum stick length
     * @return array of random stick lengths
     */
    private static int[] generateRandomSticks(int count, int minLength, int maxLength) {
        int[] sticks = new int[count];
        for (int i = 0; i < count; i++) {
            sticks[i] = minLength + (int)(Math.random() * (maxLength - minLength + 1));
        }
        return sticks;
    }

    /**
     * Helper method to print an array.
     *
     * @param arr array to print
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
