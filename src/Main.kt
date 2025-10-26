import arrays.easy.Problem001_TwoSum

/**
 * Main entry point for running LeetCode solutions
 *
 * This file demonstrates how to run and test individual solutions.
 * Each solution is organized in its respective package by category and difficulty.
 */

fun main() {
    println("🚀 Welcome to LeetCode Solutions in Kotlin!")
    println("=".repeat(50))

    // Demonstrate Two Sum solution
    demonstrateTwoSum()

    println("\n✨ Check out other solutions in their respective packages:")
    println("📁 src/arrays/     - Array problems")
    println("📁 src/strings/    - String problems")
    println("📁 src/hashmaps/   - HashMap problems")
    println("📁 src/trees/      - Tree problems")
    println("📁 src/graphs/     - Graph problems")
    println("📁 And many more...")

    println("\n🧪 Run tests with: ./gradlew test")
    println("📚 Check docs/ folder for patterns and guides")
    println("\nHappy coding! 💻")
}

/**
 * Demonstrates the Two Sum solution with various test cases
 */
private fun demonstrateTwoSum() {
    println("\n🎯 Problem 1: Two Sum")
    println("-".repeat(30))

    val solution = Problem001_TwoSum()

    // Example 1
    val nums1 = intArrayOf(2, 7, 11, 15)
    val target1 = 9
    val result1 = solution.twoSum(nums1, target1)
    println("Input: nums = [${nums1.joinToString()}], target = $target1")
    println("Output: [${result1.joinToString()}]")
    println("Explanation: nums[${result1[0]}] + nums[${result1[1]}] = ${nums1[result1[0]]} + ${nums1[result1[1]]} = $target1")

    // Example 2
    println()
    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    val result2 = solution.twoSum(nums2, target2)
    println("Input: nums = [${nums2.joinToString()}], target = $target2")
    println("Output: [${result2.joinToString()}]")
    println("Explanation: nums[${result2[0]}] + nums[${result2[1]}] = ${nums2[result2[0]]} + ${nums2[result2[1]]} = $target2")

    // Example 3 - Edge case with duplicates
    println()
    val nums3 = intArrayOf(3, 3)
    val target3 = 6
    val result3 = solution.twoSum(nums3, target3)
    println("Input: nums = [${nums3.joinToString()}], target = $target3")
    println("Output: [${result3.joinToString()}]")
    println("Explanation: nums[${result3[0]}] + nums[${result3[1]}] = ${nums3[result3[0]]} + ${nums3[result3[1]]} = $target3")

    // Performance comparison
    println()
    println("⚡ Performance Comparison:")
    val largeArray = IntArray(1000) { it }
    val targetLarge = 999 + 998 // Last two elements

    val startTime = System.currentTimeMillis()
    val resultOptimal = solution.twoSum(largeArray, targetLarge)
    val optimalTime = System.currentTimeMillis() - startTime

    val startTimeBrute = System.currentTimeMillis()
    val resultBrute = solution.twoSumBruteForce(largeArray, targetLarge)
    val bruteTime = System.currentTimeMillis() - startTimeBrute

    println("Optimal Solution (HashMap): ${optimalTime}ms - Result: [${resultOptimal.joinToString()}]")
    println("Brute Force Solution: ${bruteTime}ms - Result: [${resultBrute.joinToString()}]")
    println("Speed improvement: ${if (bruteTime > 0) "${bruteTime / maxOf(optimalTime, 1)}x faster" else "N/A"}")
}