class `1313 Decompress Run-Length Encoded List` {

    /**
     * Runtime: 212 ms, faster than 88.46% of Kotlin online submissions for Decompress Run-Length Encoded List.
        Memory Usage: 36.1 MB, less than 98.72% of Kotlin online submissions for Decompress Run-Length Encoded List.
     */
    fun decompressRLElist(nums: IntArray): IntArray {
        var freq = 0
        for (i in 0 until nums.size step 2) {
            freq += nums[i]
        }
        val result = IntArray(freq)
        var curr = 0
        for (i in 0 until nums.size step 2) {
            for (j in 0 until nums[i]) {
                result[curr++] = nums[i+1]
            }
        }
        return result
    }
}