class `426 Convert Binary Search Tree to Sorted Doubly Linked List` {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    fun treeToDoublyList(root: Node?): Node? {
TODO()
    }

    fun recurse(root: Node?) {
        if (root == null) return
        recurse(root.left)
        ///
        recurse(root.right)
    }
}