class `953 Verifying an Alien Dictionary` {

    /**
     * Runtime: 172 ms, faster than 64.82% of Kotlin online submissions for Verifying an Alien Dictionary.
    Memory Usage: 35 MB, less than 100.00% of Kotlin online submissions for Verifying an Alien Dictionary.

     */
    val map = LinkedHashMap<Char, Int>()
    fun isAlienSorted(words: Array<String>, order: String): Boolean {

        order.toCharArray().forEachIndexed { index, element ->
            map[element] = index
        }
        for (i in 0..words.size - 2) {
            if (isSorted(words[i], words[i + 1]).not()) return false
        }
        return true
    }

    private fun isSorted(left: String, right: String): Boolean {
        var a = 0
        var b = 0

        var found = false
        while (a < left.length && b < right.length) {
            if (map[left[a]]!! > map[right[b]]!!) {
                return false
            }

            if (map[left[a]]!! < map[right[b]]!!) {
                return true
            }


            ++a
            ++b
        }

        if (left.length>right.length) return false

        return true
    }
}