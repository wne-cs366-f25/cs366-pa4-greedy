# CS366 - PA4: Theoretical Analysis

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

**Conclusion:** The naive approach has time complexity of **\_\_\_\_**.

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

**Conclusion:** The heap approach has time complexity of **\_\_\_\_**.

---

## Problem 4: Performance Prediction

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
| -------------- | --------------- | -------------- | -------------- |
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

_Course content developed by Declan Gray-Mullen for WNEU with Claude_
