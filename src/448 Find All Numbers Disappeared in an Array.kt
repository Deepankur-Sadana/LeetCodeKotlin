import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    `448 Find All Numbers Disappeared in an Array`().findDisappearedNumbers(intArrayOf(
//        4, 3, 2, 7, 8, 2, 3, 1
        1,1,2,2
    ))
}

class `448 Find All Numbers Disappeared in an Array` {


    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (i in nums.indices) {
            val curr = nums[i].absoluteValue
            if (curr < nums.size && nums[curr -1] > 0) nums[curr - 1] *= -1
        }

        val res = mutableListOf<Int>()
        if (nums.isEmpty()) return emptyList()
        var max = nums[0]
        for (i in nums.indices) {
            if (nums[i] > 0) {
                res.add(i)
            }
            max = Math.max(max, nums[i].absoluteValue)
        }
        if (max == nums.size) return res

//        for (i in max+1..nums.size) {
//            res.add(i)
//        }
        return res
    }


}