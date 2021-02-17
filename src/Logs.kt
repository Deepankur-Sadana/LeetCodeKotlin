@file:Suppress("NAME_SHADOWING")

import java.util.PriorityQueue

class Logs {

    
    private fun breakLog(weight: Int, logs: IntArray): Int {
        var weight = weight
        val pq = PriorityQueue<Int>()
        logs.forEach { pq.add(it) }
        var strikes = 0
        while (pq.isNotEmpty() && weight > 0) {
            val heaviestAxe = pq.poll()
            weight -= heaviestAxe
            strikes++
            val remainingPower = heaviestAxe / 2
            if (remainingPower > 0) {
                pq.add(remainingPower)
            }
        }
        if (weight > 0) return -1
        return strikes
    }
}