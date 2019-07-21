package utils

class `283 Move Zeroes` {


    fun moveZeroes(nums: IntArray) {

        if (nums.size < 2) return

        var dirtyIndex = 0
        while (nums[dirtyIndex] != 0) {
            dirtyIndex++
            if (dirtyIndex == nums.size) return
        }

        var runner = dirtyIndex + 1


        while (runner != nums.size) {


            while (nums[runner] == 0) {
                runner++
                if (runner == nums.size) return
            }
            swap(nums, dirtyIndex, runner)
            dirtyIndex++
            runner++
        }

    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        val temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
}