import java.lang.StringBuilder


fun main(args: Array<String>) {
    `1056 Confusing Number`().confusingNumber(6)
}
class `1056 Confusing Number` {

    /**
    Runtime: 132 ms, faster than 75.00% of Kotlin online submissions for Confusing Number.
    Memory Usage: 33.7 MB, less than 25.00% of Kotlin online submissions for Confusing Number.
     */
    fun confusingNumber(N: Int): Boolean {
        val map = IntArray(10)
        for (i in map.indices) {
            map[i] = when (i) {
                0 -> 0
                1 -> 1
                6 -> 9
                8 -> 8
                9 -> 6
                2, 3, 4, 5, 7 -> -1
                else -> TODO("Not implemented")
            }
        }

        val chars = N.toString().reversed().toCharArray()
        val builder = StringBuilder("")
        chars.forEach {
            val num = Character.getNumericValue(it)
            val flip = map[num]
            if (flip == -1) return false
            builder.append(flip.toString())
        }
        return builder.toString() != N.toString()

    }
}