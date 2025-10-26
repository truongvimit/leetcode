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
 * You may assume that each input would have exactly one solution, and you may not use the
 * same element twice. You can return the answer in any order.
 *
 * Algorithm Approach:
 * 1. Use a HashMap to store complements and their indices as we iterate through the array.
 * 2. For each number, check if its complement (target - current number) exists in the HashMap.
 * 3. If found, return the indices. If not, add the current number and its index to the HashMap.
 *
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(n) - HashMap storage in worst case
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists
 */

package arrays.easy

class Problem001_TwoSum {

    /**
     * Optimal solution using HashMap
     *
     * Approach:
     * - Use a HashMap to store numbers we've seen and their indices
     * - For each number, check if its complement exists in the map
     * - If yes, return the indices; if no, add current number to map
     *
     * Time: O(n), Space: O(n)
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndex = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]

            // Check if complement exists in our map
            if (numToIndex.containsKey(complement)) {
                return intArrayOf(numToIndex[complement]!!, i)
            }

            // Store current number and its index
            numToIndex[nums[i]] = i
        }

        // This should never happen given the problem constraints
        throw IllegalArgumentException("No two sum solution exists")
    }

    /**
     * Brute force solution (for educational purposes)
     *
     * Approach:
     * - Check every pair of numbers in the array
     * - Return indices when sum equals target
     *
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

    /**
     * Two-pass HashMap solution (alternative approach)
     *
     * Approach:
     * - First pass: Store all numbers and their indices in HashMap
     * - Second pass: Look for complement of each number
     *
     * Time: O(n), Space: O(n)
     */
    fun twoSumTwoPass(nums: IntArray, target: Int): IntArray {
        val numToIndex = mutableMapOf<Int, Int>()

        // First pass: store all numbers
        for (i in nums.indices) {
            numToIndex[nums[i]] = i
        }

        // Second pass: look for complements
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (numToIndex.containsKey(complement) && numToIndex[complement] != i) {
                return intArrayOf(i, numToIndex[complement]!!)
            }
        }

        throw IllegalArgumentException("No two sum solution exists")
    }
}

/**
 * Interview Tips:
 *
 * 1. Always ask about constraints (array size, number range, duplicates allowed?)
 * 2. Clarify if we can use the same element twice (answer: no)
 * 3. Ask about return format (indices vs values, order matters?)
 * 4. Start with brute force, then optimize
 * 5. Explain trade-offs between time and space complexity
 *
 * Follow-up questions you might be asked:
 * - What if the array is sorted? (Use two pointers)
 * - What if we need to return values instead of indices?
 * - What if multiple solutions exist?
 * - What if no solution exists? (Handle gracefully)
 * - What if the array is very large? (Consider memory usage)
 */