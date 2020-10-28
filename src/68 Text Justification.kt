import java.lang.StringBuilder


fun main(args: Array<String>) {
    `68 Text Justification`().fullJustify(
        arrayOf("This", "is", "an", "example", "of", "text", "justification."),
        16
    )
}

class `68 Text Justification` {

    /**
     * Runtime: 180 ms, faster than 65.52% of Kotlin online submissions for Text Justification.
    Memory Usage: 34.6 MB, less than 17.24% of Kotlin online submissions for Text Justification.
     */
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {

        val res = ArrayList<String>()
        var index = 0

        while (index != words.size) {
            val list = ArrayList<String>()
            var widthLeft = maxWidth - words[index].length
            list.add(words[index])
            index++

            while (widthLeft > 0 && index < words.size) {
                if (words[index].length + 1 <= widthLeft) {
                    widthLeft -= words[index].length + 1
                    list.add(words[index])
                    index++
                } else {
                    break
                }
            }

            val builder = StringBuilder()

            if (index == words.size) {
                builder.append(list[0])
                for (i in 1 until list.size) {
                    builder.append(" ")
                    builder.append(list[i])
                    builder.length
                }
                while (builder.length != maxWidth) {
                    builder.append(" ")
                }
            } else {
                if (list.size > 1) {
                    val tabs = list.size - 1
                    var totalBlackChars = 0
                    list.forEach { totalBlackChars += it.length }
                    val totalWhiteSpace = maxWidth - totalBlackChars
                    val minSpace = totalWhiteSpace / tabs
                    var extraPadding = totalWhiteSpace % tabs

                    for (element in 0..list.size - 2) {
                        builder.append(list[element])
                        for (i in 0 until minSpace) {
                            builder.append(" ")
                        }
                        if (extraPadding > 0) {
                            builder.append(" ")
                            extraPadding--
                        }
                    }
                    builder.append(list.last())
                } else {
                    builder.append(list[0])
                    while (builder.length != maxWidth) {
                        builder.append(" ")
                    }
                }
            }

            res.add(builder.toString())

        }

        return res
    }
}