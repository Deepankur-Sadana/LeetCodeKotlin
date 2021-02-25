import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    `41 First Missing Positive`().firstMissingPositive(intArrayOf(1, 2, 6, 3, 5, 4))

}

class `41 First Missing Positive` {

    /**
     *
     * Runtime: 144 ms, faster than 96.20% of Kotlin online submissions for First Missing Positive.
    Memory Usage: 33.9 MB, less than 96.20% of Kotlin online submissions for First Missing Positive.

     */
    fun firstMissingPositive(nums: IntArray): Int {
        var found = false
        for (i in nums.indices) {
            if (nums[i] == 1) found = true
            if (nums[i] < 1 || nums[i] > nums.size) {
                nums[i] = 1
            }
        }
        if (!found) return 1

        if (nums.size == 1 && found) return 2
        for (i in nums.indices) {
            val curr = nums[i].absoluteValue
            if (curr < nums.size && nums[curr] > 0) {
                nums[curr] *= -1
            }
        }

        var max = nums[0].absoluteValue
        for (i in 1 until nums.size) {
            if (nums[i] > 0) return i
            max = Math.max(max, nums[i].absoluteValue)
        }
        return max + 1
    }
}