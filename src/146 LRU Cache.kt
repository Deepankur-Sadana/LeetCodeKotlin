

fun main(args: Array<String>) {
    val c = `146 LRU Cache`.LRUCache(2)
    c.put(1, 1)
    c.put(2, 2)
    c.get(1)
    c.put(3,3)
    c.get(2)
}
class `146 LRU Cache` {

    /**
     * Runtime: 368 ms, faster than 67.26% of Kotlin online submissions for LRU Cache.
    Memory Usage: 53.1 MB, less than 71.68% of Kotlin online submissions for LRU Cache.
     */
    class LRUCache(val capacity: Int) {

        private var map: LinkedHashMap<Int, Int> = LinkedHashMap<Int, Int>()

        fun get(key: Int): Int {
            if(map.containsKey(key)){
                map.put(key,map.remove(key)!!)
            }
            return map.getOrDefault(key, -1)
        }

        fun put(key: Int, value: Int) {
            if (map.containsKey(key)) {
                map.remove(key)
            }

            map[key] = value
            if (map.size > capacity ) {
                val k = map.keys.iterator().next()
                println("key $key, k $k")
                map.remove(k)
            }
        }
    }
}