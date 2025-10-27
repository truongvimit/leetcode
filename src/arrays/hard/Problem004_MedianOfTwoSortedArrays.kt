/**
 * Problem 4: MedianOfTwoSortedArrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * hard | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package arrays.hard

import kotlin.math.roundToInt

class Problem004_MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalArrays = IntArray(nums1.size + nums2.size)
        for (i in 0 until totalArrays.size) {
            if (i < nums1.size) {
                totalArrays[i] = nums1[i]
            } else {
                totalArrays[i] = nums2[i - nums1.size]
            }
        }
        for (i in 0 until totalArrays.size) {
            for (j in i + 1 until totalArrays.size) {
                val a = totalArrays[i]
                if (totalArrays[i] > totalArrays[j]) {
                    totalArrays[i] = totalArrays[j]
                    totalArrays[j] = a
                }
            }
        }
        return if (totalArrays.size % 2 == 0) {
            val middle = totalArrays.size / 2
            (totalArrays[middle].toDouble() + totalArrays[middle - 1]) / 2
        } else {
            val middle = totalArrays.size / 2
            totalArrays[middle].toDouble()
        }
    }
}

// Test directly in problem file
fun main() {
    val solution = Problem004_MedianOfTwoSortedArrays()

    solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))

}