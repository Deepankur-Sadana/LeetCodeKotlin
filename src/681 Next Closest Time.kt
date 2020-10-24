class `681 Next Closest Time` {

    /**
     * Runtime: 148 ms, faster than 100.00% of Kotlin online submissions for Next Closest Time.
    Memory Usage: 34.4 MB, less than 14.29% of Kotlin online submissions for Next Closest Time.

     */
    fun nextClosestTime(time: String): String {
        val startingTimeMap = HashSet<Char>()
        time.toCharArray().forEach { if (it != ':') startingTimeMap.add(it) }
        val h = time[0].toString() + time[1].toString()
        val m = time[3].toString() + time[4].toString()
        val currentTime = Time(h, m)
        var runningTime = currentTime
        while (true) {
            val timeNextMinute = getTimeNextMinute(runningTime)
            if (isMadeOfSameDigits(startingTimeMap, timeNextMinute)) {
                return timeNextMinute.HH.toString() + ":" + timeNextMinute.MM.toString()
            } else runningTime = timeNextMinute
        }
    }

    fun isMadeOfSameDigits(startingTime: HashSet<Char>, timeNextMinute: Time): Boolean {
        return startingTime.contains(timeNextMinute.HH.toCharArray()[0]) &&
                startingTime.contains(timeNextMinute.HH.toCharArray()[1]) &&
                startingTime.contains(timeNextMinute.MM.toCharArray()[0]) &&
                startingTime.contains(timeNextMinute.MM.toCharArray()[1])
    }

    private fun getTimeNextMinute(runningTime: Time): Time {
        if (runningTime.HH == "23" && runningTime.MM == "59") {
            return Time("00", "00")
        }
        if (runningTime.MM == "59") {
            return Time(attachPrefix(runningTime.HH.toInt() + 1),"00")
        }
        return Time(runningTime.HH, attachPrefix(runningTime.MM.toInt() + 1))
    }

    private fun attachPrefix(t: Int): String {
        return if (t < 10) {
            "0$t"
        }else t.toString()
    }

    data class Time(val HH: String, val MM: String)
}