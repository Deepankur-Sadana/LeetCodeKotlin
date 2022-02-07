fun main(args: Array<String>) {

    val arr = arrayOf("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z")
    `249 Group Shifted Strings`().groupStrings(arr)
}

class `249 Group Shifted Strings` {

    /**
     * Runtime: 196 ms, faster than 83.33% of Kotlin online submissions for Group Shifted Strings.
    Memory Usage: 36 MB, less than 78.57% of Kotlin online submissions for Group Shifted Strings.
     */
    fun groupStrings(strings: Array<String>): List<List<String>> {
        val res = ArrayList<ArrayList<String>>()
        val map = HashMap<String, ArrayList<String>>()
        strings.forEach { string ->
            val gap = string[0] - 'a'
            var hash = ""
            if (gap == 0) {
                hash = string
            } else {
                string.toCharArray().forEach { char ->
                    hash += if (char - gap < 'a') {
                        'z' - ('a' - (char - gap) - 1)
                    } else {
                        char - gap
                    }
                }
            }
            if (map[hash] == null) map[hash] = ArrayList()
            map[hash]!!.add(string)
        }


        map.values.forEach {
            res.add(it)
        }
        return res
    }
}