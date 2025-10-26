# ⏰ Time & Space Complexity Cheat Sheet

A comprehensive reference for Big O notation, algorithm complexities, and performance analysis.

## 📊 Big O Notation Overview

### Growth Rates (Best to Worst)

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | Array access, Hash table lookup |
| O(log n) | Logarithmic | Binary search, Balanced tree operations |
| O(n) | Linear | Linear search, Array traversal |
| O(n log n) | Linearithmic | Merge sort, Heap sort, Efficient sorting |
| O(n²) | Quadratic | Bubble sort, Selection sort, Nested loops |
| O(n³) | Cubic | Triple nested loops, Matrix multiplication |
| O(2ⁿ) | Exponential | Recursive Fibonacci, Subset generation |
| O(n!) | Factorial | Permutation generation, Traveling salesman |

### 📈 Performance Comparison

```
Input Size (n) | O(1) | O(log n) | O(n) | O(n log n) | O(n²) | O(2ⁿ)
10            | 1    | 3        | 10   | 33         | 100   | 1,024
100           | 1    | 7        | 100  | 664        | 10K   | 1.3×10³⁰
1,000         | 1    | 10       | 1K   | 9,966      | 1M    | ∞
10,000        | 1    | 13       | 10K  | 132,877    | 100M  | ∞
```

---

## 🗂️ Data Structure Complexities

### Arrays

| Operation | Time | Space | Notes |
|-----------|------|-------|-------|
| Access | O(1) | - | Direct index access |
| Search | O(n) | O(1) | Linear scan |
| Insert (end) | O(1) amortized | O(1) | May need resize |
| Insert (beginning) | O(n) | O(1) | Shift all elements |
| Delete (end) | O(1) | O(1) | Simple removal |
| Delete (beginning) | O(n) | O(1) | Shift all elements |

### Linked Lists

| Operation | Singly | Doubly | Notes |
|-----------|--------|--------|-------|
| Access | O(n) | O(n) | Sequential traversal |
| Search | O(n) | O(n) | Linear scan |
| Insert (head) | O(1) | O(1) | Update pointers |
| Insert (tail) | O(n) / O(1)* | O(1) | *With tail reference |
| Delete (head) | O(1) | O(1) | Update pointers |
| Delete (arbitrary) | O(n) | O(1)* | *With node reference |

### Hash Tables (HashMap/HashSet)

| Operation | Average | Worst | Space |
|-----------|---------|-------|-------|
| Search | O(1) | O(n) | O(n) |
| Insert | O(1) | O(n) | O(n) |
| Delete | O(1) | O(n) | - |

**Notes:**

- Worst case when all keys hash to same bucket
- Load factor affects performance
- Good hash function crucial for O(1) average case

### Trees

#### Binary Search Tree (BST)

| Operation | Average | Worst | Best | Space |
|-----------|---------|-------|------|-------|
| Search | O(log n) | O(n) | O(1) | O(n) |
| Insert | O(log n) | O(n) | O(1) | O(n) |
| Delete | O(log n) | O(n) | O(1) | - |

#### Balanced Trees (AVL, Red-Black)

| Operation | Time | Space |
|-----------|------|-------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | - |

#### Binary Heap (Priority Queue)

| Operation | Time | Space |
|-----------|------|-------|
| Find Min/Max | O(1) | O(n) |
| Extract Min/Max | O(log n) | - |
| Insert | O(log n) | - |
| Build Heap | O(n) | O(n) |

### Graphs

| Operation | Adjacency List | Adjacency Matrix |
|-----------|---------------|------------------|
| Add Vertex | O(1) | O(V²) |
| Add Edge | O(1) | O(1) |
| Remove Vertex | O(V + E) | O(V²) |
| Remove Edge | O(E) | O(1) |
| Query Edge | O(V) | O(1) |
| Space | O(V + E) | O(V²) |

---

## 🔄 Algorithm Complexities

### Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Stable |
|-----------|------|---------|-------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ❌ |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | ❌ |
| Counting Sort | O(n + k) | O(n + k) | O(n + k) | O(k) | ✅ |
| Radix Sort | O(d × n) | O(d × n) | O(d × n) | O(n + k) | ✅ |

**Legend:**

- n = number of elements
- k = range of input
- d = number of digits
- ✅ Stable = maintains relative order of equal elements

### Search Algorithms

| Algorithm | Best | Average | Worst | Space | Requirements |
|-----------|------|---------|-------|-------|--------------|
| Linear Search | O(1) | O(n) | O(n) | O(1) | None |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) | Sorted array |
| Hash Table Search | O(1) | O(1) | O(n) | O(n) | Hash function |

### Graph Algorithms

| Algorithm | Time | Space | Use Case |
|-----------|------|-------|----------|
| DFS | O(V + E) | O(V) | Pathfinding, Cycle detection |
| BFS | O(V + E) | O(V) | Shortest path (unweighted) |
| Dijkstra | O((V + E) log V) | O(V) | Shortest path (weighted) |
| Bellman-Ford | O(V × E) | O(V) | Negative weights allowed |
| Floyd-Warshall | O(V³) | O(V²) | All pairs shortest path |
| Kruskal's MST | O(E log E) | O(V) | Minimum spanning tree |
| Prim's MST | O((V + E) log V) | O(V) | Minimum spanning tree |

