class `359 Logger Rate Limiter` {


    class Logger() {

        lateinit var map: HashMap<String, Int>

        init {
            map = HashMap()
        }

        /**
         * Runtime: 344 ms, faster than 70.27% of Kotlin online submissions for Logger Rate Limiter.
        Memory Usage: 52.4 MB, less than 5.41% of Kotlin online submissions for Logger Rate Limiter.
         */
        fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
            if (map.containsKey(message).not()) {
                map[message] = timestamp
                return true
            } else {
                val last = map[message]!!
                if (timestamp - last >= 10) {
                    map[message] = timestamp
                    return true
                } else {
                    return false
                }
            }
        }

    }
}