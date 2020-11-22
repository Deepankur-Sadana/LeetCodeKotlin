@file:Suppress("NAME_SHADOWING")

fun main(args: Array<String>) {
    `809 Expressive Words`().expressiveWords("heeelloooy", arrayOf<String>("hello", "hi", "helo"))
}

class `809 Expressive Words` {


    /**
     * Runtime: 192 ms, faster than 37.93% of Kotlin online submissions for Expressive Words.
    Memory Usage: 35.3 MB, less than 37.93% of Kotlin online submissions for Expressive Words.
     */
    fun expressiveWords(S: String, words: Array<String>): Int {
        var res = 0
        val key = encode(S)
        outer@ for (index in words.indices) {
            val word = encode(words[index])
            if (key.chars != word.chars)
                continue

            for (i in key.chars.indices) {
                if (key.chars[i] != word.chars[i]) continue@outer
                if (key.freq[i] == word.freq[i]) continue
                if (key.freq[i] < word.freq[i]) continue@outer
                if (key.freq[i] > word.freq[i] && key.freq[i] < 3) continue@outer
            }
            ++res
        }
        return res
    }

    private fun encode(word: String): RLE {
        val res = RLE(word)
        if (word.isEmpty()) return res
        val word = word.toCharArray()
        var index = 0
        while (index < word.size) {
            var count = 1
            val currChar: Char = word[index]
            while (index < word.size - 1 && word[index + 1] == word[index]) {
                ++count
                ++index
            }
            ++index
            res.chars.add(currChar)
            res.freq.add(count)
        }
        return res
    }

    data class RLE(
        val word: String,
        val chars: ArrayList<Char> = ArrayList<Char>(),
        val freq: ArrayList<Int> = ArrayList<Int>()
    )


}
