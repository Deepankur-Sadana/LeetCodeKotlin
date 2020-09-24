class `1265 Print Immutable Linked List in Reverse` {

    /**
     * Runtime: 164 ms, faster than 77.78% of Kotlin online submissions for Print Immutable Linked List in Reverse.
        Memory Usage: 34 MB, less than 72.22% of Kotlin online submissions for Print Immutable Linked List in Reverse.

     */

    fun printLinkedListInReverse(head: ImmutableListNode?) {
        if (head == null) return
        printLinkedListInReverse(head.getNext())
        head.printValue()
    }
}


class ImmutableListNode {
    fun getNext(): ImmutableListNode? {
        TODO()
    } // return the next node.
    fun printValue() {} // print the value of this node.
}