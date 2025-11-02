/**
 * Problem 14: LongestCommonPrefix
 * https://leetcode.com/problems/longest-common-prefix/
 * easy | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package arrays.easy

/*
Input: strs = ["flower","flow","flight"]
Output: "fl"
* */

class Problem014_LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val first = strs[0]
        val sb = StringBuilder()

        for (i in first.indices) {
            val ch = first[i]
            for (j in 1 until strs.size) {
                if (i >= strs[j].length || strs[j][i] != ch) {
                    return sb.toString()
                }
            }
            sb.append(ch)
        }
        return sb.toString()
    }
}

// Test directly in problem file
fun main() {
    val solution = Problem014_LongestCommonPrefix()

    // Test cases
    val result = solution.longestCommonPrefix(arrayOf("ab", "a"))
    // TODO: Add test cases
    // solution.solve()
    println(result)
}
