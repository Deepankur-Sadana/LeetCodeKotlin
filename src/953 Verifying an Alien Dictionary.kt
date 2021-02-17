class `953 Verifying an Alien Dictionary` {

    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val map = HashMap<Char, Int>()
        order.forEachIndexed { index, char ->
            map[char] = index
        }

        val currentOrder = ArrayList<Int>()
        words[0].forEach { currentOrder.add(map[it]!!) }
        for (i in 1 until words.size) {
            val word = words[i]
            word.forEachIndexed{ index, char ->
//                map[char]>=currentOrder
            }

        }

        return true
    }
}