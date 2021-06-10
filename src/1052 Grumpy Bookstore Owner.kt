class `1052 Grumpy Bookstore Owner` {

    /**
     * Runtime: 496 ms, faster than 15.38% of Kotlin online submissions for Grumpy Bookstore Owner.
    Memory Usage: 41 MB, less than 100.00% of Kotlin online submissions for Grumpy Bookstore Owner.

     */
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        var currSatisfaction = 0
        for (i in 0 until minutes) {
            currSatisfaction += customers[i]
        }

        for (i in minutes until customers.size) {
            if (grumpy[i] == 0) {
                currSatisfaction += customers[i]
            }
        }

        var max = currSatisfaction
        for (i in minutes until customers.size) {
            val incomingIndex = i
            val removingIndex = i - minutes
            if (grumpy[removingIndex] == 1) currSatisfaction -= customers[removingIndex]
            if (grumpy[incomingIndex] == 1) currSatisfaction += customers[incomingIndex]
            max = Math.max(max, currSatisfaction)
        }
        return max
    }
}