/**
 * Problem 1: Two Sum
 * https://leetcode.com/problems/two-sum/
 * Easy | Array, Hash Table
 *
 * Given array of integers and target, return indices of two numbers that add up to target.
 *
 * Time: O(n), Space: O(n)
 */

package arrays.easy

class Problem001_TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndex = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]

            if (complement in numToIndex) {
                return intArrayOf(numToIndex[complement]!!, i)
            }

            numToIndex[nums[i]] = i
        }

        throw IllegalArgumentException("No solution")
    }
}

// Test directly in problem file
fun main() {
    val solution = Problem001_TwoSum()

    // Test cases
    println("Test 1: ${solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString()}") // [0,1]
    println("Test 2: ${solution.twoSum(intArrayOf(3, 2, 4), 6).contentToString()}")     // [1,2]
    println("Test 3: ${solution.twoSum(intArrayOf(3, 3), 6).contentToString()}")       // [0,1]
}