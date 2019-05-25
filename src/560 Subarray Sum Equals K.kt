class `560 Subarray Sum Equals K` {


    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var sumSoFar = 0
        val map = HashMap<Int,Int>()
        nums.forEach {

            sumSoFar += it
            if(sumSoFar ==k){
                ++count
            }
            if(map.contains(sumSoFar-k)){
                count += map.get(sumSoFar - k)!!

            }


            map.put(sumSoFar,map.getOrDefault(sumSoFar,0)+1)

        }
        return count
    }
}