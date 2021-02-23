class `88 Merge Sorted Array` {


    /**
     *
     * Runtime: 172 ms, faster than 60.86% of Kotlin online submissions for Merge Sorted Array.
    Memory Usage: 35.3 MB, less than 95.23% of Kotlin online submissions for Merge Sorted Array.
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for (i in m - 1 downTo 0) {
            nums1[i + n] = nums1[i]
        }
        print(nums1.contentToString())

        var a = n
        var b = 0

        var writter = 0

        while (writter < m + n) {

            if (a == m + n) {
                nums1[writter++] = nums2[b]
                b++
                continue
            }

            if (b == n) {
                nums1[writter++] = nums1[a]
                a++
                continue
            }

            if (nums1[a] < nums2[b]) {
                nums1[writter++] = nums1[a]
                a++
            } else {
                nums1[writter++] = nums2[b]
                b++
            }
        }

    }
}