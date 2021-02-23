import java.lang.StringBuilder

fun main(args: Array<String>) {
    `415 Add Strings`().addStrings("98", "9")
}

class `415 Add Strings` {


    /**
     * Runtime: 224 ms, faster than 26.53% of Kotlin online submissions for Add Strings.
    Memory Usage: 35.9 MB, less than 46.94% of Kotlin online submissions for Add Strings.
     */
    fun addStrings(num1: String, num2: String): String {
        var i = num1.length - 1
        var j = num2.length - 1
        val res = StringBuilder()
        var carry = 0

        while (true) {
            val a = if (i < 0) 0 else Character.getNumericValue(num1.toCharArray()[i])
            val b = if (j < 0) 0 else Character.getNumericValue(num2.toCharArray()[j])
            val sum = a + b + carry
            res.insert(0, sum % 10).toString()
            carry = if (sum > 9) 1 else 0
            --i
            --j
            if (i < 0 && j < 0) break
        }

        if (carry == 1)
            res.insert(0, "1").toString()

        return res.toString()
    }
}