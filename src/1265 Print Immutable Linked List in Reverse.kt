class `1265 Print Immutable Linked List in Reverse` {

    /**
     * Runtime: 164 ms, faster than 77.78% of Kotlin online submissions for Print Immutable Linked List in Reverse.
     * Memory Usage: 34 MB, less than 72.22% of Kotlin online submissions for Print Immutable Linked List in Reverse.
     */

    fun printLinkedListInReverse(head: ImmutableListNode?) {
        if (head == null) return
        printLinkedListInReverse(head.getNext())
        head.printValue()
    }
}

/**
 * Runtime: 260 ms, faster than 16.67% of Kotlin online submissions for Print Immutable Linked List in Reverse.
    Memory Usage: 34.9 MB, less than 5.55% of Kotlin online submissions for Print Immutable Linked List in Reverse.

 */
//O(N^2)
fun printLinkedListInReverse(head: ImmutableListNode?) {
    if (head?.getNext() == null) {
        head?.printValue()
        return
    }

    var last: ImmutableListNode? = null
    var curr = head!!
    while (curr.getNext() != null) {
        curr = curr.getNext()!!
    }
    last = curr
    last!!.printValue()
    while (last != head) {
        curr = head
        while (curr.getNext() != last)
            curr = curr.getNext()!!
        curr.printValue()
        last = curr
    }
}

class ImmutableListNode {
    fun getNext(): ImmutableListNode? {
        TODO()
    } // return the next node.

    fun printValue() {} // print the value of this node.
}