class `1470 Shuffle the Array` {


    /**
     * Runtime: 384 ms, faster than 5.39% of Kotlin online submissions for Shuffle the Array.
    Memory Usage: 39.3 MB, less than 16.17% of Kotlin online submissions for Shuffle the Array.

     */
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val res = IntArray(n * 2)
        var i = 0
        var j = n

        var writer = 0
        while (writer < nums.size) {
            res[writer++]= nums[i++]
            res[writer++]= nums[j++]
        }
        return res
    }

}