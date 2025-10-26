# 🧮 Arrays and Hashing Patterns

Arrays and Hash Tables are fundamental data structures that appear in almost every coding interview. This guide covers
the essential patterns and techniques you need to master.

## 📚 Table of Contents

- [Core Concepts](#-core-concepts)
- [Common Patterns](#-common-patterns)
- [Problem Categories](#-problem-categories)
- [Implementation Tips](#-implementation-tips)
- [Practice Problems](#-practice-problems)

---

## 🔑 Core Concepts

### Arrays

- **Definition**: Contiguous memory locations storing elements of the same type
- **Access**: O(1) random access by index
- **Common Operations**: Traverse, search, insert, delete, sort
- **Space**: O(n) where n is the number of elements

### Hash Tables (HashMap/HashSet)

- **Definition**: Data structure mapping keys to values using hash functions
- **Access**: O(1) average case for get/put operations
- **Collision Handling**: Chaining or open addressing
- **Space**: O(n) where n is the number of key-value pairs

---

## 🎯 Common Patterns

### 1. **Frequency Counting**

Use HashMap to count occurrences of elements.

```kotlin
// Count frequency of characters
fun countFrequency(s: String): Map<Char, Int> {
    val freq = mutableMapOf<Char, Int>()
    for (char in s) {
        freq[char] = freq.getOrDefault(char, 0) + 1
    }
    return freq
}
```

**When to use:**

- Anagram problems
- Finding duplicates
- Character/element counting
- Majority element problems

### 2. **Complement Lookup**

Store elements and check for complements (target - current).

```kotlin
// Two Sum pattern
fun twoSum(nums: IntArray, target: Int): IntArray {
    val numToIndex = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (complement in numToIndex) {
            return intArrayOf(numToIndex[complement]!!, i)
        }
        numToIndex[nums[i]] = i
    }
    return intArrayOf()
}
```

**When to use:**

- Two Sum variations
- Pair finding problems
- Target sum problems

### 3. **Prefix Sums**

Precompute cumulative sums for efficient range queries.

```kotlin
// Prefix sum array
fun buildPrefixSum(nums: IntArray): IntArray {
    val prefixSum = IntArray(nums.size + 1)
    for (i in nums.indices) {
        prefixSum[i + 1] = prefixSum[i] + nums[i]
    }
    return prefixSum
}

// Range sum query
fun rangeSum(prefixSum: IntArray, left: Int, right: Int): Int {
    return prefixSum[right + 1] - prefixSum[left]
}
```

**When to use:**

- Subarray sum problems
- Range query problems
- Continuous subarray problems

### 4. **Index Mapping**

Use array indices as hash keys for limited range integers.

```kotlin
// Count sort / bucket sort approach
fun countingSort(nums: IntArray, maxVal: Int): IntArray {
    val count = IntArray(maxVal + 1)
    for (num in nums) {
        count[num]++
    }
    // Reconstruct sorted array...
    return nums // simplified
}
```

**When to use:**

- Limited range integers (0 to n)
- Counting sort scenarios
- Missing number problems

### 5. **Set Operations**

Use HashSet for membership testing and set operations.

```kotlin
// Find intersection of two arrays
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toSet()
    val result = mutableSetOf<Int>()
    
    for (num in nums2) {
        if (num in set1) {
            result.add(num)
        }
    }
    return result.toIntArray()
}
```

**When to use:**

- Finding common elements
- Removing duplicates
- Set intersection/union problems

---

## 📂 Problem Categories

### Easy Problems

1. **Two Sum** - Complement lookup pattern
2. **Contains Duplicate** - HashSet for duplicate detection
3. **Valid Anagram** - Frequency counting
4. **Missing Number** - Mathematical or XOR approach
5. **Single Number** - XOR properties

### Medium Problems

1. **Group Anagrams** - Frequency counting with sorting
2. **Top K Frequent Elements** - Frequency + heap/bucket sort
3. **Product of Array Except Self** - Prefix/suffix products
4. **Longest Consecutive Sequence** - HashSet with sequence building
5. **Subarray Sum Equals K** - Prefix sum with HashMap

### Hard Problems

1. **First Missing Positive** - Index as hash key
2. **Largest Rectangle in Histogram** - Stack with array
3. **Trapping Rain Water** - Two pointers or stack
4. **Sliding Window Maximum** - Deque with array
5. **Minimum Window Substring** - Sliding window with HashMap

---

## 💡 Implementation Tips

### Kotlin-Specific Tips

```kotlin
// 1. Use getOrDefault for safe map access
val count = map.getOrDefault(key, 0)

// 2. Use getOrPut for lazy initialization
val list = map.getOrPut(key) { mutableListOf<Int>() }

// 3. Use indices property for array iteration
for (i in nums.indices) { /* ... */ }

// 4. Use until for exclusive ranges
for (i in 0 until nums.size) { /* ... */ }

// 5. Use contentEquals for array comparison
if (arr1 contentEquals arr2) { /* ... */ }

// 6. Convert collections efficiently
val set = nums.toSet()
val array = list.toIntArray()
```

### Performance Considerations

1. **HashMap vs Array**: Use array when keys are limited range integers (0 to n)
2. **Memory Usage**: Arrays use less memory overhead than HashMaps
3. **Cache Locality**: Arrays have better cache performance
4. **Hash Collisions**: Be aware of worst-case O(n) for HashMap operations

### Common Mistakes

1. **Off-by-one errors** in array indexing
2. **Null safety** when accessing HashMap values
3. **Modifying collection** while iterating
4. **Integer overflow** in sum calculations
5. **Not handling edge cases** (empty arrays, single element)

---

## 📝 Practice Problems

### Beginner Level (Start Here)

- [ ] Two Sum
- [ ] Contains Duplicate
- [ ] Valid Anagram
- [ ] Missing Number
- [ ] Single Number

### Intermediate Level

- [ ] Group Anagrams
- [ ] Top K Frequent Elements
- [ ] Product of Array Except Self
- [ ] Longest Consecutive Sequence
- [ ] Subarray Sum Equals K

### Advanced Level

- [ ] First Missing Positive
- [ ] Largest Rectangle in Histogram
- [ ] Trapping Rain Water
- [ ] Sliding Window Maximum
- [ ] Minimum Window Substring

---

## 🧠 Interview Tips

### Problem Recognition

- **Counting/Frequency** → HashMap
- **Fast Lookup** → HashSet
- **Range Queries** → Prefix sums
- **Limited Range** → Array as hash table
- **Duplicates/Unique** → Set operations

### Approach Strategy

1. **Understand** the problem constraints
2. **Identify** the pattern (frequency, lookup, etc.)
3. **Choose** appropriate data structure
4. **Implement** and test edge cases
5. **Optimize** if time/space can be improved

### Time/Space Analysis

- Always discuss trade-offs between time and space
- Mention average vs worst-case scenarios
- Consider input size constraints

---

## 🔗 Related Patterns

- [Two Pointers](02_two_pointers.md) - Often combined with arrays
- [Sliding Window](03_sliding_window.md) - Subarray problems
- [Sorting](04_sorting.md) - Preprocessing for array problems
- [Binary Search](05_binary_search.md) - Search in sorted arrays

Remember: Arrays and hashing form the foundation for most other patterns. Master these first! 🚀