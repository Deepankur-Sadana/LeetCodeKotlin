import kotlin.math.absoluteValue

class `1509 Minimum Difference Between Largest and Smallest Value in Three Moves` {

    /**
     * Runtime: 384 ms, faster than 72.41% of Kotlin online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
    Memory Usage: 51.9 MB, less than 51.72% of Kotlin online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.

     */
    fun minDifference(nums: IntArray): Int {
        nums.sort()
        if (nums.size < 4) return 0
        val diffAfterRemovingAllMin = nums[nums.size - 1] - nums[3]
        val diffAfterRemovingAllMAx = nums[nums.size - 4] - nums[0]
        val remove2fromStartOneFromEnd = nums[nums.size - 2] - nums[2]
        val remove1FromStartAnd2FromEnd = nums[nums.size - 3] - nums[1]
        return min(
            diffAfterRemovingAllMin,
            diffAfterRemovingAllMAx,
            remove2fromStartOneFromEnd,
            remove1FromStartAnd2FromEnd
        )
    }

    fun min(vararg nums: Int): Int {
        var min = nums[0].absoluteValue
        nums.forEach { print(it) }
        println("........")
        for (i in 1 until nums.size)
            min = Math.min(min, nums[i].absoluteValue)
        return min
    }

}


