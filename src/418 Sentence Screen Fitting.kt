class `418 Sentence Screen Fitting` {

    /**
     * Runtime: 2188 ms, faster than 10.53% of Kotlin online submissions for Sentence Screen Fitting.
    Memory Usage: 34.3 MB, less than 63.16% of Kotlin online submissions for Sentence Screen Fitting.

     */

    fun wordsTyping(sentence: Array<String>, rows: Int, cols: Int): Int {
        var inserted = 0
        var currentWord = 0
        for (r in 0 until rows) {
            var remaining = cols
            val currentWordStr = sentence.get(currentWord)
            var lengthOfCurrentWord = sentence.get(currentWord).length

            while (remaining >= lengthOfCurrentWord) {
                remaining -= lengthOfCurrentWord
                currentWord = if (currentWord == sentence.size - 1) 0 else currentWord + 1
                inserted++
                remaining-- //adding dash (If there is space)
                lengthOfCurrentWord = sentence.get(currentWord).length
            }
        }
        return inserted / sentence.size
    }

}