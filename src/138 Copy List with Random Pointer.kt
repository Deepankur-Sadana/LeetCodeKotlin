class `138 Copy List with Random Pointer` {

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    /**
     * Runtime: 176 ms, faster than 80.36% of Kotlin online submissions for Copy List with Random Pointer.
    Memory Usage: 35 MB, less than 5.36% of Kotlin online submissions for Copy List with Random Pointer.
     */
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return node
        val map = HashMap<Node, Node>()
        var curr = node
        while (curr != null) {
            map[curr] = Node(curr.`val`)
            curr = curr.next
        }
        curr = node
        while (curr != null) {
            val copy = map[curr]!!
            copy.next = map[curr]!!.next
            copy.random = map[curr]!!.random
            curr = curr.next
        }
        return map[node]
    }
}


