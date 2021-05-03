class `238 Product of Array Except Self` {


    /**
     * Runtime: 304 ms, faster than 62.98% of Kotlin online submissions for Product of Array Except Self.
    Memory Usage: 44.3 MB, less than 78.37% of Kotlin online submissions for Product of Array Except Self.

     Without extra space
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.isEmpty()) return IntArray(0)
        val first = IntArray(nums.size)
        first[0] = 1

        for (i in 1 until nums.size) {
            first[i] = first[i - 1] * nums[i - 1]
        }
        var lastElement = nums[nums.size - 1]
        var multSoFar = 1

        for (i in nums.size - 1 downTo 0) {
            first[i]*=  multSoFar
            lastElement = nums[i]
            multSoFar *= lastElement

        }

        return first
    }

    /**
     *     fun productExceptSelf(nums: IntArray): IntArray {
    if (nums.isEmpty()) return IntArray(0)
    val first = IntArray(nums.size)
    first[0] = 1

    for (i in 1 until nums.size) {
    first[i] = first[i - 1] * nums[i - 1]
    }
    val second = IntArray(nums.size)
    second[nums.size - 1] = 1
    for (i in nums.size - 2 downTo 0) {
    second[i] = second[i + 1] * nums[i + 1]
    }

    for (i in first.indices) {
    first[i] *= second[i]
    }
    return first
    }
     */
}