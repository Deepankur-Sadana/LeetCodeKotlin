class `153 Find Minimum in Rotated Sorted Array` {


    /**
     * Runtime: 184 ms, faster than 51.46% of Kotlin online submissions for Find Minimum in Rotated Sorted Array.
     * Memory Usage: 36.2 MB, less than 76.70% of Kotlin online submissions for Find Minimum in Rotated Sorted Array.
     */
    fun findMin(nums: IntArray): Int {
        return binarySearch(0, nums.size - 1, nums)
    }

    fun binarySearch(
        left: Int,
        right: Int,
        nums: IntArray

    ): Int {
        val mid = (left + right) / 2
        if ((nums[left] <= nums[mid] && nums[mid] <= nums[right]) || (right - left) < 3) {
            return Math.min(nums[left], Math.min(nums[mid], nums[right]))
        }
        if (nums[left] > nums[mid]) {//search left
            return binarySearch(left, mid - 1, nums)
        } else if (nums[mid] > nums[right]) {//search right
            return binarySearch(mid + 1, right, nums)
        } else {
            TODO("WTF")
        }
    }

}