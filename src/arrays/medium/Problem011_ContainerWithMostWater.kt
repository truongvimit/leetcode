/**
 * Problem 11: ContainerWithMostWater
 * https://leetcode.com/problems/container-with-most-water/
 * medium | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package arrays.medium

class Problem011_ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var result = 0
        for (i in 0 until height.size){
            for (j in i+1 until height.size){
                val square = if (height[i] > height[j]){
                    height[j] * (j - i)
                }else{
                    height[i] * (j - i)
                }
                if (square > result) result = square
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
