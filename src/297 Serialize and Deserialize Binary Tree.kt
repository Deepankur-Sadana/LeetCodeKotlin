import java.util.*
import kotlin.collections.ArrayList

class `297 Serialize and Deserialize Binary Tree` {


    /**
     * Runtime: 3816 ms, faster than 5.77% of Kotlin online submissions for Serialize and Deserialize Binary Tree.
    Memory Usage: 719.6 MB, less than 5.77% of Kotlin online submissions for Serialize and Deserialize Binary Tree.

     */
    class Codec() {
        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            if (root == null) return ""
            var builder = ""
            builder+=root.`val`
            val list = ArrayList<Int?>()
            recurse(list, root)
            for (i in 1 until list.size)
                builder += ", ${list[i]}"
            return builder
        }


        private fun convertIntoList(input : String): List<String> {
            val result: List<String> = input.split(",").map {  it.trim() }
            result .forEach { print( "$it ") }
            return result
        }

        fun recurse(list: ArrayList<Int?>, root: TreeNode?) {
            if (root == null) {
                list.add(null)
                return
            }
            list.add(root.`val`)
            recurse(list, root.left)
            recurse(list, root.right)

        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            if (data.isBlank()) return null
            val list = convertIntoList(data)
            val queue: Queue<String> = LinkedList<String>(list)
            if (queue.isEmpty()) return null
            val root = TreeNode(queue.poll().toInt())
            recurse(root, queue)
            return root
        }

        private fun recurse(root: TreeNode?, queue: Queue<String>) {
            if (root == null) return
            if (queue.isEmpty()) return

            val poll = queue.poll()
            if (poll != "null") {
                root.left = TreeNode(poll.toInt())
                recurse(root.left, queue)
            }
            if (queue.isEmpty()) return

            val pollAgain = queue.poll()
            if (pollAgain != "null") {
                root.right = TreeNode(pollAgain.toInt())
                recurse(root.right, queue)
            }
        }

    }
}