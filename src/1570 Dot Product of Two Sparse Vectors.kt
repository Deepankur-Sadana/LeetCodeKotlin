import java.util.*
import kotlin.collections.LinkedHashMap

/**
 * Runtime: 808 ms, faster than 15.15% of Kotlin online submissions for Dot Product of Two Sparse Vectors.
Memory Usage: 48.3 MB, less than 6.06% of Kotlin online submissions for Dot Product of Two Sparse Vectors.

 */

class `1570 Dot Product of Two Sparse Vectors` {

    class SparseVector(nums: IntArray) {
        private val positiveNum = ArrayList<Pair<Int, Int>>()// index, num

        init {
            nums.forEachIndexed { index, num -> if (num != 0) positiveNum.add(Pair(index, num)) }
        }

        fun dotProduct(other: SparseVector): Int {
            if (this.positiveNum.size == 0 || other.positiveNum.size == 0) return 0
            var thisIdx = 0
            var otherIdx = 0
            var sum = 0

            this.positiveNum.forEach { println(it) }
            other.positiveNum.forEach { println(it) }
            while (thisIdx < this.positiveNum.size && otherIdx < other.positiveNum.size) {
                when {
                    positiveNum[thisIdx].first == other.positiveNum[otherIdx].first -> {
                        sum += positiveNum[thisIdx].second * other.positiveNum[otherIdx].second
                        otherIdx++
                        thisIdx++
                    }
                    positiveNum[thisIdx].first > other.positiveNum[otherIdx].first -> {
                        otherIdx++
                    }
                    else -> {
                        thisIdx++
                    }
                }
            }

            return sum
        }
    }

}

/**
 * Runtime: 728 ms, faster than 57.58% of Kotlin online submissions for Dot Product of Two Sparse Vectors.
Memory Usage: 56.8 MB, less than 6.06% of Kotlin online submissions for Dot Product of Two Sparse Vectors.

 */
//Math.min (m,n)
class SparseVector(nums: IntArray) {
    private val positiveNum = LinkedHashMap<Int, Int>()// index, num

    init {
        nums.forEachIndexed { index, num -> if (num != 0) positiveNum[index] = (num) }
    }

    // Return the dotProduct of two sparse vectors
    fun dotProduct(other: SparseVector): Int {
        if (this.positiveNum.size == 0 || other.positiveNum.size == 0) return 0

        val small: LinkedHashMap<Int, Int>
        val big: LinkedHashMap<Int, Int>
        if (other.positiveNum.size < this.positiveNum.size) {
            small = other.positiveNum
            big = this.positiveNum
        } else {
            big = other.positiveNum
            small = this.positiveNum
        }
        var sum = 0
        small.entries.forEach {
            if (big.containsKey(it.key)) {
                sum += it.value * big[it.key]!!
            }


        }
        return sum
    }
}
