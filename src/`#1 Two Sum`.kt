class `1 Two Sum` {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val res = IntArray(2)
        val map: HashMap<Int, Int> = HashMap()
        nums.forEachIndexed { index, element ->
            map[element] = index
        }
        print(map.toString())

        nums.forEachIndexed { index, element ->
            if (map.containsKey(target - element)) {
                res[0] = index
                res[1] = map[target - element]!!

                if (index != map[target - element]!!)
                    return res
            }
        }
        return res
    }
}