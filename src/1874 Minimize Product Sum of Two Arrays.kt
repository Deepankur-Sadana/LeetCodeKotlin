class `1874 Minimize Product Sum of Two Arrays` {

    /**
     * Runtime: 972 ms, faster than 33.33% of Kotlin online submissions for Minimize Product Sum of Two Arrays.
    Memory Usage: 89.7 MB, less than 25.00% of Kotlin online submissions for Minimize Product Sum of Two Arrays.

     */
    fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sortDescending()
        var result  = 0
        for (i in nums1.indices)
            result += (nums1[i] * nums2[i])
        return result
    }

}