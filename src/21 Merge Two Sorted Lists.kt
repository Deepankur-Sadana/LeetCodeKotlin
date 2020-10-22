class `21 Merge Two Sorted Lists` {


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Runtime: 160 ms, faster than 92.01% of Kotlin online submissions for Merge Two Sorted Lists.
    Memory Usage: 34.4 MB, less than 19.53% of Kotlin online submissions for Merge Two Sorted Lists.

     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return null
        }
        if (l1 == null) return l2
        if (l2 == null) return l1

        var l1: ListNode? = l1
        var l2: ListNode? = l2
        var merge: ListNode? = null
        var curr: ListNode? = null
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                if (curr == null) {
                    curr = l1
                } else {
                    curr.next = l1
                    curr = curr.next
                }
                l1 = l1.next
            } else {
                if (curr == null) {
                    curr = l2
                } else {
                    curr.next = l2
                    curr = curr.next
                }
                l2 = l2.next
            }
            if (merge == null) {
                merge = curr
            }
        }
        if (l1 == null) {
            curr!!.next = l2
        }
        if (l2 == null) {
            curr!!.next = l1
        }
        return merge

    }
}