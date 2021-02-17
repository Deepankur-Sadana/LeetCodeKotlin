import java.util.*


class `346 Moving Average from Data Stream` {


    class MovingAverage(val size: Int) {

        var queue  = ArrayDeque<Int>()
        var sum = 0.0


        /**
         * Runtime: 352 ms, faster than 80.22% of Kotlin online submissions for Moving Average from Data Stream.
        Memory Usage: 42.9 MB, less than 6.59% of Kotlin online submissions for Moving Average from Data Stream.

         */
        fun next(next: Int): Double {
            sum += next
            queue.add(next)
            if (queue.size <= size) {
                return sum/queue.size
            }
            sum -= queue.poll()
            return sum/queue.size
        }
    }


    class MovingAverageUsingArray(val size: Int) {
        /** Initialize your data structure here. */
        val arr = IntArray(size)
        var index = 0
        var sum = 0.0
        var windowSize = 0
        var toKnock = 0


        fun next(`val`: Int): Double {
            if (windowSize < size) {
                index++
                sum +=`val`
                windowSize++
                return sum/windowSize
            } else {
                sum -= arr[toKnock]
                sum += `val`
                arr[toKnock]= `val`
//                index = toKnock
                toKnock = if (index == arr.size - 1) 0 else index + 1
                windowSize++
                return sum/size
            }
        }

    }


}