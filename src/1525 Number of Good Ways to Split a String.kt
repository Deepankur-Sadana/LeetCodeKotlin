class `1525 Number of Good Ways to Split a String` {

    /**
     * Runtime: 204 ms, faster than 75.00% of Kotlin online submissions for Number of Good Ways to Split a String.
    Memory Usage: 35.9 MB, less than 100.00% of Kotlin online submissions for Number of Good Ways to Split a String.
     */
    fun numSplits(s: String): Int {
        if (s.length <= 1) return 0
        if (s.length == 2) return 1

        val rhs = IntArray(26)
        val lhs = IntArray(26)
        val charArray = s.toCharArray()
        for (element in charArray) {
            rhs[element - 'a']++
        }

        var goodSplits = 0
        for (i in charArray.indices) {
            rhs[charArray[i] - 'a']--
            lhs[charArray[i] - 'a']++
            if (isGoodSpilt(rhs,lhs))
                goodSplits++
        }
        return goodSplits
    }

    fun isGoodSpilt(rhs: IntArray, lhs: IntArray):Boolean{
        var rhsCount = 0
        var lhsCount = 0
        rhs.forEach { if (it > 0) rhsCount++ }
        lhs.forEach { if (it > 0) lhsCount++ }
        return rhsCount == lhsCount
    }
}