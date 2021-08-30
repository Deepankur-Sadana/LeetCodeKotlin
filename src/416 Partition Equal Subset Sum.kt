class `416 Partition Equal Subset Sum` {

    /**
     * Runtime: 593 ms, faster than 23.26% of Kotlin online submissions for Partition Equal Subset Sum.
    Memory Usage: 80.8 MB, less than 18.60% of Kotlin online submissions for Partition Equal Subset Sum.
    Next challenges:
     */
    fun canPartition(nums: IntArray): Boolean {
        var res = 0
        nums.forEach { res += it }
        if (res % 2 !=0) return false

        return canPartition(0, 0, res / 2, nums)
    }

    val map = HashMap<String, Boolean>()
    private fun canPartition(index: Int, sumSoFar: Int, target: Int, nums: IntArray): Boolean {

        if (sumSoFar == target) return true
        if (sumSoFar > target) return false
        if (index == nums.size) return false
        val key = "$index,$sumSoFar"

        val res = if(map.containsKey(key)){
            map[key]!!
        } else {
            canPartition(index + 1, sumSoFar + nums[index], target, nums) ||
                canPartition(index + 1, sumSoFar, target, nums)
        }
        map[key] = res
        return res
    }
}