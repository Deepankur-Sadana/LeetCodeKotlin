fun main(args: Array<String>) {
    `443 String Compression`().compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'))
}

/**
 * Runtime: 176 ms, faster than 84.62% of Kotlin online submissions for String Compression.
Memory Usage: 34.9 MB, less than 7.69% of Kotlin online submissions for String Compression.
 */
class `443 String Compression` {

    fun compress(chars: CharArray): Int {
        var from = 0
        var writter = 0
        while (true) {
            val readResult = read(chars, from)
            chars[writter++] = readResult.char
            val freq = readResult.frequency.toString().toCharArray()
            if (readResult.frequency > 1)
                freq.forEach {
                    chars[writter++] = it
                }
            if (readResult.cursor == chars.size) break
            from = readResult.cursor
        }
        return writter
    }

    /**
     * from is inclusive
     * ReadResult#cursor is exclusive
     */
    private fun read(chars: CharArray, from: Int): ReadResult {
        if (from == chars.size) throw ArrayIndexOutOfBoundsException("cannot read character at idx $from")
        var count = 0
        var index = from
        while (index < chars.size && chars[index] == chars[from]) {
            count++
            index++
        }
        return ReadResult(chars[from], count, index)
    }

    data class ReadResult(val char: Char, val frequency: Int, val cursor: Int)
}