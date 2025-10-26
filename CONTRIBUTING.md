# 🤝 Contributing to LeetCode Solutions

Thank you for your interest in contributing! This guide will help you get started with contributing to our LeetCode
solutions repository.

## 📋 Table of Contents

- [🚀 Quick Start](#-quick-start)
- [📝 Contribution Guidelines](#-contribution-guidelines)
- [🎯 How to Add Solutions](#-how-to-add-solutions)
- [🧪 Testing Guidelines](#-testing-guidelines)
- [📚 Documentation Standards](#-documentation-standards)
- [🎨 Code Style](#-code-style)
- [🔍 Review Process](#-review-process)

---

## 🚀 Quick Start

### Prerequisites

- Kotlin 1.8+
- IntelliJ IDEA (recommended) or VS Code
- Git knowledge
- Understanding of data structures and algorithms

### Setup

1. **Fork the repository**
2. **Clone your fork**
   ```bash
   git clone https://github.com/YOUR_USERNAME/leetcode.git
   cd leetcode
   ```
3. **Create a new branch**
   ```bash
   git checkout -b feature/problem-1234-two-sum
   ```

---

## 📝 Contribution Guidelines

### What We're Looking For

- ✅ **High-quality solutions** with optimal time/space complexity
- ✅ **Clear explanations** of the algorithm approach
- ✅ **Comprehensive test cases** covering edge cases
- ✅ **Clean, readable Kotlin code** following conventions
- ✅ **Proper documentation** with complexity analysis

### What We Don't Accept

- ❌ Solutions without explanations
- ❌ Code without test cases
- ❌ Duplicate solutions (unless significantly better)
- ❌ Solutions that don't follow our directory structure
- ❌ Code that doesn't compile or pass tests

---

## 🎯 How to Add Solutions

### Directory Structure

Place your solution in the appropriate directory:

```
src/
├── arrays/easy/          # Easy array problems
├── arrays/medium/        # Medium array problems
├── arrays/hard/          # Hard array problems
├── strings/easy/         # Easy string problems
└── ...                   # Other categories
```

### File Naming Convention

- **Solution file:** `Problem{Number}_{ProblemName}.kt`
- **Test file:** `Problem{Number}_{ProblemName}Test.kt`

**Example:**

- `Problem001_TwoSum.kt`
- `Problem001_TwoSumTest.kt`

### Solution Template

```kotlin
/**
 * Problem: Two Sum
 * URL: https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 * Tags: Array, Hash Table
 * 
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * Algorithm Approach:
 * Use a HashMap to store complements and their indices as we iterate through the array.
 * For each number, check if its complement (target - current number) exists in the HashMap.
 * 
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(n) - HashMap storage in worst case
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 */

class Problem001_TwoSum {
    
    /**
     * Optimal solution using HashMap
     * Time: O(n), Space: O(n)
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndex = mutableMapOf<Int, Int>()
        
        for (i in nums.indices) {
            val complement = target - nums[i]
            
            if (numToIndex.containsKey(complement)) {
                return intArrayOf(numToIndex[complement]!!, i)
            }
            
            numToIndex[nums[i]] = i
        }
        
        throw IllegalArgumentException("No two sum solution exists")
    }
    
    /**
     * Brute force solution (for comparison)
     * Time: O(n²), Space: O(1)
     */
    fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw IllegalArgumentException("No two sum solution exists")
    }
}
```

### Test Template

```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertContentEquals

class Problem001_TwoSumTest {
    
    private val solution = Problem001_TwoSum()
    
    @Test
    fun `test example 1`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)
        
        assertContentEquals(expected, solution.twoSum(nums, target))
    }
    
    @Test
    fun `test example 2`() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)
        
        assertContentEquals(expected, solution.twoSum(nums, target))
    }
    
    @Test
    fun `test duplicate numbers`() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)
        
        assertContentEquals(expected, solution.twoSum(nums, target))
    }
    
    @Test
    fun `test no solution throws exception`() {
        val nums = intArrayOf(1, 2, 3)
        val target = 10
        
        assertThrows<IllegalArgumentException> {
            solution.twoSum(nums, target)
        }
    }
    
    @Test
    fun `test minimum array size`() {
        val nums = intArrayOf(1, 2)
        val target = 3
        val expected = intArrayOf(0, 1)
        
        assertContentEquals(expected, solution.twoSum(nums, target))
    }
    
    @Test
    fun `test negative numbers`() {
        val nums = intArrayOf(-1, -2, -3, -4, -5)
        val target = -8
        val expected = intArrayOf(2, 4)
        
        assertContentEquals(expected, solution.twoSum(nums, target))
    }
}
```

---

## 🧪 Testing Guidelines

### Test Coverage Requirements

- ✅ All example cases from LeetCode
- ✅ Edge cases (empty arrays, single elements, etc.)
- ✅ Corner cases (negative numbers, duplicates, etc.)
- ✅ Performance tests for large inputs (when applicable)
- ✅ Error conditions (invalid inputs)

### Running Tests

```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests "Problem001_TwoSumTest"

# Run tests with coverage
./gradlew test jacocoTestReport
```

---

## 📚 Documentation Standards

### Required Documentation

1. **Problem description** - Brief summary from LeetCode
2. **Problem URL** - Direct link to LeetCode problem
3. **Difficulty and tags** - As specified on LeetCode
4. **Algorithm approach** - High-level explanation
5. **Time/Space complexity** - Big O analysis
6. **Examples** - At least one example walkthrough

### Optional Documentation

- Alternative approaches
- Trade-offs between different solutions
- Interview tips and variations
- Related problems

---

## 🎨 Code Style

### Kotlin Conventions

Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html):

```kotlin
// ✅ Good
fun twoSum(nums: IntArray, target: Int): IntArray {
    val numToIndex = mutableMapOf<Int, Int>()
    // ...
}

// ❌ Bad  
fun two_sum(Nums: IntArray, Target: Int): IntArray {
    val num_to_index = mutableMapOf<Int, Int>()
    // ...
}
```

### Naming Guidelines

- **Functions:** camelCase, descriptive names
- **Variables:** camelCase, clear purpose
- **Classes:** PascalCase with problem number
- **Constants:** UPPER_SNAKE_CASE

### Comments

- Use KDoc for class and function documentation
- Add inline comments for complex logic
- Explain the "why", not just the "what"

---

## 🔍 Review Process

### Before Submitting

1. ✅ Run all tests and ensure they pass
2. ✅ Verify your solution handles all edge cases
3. ✅ Check code formatting and style
4. ✅ Ensure documentation is complete
5. ✅ Test the solution on LeetCode platform

### Pull Request Template

```markdown
## Problem Information
- **Problem:** [Problem Name](LeetCode URL)
- **Difficulty:** Easy/Medium/Hard
- **Category:** Arrays/Strings/Trees/etc.

## Solution Approach
Brief description of your algorithm and approach.

## Complexity Analysis
- **Time Complexity:** O(?)
- **Space Complexity:** O(?)

## Test Coverage
- [ ] All LeetCode examples
- [ ] Edge cases
- [ ] Error conditions
- [ ] Performance tests (if applicable)

## Checklist
- [ ] Code follows Kotlin conventions
- [ ] All tests pass
- [ ] Documentation is complete
- [ ] Solution verified on LeetCode
```

### Review Criteria

Reviewers will check:

1. **Correctness** - Does the solution work?
2. **Efficiency** - Is it optimally implemented?
3. **Code Quality** - Is it clean and readable?
4. **Testing** - Are edge cases covered?
5. **Documentation** - Is it well explained?

---

## 🏆 Recognition

### Contributors Wall

Outstanding contributors will be featured in our README with:

- GitHub profile link
- Number of problems contributed
- Special recognition badges

### Contribution Types

- 🐛 **Bug fixes** - Fix incorrect solutions
- ✨ **New solutions** - Add missing problems
- 📚 **Documentation** - Improve explanations
- 🧪 **Tests** - Add better test coverage
- 🎨 **Optimization** - Improve existing solutions

---

## 🤔 Questions?

If you have any questions:

1. 📖 Check existing issues and discussions
2. 💬 Open a new issue with the `question` label
3. 📧 Contact maintainers directly

Thank you for contributing to help others learn! 🙏

---

## 📄 License

By contributing, you agree that your contributions will be licensed under the MIT License.