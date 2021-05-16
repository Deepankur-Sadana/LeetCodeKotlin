import java.lang.StringBuilder
import java.util.*

/**
 * Runtime: 248 ms, faster than 100.00% of Kotlin online submissions for Smallest String With A Given Numeric Value.
Memory Usage: 37.6 MB, less than 66.67% of Kotlin online submissions for Smallest String With A Given Numeric Value.

 */
class `1663 Smallest String With A Given Numeric Value` {

    fun getSmallestString(n: Int, k: Int): String {
        if (26 * n < k) return ""
        var sumSoFar = n
        val arr = IntArray(n) { 1 }
        for (i in arr.size - 1 downTo 0) {
            val diff = Math.min(25,(k - sumSoFar))
            if (diff < 25) {
                arr[i] += diff
                break
            } else {
                arr[i] += 25
            }
            sumSoFar += diff
        }
        val res = StringBuilder()
        arr.forEach {
            // print(it)
            res.append( 'a' + it - 1)
        }
        return res.toString()
    }

}