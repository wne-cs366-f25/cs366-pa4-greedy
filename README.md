# CS366 - PA4: Greedy Algorithms - Minimum Cost to Connect Sticks

This assignment explores the greedy algorithm paradigm through a practical optimization problem. You will implement two different approaches to solving the "Minimum Cost to Connect Sticks" problem, analyze their time complexity, and empirically demonstrate how using appropriate data structures (heaps) can dramatically improve algorithmic efficiency.

## Problem Description

You have `n` sticks of varying lengths stored in an array. The cost to connect two sticks is equal to the sum of their lengths. Your goal is to connect all sticks into a single stick while minimizing the total cost.

**Example:**

```
Input: sticks = [2, 4, 3]

Process:
1. Connect sticks of length 2 and 3 → cost = 2+3 = 5
   Remaining sticks: [5, 4]
2. Connect sticks of length 5 and 4 → cost = 5+4 = 9
   Remaining sticks: [9]

Total cost: 5 + 9 = 14
```

**Another Example:**

```
Input: sticks = [1, 8, 3, 5]

Process:
1. Connect 1 and 3 → cost = 4, remaining = [4, 5, 8]
2. Connect 4 and 5 → cost = 9, remaining = [9, 8]
3. Connect 9 and 8 → cost = 17, remaining = [17]

Total cost: 4 + 9 + 17 = 30
```

## Greedy Strategy

The optimal strategy is: **Always connect the two smallest sticks first.**

**Why does this work?**

- Sticks that are used in multiple connections contribute to the total cost multiple times
- By always combining the smallest sticks first, we minimize their contribution to future costs
- This is a classic application of the greedy algorithm paradigm with optimal substructure

## Part A: Theoretical Analysis

Complete the theoretical analysis in `ANALYSIS.md`:

### Problem 1: Greedy Choice Property

Prove that the greedy choice (always combining the two smallest sticks) leads to an optimal solution.

**Required:**

- Explain the greedy choice property for this problem
- Provide an informal proof using the exchange argument or similar technique
- Explain why selecting any sticks other than the two smallest cannot lead to a better solution

### Problem 2: Time Complexity Analysis - Naive Approach

Analyze the time complexity of the naive approach using an unsorted list.

**Required:**

- Write the recurrence relation for the naive approach
- Calculate the total time complexity
- Explain why each iteration takes O(n) time
- Show that the overall complexity is O(n²)

### Problem 3: Time Complexity Analysis - Heap Approach

Analyze the time complexity of the heap-optimized approach using a priority queue.

**Required:**

- Explain the heap operations used (build-heap, extract-min, insert)
- Calculate the time complexity of each operation
- Show that the overall complexity is O(n log n)
- Explain why building the heap initially is O(n)

### Problem 4: Why is the Heap Faster?

Explain the practical efficiency gains of using a heap.

**Required:**

- Compare the cost of finding minimums in unsorted list vs heap
- Explain how the 'cost' of maintaining the heap saves time overall
- Draw parallels to Dijkstra's algorithm with and without heap optimization
- Discuss the trade-off between maintaining structure and operation efficiency

### Problem 5: Performance Prediction

Predict the speedup factor for different input sizes.

**Required:**

- Calculate theoretical speedup for n=100, n=1000, n=10000
- Compare O(n²) vs O(n log n) for these inputs
- Explain when the heap approach begins to show significant advantages

## Part B: Programming Implementation

Implement three methods in `GreedyAlgorithms.java`:

### Method 1: `connectSticksNaive(int[] sticks)`

Implement the naive approach using an unsorted ArrayList.

**Requirements:**

1. Validate input (throw `IllegalArgumentException` for null, empty, or single-element arrays)
2. Copy sticks into an `ArrayList<Integer>` for dynamic removal
3. Loop while more than one stick remains:
   - Find the index of the first minimum element
   - Find the index of the second minimum element (excluding the first)
   - Calculate cost as the sum of these two minimums
   - Remove both sticks from the list (careful: remove larger index first!)
   - Add their sum back to the list
   - Add cost to running total
4. Return total cost

**Time Complexity:** O(n²)
**Space Complexity:** O(n)

### Method 2: `connectSticksHeap(int[] sticks)`

Implement the optimized approach using Java's `PriorityQueue` (min-heap).

**Requirements:**

1. Validate input (same validation as naive approach)
2. Create a `PriorityQueue<Integer>` (min-heap by default in Java)
3. Add all sticks to the priority queue
4. Loop while heap size > 1:
   - Extract the first minimum using `poll()`
   - Extract the second minimum using `poll()`
   - Calculate cost as the sum of these two minimums
   - Add their sum back to the heap using `offer()`
   - Add cost to running total
5. Return total cost

**Time Complexity:** O(n log n)
**Space Complexity:** O(n)

**Key Insight:** Each heap operation (poll/offer) is O(log n), much faster than O(n) for finding minimums in unsorted list!

### Method 3: `compareApproaches(int[] sticks)` (Already Implemented)

This helper method is already provided to compare both approaches with timing analysis. Use it to observe the performance differences empirically.

## Getting Started

### Step 1: Review the Problem

Read the problem description and examples carefully. Understand why the greedy strategy works.

### Step 2: Run the Starter Code

See the current implementation structure:

```bash
./gradlew run
```

Note: This will fail with `UnsupportedOperationException` until you implement the methods.

### Step 3: Run the Test Suite

Test your implementations as you develop:

```bash
./gradlew test
```

The comprehensive test suite will verify:

- Correctness with known results
- Proper error handling for invalid inputs
- Consistency between naive and heap approaches
- Greedy algorithm optimality properties

### Step 4: Implement the Naive Approach

Start with `connectSticksNaive()`:

- Focus on correctness first
- Handle edge cases (null, empty, single stick)
- Test with small inputs to verify logic

### Step 5: Implement the Heap Approach

Then implement `connectSticksHeap()`:

- Use `PriorityQueue<Integer>` from `java.util`
- Remember: PriorityQueue in Java is a min-heap by default
- The logic is similar to naive but with different data structure

### Step 6: Compare Performance

Run the main method to see timing comparisons:

```bash
./gradlew run
```

You should observe that the heap approach is significantly faster for larger inputs!

### Step 7: Complete Your Analysis

Document your findings in `ANALYSIS.md`:

- Mathematical proofs and complexity analysis
- Observations from your empirical testing
- Explanations of the efficiency gains

## Submission Requirements

### Files to Submit

Your completed assignment should include:

1. **GreedyAlgorithms.java** - Your complete implementations
2. **ANALYSIS.md** - Complete theoretical analysis
3. All original files (build.gradle, tests, etc.)

### Submission Process

```bash
tar -czf pa4-YOURNAME.zip /workspace/assignments/pa4
```

Download the file from the container and upload to Kodiak.

## Grading Criteria

- **Submission (33.3%):** Complete submission with all required files and components
- **Completeness (33.3%):** All methods implemented, all analysis problems attempted
- **Correctness (33.3%):** Accurate implementations, passing tests, and sound mathematical analysis

**Due Date:** November 6 by 11:59 PM

**Late Policy:** 10% per day, maximum 5 days late

---

_Course content developed by Declan Gray-Mullen for WNEU with Claude_
