import java.util.*


fun main(args: Array<String>) {
    var startPrice = 6.0
    val deprecation = 0.45/2

    println("starting at $startPrice at ${String.format("%.2f", deprecation)}  % yoy deprecation")
    for (i in 1..7) {
        startPrice *= (1.0 - deprecation)
        startPrice = String.format("%.2f", startPrice).toDouble()
        println(" year $i = $startPrice")
    }
}


class `846 Hand of Straights` {

    fun isNStraightHand(hand: IntArray, W: Int): Boolean {
        if (W * W != hand.size) return false
        val map = TreeMap<Int, Int>()
        hand.forEach {
            val count = map[it] ?: 0
            map[it] = count + 1
        }

        for (set in 1..W) {
            var handSize = 0
            var last: Int? = null
            while (handSize < W) {
                if (last == null) {
                    last = map.pollFirstEntry().key
                } else {
                    val prevCount = map[last + 1] ?: return false
                    if (prevCount == 1) map.remove(last + 1)
                    else map[last + 1] = prevCount - 1
                    last += 1
                }
                ++handSize
            }
        }
        return true
    }
}