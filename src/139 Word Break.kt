class `139 Word Break` {

    /**
     * Success
    Details
    Runtime: 548 ms, faster than 6.52% of Kotlin online submissions for Word Break.
    Memory Usage: 52.3 MB, less than 5.07% of Kotlin online submissions for Word Break.

     */
    fun wordBreak(word: String, wordDict: List<String>): Boolean {
        val set = HashSet<String>()
        val dirtyMap = HashSet<String>()
        wordDict.forEach { set.add(it) }

        return compose(word, set, dirtyMap)
    }

    private fun compose(
        word: String, set: HashSet<String>, dirtyMap: HashSet<String>
    ): Boolean {
        if (word == "") return true
        if (dirtyMap.contains(word)) return false
        if (set.contains(word)) return true
        for (i in 1 until word.length) {
            val left = word.substring(0, i)
            val right = word.substring(i, word.length)
            val lhs = compose(left, set, dirtyMap)
            val rhs = compose(right, set, dirtyMap)
            if (lhs && rhs) {
                set.add(word)
                return true
            }
        }
        dirtyMap.add(word)
        return false
    }
}