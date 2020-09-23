class `26 Remove Duplicates from Sorted Array` {

    fun removeDuplicates(nums: IntArray): Int {
        var slow = 0

        for (fast in 1 until nums.size) {
            if(nums[slow] != nums[fast]){
                nums[slow+1] = nums[fast]
            ++slow
            }

        }
        return slow
    }
}