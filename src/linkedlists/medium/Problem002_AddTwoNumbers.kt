/**
 * Problem 002: AddTwoNumbers
 * https://leetcode.com/problems/add-two-numbers/
 * medium | TODO: Add tags
 *
 * TODO: Add description
 * Time: O(?), Space: O(?)
 */

package linkedlists.medium

class Problem002_AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        var stringNumber1 = ""
        var stringNumber2 = ""
        var current = l1
        while (current != null){
            stringNumber1 = current.`val`.toString() + stringNumber1
            current = current.next
        }
        current = l2
        while (current != null){
            stringNumber2 = current.`val`.toString() + stringNumber2
            current = current.next
        }
        val sum = (stringNumber1.toLong() + stringNumber2.toLong()).toString()
        val listNumber = sum.map { it - '0' }
        val resultNode = ListNode(listNumber.last())
        current = resultNode
        for (i in listNumber.lastIndex - 1 downTo  0){
            val newNode = ListNode(listNumber[i])
            current?.next = newNode
            current = newNode
        }
        return resultNode
    }
}

fun main() {
    val a = ListNode(1)
    val b = ListNode(2)
    Problem002_AddTwoNumbers().addTwoNumbers(a, b)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}