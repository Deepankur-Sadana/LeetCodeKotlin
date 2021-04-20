class `426 Convert Binary Search Tree to Sorted Doubly Linked List` {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    /**
     * Runtime: 156 ms, faster than 80.00% of Kotlin online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
    Memory Usage: 35 MB, less than 32.86% of Kotlin online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
     */
    fun treeToDoublyList(root: Node?): Node? {
        recurse(root)
        firstPrintedElement?.left = latestPrintedElement
        latestPrintedElement?.right = firstPrintedElement
        return firstPrintedElement

    }

    private var firstPrintedElement: Node? = null
    private var latestPrintedElement: Node? = null

    private fun recurse(root: Node?) {
        if (root == null) return
        recurse(root.left)

        val nextNodeToRecurse = root.right
        root.left = latestPrintedElement
        latestPrintedElement?.right = root
        println(root)
        latestPrintedElement = root

        if (firstPrintedElement == null)
            firstPrintedElement = root

        recurse(nextNodeToRecurse)
    }
}