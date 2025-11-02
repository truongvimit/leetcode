/**
 * Problem 11: ContainerWithMostWater
 * https://leetcode.com/problems/container-with-most-water/
 * medium | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package arrays.medium

import kotlin.math.max
import kotlin.math.min

class Problem011_ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var result = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            val lineHeight = min(height[left], height[right])
            result = max(result, lineHeight * (right - left))
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return result
    }
}

// Test directly in problem file
fun main() {
    val solution = Problem011_ContainerWithMostWater()

    // Test cases
    println("=== Problem 11: ContainerWithMostWater ===")
    // TODO: Add test cases
    // solution.solve()
    println("✅ Tests completed!")
}
