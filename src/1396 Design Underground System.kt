class `1396 Design Underground System` {


    /**
     * Runtime: 624 ms, faster than 75.00% of Kotlin online submissions for Design Underground System.
    Memory Usage: 73.5 MB, less than 6.25% of Kotlin online submissions for Design Underground System.
     */
    class UndergroundSystem() {
        private val checkInMap = HashMap<Int, Pair<String, Int>>()
        private val journeyMap = HashMap<String, Pair<Double, Double>>()//trip time , trips count


        fun checkIn(id: Int, stationName: String, t: Int) {
            checkInMap[id] = Pair(stationName, t)
        }

        fun checkOut(id: Int, stationName: String, t: Int) {
            val checkInData = checkInMap[id]!!
            val journeyKey = getJourneyKey(checkInData.first, stationName)
            val journey = journeyMap.getOrDefault(journeyKey, Pair(0.0, 0.0))
            journeyMap[journeyKey] = Pair(journey.first + (t - checkInData.second), journey.second + 1)
        }

        fun getAverageTime(startStation: String, endStation: String): Double {
            val journeyData = journeyMap[getJourneyKey(startStation, endStation)]!!
            return journeyData.first / journeyData.second
        }

        private fun getJourneyKey(checkIn: String, checkOut: String): String {
            return "$checkIn -> $checkOut"
        }

    }


}