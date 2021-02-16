@Suppress("UNREACHABLE_CODE")
class `1669 Merge In Between Linked Lists` {


    /**
     * Runtime: 488 ms, faster than 82.35% of Kotlin online submissions for Merge In Between Linked Lists.
    Memory Usage: 43.8 MB, less than 100.00% of Kotlin online submissions for Merge In Between Linked Lists.
     */
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var leftEnd: ListNode? = null
        var rightStart: ListNode? = null
        val midEnd: ListNode?

        var curr: ListNode? = list1
        var currIndex = 0

        while (curr != null) {
            if (currIndex +1 == a) {
                leftEnd = curr
                break
            }
            currIndex++
            curr = curr.next
        }

        while (curr != null) {
            if (currIndex == b) {
                rightStart = curr.next
                break
            }
            currIndex++
            curr = curr.next
        }

        curr = list2
        while (true) {
            if (curr?.next == null) {
                midEnd = curr
                break
            }
            curr = curr.next
        }

        leftEnd?.next = list2
        midEnd?.next = rightStart

        return list1
    }
}


