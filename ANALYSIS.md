# CS366 - PA4: Theoretical Analysis

**Student Name:** [Your Name]
**Date:** [Submission Date]

---

## Problem 1: Greedy Choice Property

**Prove that the greedy choice (always combining the two smallest sticks) leads to an optimal solution.**

### Greedy Choice Property Explanation

[Explain what the greedy choice property means for this problem]

### Informal Proof

[Provide an informal proof using exchange argument or similar technique. Consider:
- What happens if we choose sticks other than the two smallest?
- How does the greedy choice affect the total cost?
- Why can't any other choice lead to a better solution?]

### Example Demonstration

[Provide a concrete example showing that choosing non-smallest sticks leads to higher cost]

---

## Problem 2: Time Complexity Analysis - Naive Approach

**Analyze the time complexity of the naive approach using an unsorted list.**

### Algorithm Description

[Briefly describe the steps of the naive algorithm]

### Iteration Analysis

[Explain why each iteration takes O(n) time. Consider:
- Finding the first minimum: O(?)
- Finding the second minimum: O(?)
- Removing elements: O(?)
- Adding element back: O(?)]

### Total Complexity Calculation

[Show the calculation:
- Number of iterations: ?
- Cost per iteration: ?
- Total: ?]

### Recurrence Relation

[Write and solve the recurrence relation for the naive approach]

**Conclusion:** The naive approach has time complexity of ________.

---

## Problem 3: Time Complexity Analysis - Heap Approach

**Analyze the time complexity of the heap-optimized approach using a priority queue.**

### Heap Operations

[Explain the time complexity of each heap operation used:
- Building initial heap: O(?)
- Extract minimum (poll): O(?)
- Insert (offer): O(?)]

### Build-Heap Analysis

[Explain why building a heap from n elements is O(n), not O(n log n)]

### Iteration Analysis

[Analyze one iteration:
- Extract first minimum: O(?)
- Extract second minimum: O(?)
- Insert sum back: O(?)
- Total per iteration: O(?)]

### Total Complexity Calculation

[Show the calculation:
- Build heap: O(?)
- Number of iterations: ?
- Cost per iteration: O(?)
- Total: ?]

**Conclusion:** The heap approach has time complexity of ________.

---

## Problem 4: Why is the Heap Faster?

**Explain the practical efficiency gains of using a heap.**

### Finding Minimums: List vs Heap

| Operation | Unsorted List | Min-Heap |
|-----------|--------------|----------|
| Find minimum | O(?) | O(?) |
| Remove minimum | O(?) | O(?) |
| Add element | O(?) | O(?) |

### The Trade-off Explained

[Explain how "doing more work" (maintaining heap invariants) actually saves time overall]

### Connection to Dijkstra's Algorithm

[Draw parallels between this problem and Dijkstra's algorithm. How is the heap optimization similar?]

### When Does Heap Optimization Matter?

[Discuss for what input sizes the heap approach becomes significantly better]

### Comparison with Sort-First Approach

**Question:** Since sorting is also O(n log n), why not just sort the array once and process it from smallest to largest?

**Answer this question by analyzing the following:**

1. **Describe the sort-first approach:**
   - Sort array: O(n log n)
   - Process from smallest to largest
   - After combining two sticks, what happens to the result?

2. **Identify the problem:**
   - Where does the combined stick need to go?
   - How do you maintain sorted order after each combination?
   - What is the cost of reinserting into a sorted array?

3. **Calculate total complexity:**
   - Initial sort: O(?)
   - Each of n-1 iterations: O(?)
   - Total: O(?)

4. **Compare with heap approach:**
   - Which is faster: sort-first or heap?
   - Why does the heap avoid the reinsertion problem?
   - What is the key difference between "fully sorted" vs "partial order" (heap property)?

5. **Key insight:**
   - Do we need full sorted order or just access to minimums?
   - Why is heap the "right tool for the job"?

---

## Problem 5: Performance Prediction

**Predict the speedup factor for different input sizes.**

### Theoretical Speedup Calculations

For input size n, compare O(n²) vs O(n log n):

**n = 100:**
- Naive: O(100²) = [calculate]
- Heap: O(100 × log₂ 100) ≈ [calculate]
- Speedup factor: [calculate]

**n = 1,000:**
- Naive: O(1000²) = [calculate]
- Heap: O(1000 × log₂ 1000) ≈ [calculate]
- Speedup factor: [calculate]

**n = 10,000:**
- Naive: O(10000²) = [calculate]
- Heap: O(10000 × log₂ 10000) ≈ [calculate]
- Speedup factor: [calculate]

### Empirical Results

[After implementing your solution, run compareApproaches() with different input sizes and record actual timing results]

| Input Size (n) | Naive Time (ms) | Heap Time (ms) | Actual Speedup |
|----------------|-----------------|----------------|----------------|
| 100            |                 |                |                |
| 500            |                 |                |                |
| 1,000          |                 |                |                |
| 5,000          |                 |                |                |

### Analysis of Results

[Compare theoretical predictions with empirical results. Discuss:
- Do the empirical results match your theoretical predictions?
- At what input size does the heap approach become significantly faster?
- What factors might cause differences between theoretical and empirical speedup?]

---

## Reflection

### Key Insights

[What did you learn from this assignment about:
- Greedy algorithms
- Data structure selection
- The trade-off between operation complexity and overall algorithm efficiency
- The importance of choosing the right data structure]

### Challenges Encountered

[Describe any challenges you faced and how you overcame them]

### Real-World Applications

[Can you think of real-world scenarios where this type of optimization problem occurs?]

---

## References

[List any resources you consulted (textbook sections, lecture notes, etc.)]

- CLRS Chapter 16: Greedy Algorithms
- CLRS Chapter 6: Heapsort and Priority Queues
- [Add any other references]

---

_CS366 - PA4: Greedy Algorithms - Minimum Cost to Connect Sticks_
