fun main(args: Array<String>) {
    `1304 Find N Unique Integers Sum up to Zero`().moreElegant(5)
}

class `1304 Find N Unique Integers Sum up to Zero` {


    /**
     * Runtime: 202 ms, faster than 20.00% of Kotlin online submissions for Find N Unique Integers Sum up to Zero.
    Memory Usage: 35.1 MB, less than 93.33% of Kotlin online submissions for Find N Unique Integers Sum up to Zero.
     */
    fun sumZero(n: Int): IntArray {
        if (n == 0) return IntArray(0)
        if (n == 1) return IntArray(1)
        val res = IntArray(n)
        val isOdd = n / 2 == 0
        val mid = n / 2
        var l = 0
        var r = 0
        var curr = 1
        if (isOdd) {
            l = mid - 1
            r = mid + 1
        } else {
            r = mid
            l = mid - 1
        }
        while (l >= 0) {
            res[l] = curr * -1
            res[r] = curr * 1
            curr += 1
            l--
            r++
        }
        return res
    }

    /**
     *
    Runtime: 230 ms, faster than 10.00% of Kotlin online submissions for Find N Unique Integers Sum up to Zero.
    Memory Usage: 35.4 MB, less than 70.00% of Kotlin online submissions for Find N Unique Integers Sum up to Zero.
     */
    fun moreElegant(n: Int): IntArray {
        val res = IntArray(n)
        if(n == 1) return res
        var l = 0
        var r = n - 1
        var start = 1
        while (true) {
            res[l++] = start * -1
            res[r--] = start
            start++
            if (r-l<1) return res
        }

    }
}