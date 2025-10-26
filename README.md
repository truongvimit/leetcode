# 🏆 LeetCode Solutions & Data Structures Algorithms

[![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![GitHub Stars](https://img.shields.io/github/stars/truongvimit/leetcode?style=for-the-badge)](https://github.com/truongvimit/leetcode/stargazers)
[![GitHub Forks](https://img.shields.io/github/forks/truongvimit/leetcode?style=for-the-badge)](https://github.com/truongvimit/leetcode/network)

> 📚 **Comprehensive collection of LeetCode problems solutions with detailed explanations**  
> 💪 **Designed to help software engineers master coding interviews**  
> 🎯 **Organized by patterns and data structures for efficient learning**

---

## 📋 Table of Contents

- [🏗️ Project Structure](#-project-structure)
- [📊 Progress Tracker](#-progress-tracker)
- [🎯 Problem Categories](#-problem-categories)
- [📚 Study Patterns](#-study-patterns)
- [🚀 Quick Start](#-quick-start)
- [📈 Difficulty Progression](#-difficulty-progression)
- [💡 Interview Preparation](#-interview-preparation)
- [🤝 Contributing](#-contributing)

---

## 🏗️ Project Structure

```
leetcode/
├── 📁 src/
│   ├── 📁 arrays/                    # Array problems
│   │   ├── easy/
│   │   ├── medium/
│   │   └── hard/
│   ├── 📁 strings/                   # String problems
│   ├── 📁 hashmaps/                  # HashMap & HashSet problems
│   ├── 📁 linkedlists/               # LinkedList problems
│   ├── 📁 trees/                     # Tree & BST problems
│   ├── 📁 graphs/                    # Graph problems
│   ├── 📁 dynamicprogramming/        # DP problems
│   ├── 📁 backtracking/              # Backtracking problems
│   ├── 📁 sorting/                   # Sorting algorithms
│   ├── 📁 binarysearch/              # Binary search problems
│   ├── 📁 slidingwindow/             # Sliding window technique
│   ├── 📁 twopointers/               # Two pointers technique
│   ├── 📁 greedy/                    # Greedy algorithms
│   ├── 📁 heaps/                     # Heap & Priority Queue
│   ├── 📁 stacks/                    # Stack problems
│   └── 📁 queues/                    # Queue problems
├── 📁 docs/
│   ├── patterns/                     # Algorithm patterns explained
│   ├── cheatsheets/                  # Quick reference guides
│   └── interview-tips/               # Interview preparation tips
├── 📁 tests/                         # Unit tests
├── README.md
├── .gitignore
└── CONTRIBUTING.md
```

---

## 📊 Progress Tracker

| Category | Easy | Medium | Hard | Total | Completed |
|----------|------|--------|------|-------|-----------|
| **Arrays** | 0/156 | 0/234 | 0/45 | 0/435 | ![Progress](https://progress-bar.dev/0/?scale=435&title=progress&width=120&color=babaca&suffix=/435) |
| **Strings** | 0/89 | 0/145 | 0/32 | 0/266 | ![Progress](https://progress-bar.dev/0/?scale=266&title=progress&width=120&color=babaca&suffix=/266) |
| **Hash Maps** | 0/45 | 0/78 | 0/12 | 0/135 | ![Progress](https://progress-bar.dev/0/?scale=135&title=progress&width=120&color=babaca&suffix=/135) |
| **Linked Lists** | 0/23 | 0/34 | 0/8 | 0/65 | ![Progress](https://progress-bar.dev/0/?scale=65&title=progress&width=120&color=babaca&suffix=/65) |
| **Trees** | 0/45 | 0/89 | 0/23 | 0/157 | ![Progress](https://progress-bar.dev/0/?scale=157&title=progress&width=120&color=babaca&suffix=/157) |
| **Graphs** | 0/12 | 0/67 | 0/34 | 0/113 | ![Progress](https://progress-bar.dev/0/?scale=113&title=progress&width=120&color=babaca&suffix=/113) |
| **Dynamic Programming** | 0/34 | 0/156 | 0/89 | 0/279 | ![Progress](https://progress-bar.dev/0/?scale=279&title=progress&width=120&color=babaca&suffix=/279) |
| **Backtracking** | 0/8 | 0/45 | 0/23 | 0/76 | ![Progress](https://progress-bar.dev/0/?scale=76&title=progress&width=120&color=babaca&suffix=/76) |

**🎯 Overall Progress: 0/1526 (0%)**

---

## 🎯 Problem Categories

### 🔥 **Essential Patterns** (Recommended Order)

1. **Arrays & Hashing** - Foundation problems
2. **Two Pointers** - Efficient array/string processing
3. **Sliding Window** - Subarray/substring problems
4. **Binary Search** - Search in sorted arrays
5. **Linked Lists** - Pointer manipulation
6. **Trees (DFS/BFS)** - Traversal algorithms
7. **Heaps** - Priority queue problems
8. **Backtracking** - Combinatorial problems
9. **Dynamic Programming** - Optimization problems
10. **Graphs** - Advanced traversal

### 📈 **Difficulty Distribution**

- 🟢 **Easy (40%)** - Build fundamentals
- 🟡 **Medium (50%)** - Interview level
- 🔴 **Hard (10%)** - Advanced concepts

---

## 📚 Study Patterns

### 🎯 **Top 15 LeetCode Patterns**

<details>
<summary><strong>1. 🔧 Two Pointers (147 problems)</strong></summary>

**When to use:** Array/string problems involving pairs or ranges

- **Key problems:** Two Sum II, 3Sum, Container With Most Water
- **Time complexity:** Usually O(n) vs O(n²) brute force
- **Space complexity:** O(1) - in-place optimization

</details>

<details>
<summary><strong>2. 🔍 Sliding Window (72 problems)</strong></summary>

**When to use:** Subarray/substring with contiguous elements

- **Key problems:** Longest Substring Without Repeating Characters
- **Time complexity:** O(n) vs O(n²) brute force
- **Patterns:** Fixed size, variable size, shrinkable

</details>

<details>
<summary><strong>3. 📊 Binary Search (186 problems)</strong></summary>

**When to use:** Sorted arrays, search space reduction

- **Key problems:** Search in Rotated Sorted Array
- **Time complexity:** O(log n)
- **Variations:** Find target, find boundary, find peak

</details>

<details>
<summary><strong>4. 🌳 Tree DFS (250 problems)</strong></summary>

**When to use:** Tree/graph traversal, pathfinding

- **Key problems:** Path Sum, Maximum Depth
- **Traversals:** Preorder, Inorder, Postorder
- **Space complexity:** O(h) where h is height

</details>

<details>
<summary><strong>5. 🌊 Tree BFS (198 problems)</strong></summary>

**When to use:** Level-order traversal, shortest path

- **Key problems:** Binary Tree Level Order Traversal
- **Time complexity:** O(n)
- **Space complexity:** O(w) where w is max width

</details>

<details>
<summary><strong>6. 🔄 Dynamic Programming (383 problems)</strong></summary>

**When to use:** Optimization problems, overlapping subproblems

- **Key problems:** Climbing Stairs, Coin Change
- **Patterns:** 1D DP, 2D DP, State machines
- **Approach:** Top-down (memoization) vs Bottom-up

</details>

### 🏃‍♂️ **30-Day Study Plan**

**Week 1: Foundations**

- Days 1-2: Arrays & Hashing (20 problems)
- Days 3-4: Two Pointers (15 problems)
- Days 5-7: Sliding Window (15 problems)

**Week 2: Search & Sort**

- Days 8-10: Binary Search (15 problems)
- Days 11-12: Sorting (10 problems)
- Days 13-14: Stack & Queue (15 problems)

**Week 3: Trees & Graphs**

- Days 15-17: Binary Trees (20 problems)
- Days 18-19: Binary Search Trees (10 problems)
- Days 20-21: Graph DFS/BFS (15 problems)

**Week 4: Advanced**

- Days 22-23: Backtracking (10 problems)
- Days 24-25: Dynamic Programming (15 problems)
- Days 26-28: Heaps & Greedy (15 problems)
- Days 29-30: Review & Mock Interviews

---

## 🚀 Quick Start

### Prerequisites

- ✅ Kotlin 1.8+
- ✅ IntelliJ IDEA or VS Code
- ✅ Basic understanding of data structures

### Setup

```bash
# Clone the repository
git clone https://github.com/truongvimit/leetcode.git
cd leetcode

# Open in IntelliJ IDEA
idea .

# Or open in VS Code
code .
```

### Running Solutions

```kotlin
// Example: Two Sum problem
fun main() {
    val solution = TwoSum()
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    
    val result = solution.twoSum(nums, target)
    println("Result: ${result.contentToString()}") // [0, 1]
}
```

### Testing

```bash
# Run all tests
./gradlew test

# Run specific category tests
./gradlew test --tests "*ArrayTest*"
```

---

## 📈 Difficulty Progression

### 🟢 **Easy Problems** (Start Here)

Perfect for building confidence and understanding basic patterns.

**Essential Easy Problems:**

1. [Two Sum](https://leetcode.com/problems/two-sum/) - HashMap basics
2. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) - Stack usage
3. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) - LinkedList manipulation
4. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) - Kadane's algorithm
5. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) - Tree traversal

### 🟡 **Medium Problems** (Interview Level)

Core of technical interviews. Master these for success.

**Must-Know Medium Problems:**

1. [3Sum](https://leetcode.com/problems/3sum/) - Two pointers advanced
2. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) -
   Sliding window
3. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) - BFS
4. [Coin Change](https://leetcode.com/problems/coin-change/) - Dynamic Programming
5. [Number of Islands](https://leetcode.com/problems/number-of-islands/) - Graph DFS/BFS

### 🔴 **Hard Problems** (Advanced)

For senior positions and competitive programming.

**Challenge Hard Problems:**

1. [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) - Binary search advanced
2. [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) - Heap/Priority queue
3. [Word Ladder II](https://leetcode.com/problems/word-ladder-ii/) - BFS + backtracking
4. [Edit Distance](https://leetcode.com/problems/edit-distance/) - 2D DP
5. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) - Monotonic deque

---

## 💡 Interview Preparation

### 🎯 **Top Companies' Favorite Problems**

**FAANG Companies:**

- **Google:** Focus on system design, arrays, and trees
- **Amazon:** Leadership principles + coding (arrays, strings, trees)
- **Facebook/Meta:** Product sense + algorithms (graphs, DP)
- **Apple:** Attention to detail + fundamentals
- **Netflix:** Scalability + medium complexity problems

### 📋 **Interview Strategy**

**Before the Interview:**

1. ✅ Practice 150+ problems across all patterns
2. ✅ Master time/space complexity analysis
3. ✅ Prepare behavioral questions with STAR method
4. ✅ Do 5+ mock interviews

**During the Interview:**

1. 🎯 **Listen carefully** - Ask clarifying questions
2. 🎯 **Think out loud** - Explain your approach
3. 🎯 **Start simple** - Brute force first, then optimize
4. 🎯 **Code clean** - Use meaningful variable names
5. 🎯 **Test thoroughly** - Walk through examples

### 🏆 **Company-Specific Preparation**

<details>
<summary><strong>Google Interview Prep</strong></summary>

**Focus Areas:**

- System design (distributed systems)
- Algorithm complexity analysis
- Clean, readable code
- Edge case handling

**Top Problem Types:**

- Array manipulation
- Tree traversals
- Graph algorithms
- Dynamic programming

**Preparation Time:** 3-6 months
</details>

<details>
<summary><strong>Amazon Interview Prep</strong></summary>

**Focus Areas:**

- Leadership Principles (behavioral)
- Customer obsession mindset
- Scalable solutions
- Working backwards

**Top Problem Types:**

- Arrays and strings
- Trees and graphs
- System design basics
- OOP design

**Preparation Time:** 2-4 months
</details>

---

## 🤝 Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for details.

### 📝 **How to Contribute**

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/new-solution`)
3. 💻 Add your solution with tests and documentation
4. ✅ Ensure all tests pass
5. 📤 Submit a Pull Request

### 🎨 **Code Style Guidelines**

- Follow Kotlin coding conventions
- Include time/space complexity analysis
- Add comprehensive test cases
- Document algorithm approach
- Use meaningful variable names

---

## 📚 Additional Resources

### 🌟 **Recommended Books**

-
📖 [Cracking the Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/0984782850)
by Gayle McDowell
-
📖 [Elements of Programming Interviews](https://www.amazon.com/Elements-Programming-Interviews-Insiders-Guide/dp/1479274836)
by Aziz, Lee, Prakash
- 📖 [Algorithm Design Manual](https://www.amazon.com/Algorithm-Design-Manual-Steven-Skiena/dp/1848000693) by Steven
  Skiena

### 🎥 **YouTube Channels**

- 🎬 [NeetCode](https://www.youtube.com/c/NeetCode) - LeetCode solutions explained
- 🎬 [Back to Back SWE](https://www.youtube.com/c/BackToBackSWE) - Algorithm concepts
- 🎬 [TechLead](https://www.youtube.com/c/TechLead) - Interview experiences

### 🌐 **Useful Websites**

- 🔗 [LeetCode](https://leetcode.com/) - Primary practice platform
- 🔗 [HackerRank](https://www.hackerrank.com/) - Additional practice
- 🔗 [InterviewBit](https://www.interviewbit.com/) - Structured learning path
- 🔗 [Pramp](https://www.pramp.com/) - Mock interviews

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## ⭐ Support

If this repository helped you land your dream job, please:

- 🌟 **Star this repository**
- 🍴 **Share with friends**
- 💝 **Consider sponsoring**

---

<div align="center">

**Happy Coding! 🚀**

Made with ❤️ by [truongvimit](https://github.com/truongvimit)

</div>