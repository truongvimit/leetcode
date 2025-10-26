import arrays.easy.Problem001_TwoSum
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class Problem001_TwoSumTest {

    private val solution = Problem001_TwoSum()

    @Test
    fun `test example 1 - basic case`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test example 2 - different order`() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test example 3 - duplicate numbers`() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test minimum array size`() {
        val nums = intArrayOf(1, 2)
        val target = 3
        val expected = intArrayOf(0, 1)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test negative numbers`() {
        val nums = intArrayOf(-1, -2, -3, -4, -5)
        val target = -8
        val expected = intArrayOf(2, 4)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test mixed positive and negative`() {
        val nums = intArrayOf(-3, 4, 3, 90)
        val target = 0
        val expected = intArrayOf(0, 2)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test zero target`() {
        val nums = intArrayOf(0, 4, 3, 0)
        val target = 0
        val expected = intArrayOf(0, 3)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test large numbers`() {
        val nums = intArrayOf(1000000, 2000000, 3000000)
        val target = 3000000
        val expected = intArrayOf(0, 1)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test solution at end of array`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val target = 13
        val expected = intArrayOf(5, 6)

        val result = solution.twoSum(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test no solution throws exception`() {
        val nums = intArrayOf(1, 2, 3)
        val target = 10

        assertThrows<IllegalArgumentException> {
            solution.twoSum(nums, target)
        }
    }

    // Test brute force solution
    @Test
    fun `test brute force solution - example 1`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)

        val result = solution.twoSumBruteForce(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test brute force solution - duplicate numbers`() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)

        val result = solution.twoSumBruteForce(nums, target)
        assertTrue(result contentEquals expected)
    }

    @Test
    fun `test brute force - no solution throws exception`() {
        val nums = intArrayOf(1, 2, 3)
        val target = 10

        assertThrows<IllegalArgumentException> {
            solution.twoSumBruteForce(nums, target)
        }
    }

    // Test two-pass solution
    @Test
    fun `test two pass solution - example 1`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9

        val result = solution.twoSumTwoPass(nums, target)
        // Result could be [0,1] or [1,0] due to different traversal order
        assertTrue((result contentEquals intArrayOf(0, 1)) || (result contentEquals intArrayOf(1, 0)))
    }

    @Test
    fun `test two pass solution - handles same element correctly`() {
        // This test ensures we don't use the same element twice
        val nums = intArrayOf(3, 2, 3)
        val target = 6
        val expected = intArrayOf(0, 2)

        val result = solution.twoSumTwoPass(nums, target)
        assertTrue(result contentEquals expected)
    }

    // Performance test (commented out for regular runs, uncomment for performance testing)
    /*
    @Test
    fun `performance test - large array`() {
        val size = 10000
        val nums = IntArray(size) { it }
        val target = size - 1 + size - 2 // Last two elements
        
        val startTime = System.currentTimeMillis()
        val result = solution.twoSum(nums, target)
        val endTime = System.currentTimeMillis()
        
        assertTrue(result contentEquals intArrayOf(size - 2, size - 1))
        assertTrue(endTime - startTime < 100) // Should complete in under 100ms
    }
    */

    @Test
    fun `test all solutions return same result`() {
        val nums = intArrayOf(3, 2, 4, 15, 7)
        val target = 9

        val result1 = solution.twoSum(nums, target)
        val result2 = solution.twoSumBruteForce(nums, target)
        val result3 = solution.twoSumTwoPass(nums, target)

        // All solutions should find valid indices that sum to target
        assertEquals(target, nums[result1[0]] + nums[result1[1]])
        assertEquals(target, nums[result2[0]] + nums[result2[1]])
        assertEquals(target, nums[result3[0]] + nums[result3[1]])
    }
}

/**
 * Test Coverage Summary:
 *
 * ✅ All LeetCode examples (1, 2, 3)
 * ✅ Edge cases:
 *    - Minimum array size (2 elements)
 *    - Negative numbers
 *    - Zero values
 *    - Large numbers
 *    - Mixed positive/negative
 * ✅ Error conditions:
 *    - No solution exists
 * ✅ Algorithm variations:
 *    - Optimal HashMap solution
 *    - Brute force solution
 *    - Two-pass HashMap solution
 * ✅ Performance considerations:
 *    - Large array handling (optional test)
 * ✅ Correctness verification:
 *    - All solutions return valid results
 */