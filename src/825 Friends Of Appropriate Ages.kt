class `825 Friends Of Appropriate Ages` {

    /**
     * Runtime: 228 ms, faster than 95.24% of Kotlin online submissions for Friends Of Appropriate Ages.
    Memory Usage: 38.9 MB, less than 61.90% of Kotlin online submissions for Friends Of Appropriate Ages.
     */

    fun numFriendRequests(ages: IntArray): Int {

        val counts = IntArray(121)
        for (i in ages.indices) {
            counts[ages[i]]++
        }

        var res = 0
        for (i in counts.indices) {
            for (j in counts.indices) {
                if (j <= 0.5 * i + 7) continue
                if (j > i) continue
                if (j > 100 && i < 100) continue

                if (i == j) {
                    res += (counts[i] - 1) * counts[j]
                } else {
                    res += counts[i] * counts[j]
                }
            }
        }

        return res
    }


}