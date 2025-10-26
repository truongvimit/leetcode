import arrays.easy.Problem001_TwoSum
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class Problem001_TwoSumTest {

    private val solution = Problem001_TwoSum()

    @Test
    fun `test leetcode examples`() {
        // Example 1
        assertTrue(solution.twoSum(intArrayOf(2, 7, 11, 15), 9) contentEquals intArrayOf(0, 1))

        // Example 2  
        assertTrue(solution.twoSum(intArrayOf(3, 2, 4), 6) contentEquals intArrayOf(1, 2))

        // Example 3
        assertTrue(solution.twoSum(intArrayOf(3, 3), 6) contentEquals intArrayOf(0, 1))
    }

    @Test
    fun `test edge cases`() {
        // Minimum size
        assertTrue(solution.twoSum(intArrayOf(1, 2), 3) contentEquals intArrayOf(0, 1))

        // Negative numbers
        assertTrue(solution.twoSum(intArrayOf(-1, -2, -3, -4, -5), -8) contentEquals intArrayOf(2, 4))

        // Zero target
        assertTrue(solution.twoSum(intArrayOf(-3, 4, 3, 90), 0) contentEquals intArrayOf(0, 2))
    }

    @Test
    fun `test no solution`() {
        assertThrows<IllegalArgumentException> {
            solution.twoSum(intArrayOf(1, 2, 3), 10)
        }
    }
}