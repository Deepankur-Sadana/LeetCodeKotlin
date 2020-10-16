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

    // Constant space
    class ConstantSpace {


        /**
         *Runtime: 164 ms, faster than 99.11% of Kotlin online submissions for Copy List with Random Pointer.
        Memory Usage: 38.5 MB, less than 5.36% of Kotlin online submissions for Copy List with Random Pointer.

         */
        fun copyRandomList(node: Node?): Node? {
            if (node == null) return node
            var curr = node
            while (curr != null) {
                val incoming = Node(curr.`val`)
                val next = curr.next
                incoming.next = next
                curr.next = incoming
                curr = curr.next?.next
            }
            curr = node

            val res = node?.next
            while (curr != null) {
                val random = curr.random
                curr.next?.random = random?.next
                curr = curr.next?.next
            }
            curr = node

            while (curr != null) {
                val nextCurr = curr.next?.next
                val copy = curr.next!!
                curr.next = copy.next
                copy.next = copy.next?.next
                curr = nextCurr
            }
            return res
        }

    }
}



