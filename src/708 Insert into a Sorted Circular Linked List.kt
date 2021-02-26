class `708 Insert into a Sorted Circular Linked List` {

    class Node(var `val`: Int) {
        var next: Node? = null
    }

    fun insert(head: Node?, insertVal: Int): Node? {
        if (head == null) {
            val node = Node(insertVal)
            node.next = node
            return node
        } else if (head.next == head) {
            val node = Node(insertVal)
            head.next = node
            node.next = head
            return head
        }
        var slow = head
        var fast = head.next

        while (true) {
            if (insertVal >= slow!!.`val` && insertVal <= fast!!.`val`) {
                val node = Node(insertVal)
                slow.next = node
                node.next = fast
                break
            } else if (insertVal <= fast!!.`val` && insertVal <= slow.`val` && fast.`val` >= slow.`val`) {
                val node = Node(insertVal)
                slow.next = node
                node.next = fast
                break
            }
            slow = slow.next
            fast = fast!!.next
            if (slow == head) {// back to square 1
                val node = Node(insertVal)
                head.next = node
                node.next = fast
                break
            }
        }
        return head
    }


}