### Tree Algorithms

| Algorithm | Time | Space | Notes |
|-----------|------|-------|-------|
| Tree Traversal (DFS) | O(n) | O(h) | h = height |
| Tree Traversal (BFS) | O(n) | O(w) | w = max width |
| Lowest Common Ancestor | O(log n) | O(log n) | Preprocessed |
| Tree Diameter | O(n) | O(h) | Two DFS calls |

---

## 🧮 Common Patterns & Complexities

### Two Pointers

| Pattern | Time | Space | Example Problems |
|---------|------|-------|------------------|
| Opposite Direction | O(n) | O(1) | Two Sum (sorted), Palindrome |
| Same Direction | O(n) | O(1) | Remove duplicates, Fast-slow |

### Sliding Window

| Pattern | Time | Space | Example Problems |
|---------|------|-------|------------------|
| Fixed Size | O(n) | O(1) | Max sum subarray |
| Variable Size | O(n) | O(k) | Longest substring |

### Binary Search Variations

| Pattern | Time | Space | Example Problems |
|---------|------|-------|------------------|
| Find Target | O(log n) | O(1) | Classic binary search |
| Find Boundary | O(log n) | O(1) | First/last occurrence |
| Search Answer | O(n log m) | O(1) | Minimize maximum |

### Dynamic Programming

| Pattern | Time | Space | Space Optimized |
|---------|------|-------|----------------|
| 1D DP | O(n) | O(n) | O(1) often possible |
| 2D DP | O(n²) | O(n²) | O(n) often possible |
| Knapsack | O(n × W) | O(n × W) | O(W) |
| LCS/Edit Distance | O(n × m) | O(n × m) | O(min(n,m)) |

### Backtracking

| Pattern | Time | Space | Example Problems |
|---------|------|-------|------------------|
| Permutations | O(n!) | O(n) | All permutations |
| Combinations | O(2ⁿ) | O(n) | Subsets, combinations |
| Sudoku Solving | O(9^(n²)) | O(n²) | Constraint satisfaction |

---

## 🎯 Optimization Techniques

### Time Optimization

1. **Memoization**: Trade space for time in recursive solutions
2. **Hash Tables**: O(1) lookup instead of O(n) search
3. **Sorting**: Enable binary search, two pointers
4. **Preprocessing**: Calculate prefix sums, build auxiliary structures
5. **Greedy**: Choose locally optimal when globally optimal

### Space Optimization

1. **In-place algorithms**: Modify input instead of creating new structure
2. **Iterative vs Recursive**: Avoid function call overhead
3. **Rolling arrays**: Use O(1) space in DP instead of O(n)
4. **Bit manipulation**: Pack multiple boolean values
5. **Two pointers**: Avoid extra data structures

---

## 🚨 Common Complexity Mistakes

### Pitfalls to Avoid

1. **Hidden loops** in library functions (e.g., `contains()`, `indexOf()`)
2. **String concatenation** in loops (O(n²) in many languages)
3. **Recursive calls** without memoization (exponential time)
4. **Nested data structure operations** (map within map access)
5. **Sorting** when not necessary (adds O(n log n))

### Best Practices

- Always consider input constraints
- Analyze average vs worst case
- Consider space-time trade-offs
- Use amortized analysis when appropriate
- Test with large inputs mentally

---

## 📝 Quick Reference

### When to Use What

| If you need... | Consider... | Time | Space |
|---------------|------------|------|-------|
| Fast lookup | Hash Table | O(1) | O(n) |
| Sorted data | Balanced BST | O(log n) | O(n) |
| FIFO operations | Queue | O(1) | O(n) |
| LIFO operations | Stack | O(1) | O(n) |
| Priority operations | Heap | O(log n) | O(n) |
| Range queries | Segment Tree | O(log n) | O(n) |

### Problem Size Hints

- **n ≤ 20**: O(2ⁿ) or O(n!) acceptable
- **n ≤ 100**: O(n³) acceptable
- **n ≤ 1,000**: O(n²) acceptable
- **n ≤ 10⁵**: O(n log n) required
- **n ≤ 10⁶**: O(n) required
- **n ≤ 10⁸**: O(log n) or O(1) required

---

## 🔍 Analysis Framework

### Step-by-Step Analysis

1. **Identify** the basic operation
2. **Count** how many times it executes
3. **Express** in terms of input size
4. **Simplify** to dominant term
5. **Verify** with examples

### Example Analysis

```kotlin
// What's the time complexity?
fun findDuplicates(nums: IntArray): List<Int> {
    val seen = mutableSetOf<Int>()        // O(1) space allocation
    val duplicates = mutableListOf<Int>()  // O(1) space allocation
    
    for (num in nums) {                   // O(n) - loop n times
        if (num in seen) {                // O(1) - hash lookup
            duplicates.add(num)           // O(1) amortized
        } else {
            seen.add(num)                 // O(1) amortized
        }
    }
    return duplicates                     // O(1)
}
```

**Analysis**: O(n) time, O(n) space

Remember: Master the fundamentals, then recognize patterns! 🚀