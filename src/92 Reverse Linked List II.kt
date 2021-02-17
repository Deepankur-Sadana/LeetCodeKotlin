class `92 Reverse Linked List II` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head?.next == null || m == n) return head
        var curr = head
        var midEnd: ListNode? = null
        var midStart: ListNode? = null
        var rightStart: ListNode? = null

        var pos = 1
        while (pos < m) {
            midStart = curr
            curr = curr!!.next
            pos++
        }

        while (pos < n) {
            midEnd = curr
            curr = curr!!.next
            pos++
        }

        if (m == 1) return midEnd
        else return head
    }

    private fun reverse(head: ListNode, tail: ListNode) {
        var curr: ListNode? = head.next
        var prev = head
        while (curr != null) {

            curr.next = prev
        }
    }
}









