class `845 Longest Mountain in Array` {

    /**
    Runtime: 228 ms, faster than 46.27% of Kotlin online submissions for Longest Mountain in Array.
    Memory Usage: 38.4 MB, less than 6.72% of Kotlin online submissions for Longest Mountain in Array.
     */

    fun longestMountain(arr: IntArray): Int {
        if (arr.size < 3) return 0
        val l = IntArray(arr.size)
        val r = IntArray(arr.size)
        val sum = IntArray(arr.size)


        for (i in 1 until l.size) {
            if (arr[i] > arr[i - 1]) {
                l[i] = l[i - 1] + 1
            }
        }

        for (i in l.size - 2 downTo 0) {
            if (arr[i] > arr[i + 1]) {
                r[i] = r[i + 1] + 1
            }
        }

        var max = 0
        for (i in 0 until arr.size - 1) {
            val curr = if (l[i] + r[i] > 0 && l[i] * r[i] > 0) l[i] + r[i] + 1 else 0
            max = Math.max(max, curr)
        }
        return max
    }


    class SinglePass {

        fun longestMountain(arr: IntArray): Int {
            if (arr.size < 3) return 0
            val N = arr.size
            var base = 0

            var max = 0
            outer@while (base < N) {
                var climber = base

                while (climber < N - 1 && arr[climber + 1] > arr[climber]) {
                    ++climber
                }

                if (climber == N - 2) {
                    if (arr[climber +1] < arr[climber])
                        max = Math.max(max, climber + 1)
                    break@outer
                }
                if (climber == N - 1) {
                    break
                }

                var freeFall = 0
//                if ()

            }

            return max

        }
    }

}













